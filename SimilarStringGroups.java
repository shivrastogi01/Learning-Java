class SimilarStringGroups {
    public int numSimilarGroups(String[] strs) {
        int len = strs.length;
        int[] nums = new int [len];
        for (int index = 0; index < len; ++index) nums[index] = index;
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                if (equal(strs[i], strs[j])) {
                    union(i, j, nums);
                }
            }
        } 
        Set<Integer> set = new HashSet<>();
        for (var index = 0; index < len; ++index) set.add(find(index, nums));
        return set.size();
        
    }
    void union(int i, int j, int[] nums) {
        int rootI = find(i, nums);
        int rootJ = find(j, nums);
        nums[rootI] = rootJ;
    }
    int find(int i, int[] nums) {
        while(i != nums[i]) i = nums[i];
        return i;
    }
    boolean equal(String s1, String s2) {
        int diff = 0, index = 0, len = s1.length();
        for (; index < len && diff <= 2; ++index) {
            if (s1.charAt(index) != s2.charAt(index)) ++diff;
        }
        return index == len && (diff == 2 || diff == 0);
        
    }
}