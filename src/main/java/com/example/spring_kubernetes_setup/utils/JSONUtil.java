package com.example.spring_kubernetes_setup.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JSONUtil {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T convertFromJsonBytes(byte[] data, Class<T> cls) {
        return mapper.convertValue(data, cls);
    }
}
