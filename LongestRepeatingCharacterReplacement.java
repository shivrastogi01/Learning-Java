class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        
        int charCountArray[] = new int[26];
        int mostFreqCharCount = 0;
        int otherCharsCount = 0;
        int startIndex = 0;
        int currentSubstringLength = 0;
        int maxLength = 0;
		int currentCharCount = 0;
		char currentChar;
        
        for (int endIndex = 0; endIndex < s.length(); endIndex++) {
		    //Finding most frequent char in our window
            currentChar = s.charAt(endIndex);
            charCountArray[currentChar - 'A']++;
			currentCharCount = charCountArray[currentChar - 'A'];
            mostFreqCharCount = Math.max(mostFreqCharCount, currentCharCount);
            
			//Find count of other characters
            currentSubstringLength = endIndex - startIndex + 1;
            otherCharsCount = currentSubstringLength - mostFreqCharCount;
            
            if (otherCharsCount <= k) {
                maxLength = Math.max(maxLength, currentSubstringLength);
            } else {
                charCountArray[s.charAt(startIndex) - 'A']--;
                startIndex++;
            }
        }
        return maxLength;
    }
}