class BeautifulArrangements {
    public void flip(int[] nums, int left, int right){
        while(left <= right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    public int[] constructArray(int n, int k) {
        int[] nums = new int[n];
        
        for(int i=1; i<=n; i++)
            nums[i-1] = i;
        
        int i = 0;
        while(i != k){
            flip(nums, i, n-1);
            i++;
        }
        return nums;
    }
}