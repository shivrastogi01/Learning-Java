class MinimumNumerOfStepToMakeTwoStringAnagram {
    public int minSteps(String s, String t) {
        int[] sCount = new int[26], tCount = new int[26];
        
        for(char c : s.toCharArray()) sCount[c - 'a']++;
        for(char c : t.toCharArray()) tCount[c - 'a']++;
        
        int count = 0;
        
        for(int i = 0; i < 26; i++) {
            if(sCount[i] < tCount[i]) count += tCount[i] - sCount[i];
        }
        
        return count;
    }
}