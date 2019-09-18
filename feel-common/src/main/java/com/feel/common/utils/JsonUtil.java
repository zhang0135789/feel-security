package com.feel.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

/**
 * @Author: zz
 * @Description:
 * @Date: 下午 4:58 2018/12/3 0003
 * @Modified By
 */
@Slf4j
public class JsonUtil {
    private final static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));
//        mapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
//        mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
//        mapper.setFilters(new SimpleFilterProvider().setFailOnUnknownId(false));
    }

    public static <T> T toObject(String json,Class clz){
        try {
            return  (T) mapper.readValue(json,clz);
        }catch (IOException e){
            log.error(e.getMessage());
        }
        return null;
    }

    public static <T> T toObject(InputStream json, Class clz){
        try {
            return  (T) mapper.readValue(json,clz);
        }catch (IOException e){

        }
        return null;
    }

    public static <T> String toJSON(T obj){
        try {
            return  mapper.writeValueAsString(obj);
        }catch (IOException e){

        }
        return null;
    }
    /**
     * 序列化成json字符串
     *
     * @param obj 对象
     * @return json 字符串
     * @throws IOException 异常
     */
    public static String toJson(Object obj) throws IOException {
        return mapper.writeValueAsString(obj);
    }

    /**
     * 将json字符串反序列化成对象
     *
     * @param json      json字符串
     * @param valueType 对象类型
     * @param <T>       对象类型
     * @return 对象
     * @throws IOException 异常
     */
    public static <T> T fromJson(String json, Class<T> valueType) throws IOException {
        return mapper.readValue(json, valueType);
    }

    /**
     * 将json字符串反序列化成对象
     *
     * @param json json json字符串
     * @param ref  对象类型
     * @param <T>  对象类型
     * @return 对象
     * @throws IOException 异常
     */
    public static <T> T fromJson(String json, TypeReference<T> ref) throws IOException {
        return mapper.readValue(json, ref);
    }


    /**
     * 创建ObjectMapper
     *
     * @return ObjectMapper
     */
    private static ObjectMapper createObjectMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.KEBAB_CASE);
        mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return mapper;
    }
}
