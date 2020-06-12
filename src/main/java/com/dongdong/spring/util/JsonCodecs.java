package com.dongdong.spring.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;

public class JsonCodecs {
    public final static ObjectMapper jsonMapper = getObjectMapper();

    public static <T> String objectToJson(T t) {
        if(t == null) {
            return null;
        }
        try {
            return jsonMapper.writeValueAsString(t);
        } catch (Exception e) {
            return "";
        }
    }

    public static <T> String objectToPrettyJson(T t) {
        if(t == null) {
            return null;
        }
        try {
            return jsonMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(t);
        } catch (Exception e) {
            return "";
        }
    }

    public static <F, T> T convert(F f, Class<T> clazz) {
        if(f == null) {
            return null;
        }
        return jsonToObject(objectToJson(f), clazz);
    }

    public static <T> T jsonToObject(String jsonStr, Class<T> clazz) {
        if(StringUtils.isBlank(jsonStr)) {
            return null;
        }
        try {
            return jsonMapper.readValue(jsonStr, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T jsonToObject(String jsonStr, TypeReference<T> reference) {
        if(StringUtils.isBlank(jsonStr)) {
            return null;
        }
        try {
            return jsonMapper.readValue(jsonStr, reference);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static ObjectMapper getObjectMapper() {
        ObjectMapper instance = new ObjectMapper();
        instance.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // instance.enable(SerializationFeature.WRITE_ENUMS_USING_INDEX);
        instance.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        instance.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        instance.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        instance.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return instance;
    }
}
