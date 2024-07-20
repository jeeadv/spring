package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EvenPrinter
{
    @RequestMapping(path = "/print")
    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<>();

        for (int i = 2; i <= 2002; i += 2)
        {
            list.add(i);
        }
        System.out.print(list);
    }


}
