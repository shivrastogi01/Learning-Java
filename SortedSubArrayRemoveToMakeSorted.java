class SortedSubArrayRemoveToMakeSorted{
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = n-1;

        while(i+1 < n && arr[i] <= arr[i+1])
            i++;
        while(j-1 >= i && arr[j] >= arr[j-1])
            j--;
        
        if( i == j)
            return 0;
        int min = Math.min(n-i-1, j);
    
        int left = 0;
        
        while(left <= i && j < n){
            while( left <= i && arr[left] <= arr[j]){
                left++;
            }
            min = Math.min(min, j-left);
            j++;
        }
        return min;
    }
}