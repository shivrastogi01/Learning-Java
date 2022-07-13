class MinimumAsciiDeleteSum {
   public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int[] i : dp) {
            Arrays.fill(i ,-1);
        }
        return similar(s1.toCharArray() , 0 , s2.toCharArray() , 0 , dp);
    }
    public int similar(char[] s , int spo , char[] p , int ppo , int[][] dp) {
        if(spo >= s.length && ppo >= p.length) {
            return dp[spo][ppo] = 0;
        }
        if(spo >= s.length) {
            return dp[spo][ppo] = cumilative(p , ppo);
        }
        if(ppo >= p.length) {
            return dp[spo][ppo] = cumilative(s , spo);
        }
        if(dp[spo][ppo] != -1) {
            return dp[spo][ppo];
        }
        if(s[spo] == p[ppo]) {
            return  dp[spo][ppo] =similar(s , spo+1 , p , ppo+1 , dp);
        }
        int jumpS = similar(s , spo+1 , p , ppo , dp)+(s[spo]);
        int jumpP = similar(s , spo , p ,ppo+1 , dp)+p[ppo];
        return  dp[spo][ppo] =Math.min(jumpP , jumpS);
    }
    public int cumilative(char[] c , int po) {
        int sum = 0 ;
        for(int i = po ; i < c.length ; i++) {
            sum+=c[i];
        }
        return sum;
    }
}