import java.util.*;
import java.io.*;
import java.lang.*;



class ArrayWithPrefixSum
{ 

	static int getSum(int pre_sum[], int qs, int qe)
	{
		if(qs == 0)
		    return pre_sum[qe];
		    
		else    
		    return pre_sum[qe] - pre_sum[qs - 1];
	}

	static void update(int pre_sum[], int arr[], int i, int newVal, int n)
	{
		int diff = newVal - arr[i];
		
		for(int j = i; j < n; j++)
		    pre_sum[j] += diff;
	}
	
	static void initialize(int pre_sum[], int arr[], int n)
	{
	    pre_sum[0] = arr[0];
	    
	    for(int i = 1; i < n; i++)
	    {
	        pre_sum[i] = pre_sum[i - 1] + arr[i];
	    }
	}

	public static void main(String args[]) 
    {

		int arr[] = {10, 20, 30, 40, 50}, n= 5;
        
        int pre_sum[] = new int[n];
        
        initialize(pre_sum, arr, n);
        
		System.out.print(getSum(pre_sum, 0, 2) + " ");
		System.out.print(getSum(pre_sum, 1, 3) + " ");
		
		update(pre_sum, arr, 1, 60, n);
		
		System.out.print(getSum(pre_sum, 0, 2) + " ");
		System.out.print(getSum(pre_sum, 1, 3) + " ");

    } 

}