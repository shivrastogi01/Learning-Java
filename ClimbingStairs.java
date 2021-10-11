class ClimbingStairs {
    public int climbStairs(int n) {
        
        if(n < 2) return 1;
        if(n < 1) return 0;
       
        int prev = 1;
        int prevPrev = 1;
        
        int current = prev + prevPrev;
        
        for(int i = 2; i < n; ++i) {
            prev = prevPrev;
            prevPrev = current;
            
            current = prev + prevPrev;
        }
        
        return current;
    }
}