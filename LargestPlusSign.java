class LargestPlusSign {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] row = new int[n][n];
        int[][] col = new int[n][n];
        int[][] arr = new int[n][n];
        int ans = 0;
        
        for (int[] mine : mines) {
            int i = mine[0], j = mine[1];
            arr[i][j] = 1;
            row[i][j] = 1;
            col[i][j] = 1;
        }
        for (int i = 0; i < n; i++) {
            handleRow(i, row);
            handleCol(i, col);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = row[i][j];
                int y = col[i][j];
                ans = Math.max(ans, (Math.min(x, y)));
            }
        }
        return ans;
    }
    
    private void handleRow(int i, int[][] row) {
        List<Integer> temp = new ArrayList<>();
        temp.add(-1);
        for (int j = 0; j < row.length; j++) {
            if (row[i][j] == 1) {
                temp.add(j);
                row[i][j] = 0;
            }
        }
        temp.add(row.length);
        int right = temp.get(0);
        int left = 0;
        for (int j = 1; j < temp.size(); j++) {
            left = right;
            right = temp.get(j);
            for (int k = left + 1; k < right; k++) {
                row[i][k] = Math.min(k - left, right - k);
            }
        }
    }
    
    private void handleCol(int j, int[][] col) {
        List<Integer> temp = new ArrayList<>();
        temp.add(-1);
        for (int i = 0; i < col.length; i++) {
            if (col[i][j] == 1) {
                temp.add(i);
                col[i][j] = 0;
            }
        }
        temp.add(col.length);
        int bot = temp.get(0);
        int top;
        for (int i = 1; i < temp.size(); i++) {
            top = bot;
            bot = temp.get(i);
            for (int k = top + 1; k < bot; k++) {
                col[k][j] = Math.min(k-top, bot-k);
            }
        }
    }
}