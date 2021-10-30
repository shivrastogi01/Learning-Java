class SingleElement2 {//All element comes  3ice except one
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; ++i){ // If nums[i] is in map, increment by one. If not, set default value to 1
            if (map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1);
            else 
                map.put((nums[i]), 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){ // Iterate through map, and find index that has value == 1
            if (entry.getValue() == 1)
                return entry.getKey();
        }
        
        throw new IllegalArgumentException("Arguments do not satisfy given constraints");
        
    }
}