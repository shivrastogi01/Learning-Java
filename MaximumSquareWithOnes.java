class MaximumSquareWithOnes{
public int maximalSquare(char[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][]dp = new int[row][col];
        int max = 0;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(matrix[i][j]=='1') {
                    dp[i][j] = 1;
                    max = 1;
                }
            }
        }
        
        for(int i=1; i<row; i++) {
            for(int j=1; j<col; j++) {
                if(matrix[i][j]=='1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1])+1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return  max * max;
    }
}