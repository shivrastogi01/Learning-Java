class DecodeWays {
    
    public long numDecodings(String s,int IDX,long[]dp) {
        int n=s.length();
        for(int idx=n;idx>=0;idx--){
            if(idx==n){
                dp[idx]=1;
                continue;
            }

            if(s.charAt(idx)=='0'){
                dp[idx]=0;
                continue;
            }

            long count=0;
            int mod=(int) 1e9 + 7;

            char ch1=s.charAt(idx);
            //if we get * as first character, Here in this call treat * as a single character only
            if(ch1=='*'){
                count=(count + 9 * dp[idx+1])%mod;

                //if we get * as second character also, Here in this call treat ** combined
                if(idx<n-1){
                    if(s.charAt(idx+1)=='*'){
                        count = (count + 15 * dp[idx+2])%mod;
                    }
                    else if(s.charAt(idx+1)>='0' && s.charAt(idx+1)<='6'){
                        count = (count + 2 * dp[idx+2])%mod;
                    }
                    else if(s.charAt(idx+1)>='7'){
                        count = (count + dp[idx+2])%mod;
                    }
                }
            }

            else{
                //first character is not *
                count = (count + dp[idx+1])%mod;
                if(idx<n-1){
                    if(s.charAt(idx+1)!='*'){
                        if(idx<n-1 && (s.charAt(idx)=='1' || s.charAt(idx)=='2' &&      s.charAt(idx+1)<'7')){
                            count = (count + dp[idx+2])%mod;
                        }
                    }
                    else if(ch1=='1'){
                        count=(count + 9 * dp[idx+2])%mod;
                    }
                    else if(ch1=='2'){
                        count=(count + 6 * dp[idx+2])%mod;
                    }
                }
            }
            
            dp[idx]=count;
        }
        
        return dp[IDX];
    }
    
    public int numDecodings(String s) {
        int n=s.length();
        long dp[]=new long[n+1];
        Arrays.fill(dp,-1);
        long ans = numDecodings(s,0,dp);
        return (int)ans;
    }
}
