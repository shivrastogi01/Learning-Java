class RLEIterator {
    public TreeMap<Long, Integer> map;
    public long count;
    public RLEIterator(int[] encoding) {
        map = new TreeMap<>();
        long c = 0;
        for (int i = 0; i < encoding.length; i += 2) {
            if (encoding[i] == 0)
                continue;
            c += (long)encoding[i];
            map.put(c, encoding[i + 1]);
        }
    }
    
    public int next(int n) {
        count += (long)n;
        Long ceilingKey = map.ceilingKey(count);
        if (ceilingKey == null)
            return -1;
        return map.get(ceilingKey);
    }
}