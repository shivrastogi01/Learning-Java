class CountNumberOfSubString {
    public int countSubstrings(String s) {
        if(s.length() == 0)
            return 0;
        if(s.length() == 1)
            return 1;
        
        
        // try this question using the dynamic programming approach
        int len = s.length();
        int [] [] dp = new int [len] [len];
        int count = 0;   
        // set diagnals to 1
        for(int i = 0; i < len; i++){
            dp[i][i] = 1;
            count++;
        }
        
        
        // set any length of 2 repeating characters as 1
        for(int i = 0; i < len - 1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = 1;
                count++;
            }
        }
        
        
        // check for lengths greater than 3 being palindromic
        // variable l represents the length of the substring we are checking is palindromic
        // variable st represents the starting index of the substring we are checking
        // variable e represents the ending index of the substring we are checking
        for(int l = 3; l <= len; l++){
            for(int st = 0; st < len - l + 1; st++) {
                // end index will be the starting index + length of the substring - 1
                int e = st + l - 1;
                // if start and end characters are equal and substring in between is a palindrome this is also a palindrome
                if(s.charAt(st) == s.charAt(e) && dp[st+1][e-1] == 1) {
                    dp[st][e] = 1;
                    count++;
                }
            }
        }
        
        return count;
    }
}