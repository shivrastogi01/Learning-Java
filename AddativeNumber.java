public class AddativeNumber {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) return false;
        final int N = num.length();
        for (int len1 = 1; len1 <= N/2; len1++) {
            if (num.charAt(0) == '0' && len1 > 1) return false;
            long a = Long.parseLong(num.substring(0, len1));  // Note: use Long because the number may be out of the range of Integer type.
            for (int len2 = 1; len1 + len2 < N; len2++) {
                if (num.charAt(len1) == '0' && len2 > 1) break;
                long b = Long.parseLong(num.substring(len1, len1 + len2));
                if (isValid(a, b, len1 + len2, num)) return true;
            }
        }
        return false;
    }

    private boolean isValid(long a, long b, int start, String num) {
        if (start == num.length()) return true;
        long sum = a + b;
        String str = String.valueOf(sum);
        return num.startsWith(str, start) && isValid(b, sum, start + str.length(), num);
    }
}