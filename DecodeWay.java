class DecodeWay {
    public int numDecodings(String s) {
        if (s == "" || s.charAt(0) == '0'){return 0;}
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++){
            if (i == 0){dp[i] = 1;}
            else if(i == 1){
                if (s.charAt(i-1) == '1' && s.charAt(i) != '0'){
                    dp[i] = 2;
                } else if (s.charAt(i-1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6'){
                    dp[i] = 2;
                } else if (s.charAt(i) == '0') {
                    if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2'){
                        dp[i] = 1;
                    } else {
                        return 0;
                    }
                } else {
                    dp[i] = 1;
                }
            } else {
                if (s.charAt(i-1) == '1' && s.charAt(i) != '0'){
                    dp[i] = dp[i-1] + dp[i-2];
                } else if (s.charAt(i-1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6'){
                    dp[i] = dp[i-1] + dp[i-2];
                } else if (s.charAt(i) == '0') {
                    if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2'){
                        dp[i] = dp[i-2];
                    } else {
                        return 0;
                    }
                } else {
                    dp[i] = dp[i-1];
                }
            }
        }
        
        return dp[dp.length-1];
    }
}