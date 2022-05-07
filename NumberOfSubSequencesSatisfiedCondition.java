class NumberOfSubSequencesSatisfiedCondition {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int count=0,mod=(int)((1e9)+7),i=0,j=nums.length-1;
        int pow[]=new int[nums.length];
        pow[0]=1;
        for(int k=1;k<nums.length;k++)
            pow[k]=(pow[k-1]*2)%mod;
        while(i<=j){
            int sum=nums[i]+nums[j];
            if(sum<=target)
                count=(count+pow[j-i++])%mod;
            else j--;
        }
        return count;
    }
}