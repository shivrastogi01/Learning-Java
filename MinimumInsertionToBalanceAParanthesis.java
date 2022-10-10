class MinimumInsertionToBalanceAParanthesis {
    public int minInsertions(String s) {
        int ans =0;
        int o = 0;                                         // No. of '('
        int n = s.length();
        
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(') {                         // if i-th char is '('
                o++;                                       // count No. of '('
            }else {
                if(i == n-1) {
                    ans += (o>0)?1:2;
                }else if(s.charAt(i+1) != ')') {           // if there are no 2 consecutive ')'
                    ans += (o>0)?1:2;                      // if '(' is present previously then add 1 else add 2
                } else {                                   // if there are 2 consecutive ')'
                    ans += (o>0)?0:1;                      // if '(' is present previously then add 0 else add 1
                    i++;                                   // i++ so that is crosses next ')' too
                }
                o--;                                       // we have made one '(' balanced so decrement by 1 
                if(o<0) o=0;                               // if count of '(' is -ve then make it 0 so new fresh checking starts from next index
            }   
        }
        
        if(o > 0) {                                       // if there are any '(' left out, then add 2 ')' forEach '('
            ans+= 2*o;
        }
        
        return ans;
    }
}