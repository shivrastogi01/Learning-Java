class RussianDollEnvelope {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (p, q) -> p[0] == q[0] ? q[1] - p[1] : p[0] - q[0]);
        int n = envelopes.length;
        int lis[] = new int[n + 1];
        int l = 1;
        lis[0] = envelopes[0][1];
        for (int i = 1; i < n; i++) {
            int j = Arrays.binarySearch(lis, 0, l, envelopes[i][1]);
            if (j < 0) j = ~j;
            lis[j] = envelopes[i][1];
            if (j == l) {
                l++;
            }
        }
        return l;
    }
}