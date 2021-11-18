class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] bucket = new int[101];
        
        for (int i : heights)
            bucket[i]++;
        
        int ans = 0, currHeight = 0;
        
        for (int i = 0; i < heights.length; ++i) {
            while (bucket[currHeight] == 0)
                ++currHeight;
            
            if (currHeight != heights[i]) {
                ++ans;
            }
            
            bucket[currHeight]--;
        }
        
        return ans;
    }
}