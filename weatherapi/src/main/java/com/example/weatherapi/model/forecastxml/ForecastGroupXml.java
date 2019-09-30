package com.example.weatherapi.model.forecastxml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "forecasts")
public class ForecastGroupXml {

    @JacksonXmlElementWrapper(localName = "forecast", useWrapping = false)
    @JacksonXmlProperty(localName = "forecast")
    private List<ForecastXml> forecasts;

    public ForecastGroupXml() {
        this.forecasts = new ArrayList();
    }

    public ForecastGroupXml(List<ForecastXml> forecasts) {
        this.forecasts = forecasts;
    }

    public List<ForecastXml> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<ForecastXml> forecasts) {
        this.forecasts = forecasts;
    }

    @Override
    public String toString() {
        return "ForecastGroup{" +
                "forecasts=" + forecasts +
                '}';
    }
}
