package com.example.demo.restcontroller;

import com.example.demo.beans.Question;
import com.example.demo.component.CommonService;
import com.example.demo.component.ConfigurationBean;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class CommonController
{
    @Autowired
    public ConfigurationBean configurationBean;

    @Autowired
    public CommonService commonService;

    @Value("${welcome.message}")
    public String welcomeMessage;

    @GetMapping("/welcome")
    public String getWelcomeMessage()
    {
        return welcomeMessage;
    }

    @GetMapping("/get-configuration")
    public ConfigurationBean getConfigurationBean()
    {
        return configurationBean;
    }

    @GetMapping("/questions")
    public  ResponseEntity<List<Question>> getQuestions()
    {
        List<Question> questions = commonService.getQuestions();
        if (questions == null || questions.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(commonService.getQuestions());
    }

    @GetMapping(value = "/question/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity<Question> getQuestion(@PathVariable long id)
    {
        Question question1 = commonService.getQuestion(id);
        if (question1 == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(commonService.getQuestion(id));
    }

    @PostMapping("/question")
    public ResponseEntity<Void> addQuestion(@RequestBody Question question)
    {
        commonService.addQuestion(question);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(question.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/question")
    public ResponseEntity<Void> updateQuestion(@RequestBody Question question)
    {
        Question question1 = commonService.getQuestion(question.getId());
        if (question1 == null)
        {
            return ResponseEntity.badRequest().build();
        }

        commonService.updateQuestion(question);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/question/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable long id)
    {
        Question question = commonService.getQuestion(id);
        if (question == null)
        {
            return ResponseEntity.notFound().build();
        }

        commonService.deleteQuestion(id);

        return ResponseEntity.noContent().build();
    }
}
