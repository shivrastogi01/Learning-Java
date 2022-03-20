class MonotoneIncreasingDigits{
    public int monotoneIncreasingDigits(int n) {
        String str = String.valueOf(n);
        int length = str.length();
        int[] nums = new int[length];
        int idx = length;
        int ans = 0;
        for (int i = 0; i < length; i++) {
            nums[i] = Integer.parseInt(str.substring(i, i + 1));
            if (i > 0 && nums[i-1] > nums[i]) {
                idx = Math.min(idx, i - 1);
                while (idx > 0 && nums[idx - 1] == nums[idx]) {
                    idx--;
                }
            }
        }
        for (int i = 0; i < length; i++) {
            if (i < idx) {
                ans = 10 * ans + nums[i];
            } else if (i == idx) {
                ans = 10 * ans + (nums[i] - 1);
            } else {
                ans = 10 * ans + 9;
            }
        }
        return ans;
    }
}