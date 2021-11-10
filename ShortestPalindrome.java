class ShortestPalindrome {
    static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    static int calculateLps(String s) {
        int n = s.length();
        int[] lps = new int[n];
        lps[0] = -1;
        for (int i = 1; i < n; i++) {
            if (i == n / 2) {
                lps[i] = -1;
            } else if (s.charAt(i) == s.charAt(lps[i - 1] + 1)) {
                lps[i] = lps[i - 1] + 1;
            } else {
                int j = -1;
                if (lps[i - 1] != j) j = lps[lps[i - 1]];
                lps[i] = -1;
                if (s.charAt(i) == s.charAt(j + 1)) lps[i] = j + 1;
            }
        }
        return lps[n - 1];
    }

    public static String shortestPalindrome(String s) {
        if (isPalindrome(s)) return s;
        StringBuilder rsb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            rsb.append(s.charAt(i));
        String rs = rsb.toString();
        String srs = s + rs;
        int lps = calculateLps(srs);
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i > lps; i--)
            result.append(s.charAt(i));
        result.append(s);
        return result.toString();
    }
}