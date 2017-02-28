package org.javcode.cucumber.spring.steps;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.javcode.cucumber.spring.domain.ApiResponse;
import org.javcode.cucumber.spring.domain.Post;
import org.javcode.cucumber.spring.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;

public class PostStep extends BaseTest
{
	@Autowired
	private PostService postService;

	@When("^I query all fake posts$")
	public void i_query_all_fake_posts() throws IOException
	{
		world.put("apiResponse", postService.getPosts());
	}

	@Then("^the response status code is (\\d+)$")
	public void the_response_status_code_is(String code) {
		ApiResponse apiResponse = world.get("apiResponse", ApiResponse.class);
		assertThat(apiResponse.getResponse().getStatusLine().getStatusCode(), is(Integer.parseInt(code)));
	}

	@Then("^there are (\\d+) posts$")
	public void there_are_n_posts(String n) {
		ApiResponse<Post[]> apiResponse = world.get("apiResponse", ApiResponse.class);
		Post[] posts = apiResponse.getBody();
		assertThat(posts.length,  is(Integer.parseInt(n)));
	}
}
