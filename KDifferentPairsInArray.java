class KDifferentPairsInArray {
    public int findPairs(int[] nums, int k) 
    {
        if(k==0)
            return kIsZero(nums);
        int c=0;
        HashSet<Integer> H = new HashSet<>();
        for(int i:nums)
        {
            if(H.contains(i))
                continue;
            if(H.contains(i-k))
                c++;
            if(H.contains(i+k))
                c++;
            H.add(i);
        }
        return c;
    }
    public int kIsZero(int[] nums)
    {
        int c=0;
        HashSet<Integer> H = new HashSet<>();
        HashSet<Integer> C = new HashSet<>();
        for(int i:nums)
        {
            if(C.contains(i))
                continue;
            if(H.contains(i))
            {
                c++;
                C.add(i);
            }
            H.add(i);
        }
        return c;
    }
}