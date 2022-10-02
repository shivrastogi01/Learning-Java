class NumberOfDiceRollsWithTargetSum {
    public int numRollsToTarget(int d, int f, int target) {
        return dfs(d, f, target, new Integer[d+1][target+1]);
    }
    
    int dfs(int d, int f, int target, Integer[][] cache){
        int MOD = 1_000_000_007;
        
        if(d == 0 && target == 0)
            return 1;

        if(d == 0 || target <= 0)
            return 0;
        
        if(cache[d][target] == null){
            int count = 0;
            // For each face in a die
            for(int i=1; i <= f; i++)
                count = (count + dfs(d-1, f, target - i, cache)) % MOD;
            cache[d][target] = count;
        }        
        return cache[d][target];
    }
}