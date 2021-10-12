class AllPossibleCombinations {
    public boolean combs(List<List<Integer>> list, int max, int start, int times, List<Integer> curr){
        List<Integer> prev = new ArrayList<>(curr);
        for(int i = start; i<=max; ++i){
            if(i>start)
                curr = new ArrayList<>(prev);
            
            curr.add(i);
            boolean flag = false;
            
            if(times>1)
                flag = combs(list, max+1, i+1, times-1, curr);
            
            if(!flag)
                list.add(curr);
        }
        
        return true;
    }
                      
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        
        combs(list, n-k+1, 1, k, new ArrayList<>());
        return list;
    }
}