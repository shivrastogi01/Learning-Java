class NumberOfDistinctAverage {
      public int distinctAverages(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0, n = nums.length; i < n / 2; ++i) {
            seen.add(nums[i] + nums[n - 1 - i]);
        }
        return seen.size();
    }
}