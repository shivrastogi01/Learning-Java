class ConsecutiveNumberSum{
    public int consecutiveNumbersSum(int N) {
        
        
   int res=0;
        int i=1;
        
        while(N>0){
            N-=i;
            
            if(N%i==0){
                res++;
            }
            i++;
        }
        
        return res;
    }
}
