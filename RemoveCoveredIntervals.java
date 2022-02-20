class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(arr1,arr2)->Integer.compare(arr1[0],arr2[0]));
        int[] curr=new int[]{-1,-1};
        int result=0;
        for(int[] interval:intervals){
            if(interval[0]>curr[0] && interval[1]>curr[1]){
                curr[0]=interval[0];
                result++;
            }
            curr[1]=Math.max(curr[1],interval[1]);
        }
        return result;
    }
}