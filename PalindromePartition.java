class PalindromePartition {
    public List<List<String>> partition(String s) {
        
        List<List<String>> res = new ArrayList();
        
        pallindrome(s, 0, new ArrayList<String>(), res);
        return res;
    }
    void pallindrome(String s, int start, ArrayList<String> currList, List<List<String>> res) {
        
        if (start == s.length()) {
            res.add(new ArrayList<String>(currList));
        }
        
        for (int i = start; i < s.length(); i++) {
            
            String prefix = s.substring(0, i+1);
            String restString = s.substring(i+1);

            if (isPallindrome(prefix)) {
                currList.add(prefix);
                pallindrome(restString, 0, currList, res); //start is 0 coz evertime its a new string
                currList.remove(currList.size()-1); //backtrack
            }
        }
    }
    
    boolean isPallindrome(String s) {
        int start = 0, end = s.length()-1;
        
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            
            start++;
            end--;
        }
        return true;
    }
}