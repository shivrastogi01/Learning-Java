class MaximumEqualFrequency {
    int ans = 0;
    public int maxEqualFreq(int[] nums) {
        TreeMap<Integer,Set<Integer>> map = new TreeMap<>();
        int[] counter = new int[(int)1e5+3];
        for(int i=0;i<nums.length;i++){
            int prev = counter[nums[i]];
            map.getOrDefault(prev,new HashSet<>()).remove(nums[i]);
            if(map.getOrDefault(prev,new HashSet<>()).size()==0){
                map.remove(prev);
            }
            counter[nums[i]]++;
            Set<Integer> set = map.getOrDefault(counter[nums[i]],new HashSet<>());
            set.add(nums[i]);
            map.put(counter[nums[i]],set);
            check(map,i+1);
        }
        check(map,nums.length);
        return ans;
    }
    
    private void check(TreeMap<Integer,Set<Integer>> map,int len){
        if(map.size()==1){
            if(map.containsKey(1)||map.get(map.firstKey()).size()==1){
                ans = Math.max(ans,len);
            }
        }else if(map.size()==2){
            int first = map.firstKey();
            if(first==1 && map.get(first).size()==1){
                ans = Math.max(ans,len);
            }
            int second = map.lastKey();
            if(second==first+1 && map.get(second).size()==1){
                ans = Math.max(ans,len);
            }
        }
    }
}