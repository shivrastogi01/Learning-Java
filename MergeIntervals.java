class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        
        int i=0,j=1;
        
        while(i<intervals.length && j<intervals.length) {
            if(intervals[i][1] >= intervals[j][0]) {
                intervals[i][1] = Math.max(intervals[i][1],intervals[j][1]);
                j++;
            } else {
                i++;
                intervals[i][0] = intervals[j][0];
                intervals[i][1] = intervals[j][1];
                j++;
            }
        }
        return Arrays.copyOfRange(intervals, 0, i+1);
    }
}