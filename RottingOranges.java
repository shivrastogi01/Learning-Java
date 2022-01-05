class RottingOranges {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> pq = new LinkedList<>();
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    pq.add(new int[]{i, j});
                }
            }
        }
        
        Queue<int[]> cq = new LinkedList<>();
        int minutes = 0;
        
        while(!pq.isEmpty()){
            int[] curr = pq.remove();
            
            // grid[curr[0]][curr[j]] = 
                
            if(curr[0]-1 >= 0){
                if(grid[curr[0]-1][curr[1]] == 1){
                    // fresh orange
                    grid[curr[0]-1][curr[1]] = 2;
                    cq.add(new int[]{curr[0]-1, curr[1]});
                }
            }    
            if(curr[1]-1 >= 0){
                if(grid[curr[0]][curr[1]-1] == 1){
                    // fresh orange
                    grid[curr[0]][curr[1]-1] = 2;
                    cq.add(new int[]{curr[0], curr[1]-1});
                }
            }    
            if(curr[0]+1 < grid.length){
                if(grid[curr[0]+1][curr[1]] == 1){
                    // fresh orange
                    grid[curr[0]+1][curr[1]] = 2;
                    cq.add(new int[]{curr[0]+1, curr[1]});
                }
            }    
            if(curr[1]+1 < grid[0].length){
                if(grid[curr[0]][curr[1]+1] == 1){
                    // fresh orange
                    grid[curr[0]][curr[1]+1] = 2;
                    cq.add(new int[]{curr[0], curr[1]+1});
                }
            }
            
            if(pq.isEmpty() && !cq.isEmpty()){
                pq = cq;
                cq = new LinkedList<>();
                minutes++;
            }
        }
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        
        return minutes;
    }
}