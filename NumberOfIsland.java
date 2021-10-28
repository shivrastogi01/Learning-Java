class NumberOfIsland {

public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    BFS(grid, i, j);
                }
            }
        }
        return islands;
    }

    private void BFS(char[][] grid, int x, int y) {
        // Mark the land as visited by setting it to '0'
        grid[x][y] = '0';

        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{x, y});

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (q.size() > 0) {
            int size = q.size();
            int[] p = q.poll();

            for (int i = 0; i < size; i++) {
                for (int[] dir : dirs) {
                    int x1 = p[0] + dir[0];
                    int y1 = p[1] + dir[1];

                    // Invalid neighbor skipped
                    if(x1 < 0 || x1 >= grid.length || y1 < 0 || y1 >= grid[0].length)
                        continue;

                    if (grid[x1][y1] == '1') {
                        grid[x1][y1] = '0';
                        q.offer(new int[] {x1, y1});
                    }
                }
            }
        }
    }
}