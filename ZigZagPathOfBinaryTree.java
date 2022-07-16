class ZigZagPathOfBinaryTree{
    
    public List<Integer> pathInZigZagTree(int label) {
        int n = label;
        List<Integer> ans = new ArrayList<>();
        ArrayList<int[]> helper = new ArrayList<>();
        int[] arr = {1,1};
        helper.add(arr);
        while(n>arr[1]){
            int[] temp = {arr[0]*2,arr[1]+arr[0]*2};
            helper.add(temp);
            arr = temp;
        }
        int level = helper.size();   
        while(n>1){
            if (level%2==0){
                ans.add(n);
                int[] temp = helper.get(level-1);
                n = temp[1] - (n-temp[0]);
                n = n/2;
            }else{
                ans.add(n);
                n = n/2;
                int[] temp = helper.get(level-2);
                n = temp[1] - (n-temp[0]);
            }
            level--;
        }
        ans.add(1);
        Collections.reverse(ans);
        return ans;
        
    }
}