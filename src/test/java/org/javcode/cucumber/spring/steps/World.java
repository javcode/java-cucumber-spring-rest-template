////////////////////////////////////////////////////////////////////////////////
//
// Copyright (c) 2017, Suncorp Metway Limited. All rights reserved.
//
// This is unpublished proprietary source code of Suncorp Metway Limited.
// The copyright notice above does not evidence any actual or intended
// publication of such source code.
//
////////////////////////////////////////////////////////////////////////////////
package org.javcode.cucumber.spring.steps;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class World
{
    private Map<String, Object> data = new HashMap<>();

    public <T> T get(String key, Class<T> type) {
        if(data.containsKey(key)) {
            return type.cast(data.get(key));
        } else {
            return null;
        }
    }

    public void put(String key, Object value) {
        data.put(key, value);
    }

    public void clear() {
        data.clear();
    }
}
