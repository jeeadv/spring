package com.example.demo.others;

public class Demo3
{
    static String[] input = new String[] {"abc","d","def","ef"};
    static int[] cost = new int[] {1,1,10,5};
    static String target = "abcdef";
    static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args)
    {
        //Input: target = "abcdef", words = ["abdef","abc","d","def","ef"], costs = [100,1,1,10,5]

        minCost(0, "", 0, "");
        System.out.println(minCost);
    }

    private static void minCost(int i, String s, int sum, String indices)
    {

        if (i == cost.length)
        {
            if (s.equals(target))
            {
                minCost = Math.min(minCost, sum);
            }
            return;
        }
        minCost(i + 1, s + input[i], sum +  + cost[i], indices + " " + i);
        minCost(i + 1, s, sum, indices);
    }
}
