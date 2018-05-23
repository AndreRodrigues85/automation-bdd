package com.danieljr.at.context;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Daniel Junior.
 */
@Component
public class TestContext {

    private Map<String, Object> resourceMap;

    public TestContext() {
        resourceMap = new HashMap<>();
    }

    public void put(String key, Object object) {
        resourceMap.put(key, object);
    }

    public Object get(String key) {
        return resourceMap.get(key);
    }

    public void clear() {
        resourceMap.clear();
    }
}