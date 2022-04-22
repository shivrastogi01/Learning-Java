class DistinctEchoSubstring {
    public int distinctEchoSubstrings(String s) {
        HashSet<String>set=new HashSet();
        int dp[][]=new int[s.length()+1][s.length()+1];
        for(int i=s.length()-1;i>=0;i--)
        {
            for(int j=i+1;j<s.length() && (j-i<=s.length()/2);j++)
            {
                if(s.charAt(i)==s.charAt(j))
                {
                    dp[i][j]=1+dp[i+1][j+1];
                    if(dp[i+1][j+1]>=j-i-1)
                        set.add(s.substring(i,j));
                }
            }
        }
        return set.size();
    }
}