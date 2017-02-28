////////////////////////////////////////////////////////////////////////////////
//
// Copyright (c) 2017, Suncorp Metway Limited. All rights reserved.
//
// This is unpublished proprietary source code of Suncorp Metway Limited.
// The copyright notice above does not evidence any actual or intended
// publication of such source code.
//
////////////////////////////////////////////////////////////////////////////////
package org.javcode.cucumber.spring.services;

import java.io.IOException;

import org.apache.commons.httpclient.HttpMethod;
import org.javcode.cucumber.spring.domain.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ApiClientService
{
    @Autowired
    private HttpClientService httpClientService;

    private ObjectMapper objectMapper = new ObjectMapper();

    public <T> T map(HttpMethod response, Class<T> type) throws IOException
    {
        return objectMapper.readValue(response.getResponseBodyAsString(), type);
    }

    public <T> ApiResponse<T> execute(HttpMethod request, Class<T> type) throws IOException
    {
        httpClientService.executeRequest(request);
        return new ApiResponse<>(map(request, type), request);
    }

}
