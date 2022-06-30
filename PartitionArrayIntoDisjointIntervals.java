class PartitionArrayIntoDisjointIntervals{
    public int partitionDisjoint(int[] nums) {
        int lmax = nums[0];
        int greater = nums[0];
        int ans = 0;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > greater) greater = nums[i];
            else if (nums[i] < lmax){
                lmax = greater;
                ans = i;
            }
        }
        return ans+1;
    }
}