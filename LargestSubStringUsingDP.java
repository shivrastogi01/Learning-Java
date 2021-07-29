class LargestSubStringUsingDP {
    public int lengthOfLongestSubstring(String s) {
		// If the String is empty it will be returned
        if(s.isEmpty()) return 0;
		
		// Initializes the current and maximum variables
        int current = 1, max = 1;
        
		// Checks for every substring withing the string using to for loops
        for(int i = 0; i < s.length() - 1; i++) {
			// Initializes the hashmap to hold the characters in the string
            HashMap<Character,Integer> memo = new HashMap<>();
            memo.put(s.charAt(i),i);// Puts the first character within the hashmap
            
			// Create a second for loop to iterate through all of the elements after i
            for(int j = i+1; j < s.length(); j++) {
				
				// If we find an element that has already been 
				// placed in the hashmap then it is a duplicate
                if(memo.containsKey(s.charAt(j))) {
					// Updates the max and breaks out of the for loop
                    max = Math.max(max, current);
                    break;
                }
				
				// If a duplicate has not been found, then current is incremented
				// and the character is placed in the hashmap
                current++;
                memo.put(s.charAt(j), j);
            }
			
			// Update the maximum value in the case there were no duplicates in the last string
			// And update the current value since we are now going to loo at a new 
            max = Math.max(max,current);
            current = 1;
        }
        
        return max;
    }
}