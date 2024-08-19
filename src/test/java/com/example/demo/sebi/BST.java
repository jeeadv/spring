package com.example.demo.sebi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BST
{
    static class Node
    {
        int value;
        Node left;
        Node right;

        Node(int value, Node left, Node right)
        {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public String toString()
        {
            return "" + this.value;
        }
    }

    @Test
    public void test()
    {
        Node root = null;
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        Assertions.assertEquals(List.of(), list);

        root = insert(root, 8);
        list = new ArrayList<>();
        inorder(root, list);
        Assertions.assertEquals(List.of(8), list);

        root = insert(root, 5);
        list = new ArrayList<>();
        inorder(root, list);
        Assertions.assertEquals(List.of(5, 8), list);

        root = insert(root, 20);
        list = new ArrayList<>();
        inorder(root, list);
        Assertions.assertEquals(List.of(5, 8, 20), list);

        root = insert(root, 1);
        list = new ArrayList<>();
        inorder(root, list);
        Assertions.assertEquals(List.of(1, 5, 8, 20), list);

        Assertions.assertEquals(1, search(root, 1).value);
        Assertions.assertEquals(20, search(root, 20).value);
        Assertions.assertEquals(5, search(root, 5).value);
        Assertions.assertEquals(8, search(root, 8).value);
        Assertions.assertEquals(null, search(root, 99));

        root = deleteLeaf(root, 1);
        Assertions.assertEquals(null, search(root, 1));
        Assertions.assertEquals(20, search(root, 20).value);

        root = deleteLeaf(root, 20);
        Assertions.assertEquals(null, search(root, 20));
        Assertions.assertEquals(5, search(root, 5).value);
    }

    public void inorder(Node root, List<Integer> list)
    {
        if (root == null)
        {
            return;
        }
        inorder(root.left, list);
        list.add(root.value);
        inorder(root.right, list);
    }

    public Node insert(Node root, int value)
    {
        if (root == null)
        {
            return new Node(value, null, null);
        }

        if (value > root.value)
        {
            root.right = insert(root.right, value);
        }
        else
        {
            root.left = insert(root.left, value);
        }
        return root;
    }

    public Node search(Node root, int value)
    {
        if (root == null)
        {
            return null;
        }
        if (value == root.value)
        {
            return root;
        }
        else if (value < root.value)
        {
            return search(root.left, value);
        }
        else
        {
            return search(root.right, value);
        }
    }

    public Node deleteLeaf(Node root, int value)
    {
        if (root == null)
        {
            return null;
        }
        if (value == root.value)
        {
            return null;
        }
        else if (value < root.value)
        {
            root.left = deleteLeaf(root.left, value);
            return root;
        }
        else
        {
            root.right = deleteLeaf(root.right, value);
            return root;
        }

    }
}
