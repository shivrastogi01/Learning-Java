class CardFlippingGame {
    public int flipgame(int[] fronts, int[] backs) {        
        Set<Integer> both = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) both.add(fronts[i]);
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < fronts.length; i++) {
            if (!both.contains(fronts[i])) res = Math.min(res, fronts[i]);
            if (!both.contains(backs[i])) res = Math.min(res, backs[i]);
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}