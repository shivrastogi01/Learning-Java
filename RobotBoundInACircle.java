class RobotBoundInACircle {
    public boolean isRobotBounded(String instructions) {
        int x=0, y=0, dir=1; // dir = 1 -> 'N' 
        for(char c: instructions.toCharArray()){
            if(c== 'G'){
                if(dir == 1) //N
                    y++;
                else if(dir == 2)// E
                    x++;
                else if(dir == 3) // S
                    y--;
                else // W
                    x--;
            }
            else if( c == 'L')
                dir = dir == 1 ? 4 : dir -1 ; 
            else
                dir = dir == 4 ? 1 : dir +1;
        }
        return x == 0 && y == 0 || dir > 1; 
    }
}