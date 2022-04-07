public class ClosestPalindrome{
    public String nearestPalindromic(String n) {
        long number = Long.parseLong(n);
        long big = findHigherPalindrome(number + 1);
        long small = findLowerPalindrome(number - 1);
        return Math.abs(number - small) > Math.abs(big - number) ? String.valueOf(big) : String.valueOf(small);
    }
    public long findHigherPalindrome(long limit) {
        char[] s = Long.toString(limit).toCharArray();
        int m = s.length;
        // init t to be a palindrome
        char[] t = new char[m];
        System.arraycopy(s, 0, t, 0, m/2+1);
        for (int i = 0; i < m / 2; i++) {
            t[m - 1 - i] = t[i];
        }
        for (int i = 0; i < m; i++) {
            if (s[i] < t[i]) {  // case: 321
                return Long.parseLong(String.valueOf(t));
            } else if (s[i] > t[i]) {  // case: 1991
                for (int j = (m - 1) / 2; j >= 0; j--) {
                    if (t[j] == '9') {
                        t[j] = '0';
                    } else {
                        t[j]++;
                        break;
                    }
                }
                // make it palindrome again
                for (int k = 0; k < m / 2; k++) {
                    t[m - 1 - k] = t[k];
                }
                return Long.parseLong(String.valueOf(t));  // case: 1991
            }
        }
        return Long.parseLong(String.valueOf(t));  // case: 1, 21
    }
    
    public long findLowerPalindrome(long limit) {
        char[] s = Long.toString(limit).toCharArray();
        int m = s.length;
        // init t to be a palindrome
        char[] t = new char[m];
        System.arraycopy(s, 0, t, 0, m/2+1);
        for (int i = 0; i < m / 2; i++) {
            t[m - 1 - i] = t[i];
        }
        for (int i = 0; i < m; i++) {
            if (s[i] > t[i]) {  // case: 123
                return Long.parseLong(String.valueOf(t));
            } else if (s[i] < t[i]) {
                for (int j = (m - 1) / 2; j >= 0; j--) {
                    if (t[j] == '0') {
                        t[j] = '9';
                    } else {
                        t[j]--;
                        break;
                    }
                }
                if (t[0] == '0') {
                    char[] a = new char[m - 1];
                    Arrays.fill(a, '9');
                    return Long.parseLong(String.valueOf(a)); // case: 1001
                }
                // make it palindrome again
                for (int k = 0; k < m / 2; k++) {
                    t[m - 1 - k] = t[k];
                }
                return Long.parseLong(String.valueOf(t));  // case: 321
            }
        }
         return Long.parseLong(String.valueOf(t));  // case: 1
    }
}