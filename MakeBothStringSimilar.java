class MakeBothStringSimilar                  //By deleting from the any of the string ,we can use delete operation only.
{
    public int minDistance(String word1, String word2)
    {
        // edge cases.
        if (word1 == null && word2 == null)
            return 0;
        if (word1 == null) return word2.length();
        if (word2 == null) return word1.length();
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        
        // steps[i][j]: subString(0~i) of word1 need steps[i][j] to get to substring(0~j) of word2.
        int[][] steps = new int[word1.length() + 1][word2.length() + 1];
        // initialize
        for (int i = 1; i <= word1.length(); i++)
            steps[i][0] = i;    // substring(0~i) of word1 need its length steps to delete to empty.
        for (int j = 1; j <= word2.length(); j++)
            steps[0][j] = j;    // substring(0~j) of word2 need its length steps to delete to empty.
        
        for (int i = 1; i <= word1.length(); i++)
        {
            for (int j = 1; j <= word2.length(); j++)
            {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    steps[i][j] = steps[i - 1][j - 1];  // no need to operate at all.
                else
                {
                    int delWord1 = steps[i - 1][j] + 1; // delete from word1
                    int delWord2 = steps[i][j - 1] + 1; // delete from word2
                    int delFromBoth = steps[i - 1][j - 1] + 2;  // delete both from word1 and word2.
                    
                    // choose minimum steps of the above three operations.
                    steps[i][j] = Math.min(delWord1, Math.min(delWord2, delFromBoth));
                }
            }
        }
        
        // return steps from full-length of word1 to full-length of word2.
        return steps[word1.length()][word2.length()];
    }
}