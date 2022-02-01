class NonOverlappingIntervals{

			public int eraseOverlapIntervals(int[][] intervals) {

			int toremove =0;
			Arrays.sort(intervals, (a,b)->(Integer.compare(a[0],b[0])));

			for(int i=0;i<intervals.length-1;i++){
				if(intervals[i][1]<=intervals[i+1][0]){
					continue;
				}
				else
				{
					intervals[i+1][1]=Math.min(intervals[i][1],intervals[i+1][1]);
					toremove++;
				}
			}
			return toremove;
			} 
}