class LongestArthimeticSequence{
   public int longestArithSeqLength(int[] nums) {
        int max = 2;// As can form AP with any 2 elements
        
        // Time: O(N^2) Take dp[index][diff], but as diff can be negative as well can not take int[][]. So taking HashMap and also fast lookup. We will check if same diff has occured previously also then extend the length
        HashMap<Integer, Integer>[] dp = new HashMap[nums.length];// keep map at each index, which will maintain map of diff->count for all prev element
        
        for(int i=0; i < nums.length;i++) dp[i] = new HashMap();
        
        for(int i=1; i < nums.length; i++){
            // Now we want to populate map at index i with Map[diff->count] for diff with all prev elements
            for(int j=0; j < i; j++){// Check diff with all prev numbers
                int currDiff = nums[i] - nums[j];
                int lengthTillCurrI = 2;
                if(dp[j].containsKey(currDiff)){ // If same diff have occureed prev at some j index
                    lengthTillCurrI =  dp[j].get(currDiff) +1;  // increase the no of time this diff has occured till i, which will be longest AP 
                }
                
                dp[i].put(currDiff,lengthTillCurrI);// Update length at current i
                
                max = Math.max(max,dp[i].get(currDiff)); // Update global max
            }    
        }
        return max;
    }
}