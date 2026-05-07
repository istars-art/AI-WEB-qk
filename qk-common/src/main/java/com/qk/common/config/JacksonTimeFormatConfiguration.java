package com.qk.common.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

@Configuration
public class JacksonTimeFormatConfiguration {

    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> {
            // 设置日期格式
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);

            DateTimeFormatter flexibleFormatter = new DateTimeFormatterBuilder()
                    .append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                    .optionalStart()
                    .appendFraction(ChronoField.MILLI_OF_SECOND, 0, 3, true)
                    .optionalEnd()
                    .optionalStart()
                    .appendOffsetId()
                    .optionalEnd()
                    .toFormatter();
            
            // 处理序列化（后端 -> 前端）
            builder.serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(formatter));
            
            // 处理反序列化（前端 -> 后端）
            builder.deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer(flexibleFormatter));

            // 忽略未知字段
            builder.featuresToEnable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
        };
    }
}