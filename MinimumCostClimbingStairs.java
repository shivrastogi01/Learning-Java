class MinimumCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
       
        int len = cost.length;
        
        if(cost == null || len == 0)
            return 0;
        
        int[] copy = new int[len + 1];
        System.arraycopy(cost, 0, copy, 0, len);
        copy[cost.length] = 0;
        //cost = copy;
        
       
        for(int i = len - 3; i >= 0; i--){
          
           cost[i] += Math.min(cost[i+1], cost[i+2]);
          
        }
        
        return Math.min(cost[0], cost[1]);
    }
}