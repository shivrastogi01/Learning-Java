import java.util.*;
import java.lang.*;
import java.io.*;

class FindLongestSubArrayGivenSumUsingHashing
{
    public static void main (String[] args) 
    {
		System.out.println("Enter how many elements you want in array ");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println(" Enter array elements");
        int arr[] = new int[n];
		for(int i=0;i<n;i++)
		arr[i]=sc.nextInt();
		System.out.println("Enter the Sum you waant to find ");
		int sum=sc.nextInt();
		
        System.out.println("The longest substring of lengthis : " +LongestSumSubarray(arr,sum));
        
    }
    
    static int LongestSumSubarray(int arr[], int sum)
    {
        HashMap<Integer,Integer> hm= new HashMap<Integer,Integer>();
        int prefix_sum = 0 , res=0;
		for(int i=0;i<arr.length;i++){
			prefix_sum +=arr[i];
			if(hm.containsKey(prefix_sum-sum))
			res=Math.max(res,i-hm.get(prefix_sum-sum));
			if(prefix_sum==sum)
			res=i+1;
			if(hm.containsKey(prefix_sum)==false)
			hm.put(prefix_sum,i);
			
		//	hs.add(prefix_sum);
			
		}
		return res;
	}
}//Time complexity is Big O(n), Aux. space BigO(n) 
