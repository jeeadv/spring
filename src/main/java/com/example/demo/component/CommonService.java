package com.example.demo.component;

import com.example.demo.beans.Question;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommonService {

    long counter = 3;
    Map<Long, Question> questionMap = new HashMap<>(Map.of(1L, new Question(1L, "kumar"), 2L, new Question(2L, "gaurav")));//;

    public List<Question> getQuestions()
    {
        return questionMap.values().stream().toList();
    }

    public Question getQuestion(long id)
    {
        return questionMap.get(id);
    }

    public void addQuestion(Question question)
    {
        question.setId(counter);
        questionMap.put(counter, question);
        counter++;
    }

    public void deleteQuestion(long id)
    {
        questionMap.remove(id);
    }

    public void updateQuestion(Question question)
    {
        questionMap.put(question.getId(), question);
    }
}