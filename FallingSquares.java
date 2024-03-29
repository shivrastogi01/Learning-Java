class FallingSquares {
    public List<Integer> fallingSquares(int[][] positions) {
        // Coordinate compression using TreeSet
        Set<Integer> unique = new TreeSet<>();

        for (int[] square : positions) {
            unique.add(square[0]);
            unique.add(square[0] + square[1] - 1);
        }

		// converted the TreeSet to a List
        List<Integer> sorted = new ArrayList<>(unique);   
		
		// Storing the max heights for compressed coordinates
        int[] heights = new int[sorted.size()];
		
		// Our answer list
        List<Integer> list = new ArrayList<>(positions.length); 
		
		// Global Max
        int max = 0;
        
        for (int[] square : positions) {
            // coordinate compression lookup
            int x1 = Collections.binarySearch(sorted, square[0]);
            int x2 = Collections.binarySearch(sorted, square[0] + square[1] - 1);
            
			// get the current max for the interval between x1 and x2
            int current = 0;
            for (int i = x1; i <= x2; i++) {
                current = Math.max(current, heights[i]);
            }
            
			// add the new square on the top
            current += square[1];
            
			// update the interval with the new value
            for (int i = x1; i <= x2; i++) {
                heights[i] = current;
            }        
            
			// recalculate the global max
            max = Math.max(max, current);
            
            list.add(max);
        }

        return list;
    }   
}