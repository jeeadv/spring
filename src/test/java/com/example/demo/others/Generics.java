package com.example.demo.others;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Generics
{
    @Test
    public void test()
    {
        Node node1 = new Node("abc");
        Node node2 = new Node(1);
        Map<Node, Integer> map = new HashMap<>();
        map.put(node1, 1);
        map.put(node2, 2);
        Assertions.assertEquals("{1=2, abc=1}", map.toString());

        MyMap<Node, Integer> myMap = new MyMap<>();
        myMap.put(node1, 1);
        myMap.put(node2, 2);

    }
}

class MyMap<K, V>
{
    Map<K, V> map = new HashMap<>();

    public boolean containsKey(K key)
    {
        return map.containsKey(key);
    }

    public V get(K key)
    {
        return map.get(key);
    }

    public void put(K key, V value)
    {
        map.put(key, value);
    }
}

class Node<T>
{
    T value;
    Node(T value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return this.value.toString();
    }
}
