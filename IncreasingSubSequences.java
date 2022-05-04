class IncreasingSubSequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        for(int i = 0; i < nums.length; i++) {
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.add(nums[i]);
            build(nums, i+1, nums[i], list);       
        }
        return retlist;
        
    }
    
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    
    List<List<Integer>> retlist = new ArrayList<List<Integer>>();
    
    public void build(int[] nums, int index, int prev, LinkedList<Integer> list) {
        
        if (list.size() > 1) {      
            List<Integer> ret = new ArrayList<Integer>(list);
            String s = Arrays.toString(ret.toArray());
            if (map.get(s) == null) {
                retlist.add(ret);
                map.put(s, 1);
            }
        }
        
        if(index == nums.length) return;
        
       
        
        for(int i = index; i < nums.length; i++) {
            if (nums[i] >= prev) {
                list.add(nums[i]);
                build(nums, i+1, nums[i], list);
                list.removeLast();
                
            }
        }
    }
    
}