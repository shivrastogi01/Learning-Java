class RepeatedSubStringPattern {
    public boolean repeatedSubstringPattern(String s) {
        for(int i = 0; i < s.length() / 2; i++){
            if(s.length() % (i + 1) != 0)
                continue;
            String tocheck = s.substring(0, i + 1);
            for(int j = i + 1; j <= s.length(); j += i + 1){
                if(j == s.length())
                    return true;
                if(tocheck.equals(s.substring(j, j + i + 1)) == false)
                    break;
            }
        }
        return false;
    }
}