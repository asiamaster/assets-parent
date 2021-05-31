package com.dili.assets.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * WebConfig
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    public WebConfig() {
    }

    @Bean
    public Converter<String, Date> addDateConvert() {
        return new Converter<String, Date>() {
            public Date convert(String source) {
                if (StringUtils.isBlank(source)) {
                    return null;
                } else {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = null;

                    try {
                        date = sdf.parse(source);
                    } catch (ParseException var7) {
                        sdf = new SimpleDateFormat("yyyy-MM-dd");

                        try {
                            date = sdf.parse(source);
                        } catch (ParseException var6) {
                            var6.printStackTrace();
                        }
                    }

                    return date;
                }
            }
        };
    }

    @Bean
    public Converter<String, LocalDate> addLocalDateConvert() {
        return new Converter<String, LocalDate>() {
            public LocalDate convert(String source) {
                return LocalDate.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }
        };
    }

    @Bean
    public Converter<String, LocalDateTime> addLocalDateTimeConvert() {
        return new Converter<String, LocalDateTime>() {
            public LocalDateTime convert(String source) {
                return LocalDateTime.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }
        };
    }

    @Bean
    public Converter<String, Instant> addInstantConvert() {
        return new Converter<String, Instant>() {
            public Instant convert(String source) {
                try {
                    return Instant.ofEpochMilli(Long.parseLong(source));
                } catch (NumberFormatException var3) {
                    return Instant.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault()).parse(source));
                }
            }
        };
    }

    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        Iterator it = converters.iterator();
        int index = -1;
        int tmp = 0;

        while(it.hasNext()) {
            Object obj = it.next();
            if (obj instanceof MappingJackson2HttpMessageConverter) {
                it.remove();
                index = tmp;
            }

            if (index == -1) {
                ++tmp;
            }
        }

        JsonHttpMessageConverter fastJsonHttpMessageConverter = new JsonHttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
        if (index != -1) {
            converters.add(index, fastJsonHttpMessageConverter);
        } else {
            converters.add(fastJsonHttpMessageConverter);
        }

    }
}