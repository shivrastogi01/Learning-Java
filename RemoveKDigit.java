class RemoveKDigit {
    public String removeKdigits(String num, int k) {
	if(k == num.length()) return "0";
        int len = num.length();
        char stack[] = new char[len];
        int index = 0;
        for(int i = 0; i < len; i++){
            char each = num.charAt(i);
            while(k > 0 && index > 0 && stack[index-1] > each){
                index--;
                k--;
            }
            stack[index++] = each;
        }
        
        //  is there anything needs to delete
        index = index - k;
        String ans = String.valueOf(stack, 0, index);
        
        // what is the first index that have non zero value
        int i;
        for(i = 0; i < (ans.length()-1) && ans.charAt(i) == '0'; i++);
        
        return ans.substring(i);
    }
}