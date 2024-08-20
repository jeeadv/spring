package com.example.demo.others;

/* Problem Name is &&& Optimal Path &&& PLEASE DO NOT REMOVE THIS LINE. */

/*
** Instructions to candidate.
**  1) You are an avid rock collector who lives in southern California. Some rare
**     and desirable rocks just became available in New York, so you are planning
**     a cross-country road trip. There are several other rare rocks that you could
**     pick up along the way.
**
**     You have been given a grid filled with numbers, representing the number of
**     rare rocks available in various cities across the country.  Your objective
**     is to find the optimal path from So_Cal to New_York that would allow you to
**     accumulate the most rocks along the way.
**
**     Note: You can only travel either north (up) or east (right).
**  2) Consider adding some additional tests in doTestsPass().
**  3) Implement optimalPath() correctly.
**  4) Here is an example:
**                                                           ^
**                 {{0,0,0,0,5}, New_York (finish)           N
**                  {0,1,1,1,0},                         < W   E >
**   So_Cal (start) {2,0,0,0,0}}                             S
**                                                           v
**   The total for this example would be 10 (2+0+1+1+1+0+5).
2 3 4 5 10
2 3 4 5 5
2 2 2 2 2
*/

public class Demo7 {
    /*
     **  Find the optimal path.
     */
    public static int optimalPath(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
        {
            return 0;
        }
        for (int i = grid.length - 2; i >= 0; i--)
        {
            grid[i][0] += grid[i + 1][0];
        }

    /*for (int i = 0; i < grid.length; i++)
    {
      for (int j = 0; j < grid[0].length; j++)
        System.out.print(grid[i][j] + " ");
      System.out.println();
    }*/

        for (int i = 1; i < grid[0].length; i++)
        {
            grid[grid.length - 1][i] += grid[grid.length - 1][i - 1];
        }

        for (int i = grid.length - 2; i >= 0; i--)
        {
            for (int j = 1; j < grid[0].length; j++)
            {
                grid[i][j] += Math.max(grid[i + 1][j], grid[i][j - 1]);
            }
        }
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
        return grid[0][grid[0].length - 1];
    }

    /*
     **  Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass() {
        boolean result = true;
        // Base test case
        result &= optimalPath(new int[][]{
                {0, 0, 0, 0, 5},
                {0, 1, 1, 1, 0},
                {2, 0, 0, 0, 0}}) == 10;
        // Random numbers
        result &= optimalPath(new int[][]{
                {1, 3, 2, 0, 2, 1, 8},
                {3, 4, 1, 2, 0, 1, 1},
                {1, 1, 1, 2, 3, 2, 1},
                {1, 0, 1, 1, 4, 2, 1}}) == 25;
        // All 0's
        result &= optimalPath(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}}) == 0;
        // Many optimal paths
        result &= optimalPath(new int[][]{
                {1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1}}) == 8;
        // Empty grid
        result &= optimalPath(new int[][]{{}}) == 0;

        return result;
    }


    /*
     **  Execution entry point.
     */
    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }
    }
}
