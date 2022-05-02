class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int arr[] = new int[nums.length];
        int n = nums.length-1;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                arr[k++] = nums[i];
            } else {
                arr[n--] = nums[i];
            }
        }
        return arr;
    }
}