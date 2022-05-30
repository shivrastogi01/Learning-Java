class SubArraySumDivisibleByK {
   public int subarraysDivByK(int[] nums, int k) {
       HashMap<Integer,Integer> map = new HashMap<>();
       int count = 0;
       int prefixSum= 0; 
       for(int i=0;i<nums.length;i++){
        prefixSum+=nums[i]; 
        int rem = prefixSum % k;   
        if(rem % k ==0){ //Check sum for current Prefix 
         count++;   
        }
        if(rem<0){
         rem+=k;  // Formal Remainder concept without this no sence for prefixSum and Map 
        }   
        if(map.containsKey(rem)){
         count += map.get(rem) ;   
        }
        map.put(rem,map.getOrDefault(rem,0)+1);   
       } 
     return count;    
    }
}