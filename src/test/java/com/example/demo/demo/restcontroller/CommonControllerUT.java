package com.example.demo.demo.restcontroller;

import com.example.demo.demo.DemoApplication;
import com.example.demo.demo.beans.Question;
import com.example.demo.demo.component.CommonService;
import com.example.demo.demo.restcontroller.CommonController;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(CommonController.class)
public class CommonControllerUT
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommonService commonService;

    @Test
    public void get() throws Exception
    {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/question/1").accept(MediaType.APPLICATION_JSON);
        Mockito.when(commonService.getQuestion(Mockito.any())).thenReturn(new Question(1, "Ram"));
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        JSONAssert.assertEquals("{id: 1, name: Ram}", mvcResult.getResponse().getContentAsString(), false);
    }



}
