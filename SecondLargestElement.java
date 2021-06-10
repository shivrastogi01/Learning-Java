import java.util.*;
import java.io.*;

class SecondLargestElement{
	public static void main(String [] args)
		{
	System.out.println("Enter the no of element you want to enter in Array");
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	System.out.println("Enter array element");
	int arr[]=new int[n];
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
	int res=secondLargest(arr);
	System.out.println("Second largest element is: " +arr[res]);
	
	}
	static int secondLargest(int arr[]){
		int res=-1, largest=0;
		
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]>arr[largest]){
				res=largest;
				largest=i;
			}
			else if(arr[i]!=arr[largest]){
				if(res==-1 || arr[i]>arr[res])
				res=i;
			}
		}
		return res;
	}
	

}