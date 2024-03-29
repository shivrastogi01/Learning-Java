 if (n == 0)
        return 1;
 
    // If n is equal to 1 then we
    // can't reach at position O
    if (n == 1)
        return 0;
 
    int [][]dp = new int[4][n + 1];
 
    // Initial Conditions
 
    // Represents position O
    dp[0][0] = 1;
 
    // Represents position A
    dp[1][0] = 0;
 
    // Represents position B
    dp[2][0] = 0;
 
    // Represents position C
    dp[3][0] = 0;
 
    // Filling the table
    for(int i = 1; i <= n; i++)
    {
        
       // The number of ways to reach
       // a particular position (say X)
       // at the i'th step is equivalent
       // to the sum of the number
       // of ways the person is not at
       // position X in the last step.
       int countPositionO = dp[1][i - 1] +
                            dp[2][i - 1] +
                            dp[3][i - 1];
       int countPositionA = dp[0][i - 1] +
                            dp[2][i - 1] +
                            dp[3][i - 1];
       int countPositionB = dp[0][i - 1] +
                            dp[1][i - 1] +
                            dp[3][i - 1];
       int countPositionC = dp[0][i - 1] +
                            dp[1][i - 1] +
                            dp[2][i - 1];
        
       dp[0][i] = countPositionO;
       dp[1][i] = countPositionA;
       dp[2][i] = countPositionB;
       dp[3][i] = countPositionC;
    }
    return dp[0][n];