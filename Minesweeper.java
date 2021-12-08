class Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0], c = click[1];
        if(board[r][c] == 'M') {
            board[r][c] = 'X';
        } else {        
            dfs(board, r, c);
        }

        return board;
    }
    
    private static void dfs(char[][] board, int r, int c) {
        if(outOfBounds(board, r, c) || board[r][c] != 'E')
            return;
        
        int mines = getMinesCount(board, r, c);
        if(mines > 0) {
            board[r][c] = (char)('0' + mines);
            return;
        }

        board[r][c] = 'B';
        for(int ro = -1; ro <= 1; ro++) {
            for(int co = -1; co <= 1; co++) {
                dfs(board, r + ro, c + co);
            }
        }
    }
    
    private static int getMinesCount(char[][] board, int r, int c) {
        int result = 0;
        for(int ro = -1; ro <= 1; ro++) {
            for(int co = -1; co <= 1; co++) {
                int r2 = r + ro, c2 = c + co;
                if(!outOfBounds(board, r2, c2) && board[r2][c2] == 'M')
                    result++;
            }
        }
        
        return result;
    }
    
    private static boolean outOfBounds(char[][] board, int r, int c) {
        return r < 0 || c < 0 || r >= board.length || c >= board[0].length;
    }
}