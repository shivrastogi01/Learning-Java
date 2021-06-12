 import java.util.*;
import java.io.*;
import java.lang.*;
class EquilibriumPoint
{ 

  
    static boolean checkEquilibrium(int arr[])
    {
    	int sum = 0;

    	for(int i = 0; i <arr.length; i++)
    	{
    		sum += arr[i];
    	}

    	int l_sum = 0;

    	for(int i = 0; i < arr.length; i++)
    	{
    		if(l_sum == sum - arr[i])
    			return true;

    		l_sum += arr[i];

    		sum -= arr[i];
    	}

    	return false;
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
	
       System.out.println(checkEquilibrium(arr));

    } 

}