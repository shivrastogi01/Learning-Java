import java.util.*;
import java.io.*;
import java.lang.*;
class SortedArray
{ 
    static boolean isSorted(int arr[])
    {
    	for(int i = 1; i < arr.length; i++)
    	{
    	    if(arr[i] < arr[i - 1])
    	        return false;
    	}

    	return true;
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

       System.out.println(isSorted(arr));
    } 
}