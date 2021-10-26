class InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int idx = searchInsert(intervals, newInterval, 0, intervals.length-1);  //O(logn)
        
        int newLen = intervals.length + 1;
        
        //Search backward for overlap, and make interval as overlap by updating to -1
        for(int i=idx-1; i>=0; i--){    //O(N)
            if(isOverlap(intervals[i], newInterval)){
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                intervals[i][0] = -1;
                intervals[i][1] = -1;
                newLen--;
            }else{
                break;
            }
        }
        
        //Search forward for overlap, and make interval as overlap by updating to -1
        for(int i=idx; i<intervals.length; i++){    //O(N)
            if(isOverlap(intervals[i], newInterval)){
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                intervals[i][0] = -1;
                intervals[i][1] = -1;
                newLen--;
            }else{
                break;
            }
        }
        

        if(idx >= newLen ) idx = newLen - 1;
        
        
        //Copy the array
        int[][] output = new int[newLen][2];
        int j=0;
        for(int i=0; i<intervals.length; i++){  //Time: O(N)
            if(i == idx){
                output[j++] = newInterval;
            }

            if(intervals[i][0] != -1){
                output[j++] = intervals[i];
            }
        }
        
        if(j < newLen){
            output[j++] = newInterval;
        }
        
        return output;

    }
    

    
    private int searchInsert(int[][] intervals, int[] newInterval, int l, int r){
        if(l > r){
            return l;
        }
        
        int m = l + (r-l)/ 2;
        if(intervals[m][0] ==  newInterval[0]) return m;
        if(intervals[m][0] > newInterval[0]){
            return searchInsert(intervals, newInterval, l, m-1);
        }else{
            return searchInsert(intervals, newInterval, m+1, r);
        }
        
    }

    
    private boolean isOverlap(int[] i1, int[] i2){
        return i1[1] >= i2[0] && i1[0] <= i2[1];
    }
}