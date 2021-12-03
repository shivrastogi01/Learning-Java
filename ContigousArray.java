class ContigousArray {
    public int findMaxLength(int[] nums) {
       HashMap<Integer,Integer>map=new HashMap<>();

        int l=0;
        int one=0;
        int zero=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                zero++;
            }
            
            else{
                one++;
            }
            
            if(zero==one)
            {
                l=Math.max(l,i+1);
            }
            else{
                if(map.containsKey(zero-one))
                {
                    int j=map.get(zero-one);
                    l=Math.max(l,i-j);
                    
                }
                
                else{
                    map.put(zero-one,i);
                }
                
                
            }
          
            
        }
        return l;
    }
}