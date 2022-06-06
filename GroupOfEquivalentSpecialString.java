class GroupOfEquivalentSpecialString {
    
    public boolean areAnagram(String s1, String s2) {
        int [] freq = new int [26];
        for (int i = 0; i < s1.length(); i ++) {
            freq[s1.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < s2.length(); i ++) {
            if (freq[s2.charAt(i) - 'a'] == 0) {
                return false;
            }
            freq[s2.charAt(i) - 'a'] --;
        }
        
        for (int i = 0; i < freq.length; i ++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        return true;
    }
    
    public boolean inSameGroup(String s1, String s2) {
        StringBuilder sb1Odd = new StringBuilder();
        StringBuilder sb1Even = new StringBuilder();
        StringBuilder sb2Odd = new StringBuilder();
        StringBuilder sb2Even = new StringBuilder();
        
        for (int i = 0; i < s1.length(); i ++) {
            if (i % 2 == 0) {
                sb1Even.append(s1.charAt(i));
                sb2Even.append(s2.charAt(i));
            } else {
                sb1Odd.append(s1.charAt(i));
                sb2Odd.append(s2.charAt(i));
            }
        }
        
        return areAnagram(sb1Even.toString(), sb2Even.toString()) &&
            areAnagram(sb1Odd.toString(), sb2Odd.toString());
    }
    
    public int numSpecialEquivGroups(String[] words) {
        List<String> groups = new ArrayList<String>();
        for (int i = 0; i < words.length; i ++) {
            boolean added = false;
            for (int j = 0; j < groups.size(); j ++) {
                String sample = groups.get(j);
                if (inSameGroup(sample, words[i])) {
                    added = true;
                }
            }
            if (!added) {
                groups.add(words[i]);
            }
        }
        
        return groups.size();
    }
}