import java.util.*;
import java.io.*;
import java.lang.*;



class BinarySearch
{ 
	
	

	static int bSearch(int arr[],  int x)
	{
		int low = 0, high = arr.length- 1;

		while(low <= high)
		{
			int mid = (low + high) / 2;

			if(arr[mid] == x)
				return mid;

			else if(arr[mid] > x)
				high = mid - 1;

			else
				low = mid + 1;
		}

		return -1;
	}

	public static void main(String args[]) 
    {
     System.out.println("Enter the no of element you want to enter in Array");
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	System.out.println("Enter array elements in sorted order");
	int arr[]=new int[n];
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();

		int x = 25;
    
        System.out.println(bSearch(arr, x));
		
    } 

}