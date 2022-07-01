class KnightProbabilityInChessBoard {

int[][] moves = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};

public double knightProbability(int n , int k, int row, int col) {
    if (n == 0) return 0;
    
    return knightProbability(n, k, row, col, new Double[k + 1][n][n]);
}

private double knightProbability(int n, int k, int row, int col, Double[][][] cache) {
    if (!isValid(n, row, col)) return 0;
    
    if (k == 0) return 1;
    
    if (cache[k][row][col] != null) 
        return cache[k][row][col];
    
    double probability = 0;
    
    for (int[] move : moves) {
        int nrow = row + move[0];
        int ncol = col + move[1];
         
        probability += knightProbability(n, k - 1, nrow, ncol, cache) / 8;   
    }
    
    return cache[k][row][col] = probability;
}

private boolean isValid(int n, int row, int col) {
    if (row < 0 || row >= n || col < 0 || col >= n) return false;
    
    return true;
}
}