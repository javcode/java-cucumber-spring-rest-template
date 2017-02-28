package org.javcode.cucumber.spring.services;

import java.io.IOException;

import org.apache.commons.httpclient.methods.GetMethod;
import org.javcode.cucumber.spring.domain.ApiResponse;
import org.javcode.cucumber.spring.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService
{
	@Autowired
	private ApiClientService apiClientService;

	public ApiResponse<Post[]> getPosts() throws IOException
	{
		return apiClientService.execute(new GetMethod("/posts"), Post[].class);
	}
}
