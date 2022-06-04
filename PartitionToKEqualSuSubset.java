class PartitionToKEqualSuSubset {
    
    int[] bins;
    int[] nums;
    int numberOfBins;
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0, max = 0;
        for (var num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        
        if (sum % k != 0 || max > sum / k || nums.length < k)
            return false;
        
        this.numberOfBins = k;
        this.bins = new int[numberOfBins];
        this.nums = nums;
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; ++i, --j) {
            int temp = this.nums[i];
            this.nums[i] = this.nums[j];
            this.nums[j] = temp;
        }
        
        return dfs(0, sum / k);
    }
    
    private boolean dfs(int index, int target) {
        if (index == nums.length)
            return true;
        
        Set<Integer> binValues = new HashSet<>();
        
        for (int i = 0; i < numberOfBins; ++i) {
            if (binValues.contains(bins[i])) 
                continue; // already processed such request
            
            if (bins[i] + nums[index] > target) 
                continue; // pruning out this branch
            
            binValues.add(bins[i]);
            bins[i] += nums[index];
            if (dfs(index + 1, target))
                return true;
            bins[i] -= nums[index];
        }
        
        return false;
    }
}