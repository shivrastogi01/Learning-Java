class New21Game{
    public double new21Game(int n, int k, int maxPts) {
        if (n >= k + maxPts - 1) {
            return 1.00000;
        }
        double[] prefixSum = new double[k + maxPts + 1];  //prefixSum[i+1] = sum(dp[0] ~ dp[i])
        double temp = 1.0;
        prefixSum[1] = 1.0;
        for (int i = 1; i < k + maxPts; i++) {
            int left = Math.max(i - maxPts, 0);
            int right = Math.min(i, k);
            temp = (prefixSum[right] - prefixSum[left]) / maxPts;
            prefixSum[i + 1] = prefixSum[i] + temp;
        }
        return prefixSum[n+1] - prefixSum[k];
    }
}