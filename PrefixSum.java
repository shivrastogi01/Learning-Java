import java.util.*;
import java.io.*;
import java.lang.*;
class PrefixSum
{ 

    static int[] preSum(int arr[])
    {
    	
    	int prefix_sum[] = new int[arr.length];

    	prefix_sum[0] = arr[0];

    	for(int i = 1; i < arr.length; i++)
    	{
    		prefix_sum[i] = prefix_sum[i - 1] + arr[i];
    	}
    	
    	return prefix_sum;
    }

    static int getSum(int prefix_sum[], int l, int r)
    {
    	if(l != 0)
    		return prefix_sum[r] - prefix_sum[l - 1];
    	else
    		return prefix_sum[r];
    }
    
    
    public static void main(String args[]) 
    { 
	 System.out.println("Enter the no of element you want to enter in Array");
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	System.out.println("Enter array element");
	int arr[]=new int[n];
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
	System.out.println("Enter the index from where to where you want sum");
	int start=sc.nextInt();
	int end=sc.nextInt();

       int prefix_sum[] = preSum(arr);

       System.out.println(getSum(prefix_sum, start, end));
       
       
    } 

}//time complexity bigO(1);