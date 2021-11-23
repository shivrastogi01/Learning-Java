class SecondLargestDigitInString {
   public int secondHighest(String s) {
        int n=s.length();
        int max1='0'-1;
        int max2=max1;
        for(int i=0;i<n;i++)
            if(s.charAt(i)<'a')
                if(s.charAt(i)>max1)
                {
                    max2=max1;
                    max1=s.charAt(i);
                }else if(s.charAt(i)<max1 && s.charAt(i)>max2)
                    max2=s.charAt(i);
        return max2-'0';
    }
}