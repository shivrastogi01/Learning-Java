class MostFrequentSubTreeSum {
    int maxf=0;
    HashMap<Integer, Integer> map=new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
        helper(root);
        for(int key: map.keySet()){
            if(map.get(key)==maxf){
                ans.add(key);
            }
        }
        int [] res=new int[ans.size()];
        int i=0;
        for(int key: ans){
            res[i++]=key;
        }
        return res;
    }
    
    public int helper(TreeNode root){
        if(root==null) return 0;
        int lsum=helper(root.left);
        int rsum=helper(root.right);
        int mysum=lsum+rsum+root.val;
        map.put(mysum, map.getOrDefault(mysum,0)+1);
        maxf=Math.max(maxf,map.get(mysum));
        return mysum;
    }
}