class BeautifulArrangement {
    public int countArrangement(int n) {
        return backtrack(n, n, new Integer[1 << (n + 1)], 0);
    }
    
    private int backtrack(int n, int index, Integer[] cache, int cacheindex)
    {
        if(index == 0)
            return 1;
        
        int result = 0;
        if(cache[cacheindex] != null)
            return cache[cacheindex];
        
        for(int i = n; i > 0; i--)
        {
            if((cacheindex & (1 << i)) == 0 &&  (i%(index) == 0 || (index)%i == 0))
            {
                result += backtrack(n, index - 1, cache, cacheindex | 1 << i);
            }
        }
        
        cache[cacheindex] = result;
        return result;
    }
}
