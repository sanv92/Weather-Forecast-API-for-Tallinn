package com.example.weatherapi.mappers;

import com.example.weatherapi.model.forecastxml.ForecastGroupXml;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.security.InvalidParameterException;

public class MapperFactory {

    private MapperFactory() {}

    public static class Builder {
        private String content;

        public Builder withContent(String content) {
            this.content = content;
            return this;
        }

        public ForecastGroupXml map(final MediaType contentType) {
            if (content.isEmpty()) {
                throw new InvalidParameterException();
            }

            try {
                if (contentType.isCompatibleWith(MediaType.APPLICATION_XML)) {
                    return new XmlMapper().map(content);
                } else {
                    return new JsonMapper().map(content);
                }
            } catch (RuntimeJsonMappingException | IOException ex) {
                throw new RuntimeJsonMappingException(ex.getMessage());
            }
        }
    }
}

