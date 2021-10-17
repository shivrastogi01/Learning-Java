class EditWords {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            throw new IllegalArgumentException("Input strings are null");
        }

        int insertCost = 1;
        int deleteCost = 1;
        int replaceCost = 1;
        int l1 = word1.length();
        int l2 = word2.length();

        if (l1 == 0) {
            return l2 * insertCost;
        }
        if (l2 == 0) {
            return l1 * deleteCost;
        }
        // Bellow condition can be used only if all three costs are same.
        if (l1 > l2) {
            return minDistance(word2, word1);
        }

        int[] dp = new int[l1 + 1];
        // Setting DP array for 0th column of 2D DP array. Here l2 is blank, thus we
        // have to delete everything in l1.
        for (int i = 1; i <= l1; i++) {
            dp[i] = dp[i - 1] + deleteCost;
        }

        for (int j = 1; j <= l2; j++) {
            int prev = dp[0];
            dp[0] += insertCost; // l1 is blank, Inserting l2 chars in l1.
            char c2 = word2.charAt(j - 1);
            for (int i = 1; i <= l1; i++) {
                char c1 = word1.charAt(i - 1);
                int temp = dp[i];
                // Both chars are same, so the distance will also remain same as dp[i-1][j-1]
                if (c1 == c2) {
                    dp[i] = prev;
                } else {
                    // Replace l1[i - 1] by l2[j - 1] ==> dp[i][j] = dp[i - 1][j - 1] + 1
                    // Delete l1[i-1] from l1[0..i-1] ==> dp[i-1][j] + 1
                    // Insert l2[j-1] into l1[0..i-1] ==> dp[i][j-1] + 1
                    dp[i] = Math.min(prev + replaceCost, Math.min(dp[i - 1] + deleteCost, dp[i] + insertCost));
                }
                prev = temp;
            }
        }

        return dp[l1];
    }
}