class BitwiseOrsSubarray {

public int subarrayBitwiseORs(int[] arr) {
    HashSet<Integer>[] dp = new HashSet[arr.length];
    HashSet<Integer> s = new HashSet<>();
    for (int i = 0; i < arr.length; i++) dp[i] = new HashSet<>();
    dp[0].add(arr[0]);
    s.add(arr[0]);
    for (int i = 1; i < arr.length; i++) {
        s.add(arr[i]);
        dp[i].add(arr[i]);
        for (int k : dp[i - 1]) {
            s.add(k | arr[i]);
            dp[i].add(k | arr[i]);
        }
    }
    return s.size();
}
}