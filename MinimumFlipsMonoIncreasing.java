class MinimumFlipsMonoIncreasing{
   public int minFlipsMonoIncr(String s) {
        int[] ones = new int[s.length() + 1];
        int[] zeros = new int[s.length() + 1];
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                ones[i+1] = Math.min(ones[i], zeros[i]) + 1;
                zeros[i+1] = zeros[i];
            } else {
                ones[i+1] = Math.min(ones[i], zeros[i]);
                zeros[i+1] = zeros[i] + 1;
            }
        }
        
        return Math.min(zeros[s.length()], ones[s.length()]);       
    }
}