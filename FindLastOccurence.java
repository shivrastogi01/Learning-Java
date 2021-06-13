import java.util.*;
import java.io.*;
import java.lang.*;



class FindLastOccurence
{ 
	
	

	static int lastOcc(int arr[],int x)
	{
		int low = 0, high = arr.length - 1;

		while(low <= high)
		{
			int mid = (low + high) / 2;

			if(x > arr[mid])
				low = mid + 1;

			else if(x < arr[mid])
				high = mid - 1;

			else
			{
				if(mid ==arr.length - 1 || arr[mid + 1] != arr[mid])
					return mid;

				else
					low = mid + 1;
			}

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

		int x = 10;

		System.out.println(lastOcc(arr, x));

    } 

}