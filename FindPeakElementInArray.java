class FindPeakElementInArray {
    public int findPeakElement(int[] nums) {
      if(nums.length<2) return 0;
        int start=0;
        int end=nums.length-1;
        int mid=0;        
        while(start<end){
          mid=start+(end-start)/2;
            if(nums[mid]<nums[mid+1]){
                start=mid+1;
            }
            else{
                end=mid;
            }
        }
        return start;
    }
}