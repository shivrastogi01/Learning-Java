class MaxIncreaseKeepingSkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int increase = 0;
        int[] rowmax = new int[grid.length], colmax = new int[grid.length];
        for (int i = 0; i < grid.length; i ++) {
            final int x = i;
            rowmax[i] = Arrays.stream(grid[i]).map(j -> -j).sorted().map(j -> -j).limit(1).sum();
            colmax[i] = Arrays.stream(grid).map(j -> -j[x]).sorted().map(j -> -j).mapToInt(Integer::intValue).limit(1).sum();
        }
        int i = 0, j = 0;
        while (i < grid.length) {
            if (j == grid.length) {
                j = 0;
                i ++;
                continue;
            }
            increase += Math.min(rowmax[i], colmax[j]) - grid[i][j];
            j ++;
        }
        return increase;
    }
}