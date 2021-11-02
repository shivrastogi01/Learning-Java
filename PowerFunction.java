class PowerFunction {
    public double myPow(double x, int n) {
        double ans = 1;
        
        while(n != 0){
            if (n%2 != 0) {
                if(n>0){
                    ans = ans * x;
                }
                else{
                    ans = ans * 1/x;
                }
            }
            
            x = x * x;
            n/=2;
        }
        return ans;
    }
}