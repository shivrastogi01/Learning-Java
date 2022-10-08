class CanConvertStringInKMoves {
    public boolean canConvertString(String s, String t, int k) {
        int len1 = s.length();
        int len2 = t.length();
        if (len1 != len2) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        int[] freq = new int[26];
        int multiple = k / 26;
        for (int i = 0; i < 26; i++) {
            freq[i] = multiple;
        }
        int rem = k % 26;
        for (int i = 1; i <= rem; i++) {
            freq[i]++;
        }
        int movesRemaining = k;
        for (int i = 0; i < len1; i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if (ch1 == ch2) {
                movesRemaining--;
                continue;
            }
            int diff = (ch2 - ch1 + 26) % 26;
            if (freq[diff] > 0) {
                freq[diff]--;
                movesRemaining--;
            } else {
                return false;
            }
        }
        return movesRemaining >= 0;
    }
}