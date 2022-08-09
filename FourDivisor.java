class FourDivisor {
public int sumFourDivisors(int[] nums) {
int sum=0;
for(int num:nums){
int sqrt = (int) Math.sqrt(num);

        if(sqrt*sqrt==num){  // if perfect square exist then no. divisors will be odd, so we can skip
            continue;
        }
        else{
            int tempCount=0;
            int tempSum=0;
            for(int i=1;i<=sqrt;i++){
                if(num%i==0){
                tempSum += i+(num/i);
                tempCount+=2;
                }
                
            }
            if(tempCount==4){
                sum+=tempSum;
            }
        }
    }
    return sum;
}
}