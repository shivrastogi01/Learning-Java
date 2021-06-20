import java.util.*;
import java.lang.*;
import java.io.*;

class FindSubArraySumZeroUsingHashing
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
		
        System.out.println(ZeroSumSubarray(arr));
        
    }
    
    static boolean ZeroSumSubarray(int arr[])
    {
        Set<Integer> hs = new HashSet<Integer>();
        int prefix_sum = 0;
		for(int i=0;i<arr.length;i++){
			prefix_sum +=arr[i];
			if(hs.contains(prefix_sum))
			return  true;
			if(prefix_sum==0)
			return true;
			
			hs.add(prefix_sum);
			
		}
		return false;
	}
}
