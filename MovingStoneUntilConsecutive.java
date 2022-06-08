class MovingStoneUntilConsecutive {
    public int[] numMovesStones(int a, int b, int c) {
       
	int[] answer = new int[2];
	
	// Calculate absolute differences between variables
    int k1 = Math.abs(a-b), k2 = Math.abs(b-c), k3 = Math.abs(a-c);
	
	// Max gives distance between edge numbers (excluding middle number)
    int max = Math.max(Math.max(k1, k2), k3);
	
	// Min gives least of the distances (number one of the edges and middle number)
    int min = Math.min(Math.min(k1, k2), k3)-1;
    
	// See if we have no spot left
    if (max == 2) answer[0] = 0;
	// Check if we have one spot available
    else if (min < 2) answer[0] = 1;
	// Any other case we can achieve in 2 moves
    else answer[0] = 2;
    
	// Maximum would be number of empty spots;
    answer[1] = k1+k2+k3-max-2;
    
    return answer;
        
    }
}