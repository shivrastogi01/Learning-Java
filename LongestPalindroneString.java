class LongestPalindroneString {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return s;
        int startPos = 0;
        int endPos = 0;
        int index = 0;
        while (index < s.length()) {
            int left = index;
            int right = index;
            
            // Expand to right as long as the char is the same
            while (right + 1 < s.length() 
                   && s.charAt(right + 1) == s.charAt(index)) ++ right;
            index = right + 1; // ignore the consecutive same character
            
            while (left - 1 >= 0 && right + 1 < s.length()
                  && s.charAt(left - 1) == s.charAt(right + 1)) {
                -- left;
                ++ right;
            }
            
            if (right + 1 - left > endPos + 1 - startPos) {
                startPos = left;
                endPos = right;
            }
        }
        
        return s.substring(startPos, endPos + 1);
    }
}