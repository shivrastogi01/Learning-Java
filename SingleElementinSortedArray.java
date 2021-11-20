class SingleElementinSortedArray{
public int singleNonDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) return nums[i];
            else if (i != nums.length - 2) i++;
        }
        return nums[nums.length - 1];
    }
}