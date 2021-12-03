class PartionOfEqulSumSubArray{
    int[] input;
    boolean[] used;
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int sum = 0;
        for (int num : nums) sum += num;
        
        if (sum % k != 0) return false;       
        sum = sum / k;
        input = new int[nums.length];
        used = new boolean[nums.length];
        
        // as we know all nums are positive, we can sort them 
        // in descending order to make it fail-fast
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            input[i] = nums[nums.length - 1 - i];
        }
        
        for (int i = 0; i < k; i++) {
            if (!find(0, sum)) return false;
        }
        
        return true;
    }
    
    private boolean find(int i, int target) {
        if (i == input.length || input[i] > target) return false; // fail-fast
        
        if (used[i]) return find(i + 1, target);
        used[i] = true;
        
        if (input[i] == target) return true;
        target = target - input[i];
        
        for (int j = i + 1; j < input.length; j++) {
            if (find(j, target)) return true;
        }
        used[i] = false;
        return false;
    }
}