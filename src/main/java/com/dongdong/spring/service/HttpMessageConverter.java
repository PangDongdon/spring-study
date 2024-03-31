package com.dongdong.spring.service;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Date: 2019/11/1  10:43
 * @Author: dongdong
 */
public interface HttpMessageConverter<T> {
    //指示此转换器是否可以读取给定的类
    boolean canRead(Class<?> clazz, @Nullable MediaType mediaType);

    //指示此转换器是否可以写给定的类
    boolean canWrite(Class<T> clazz,@Nullable MediaType mediaType);

    //返回List<MediaType>
    List<MediaType> getSupportedMediaTypes();

    //读取一个inputMessage
    T read(Class<? extends T> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException;

    //往output message 写一个Object
     void write(T t, @Nullable MediaType contentType, HttpOutputMessage outputMessage) throws IOException , HttpMessageNotWritableException;

     public <T> T getForObject(String url,Class<T> reponseType,Object...  urlVariables);

     public <T> T getForObject(String url, Class<T> reponseType, Map<String,?> uriVariables);

     public <T> T getForObject(URI url, Class<T> reponseType);



}
