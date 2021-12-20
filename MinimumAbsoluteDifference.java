class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        int n=arr.length;
        Arrays.sort(arr);
        int diff=Integer.MAX_VALUE;
        int currDiff=0;
        for(int i=0;i<n-1;i++) {
            currDiff=arr[i+1]-arr[i];
            List<Integer> tmpLst = new ArrayList<>();
            if(currDiff<=diff){
                if(currDiff!=diff)
                    res.clear();
                diff=currDiff;
                tmpLst.add(arr[i]);
               tmpLst.add(arr[i+1]);
                res.add(tmpLst);
            }
        }
        return res;
    }
}