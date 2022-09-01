class LongestWellPerformingIntervals {
  
    //0(n)
    public int longestWPI(int[] hours) {
        /*
          s1+s2=sum
          s2=sum-s1
          sum-s1>0
          sum > s1
        */
        int res = 0, score = 0, n = hours.length;
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            score += hours[i] > 8 ? 1 : -1;
            if (score > 0) {
                res = i + 1;
            } else {
                seen.putIfAbsent(score, i);
                if (seen.containsKey(score - 1))
                    res = Math.max(res, i - seen.get(score - 1));
            }
        }
        return res;
    }
}