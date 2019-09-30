package com.example.weatherapi;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(
        prefix = "weatherapi"
)
public class WeatherProperties {

    private String apiUrl = "https://ilmateenistus.ee";

    private String locale = "eng";

    public WeatherProperties() {}

    public WeatherProperties(String apiUrl, String locale) {
        this.apiUrl = apiUrl;
        this.locale = locale;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    @Override
    public String toString() {
        return "WeatherProperties{" +
                "apiUrl='" + apiUrl + '\'' +
                ", locale='" + locale + '\'' +
                '}';
    }
}
