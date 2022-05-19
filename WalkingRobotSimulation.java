class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        int furthest_point = 0;
        
        int[] pos = new int[]{0,0};
        
        int dir = 0;
        
        HashSet<String> hs = new HashSet<>();
        
        for(int[] obstacle: obstacles)
            hs.add(obstacle[0]+","+obstacle[1]);
        
        for(int i: commands){
            if(i == -1){
                dir = (dir+1)%4;
                continue;
            }
            
            else if(i == -2){
                if(dir == 0)
                    dir = 3;
                else
                    dir = (dir-1)%4;
                continue;
            }
            
            while(i-- > 0){
                if(dir == 0){
                    int x = pos[0];
                    int y = pos[1]+1;
                    
                    if(hs.contains(x+","+y))
                        continue; 
                    else
                        pos[1]++;
                }
                else if(dir == 1){
                    int x = pos[0]+1;
                    int y = pos[1];
                    
                    if(hs.contains(x+","+y))
                        continue; 
                    else
                        pos[0]++;
                }
                else if(dir == 2){
                    int x = pos[0];
                    int y = pos[1]-1;
                    
                    if(hs.contains(x+","+y))
                        continue; 
                    else
                        pos[1]--;
                }
                else if(dir == 3){
                    int x = pos[0]-1;
                    int y = pos[1];
                    
                    if(hs.contains(x+","+y))
                        continue; 
                    else
                        pos[0]--;
                }
            }
            furthest_point = Math.max(furthest_point, ((pos[0]*pos[0]) + (pos[1]*pos[1])));
        }
        return furthest_point;
    }
}