class BricksFallingWhenHit{
    int[] par;
    int[] num;
    public int[] hitBricks(int[][] grid, int[][] hits) {
        if (grid == null || grid.length == 0){
            return new int[]{};
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int k = hits.length;
        int[] result = new int[k];
        
        par = new int[m * n];
        num = new int[m * n];
        
        for (int[] hit : hits){
            // erase brick only
            int x = hit[0];
            int y = hit[1];
            if (grid[x][y] == 1) grid[x][y] = 2; 
        }
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    addBrick(grid, m, n, i, j, false);
                }
            }
        }
        
        //rebuild the wall
        for (int i = k - 1; i >= 0; i--){
            int[] cur = hits[i];
            int x = cur[0];
            int y = cur[1];
            if (grid[x][y] != 2) {
                result[i] = 0;
                continue;
            }
            grid[x][y] = 1;
            int increment = addBrick(grid, m, n, x, y, true);
            result[i] = increment;
        }
        return result;
    }
    
    public int addBrick(int[][] grid, int m, int n, int i, int j, boolean checkLower){
        int key = i * n + j;
        par[key] = key;
        num[key] = 1;
        // return the number of new stabled brick
        int count = key < n ? 1 : 0; 
        if (i > 0 && grid[i - 1][j] == 1) count += union(key, key - n, n);
        if (j > 0 && grid[i][j - 1] == 1) count += union(key, key - 1, n);
        if (checkLower && i < m - 1 && grid[i + 1][j] == 1) count += union(key, key + n, n);
        if (checkLower && j < n - 1 && grid[i][j + 1] == 1) count += union(key, key + 1, n);
        return Math.max(0, count - 1); // erasure brick will not count as falling ones
    }
    
    public int union(int x, int y, int n){
        // not union two sets together, but also union the size number, return the increment
        int rx = find(x);
        int ry = find(y);
        
        if (rx == ry) return 0;
        
        // all nodes in ry set will be stabled
        if (rx < n && ry >= n) {
            par[ry] = par[rx];
            num[rx] += num[ry];
            return num[ry];
        } 
        else if (rx >= n && ry < n){ // nodes in rx will be stabled
            par[rx] = par[ry];
            num[ry] += num[rx];
            return num[rx];
        }
        else {  // no change in status
            par[rx] = par[ry];
            num[ry] += num[rx];
            return 0;
        }
        
    }
    public int find(int x){
        if (par[x] == x) return x;
        par[x] = find(par[x]);
        return par[x];
    }
}