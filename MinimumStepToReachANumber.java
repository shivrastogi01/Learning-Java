class MinimumStepToReachANumber {
    public int reachNumber(int target) {
	//STEP-1
        target=Math.abs(target);
		//Initially we start from 0 thus sum==0
        int sum=0;
        int i=1;
        int step=0;
		//STEP-2
        while(sum<target)
        {
            sum+=i;
            step++;
            i++;
        }
		//STEP-3
        while((sum-target)%2!=0)
        {
            sum+=i;
            i++;
            step++;
        }
        return step;
    }
}