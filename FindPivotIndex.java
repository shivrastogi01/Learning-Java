 class FindPivotIndex{
 public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int n: nums) sum += n;

        int i= 0;
        int leftSum = 0, rightSum;
        while(i < nums.length){
            rightSum = sum - leftSum - nums[i];
            if(leftSum == rightSum) return i;
            leftSum += nums[i];
            i++;
        }
        return -1;
    }
	}