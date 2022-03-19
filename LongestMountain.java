class LongestMountain {
   public int longestMountain(int[] arr) {
        if(arr.length < 3){
            return 0;
        }
        int res = 0,  left = 0;
        int i =0;
        while( i< arr.length){
            int incr = 0;
            while( i + 1 < arr.length && arr[i] < arr[i+1]){
                incr++;
                i++;
            }
            if(incr == 0){
                i++;
                continue;
            }
            int decr = 0;
            while( i + 1 < arr.length && arr[i] > arr[i+1]){
                decr++;
                i++;
            }
            if(decr == 0){
                continue;
            }

            res = Math.max(res, incr + decr + 1);

        }
        return res;
    }
}