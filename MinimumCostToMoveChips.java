class MinimumCostToMoveChips {
  public int minCostToMoveChips(int[] position) {
        int even=0, odd=0;
        // if all positions are unique then cost will be same for each position only the count of duplicate positions makes difference.
        for(int i=0;i<position.length;i++) {
            if(position[i]%2==0) even++;
           else odd++;
        }
        return Math.min(even, odd);
    }
}