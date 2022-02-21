class StoneGame {
    public boolean stoneGame(int[] piles) {
        int start=0;
        int end = piles.length-1;
        int alice =0;
        int bob = 0;
        while(start<end){
            alice+=Math.max(piles[start],piles[end]);
            bob+=Math.min(piles[start],piles[end]);
            start++;
            end--;
        }
        return alice>bob;
    }
}