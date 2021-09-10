class RotateArrayByOne {
    public void rotate(int[] nums, int k) {
        int n = nums.length;        // num = [1,2,3,4,5,6,7] and k = 3
        k = k % n;
        reverse(nums, 0, n - 1);    // nums = [7,6,5,4,3,2,1]
        reverse(nums, 0, k - 1);    // nums = [5,6,7,4,3,2,1]
        reverse(nums, k , n - 1);   // nums = [5,6,7,1,2,3,4] -> after rotation
    }
    
    void reverse(int[] nums, int start, int end){
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }
}