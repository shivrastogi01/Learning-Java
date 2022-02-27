class LongestStringChain {
    
    public int longestStrChain(String[] words) {
        var n = words.length;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        var nextRangeIdx = new int[n];
        nextRangeIdx[n - 1] = n;
        for (int i = n - 2; i >= 0; i--)
            nextRangeIdx[i] = words[i].length() == words[i + 1].length()
                ? nextRangeIdx[i + 1]
                : i + 1;
        
        var dp = new int[words.length];
        for (int curIdx = n - 1; curIdx >= 0; curIdx--) {
            var curWord = words[curIdx];
            var nextIdx = nextRangeIdx[curIdx];
            var maxSeq = 1;
            while (nextIdx < words.length && curWord.length() + 1 == words[nextIdx].length()) {
                if (predecessor(curWord, words[nextIdx])) 
                    maxSeq = Math.max(maxSeq, dp[nextIdx] + 1);                    
                nextIdx++;
            }
            dp[curIdx] = maxSeq;
        }
            
        var max = 0;
        for (int len : dp)
            if (len > max)
                max = len;

        return max;
    }
    
    boolean predecessor(String pre, String cur) {       
        var p = 0;
        var c = 0;
        var inserted = false;
        while (p < pre.length() && c < cur.length()) {
            if (pre.charAt(p) == cur.charAt(c)) {
                p++;
            } else {
                if (inserted)
                    return false;
                inserted = true;
            }
            c++; 
        }
        
        return true;
    }
}