class OnesAndZeros {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int [][][] dp = new int[len+1][m+1][n+1];
        int [] cntZero = new int[len+1], cntOne = new int[len+1];
        for (int i = 1; i<=len; i++) {
            int zero = 0, one = 0;
            for (int j = 0; j<strs[i-1].length(); j++) {
                char temp = strs[i-1].charAt(j);
                if (temp == '0') zero++;
                else one++;
            }
            cntZero[i] = zero; cntOne[i] = one;
            if (zero<=m && one<=n) {
                dp[i][zero][one] = 1;
            }
        }
        int ans = 0;
        for (int k = 1; k<=len; k++) {
            int zero = cntZero[k], one = cntOne[k];
            for (int i = 0; i<=m; i++) {
                for (int j = 0; j<=n; j++) {
                    dp[k][i][j] = dp[k-1][i][j];
                    if (i<zero || j<one) continue;
                    dp[k][i][j] = Math.max(dp[k-1][i-zero][j-one] + 1, dp[k][i][j]); 
                    if (ans<dp[k][i][j]) {
                        ans = dp[k][i][j];
                    }
                }
            }    
        }
        return ans;
    }
}