class QueenThatCanAttackKing {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> al = new ArrayList<>();
        int[][] board = new int[8][8];
        for(int[] coordinate : queens) {
            board[coordinate[0]][coordinate[1]] = 1;
        }
        
		
		// Simply traverse from the king's coordinates in all the 8 directions and add the first observed coordinate of the queen in all these 8 directions
        int row = king[0], col = king[1];
		
        for(int j = col; j < board.length; j++) {
            if(board[row][j] == 1) {
                al.add(new ArrayList<>(Arrays.asList(row, j)));
                break;
            }
        }
        
        for(int j = col; j >= 0; j--) {
            if(board[row][j] == 1) {
                al.add(new ArrayList<>(Arrays.asList(row, j)));
                break;
            }
        }
        
        for(int i = row; i < board.length; i++) {
            if(board[i][col] == 1) {
                al.add(new ArrayList<>(Arrays.asList(i, col)));
                break;
            }
        }
        
        for(int i = row; i >= 0; i--) {
            if(board[i][col] == 1) {
                al.add(new ArrayList<>(Arrays.asList(i, col)));
                break;
            }
        }
        
        
        for(int i = row + 1, j = col + 1; i < board.length && j < board.length; i++, j++) {
            if(board[i][j] == 1) {
                al.add(new ArrayList<>(Arrays.asList(i, j)));
                break;
            }
        }
        
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 1) {
                al.add(new ArrayList<>(Arrays.asList(i, j)));
                break;
            }
        }
        
        for(int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if(board[i][j] == 1) {
                al.add(new ArrayList<>(Arrays.asList(i, j)));
                break;
            }
        }
        
        for(int i = row + 1, j = col - 1; i < board.length && j >= 0; i++, j--) {
            if(board[i][j] == 1) {
                al.add(new ArrayList<>(Arrays.asList(i, j)));
                break;
            }
        }
        
        return al;
    }
}