class CountingBits {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i < n + 1; ++ i) {
            res[i] = countBitOne(i);
        }
        return res;
    }
    
    private int countBitOne(int num) {
        int count = 0;
        for (int i = 0; i < 32; ++ i) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
}