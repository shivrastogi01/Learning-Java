class PlantingFlowerWithNoAdjacent {
    int[] ans = null;
    public int[] gardenNoAdj(int n, int[][] paths) {
        ans = new int[n];
        HashMap<Integer, HashSet<Integer>> m = new HashMap();
        
        for(int[] p: paths) {
            HashSet<Integer> h = m.getOrDefault(p[0], new HashSet());
            h.add(p[1]);
            m.put(p[0], h);
            
            HashSet<Integer> h1 = m.getOrDefault(p[1], new HashSet());
            h1.add(p[0]);
            m.put(p[1], h1);
        }
    
        int[] colors = new int[]{1,2,3,4};
        for(Integer key: m.keySet()) {
             dfs(m, colors, key);
        }
        
        for(int i=0; i<n; i++) {
            if (ans[i] == 0) ans[i] = 1;
        }
        return ans;
        
    }
    
    void dfs(HashMap<Integer, HashSet<Integer>> m, int[] col, int p) {
       if (ans[p-1] != 0) return;
        
        ans[p-1] = getFlower(p, col, m);
        for(Integer ad: m.get(p)) {
            dfs(m, col, ad);
        }
    }
    
    int getFlower(int p, int[] col, HashMap<Integer, HashSet<Integer>> m) {
        for(int c: col) {
            boolean canPick = true;
            for(Integer ad: m.get(p)) {
                if(ans[ad-1] == c) {
                    canPick = false;
                    break;
                }
            }
            if (canPick) return c;
        }
        return 0;
    }
}