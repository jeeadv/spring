package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
* Longest Common Prefix
Input: {“apple”, “ape”, “april”}
Output: “ap”
Input: strs[] = [“javaarticle”, “java”, “javadev”, “javaaaa”]
Output: java
Explanation: “java” is the longest common prefix in all the given strings.

Input: strs[] = [“hello”, “world”]
Output: -1
Explanation: There’s no common prefix in the given strings.


 * */
public class Demo8
{

    public static void main(String[] args) {
        String s = "Hi my name is John";
        Map<String, List<String>> map = s.chars().mapToObj(c -> String.valueOf((char)c)).collect(Collectors.groupingBy(c -> c));
        System.out.println(map);

        List<String> result = s.chars().mapToObj(c -> String.valueOf((char)c))
                .filter(c -> map.get(c).size() == 1).limit(1).collect(Collectors.toList());

        System.out.println(result.get(0));

    }


}
