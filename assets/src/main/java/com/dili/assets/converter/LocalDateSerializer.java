package com.dili.assets.converter;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateSerializer implements ObjectSerializer {
    public static final LocalDateSerializer instance = new LocalDateSerializer();
    private static final String defaultPattern = "yyyy-MM-dd";
    SerializeConfig serializeConfig;

    public LocalDateSerializer() {
        this.serializeConfig = SerializeConfig.globalInstance;
    }

    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter out = serializer.out;
        if (object == null) {
            out.writeNull();
        } else {
            LocalDate result = (LocalDate)object;
            out.writeString(result.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }

    }
}
