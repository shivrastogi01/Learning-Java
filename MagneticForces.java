class MagneticForces {
   public int maxDistance(int[] position, int m) {
        int l = 0;// minimum mag force diff we can achieve
        int r = Integer.MAX_VALUE; // maximum we can achieve
        int maxForceSoFar=r;
        Arrays.sort(position);// Its easier to sort array to find isPossible, although this increases the time complexity to NLog(N)
        
        while(l <= r){
            int mid = l + (r-l)/2;// Max force we can achieve with m balls
            
            boolean isPossible = check(position,mid,m);
            
            if(isPossible){// If still possible, Try to get more force -> Go to right
                maxForceSoFar = mid;
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return maxForceSoFar;
    }
    
    private boolean check(int[] position, int maxForce, int m){
        int currPos = position[0];
        m -= 1; // Placed first ball at first position
        for(int i = 1; i < position.length; i++){
            int nextPos = position[i];
            if((nextPos - currPos) >= maxForce){
                m -= 1;//place next ball
                currPos = nextPos;
            }
        }
        return m <= 0;
    }
}