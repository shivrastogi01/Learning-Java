class FindWinnerInArrayGame {
public int getWinner(int[] arr, int k) {
    int len=arr.length,max=arr[0],count=1,previousMax=0;
        for(int i=1;i<len;i++){
            if(max<arr[i]){
                max=arr[i];
                count=1;
            }
            if(max==previousMax) count++;
           previousMax=max;
            if(count==k) return previousMax;
        }
        return max;
}
}