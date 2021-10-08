public class MinimumPathSumInMatrix {
    /**
     * Space Complexity O(m*n) -- for dp matrix
     * Time Complexity O(m*n)
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        //initialise a dp with size same as original array
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                //start counting the cost from the bottom right cell(bottom up approach) this is base condition
                //Cost of going to destination from destination is the lowest subset problem
                //then expand with the computed value to other cells gradually
                //when solving bigger subsets other than base condition, remember we can only go right or bottom
                if (i + 1 > m - 1 && j + 1 > n - 1) //base condition
                    dp[i][j] = grid[i][j];

                else if (i + 1 > m - 1)//boundary condition: handles the bottom most row
                    dp[i][j] = dp[i][j + 1] + grid[i][j];

                else if (j + 1 > n - 1)//boundary condition: handles the right most column
                    dp[i][j] = dp[i + 1][j] + grid[i][j];
                else {// normal cells : get the min of 1 horizontal  right travel and 1 vertical bottom travel
                    dp[i][j] = Math.min(dp[i][j + 1] + grid[i][j], dp[i + 1][j] + grid[i][j]);
                }
            }
        }
        return dp[0][0];
    }
}