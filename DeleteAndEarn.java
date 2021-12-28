class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int inc = 0;
        int exc = 0;
		// we'll make an arrat of size as given in constraint
        int []arr = new int[10001];
		for(int i : nums){
            arr[i]++;
        }
		//we'll write the occurence in that array
        for(int i =0 ;i < 10001 ; i++){
            int ni = exc + arr[i]*i;
            int ne = Math.max(inc , exc);
            
            exc = ne;
            inc = ni;
                
        }
		// now the ques convert into max sum of non adjacent elements
        return Math.max(exc,inc);
    }
}