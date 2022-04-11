class MaxDistanceBetweenTwoPairsOfValues{
   public int maxDistance(int[] nums1, int[] nums2) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums1.length; i++)
        {
            int index = getIndex(nums2,i,nums1[i]);
            if(index - i < max)
                continue;
            max = Math.max(max, index-i);
        }
        return max < 0? 0 : max;
    }
    
    private int getIndex(int[] nums, int start, int target)
    {
        int left = start, right = nums.length-1;
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(nums[mid] >= target)  
                left = mid+1;
            else
                right = mid-1 ;
        }
        return right;
    }
}