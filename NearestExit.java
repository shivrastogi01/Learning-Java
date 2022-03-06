class NearestExit {
    public int nearestExit(char[][] maze, int[] entrance) {
        int M = maze.length;
        int N = maze[0].length;
        
        int[][] delta = new int[][] { {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        int stepCount = 1;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';  // mark as + to indicate we cannot go back to that location
        
        int i, j, x, y, K;
        int[] current;
        
        while(!queue.isEmpty()){
            K = queue.size();
            for(i = 0; i < K; i++){
                current = queue.poll();
        
                for(j = 0; j < 4; j++){
                    x = current[0] + delta[j][0];
                    y = current[1] + delta[j][1];
                    
                    if(x >= 0 && x < M && y >= 0 && y < N){
                        if(maze[x][y] == '.'){
                            // empty cell
                            if(x == 0 || x == M - 1 || y == 0 || y == N - 1){
                                return stepCount;
                            }else{
                                maze[x][y] = '+';  // mark as + to indicate we cannot go back to that location
                                queue.offer(new int[] { x, y });
                            }
                        }
                    }
                }
            }
            
            ++stepCount;
        }
        
        return -1;
    }
}