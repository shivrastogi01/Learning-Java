class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        int row = board.length;     // row = 2
        int col = board[0].length;  // col = 3
        String target = getString(new int[][] {{1, 2, 3}, {4, 5, 0}});
        if (getString(board).equals(target))
            return 0;
        
        HashSet<String> visited = new HashSet<>();
        Queue<int[][]> queue = new LinkedList<>();
        
        queue.add(deepCopy(board));
        visited.add(getString(board));
        int[][] shifts = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[][] cur = queue.poll();
                // find the position of empty
                int x = 0, y = 0;   
                for (int rowIndex = 0; rowIndex < row; rowIndex++) {
                    for (int colIndex = 0; colIndex < col; colIndex++) {
                        if (cur[rowIndex][colIndex] == 0) {
                            x = rowIndex;
                            y = colIndex;
                        }
                    }
                }
                
                // check all possible moves
                for (int[] shift:shifts) {
                    int xNew = x + shift[0];
                    int yNew = y + shift[1];
                    if (xNew >= 0 && yNew >= 0 && xNew < row && yNew < col) {
                        int[][] boardNew = deepCopy(cur);
                        int temp = boardNew[x][y];
                        boardNew[x][y] = boardNew[xNew][yNew];
                        boardNew[xNew][yNew] = temp;
                        
                        if (getString(boardNew).equals(target))
                            return step;
                        
                        String strNew = getString(boardNew);
                        if (!visited.contains(strNew)) {
                            visited.add(strNew);
                            queue.add(boardNew);
                        }
                    }
                }
            }
            
            step ++;
        }
        
        return -1;
    }
    
    private String getString(int[][] board) {
        String str = "";
        for (int[] row:board) {
            for (int cur:row) {
                str = str + String.valueOf(cur);
            }
        }
        
        return str;
    }
    
    private int[][] deepCopy(int[][] origin) {
        int row = origin.length;
        int col = origin[0].length;
        int[][] clone = new int[row][col];
        for (int i = 0; i < row; i++) {
            clone[i] = Arrays.copyOf(origin[i], col);
        }
        
        return clone;
    }

}