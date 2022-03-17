class MagicSquareInGrid {
    public int numMagicSquaresInside(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length - 2; i++)
            for (int j = 0; j < grid[0].length - 2; j++)
                 if (this.isMagicBox(grid, i, j)) 
                     result++;
         return result;
    }

    boolean isMagicBox(int[][] grid, int x, int y) {
        if (grid[x+1][y+1] != 5)
            return false;
        boolean flag = false;
        int rowSum = 0;
        for (int r = x; r < x + 3; r++) {
            rowSum = 0;
            for (int c = y; c < y + 3; c++) {
                rowSum += grid[r][c];
                flag = !flag;
                if (r == x+1 && c == y+1)
                    continue;
                if (this.isEven(grid[r][c]) != flag)
                    return false;
            }
            if (rowSum != 15)
                return false;
        }
        return grid[x][y] + grid[x+1][y] + grid[x+2][y] == 15;
    }
    
    boolean isEven(int n) {
        return (n & 1) == 0;
    }
}