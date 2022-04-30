class GlobalAndLocalInversion{
    int global = 0;
    public boolean isIdealPermutation(int[] nums) {
        int local = localInversions(nums);
        mergeSort(nums,0,nums.length-1);
        return local==global;
    }
    private int localInversions(int nums[]){
        int local = 0;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>nums[i+1]){
                local++;
            }
        }
        return local;
    }
    private void mergeSort(int[] nums,int start,int end){
        if(start>=end) return;
        int mid = start + (end-start)/2;
        mergeSort(nums,start,mid);
        mergeSort(nums,mid+1,end);
        merge(nums,start,mid,end);
    }
    private void merge(int nums[],int start,int mid,int end){
        int ans[] = new int[end-start+1];
        int s1 = start;
        int s2 = mid+1;
        int index = 0;
        while(s1<=mid && s2<=end){
            if(nums[s1]<nums[s2]){
                ans[index++] = nums[s1];
                s1++;
            }else{
                ans[index++] = nums[s2];
                global += mid-s1+1;
                s2++;
            }
        }
        while(s1<=mid){
            ans[index++] = nums[s1];
            s1++;
        }
        while(s2<=end){
            ans[index++] = nums[s2];
            s2++;
        }
        for(int i=0;i<ans.length;i++){
            nums[i+start] = ans[i];
        }
    }
}