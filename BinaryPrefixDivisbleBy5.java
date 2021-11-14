class BinaryPrefixDivisbleBy5 {
   public List<Boolean> prefixesDivBy5(int[] nums) {
        int a = 0;
        List<Boolean> res = new ArrayList<>();
        for (int i :nums) {
            a = (a << 1 | i) % 5;
            res.add(a == 0);
        }
        return res;
    }
}