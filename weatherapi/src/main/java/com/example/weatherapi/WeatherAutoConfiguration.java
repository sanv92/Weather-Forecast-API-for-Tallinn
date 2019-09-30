package com.example.weatherapi;

import com.example.weatherapi.converters.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Configuration
@EnableConfigurationProperties(WeatherProperties.class)
@PropertySource("classpath:weatherapi.properties")
public class WeatherAutoConfiguration {

    WeatherAutoConfiguration() {
    }

    @Configuration
    public static class ConverterConfiguration implements WebMvcConfigurer {

        @Override
        public void addFormatters(FormatterRegistry registry) {
            TemperatureXmlToTemperature place = new TemperatureXmlToTemperature();
            WindXmlToPlace wind = new WindXmlToPlace();
            ForecastNightXmlToForecast nightForecast = new ForecastNightXmlToForecast(place, wind);
            ForecastDayXmlToForecast dayForecast = new ForecastDayXmlToForecast(place, wind);
            ForecastGroupXmlToForecasts forecasts = new ForecastGroupXmlToForecasts(nightForecast, dayForecast);

            registry.addConverter(place);
            registry.addConverter(wind);
            registry.addConverter(nightForecast);
            registry.addConverter(dayForecast);
            registry.addConverter(forecasts);
        }
    }

    @Configuration
    public static class WeatherApiConfiguration {
        private final WeatherProperties properties;
        private final RestTemplate restTemplate;
        private final ConversionService conversionService;

        @Autowired
        WeatherApiConfiguration(
                WeatherProperties properties,
                RestTemplate restTemplate,
                @Qualifier("mvcConversionService") ConversionService conversionService
        ) {
            this.properties = properties;
            this.restTemplate = configureRestTemplate(restTemplate);
            this.conversionService = conversionService;
        }

        @Bean
        @ConditionalOnProperty({"weatherapi.api-url", "weatherapi.locale"})
        public WeatherApi weatherApi() {
            return new WeatherApi(properties, restTemplate, conversionService);
        }

        private RestTemplate configureRestTemplate(RestTemplate restTemplate) {
            restTemplate.getMessageConverters()
                    .add(0, new StringHttpMessageConverter(
                                    Charset.forName(StandardCharsets.ISO_8859_1.name())
                            )
                    );

            return restTemplate;
        }
    }
}
