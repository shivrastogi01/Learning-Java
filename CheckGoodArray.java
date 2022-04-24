class CheckGoodArray {
    public boolean isGoodArray(int[] nums) {
        if (nums.length == 1) return nums[0] == 1;
        
        int n = nums[0];
        for (int i : nums) {
            //gcd = findGCD(n, i);
            if (findGCD(n , i) == 1) return true;
            n = findGCD(n , i);
        }
        return false;
    }
    static int findGCD(int a, int b) {   
        if (b == 0) return a;     
        return findGCD(b, a % b);   
    }  
}