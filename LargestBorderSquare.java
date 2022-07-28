class LargestBorderSquare {
    public int largest1BorderedSquare(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        // Create a memo
        int rows = grid.length, cols = grid[0].length;
        int[][][] memo = new int[rows][cols][2];
        memo[0][0][0] = grid[0][0] == 0 ? 0 : 1;
        memo[0][0][1] = memo[0][0][0];

        // Pre-processing:
        // (1) first row: [0][i]
        for (int i = 1; i < cols; i++) {
            if (grid[0][i] == 0) {
                continue;
            }
            memo[0][i][0] = memo[0][i - 1][0] + 1;
            memo[0][i][1] = 1;
        }
        // (2) first col; [i][0]
        for (int i = 1; i < rows; i++) {
            if (grid[i][0] == 0) {
                continue;
            }
            memo[i][0][0] = 1;
            memo[i][0][1] = memo[i - 1][0][1] + 1;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (grid[i][j] == 0) {
                    continue; // 0
                }
                // (1) horizontal (left --> right)
                memo[i][j][0] = memo[i][j - 1][0] + 1;
                // (2) veritical (top --> down)
                memo[i][j][1] = memo[i - 1][j][1] + 1;
            }
        }

        // Find the max side length (side) for squares that use [i][j] as bottom-right vertex;
        int maxSide = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 2.1 Find possible side length;
                int side = Math.min(memo[i][j][0], memo[i][j][1]);

                // pruning 1
                if (side < maxSide) {
                    // Even if we can find a valid square, it can not be answer
                    // (because we're looking for the largest).
                    continue;
                }

                // 2.2 Validte the other two sides which we don't know yet.
                for (; side > maxSide; side--) {
                    if (memo[i - side + 1][j][0] >= side && memo[i][j - side + 1][1] >= side) {
                        maxSide = side;
                        break; // pruning 2: no need to consider smaller sides...We're looking for max.
                    }
                }
            }
        }
        return maxSide * maxSide;
    }
}