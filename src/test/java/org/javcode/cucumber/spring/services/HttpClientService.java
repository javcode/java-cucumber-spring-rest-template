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

import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpHost;
import org.apache.commons.httpclient.HttpMethod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HttpClientService
{
    @Value("${apiUrl}")
    private String apiUrl;

    @Value("${apiPort}")
    private String apiPort;

    private HttpClient getClient() {
        return new HttpClient();
    }

    public int executeRequest(HttpMethod request) throws IOException
    {
        HostConfiguration hostConfiguration = new HostConfiguration();
        hostConfiguration.setHost(apiUrl, Integer.parseInt(apiPort));
        HttpClient client = getClient();
        return client.executeMethod(hostConfiguration, request);
    }
}
