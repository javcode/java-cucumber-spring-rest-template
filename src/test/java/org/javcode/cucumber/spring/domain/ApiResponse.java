////////////////////////////////////////////////////////////////////////////////
//
// Copyright (c) 2017, Suncorp Metway Limited. All rights reserved.
//
// This is unpublished proprietary source code of Suncorp Metway Limited.
// The copyright notice above does not evidence any actual or intended
// publication of such source code.
//
////////////////////////////////////////////////////////////////////////////////
package org.javcode.cucumber.spring.domain;

import org.apache.commons.httpclient.HttpMethod;

public class ApiResponse<T>
{
    private T body;
    private HttpMethod response;

    public ApiResponse(T body, HttpMethod response) {
        this.body = body;
        this.response = response;
    }

    public T getBody()
    {
        return body;
    }

    public void setBody(T body)
    {
        this.body = body;
    }

    public HttpMethod getResponse()
    {
        return response;
    }

    public void setResponse(HttpMethod response)
    {
        this.response = response;
    }
}
