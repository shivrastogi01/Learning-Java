class DecreaseArray {
    public int movesToMakeZigzag(int[] nums) {
        int count1 = 0, count2 = 0;
        int nums1[] = nums.clone();
        int nums2[] = nums.clone();
        //Checking the condition that all even placed numbers are greater than their adjacent position numbers..
        for(int i = 1;i<nums1.length;i++){
            if(i%2 == 1){
                if(nums1[i] >= nums1[i-1]){
                    int moves = nums1[i] - nums1[i-1] + 1;
                    count1 += moves;
                    nums1[i] = nums[i-1] - 1;
                }
            }
            else{
                if(nums1[i] <= nums1[i-1]){
                    int moves = nums1[i-1] - nums1[i] + 1;
                    count1 += moves;
                    nums1[i-1] = nums[i] - 1;
                }
            }
        }
        
        //Checking for the condition that all odd placed numbers are greater than their adjacent position numbers-->
        for(int i = 1;i<nums2.length;i++){
            if(i%2 == 0){
                if(nums2[i] >= nums2[i-1]){
                    int moves = nums2[i] - nums2[i-1] + 1;
                    count2 += moves;
                    nums2[i] = nums2[i-1] - 1;
                }
            }
            else{
                if(nums2[i] <= nums2[i-1]){
                    int moves = nums2[i-1] - nums2[i] + 1;
                    count2 += moves;
                    nums2[i-1] = nums2[i] - 1;
                }
            }
        }
        return Math.min(count1, count2);
    }
}