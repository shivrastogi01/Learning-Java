class NumberOfSubArrayMaximumBounded {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        
        int i=0;
        int j=0;
        int m=0;
        int count=0;
        
        while(j<nums.length){
            
            if(nums[j] > right){
                m=0;
                i=j+1;
            }
            
            if(nums[j]>=left && nums[j] <=right){
                m = j-i+1;
            }
            count+=m;
            j++;
            
            
        }
        
        return count;
        
    }
}