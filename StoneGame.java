class StoneGame{ 

 Map[] startToMToRes = {new HashMap<Integer, Map<Integer, int[]>>(), 
                           new HashMap<Integer, Map<Integer, int[]>>()};
    
    public int stoneGameII(int[] piles) {
        return helper(piles, 0, 1, true)[0];
    }
    
    private int[] helper(int[] piles, int start, int M, boolean turnA) {
        if(start >= piles.length) {
            return new int[] {0,0};
        }
        
        Map<Integer, int[]> mToRes = (Map) startToMToRes[turnA ? 0 : 1]
            .getOrDefault(start, new HashMap<Integer, int[]>());
        if(mToRes.containsKey(M)) {
            return mToRes.get(M);
        }
        
        int sum = 0;
        int[] res = new int[] {0, 0};
        for(int i = 0; i < 2 * M && start + i < piles.length; i++) {
            sum += piles[start + i];

            int mNew = Math.max(M, i + 1);
            int[] childRes = helper(piles, start + i + 1, mNew, !turnA);
            
            int a = childRes[0] + (turnA ? sum : 0);
            int b = childRes[1] + (!turnA ? sum : 0);
            
            if((turnA && a > res[0]) || (!turnA && b > res[1])) {
                res[0] = a;   
                res[1] = b;   
            }
        }
        
        mToRes.put(M, res);
        startToMToRes[turnA ? 0 : 1].put(start, mToRes);
        return res;
    }
}