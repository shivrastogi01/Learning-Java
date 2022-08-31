class CountNumberOfEasySUbArray {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans=0,cnt=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0)
                cnt++;
            
            if(cnt==k)
                ans++;
            
            if(map.containsKey(cnt-k)){
                ans+=map.get(cnt-k);
            }
            map.put(cnt,map.getOrDefault(cnt,0)+1);
        }
       
        return ans;
    }
}