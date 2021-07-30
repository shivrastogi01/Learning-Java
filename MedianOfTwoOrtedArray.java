class MedianOfTwoOrtedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalSize = nums1.length + nums2.length;
        int index1 = 0;
        int index2 = 0;
        int[] mergedArray = new int[totalSize];
        for(int i = 0; i < totalSize; i++){
            if(index1 < nums1.length && index2 < nums2.length){
                if( nums1[index1] < nums2[index2]){                               
                    mergedArray[i] = nums1[index1];
                    index1++;
                }else{
                    mergedArray[i] = nums2[index2];
                    index2++;
                }
            }else if(index1 < nums1.length){
                mergedArray[i] = nums1[index1];
                index1++;                
            }else{
                mergedArray[i] = nums2[index2];
                index2++;                
            }
        }
        if( totalSize % 2 == 0){
            return (mergedArray[(totalSize/2) -1 ] + mergedArray[totalSize/2])/2d;
        }
        return  mergedArray[totalSize/2];
        
    }
}