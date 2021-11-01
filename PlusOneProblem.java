class PlusOneProblem {
    public int[] plusOne(int[] digits) {
        int carry = 1; // to add 1 
        for(int i = digits.length - 1; i >= 0; i--)
        {
                int sum = digits[i] + carry;
                digits[i] = sum % 10;
                carry = sum/10;
        }
        int[] ans = new int[digits.length + 1];
        if(carry != 0)
        {
            ans[0] = carry;
            for(int i = 1; i < digits.length; i++)
            {
                ans[i] = digits[i];
            }
            return ans;
        }
        return digits;
    }
}