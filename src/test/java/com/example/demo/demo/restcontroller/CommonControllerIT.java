package com.example.demo.demo.restcontroller;

import com.example.demo.demo.DemoApplication;
import com.example.demo.demo.beans.Question;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.List;

@SpringBootTest(classes= DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CommonControllerIT
{
    @LocalServerPort
    public String port;

    @Test
    public void get() throws JSONException
    {
        System.out.println("PORTPORTPORT:" + port);
        String url = "http://localhost:" + port + "/question/1";

        TestRestTemplate testRestTemplate = new TestRestTemplate();
        List<Question> result = testRestTemplate.getForObject(url, List.class);
        System.out.println(result.toString());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        ResponseEntity<String> response = testRestTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        JSONAssert.assertEquals("{id:1, name:kumar}", response.getBody(), false);

        ResponseEntity<List<Question>> resp = testRestTemplate.exchange("http://localhost:" + port + "/questions", HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Question>>(){});

        System.out.println(resp.getBody().toString());
        Assertions.assertTrue(resp.getBody().contains(new Question(1L, "kumar")));
    }

    @Test
    public void search() throws JSONException
    {
        TestRestTemplate testRestTemplate = new TestRestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<List<Question>> resp = testRestTemplate.exchange("http://localhost:" + port + "/questions",
                HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Question>>(){});

        System.out.println(resp.getBody().toString());
        Assertions.assertTrue(resp.getBody().contains(new Question(1L, "kumar")));
    }

    @Test
    public void post() throws JSONException
    {
        String url = "http://localhost:" + port + "/question";

        TestRestTemplate testRestTemplate = new TestRestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity httpEntity = new HttpEntity(new Question(3, "jha"), httpHeaders);
        ResponseEntity<String> response = testRestTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
        Assertions.assertTrue(response.getHeaders().get(HttpHeaders.LOCATION).get(0).contains(url));

    }
}
