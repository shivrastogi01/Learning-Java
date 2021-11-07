class PermutationSequence {
    private static void moveToLast(int[] a, int m) {
    int len = a.length;
    if (m == len - 1) return;
    int temp = a[m];
    // System.out.println(Arrays.toString(a));
    System.arraycopy(a, m + 1, a, m, len - m - 1);
    // System.out.println(Arrays.toString(a));
    a[len - 1] = temp;
  }

  public String getPermutation(int n, int k) {
    int[] fac = new int[n + 1], nums = new int[n];
    fac[0] = 1;
    for (int i = 1; i <= n; i++) {
      fac[i] = fac[i - 1] * i;
      nums[i - 1] = i;
    }
    StringBuilder builder = new StringBuilder(n);
    k -= 1;
    for (int i = n; i > 0; i--) {
      int m = k / fac[i - 1];
      k %= fac[i - 1];
      builder.append(nums[m]);
      moveToLast(nums, m);
    }

    return builder.toString();
  }
}