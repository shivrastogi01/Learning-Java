class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        
        int[] charCountMap = new int[26];//to store count of each letter
        
        //finding the window.Here window is equal to the length of s1, because s2 should contain s1
        int windowSize = s1.length();
        
        int length = s2.length();
        
        for(char ch : s1.toCharArray()){
            charCountMap[ch - 'a']++;
        }
        
        int start = 0;
        int end = 0;
        int count = 0; // this counts helps in matching the total letters of the string s1 and substring in s2
        
        while(end < length){
            
            char ch = s2.charAt(end);
            charCountMap[ch - 'a']--;
            
            //if the character count is greater than zero then increment the count variable by 1
            if(charCountMap[ch - 'a'] >= 0)count++;
            
            if(end - start + 1 == windowSize){
                
                //check whether count == windowsize if yes that means there is a permutation available
                if(count == windowSize)return true;
                
                
                /** 
                * if there is no permutation for this window
                * then increment the count of the first character of the window/substring
                * and decrement the count variable as we are removing one character from the window/substring
                */
                
                char firstChar = s2.charAt(start);
                charCountMap[firstChar - 'a']++;
                if(charCountMap[firstChar - 'a'] >= 1)count--;
                start++;
            }
            
            end++;
        }
        
        return false;
    }
}