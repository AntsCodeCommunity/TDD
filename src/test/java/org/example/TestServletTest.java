package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestServletTest {

	private static String studentJson;

	@BeforeAll
	static void responseBody() {
		Student student = new Student("AntsCode", "man");
		Gson gson = new Gson();
		studentJson = gson.toJson(student);
	}

	@Test
	void goGetTest() {

		HttpClient httpClient = HttpClient.newBuilder().version(Version.HTTP_1_1).build();

		HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("http://localhost:8080/TDD/TestServlet")).header("Accept", "application/json").GET().build();

		try {
			HttpResponse<String> response = httpClient.send(httpRequest, BodyHandlers.ofString(StandardCharsets.UTF_8));
			Assertions.assertThat(response.statusCode()).isEqualTo(200);
			Assertions.assertThat(response.headers().allValues("Content-Type")).contains("application/json;charset=UTF-8");
			Assertions.assertThat(response.body()).isEqualTo(studentJson);
		}
		catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}

}