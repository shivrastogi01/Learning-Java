class CutOffTressForGolfEvent {
    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList<>();
        for (int i  = 0; i < forest.size(); i++) for (int j = 0; j < forest.get(i).size(); j++) if (forest.get(i).get(j) > 1) trees.add(new int[]{i, j, forest.get(i).get(j)});
        Collections.sort(trees, (a,b)->a[2]-b[2]);
        int[] start = new int[2];
        int res = 0;
        for (int[] end : trees) {
            int steps = bfs(forest, start, end);
            if (steps == -1) return -1;
            res += steps;
            start = end;
        }
        return res;
    }
    private int bfs(List<List<Integer>> forest, int[] s, int[] e) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{s[0],s[1]}); 
        int n = forest.size(), m = forest.get(0).size();
        boolean[][] visited = new boolean[n][m];
        visited[s[0]][s[1]] = true;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        int steps = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (cur[0] == e[0] && cur[1] == e[1]) return steps;
                for (int[] d : dir) {
                    int x = d[0] + cur[0], y = d[1] + cur[1];
                    if (x >= 0 && x < forest.size() && y >= 0 && y < forest.get(x).size() && !visited[x][y] && forest.get(x).get(y) > 0) {
                        q.offer(new int[]{x, y}); 
                        visited[x][y] = true;
                    }
                }
            }
            steps++;            
        }
        return -1;
    }
}
