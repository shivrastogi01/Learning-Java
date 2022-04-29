class MinimumAbsoluteSumDifference {
   public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        long sum = 0, maxDecrease = 0;
        TreeSet<Integer> set = new TreeSet<>();
        Arrays.stream(nums1).forEach(set::add);

        for (int i = 0; i < nums1.length; i++) {
            sum += Math.abs(nums1[i] - nums2[i]);
            if (nums1[i] != nums2[i]) {
                Integer ceil = set.ceiling(nums2[i]), floor = set.floor(nums2[i]);
                if (ceil != null) {
                    maxDecrease = Math.max(maxDecrease, Math.abs(nums1[i] - nums2[i]) - Math.abs(ceil - nums2[i]));
                }
                if (floor != null) {
                    maxDecrease = Math.max(maxDecrease, Math.abs(nums1[i] - nums2[i]) - Math.abs(floor - nums2[i]));
                }
            }
        }
        return (int) ((sum - maxDecrease) % (1e9 + 7));
    }
}