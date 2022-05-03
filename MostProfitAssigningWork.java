class MostProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxDifficulty = 0;
        int minDifficulty = Integer.MAX_VALUE;
        for (int diff: difficulty) {
            maxDifficulty = Math.max(maxDifficulty, diff);
            minDifficulty = Math.min(minDifficulty, diff);
        }
        int[] diffMap = new int[maxDifficulty + 1];
        for (int i = 0; i < profit.length; i++) {
            diffMap[difficulty[i]] = Math.max(diffMap[difficulty[i]], profit[i]);
        }
        for (int i = minDifficulty; i < diffMap.length; i++) {
            diffMap[i] = Math.max(diffMap[i], diffMap[i - 1]);
        }
        int total = 0;
        for (int w: worker) {
            if (w > maxDifficulty) {
                total += diffMap[maxDifficulty];
            } else {
                total += diffMap[w];
            }            
        }
        return total;
    }
}