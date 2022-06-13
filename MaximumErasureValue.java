class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        int ans = 0;
        int left = 0;
        HashSet<Integer> set = new HashSet();
        int sum = 0;
        for(int right = 0; right < nums.length; right++){
            while(set.contains(nums[right])){
                set.remove(nums[left]);
                sum -= nums[left++];
            }
            sum += nums[right];
            set.add(nums[right]);
            
            ans = Integer.max(ans, sum);
        }
        
        return ans;
    }
}