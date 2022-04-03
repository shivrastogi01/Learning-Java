class LargestPalindromeProduct {
    public int largestPalindrome(int n) {
        //enumrate every palindrome number
        if( n == 1) return 9;
        // 2 digits's max is 10^2  - 1=99
        int maxNum = (int) (Math.pow(10,n) - 1);
        for(int i = maxNum;i >= 0; i--){
            //find the panlindrome number
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(i));
            StringBuilder b = new StringBuilder();
            b.append(String.valueOf(i));
            b.reverse();
            sb.append(b);
            //ex: a-123 b -123 -> b.reverse = 321
           //sb = a+ b.verse = 123321 is a palindrome number
            long panlindromeNum = Long.valueOf(sb.toString());
            for(long j = (long)maxNum; j*j >= panlindromeNum; j--){
                if(panlindromeNum % j == 0){
                    return (int)( panlindromeNum % 1337);
                }
            }
        }
        return 0;
    }
}