class MinSwapToMakeStringEqual {
    public int minimumSwap(String s1, String s2) {
        int xy = 0;
        int yx = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) if (c1 == 'x') xy++; else yx++;
        }
        if (1 == ((xy+yx)&1)) return -1;
        
        int count = 0;
        count += xy/2;
        count += yx/2;
        count += 2*(xy%2);
        
        return count;
    }
}