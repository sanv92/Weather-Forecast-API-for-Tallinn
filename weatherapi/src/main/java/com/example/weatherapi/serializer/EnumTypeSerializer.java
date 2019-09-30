package com.example.weatherapi.serializer;

import com.example.weatherapi.model.ForecastType;
import com.example.weatherapi.model.PlaceType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class EnumTypeSerializer extends StdSerializer {

    public EnumTypeSerializer() {
        super(PlaceType.class);
    }

    public EnumTypeSerializer(Class t) {
        super(t);
    }

    @Override
    public void serialize(
            Object object,
            JsonGenerator generator,
            SerializerProvider provider
    )
            throws IOException {
        ForecastType placeType = (ForecastType) object;
        generator.writeStartObject();
        generator.writeFieldName("name");
        generator.writeString(placeType.getName());
        generator.writeFieldName("value");
        generator.writeString(placeType.name());
        generator.writeEndObject();
    }
}

