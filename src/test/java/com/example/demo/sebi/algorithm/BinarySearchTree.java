package com.example.demo.sebi.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTree
{
    @Test
    public void test()
    {
        Assertions.assertEquals(0, binarySearch(0, 3, new int[] {1, 2, 3, 4}, 1));
        Assertions.assertEquals(1, binarySearch(0, 3, new int[] {1, 2, 3, 4}, 2));
        Assertions.assertEquals(2, binarySearch(0, 3, new int[] {1, 2, 3, 4}, 3));
        Assertions.assertEquals(3, binarySearch(0, 3, new int[] {1, 2, 3, 4}, 4));
        Assertions.assertEquals(-1, binarySearch(0, 3, new int[] {1, 2, 3, 4}, 5));
    }

    void insert()
    {

    }

    void delete()
    {

    }

    int search()
    {
        return -1;
    }

    public int binarySearch(int l, int r, int[] arr, int target)
    {
        if (l > r)
        {
            return -1;
        }
        int mid = (l + r) / 2;
        if (target == arr[mid])
        {
            return mid;
        }
        else if (target < arr[mid])
        {
            return binarySearch(l, mid - 1, arr, target);
        }
        else
        {
            return binarySearch(mid + 1, r, arr, target);
        }
    }
}
