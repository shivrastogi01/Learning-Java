class LargestSubArrayWithSumK
{
    // Naive function to find the maximum length subarray with sum `S` present
    // in a given array
    public static void findMaxLenSubarray(int[] nums, int S)
    {
        // `len` stores the maximum length of subarray with sum `S`
        int len = 0;
 
        // stores ending index of the maximum length subarray having sum `S`
        int ending_index = -1;
 
        // consider all subarrays starting from `i`
        for (int i = 0; i < nums.length; i++)
        {
            int target = 0;
 
            // consider all subarrays ending at `j`
            for (int j = i; j < nums.length; j++)
            {
                // sum of elements in the current subarray
                target += nums[j];
 
                // if we have found a subarray with sum `S`
                if (target == S)
                {
                    // update length and ending index of maximum length subarray
                    if (len < j - i + 1)
                    {
                        len = j - i + 1;
                        ending_index = j;
                    }
                }
            }
        }
 
        // print the subarray
        System.out.println("[" + (ending_index - len + 1)
                            + ", " + ending_index + "]");
    }
 
    public static void main (String[] args)
    {
        int[] nums = { 5, 6, -5, 5, 3, 5, 3, -2, 0 };
        int target = 8;
 
        findMaxLenSubarray(nums, target);
    }
}