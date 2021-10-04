import java.util.*;

class MaxSumSubArray{
	public static int subArraySum(int [] arr){
		int maxSum=arr[0];
		int currSum=maxSum;
		for(int i=1;i<arr.length;i++){
			currSum=Math.max(currSum + arr[i], arr[i]);
			maxSum=Math.max(currSum,maxSum);
		}
		return maxSum;
	}
	public static void main(String [] args){
		int arr[]={1,-2,0,3};
		System.out.println(subArraySum(arr));
	}
}