class LengthOfLongestFibonacciSubsequence {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = arr[i];
                int b = arr[j];
                int k = 2;
                while (map.containsKey(a + b)) {
                    int c = a + b;
                    a = b;
                    b = c;
                    k++;
                }
                max = Math.max(max, k);
            }
        }
        return max == 2 ? 0 : max;       
    }
}