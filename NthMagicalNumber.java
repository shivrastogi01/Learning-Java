class NthMagicalNumber{
    private static int M = (int)1e9 + 7;
    public int nthMagicalNumber(int n, int a, int b) {
        // num / a + num / b - num / lcd(a, b)
        // As a number increases by LCD, the count gets increased by count(lcd, a, b, lcd)
        int lcd = lcd(a, b);
        int unit = count(lcd, a, b, lcd);
        long mul = n / unit;
        n %= unit;

        int lo = 1, hi = Integer.MAX_VALUE;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int count = count(mid, a, b, lcd);
            if (count == n) return (int)(mid % M - Math.min(mid % a, mid % b) + (mul * lcd) % M) % M;
            else if (count < n) lo = mid + 1;
            else hi = mid - 1;
        }

        return -1;
    }

    private int count(int num, int a, int b, int lcd){
        return num / a + num / b - num / lcd;
    }

    private int lcd(int a, int b){
        return a * b / gcd(a, b);
    }

    private int gcd(int a, int b){
        if (a == 0) return b;
        if (b == 0) return a;
        if (b > a) return gcd(b, a);
        return gcd(b, a % b);
    }
}