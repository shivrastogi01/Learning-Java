class DiagonalTraverse {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Deque<Integer>> lis = new ArrayList<>();
        for(int i=0;i<nums.size();i++) {
            List<Integer> temp=nums.get(i);
            for(int j=0;j<temp.size();j++) {
                if(i+j>=lis.size()) lis.add(new ArrayDeque<>());
                lis.get(i+j).push(temp.get(j));
            }
        }
        List<Integer> res = new ArrayList<>();
        for(Deque<Integer> d: lis) {
            for(int n: d)
                res.add(n);
        }
    
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}