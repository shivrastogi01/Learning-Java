class ContainVirus {
    HashSet<Integer> seen;
    List<HashSet<Integer>> regions;
    List<HashSet<Integer>> neighbours;
    List<Integer> perimiters;
    int [][] grid;
    int [][] dirs;
    int ROW;
    int COL;
    public int containVirus(int[][] grids) {
        this.grid = grids;
        this.ROW = grid.length;
        this.COL = grid[0].length;
        this.dirs = new int [][]{{-1,0},{1,0},{0,1},{0,-1}};
        int result = 0;
        while(true){
            this.seen = new HashSet();
            this.regions = new ArrayList();
            this.neighbours = new ArrayList();
            this.perimiters = new ArrayList();
            for(int r =0;r<grid.length;r++){
                for(int c =0;c<grid[r].length;c++){
                    int getIndex = COL*r+c;
                    if(grid[r][c] == 1 && !this.seen.contains(getIndex)){
                        this.regions.add(new HashSet());
                        this.neighbours.add(new HashSet());
                        this.perimiters.add(0);
                        bfs(r,c);
                    }
                }
            }
            if(regions.size() == 0)
                break;
            int boundaryRegionIndex = 0;
            for(int i =0;i<neighbours.size();i++){
                HashSet<Integer> neighbour = neighbours.get(i);
                boundaryRegionIndex = neighbour.size() > neighbours.get(boundaryRegionIndex).size()?i:boundaryRegionIndex;
                }
            for(int i =0;i<regions.size();i++){
                if(i == boundaryRegionIndex){
                    HashSet<Integer> region = regions.get(i);
                    Iterator<Integer> itr = region.iterator();
                    while(itr.hasNext()){
                        int index = itr.next();
                        int r = index/COL;
                        int c = index%COL;
                        this.grid[r][c] = -1;
                    }
                    result += perimiters.get(i);
                }
                else{
                     HashSet<Integer> neighbour = neighbours.get(i);
                        Iterator<Integer> itr = neighbour.iterator();
                         while(itr.hasNext()){
                             int index = itr.next();
                             int r = index/COL;
                             int c = index%COL;
                             this.grid[r][c] = 1;
                    }
                }
            }
        }
        return result;
    }
    
    private void bfs(int row, int col){
        Queue<Integer> queue = new LinkedList();
        queue.add(COL*row+col);
        seen.add(COL*row+col);
        while(queue.size() > 0){
            int index = queue.poll();
            regions.get(regions.size()-1).add(index);
            int r = index/COL;
            int c = index%COL;
            for(int [] dir : dirs){
                int nextRow = r + dir[0];
                int nextCol = c + dir[1];
                int nextIndex = COL*nextRow+nextCol;
                if(nextRow >=0 && nextRow < ROW && nextCol >=0 && nextCol < COL){
                    if(grid[nextRow][nextCol] == 0){
                        neighbours.get(neighbours.size()-1).add(nextIndex);
                        perimiters.set(perimiters.size()-1, perimiters.get(perimiters.size()-1)+1);
                    }
                    else if(grid[nextRow][nextCol] == 1 && !seen.contains(nextIndex)){
                        seen.add(nextIndex);
                        queue.add(nextIndex);
                    }
                }
            }
        }
        
    }
}