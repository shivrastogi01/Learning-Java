import java.util.*;
import java.io.*;
import java.lang.*;
class MajorityElement
{ 

    static int findMajority(int arr[])
    {
    	int res = 0, count = 1;

    	for(int i = 1; i <arr.length; i++)
    	{
    		if(arr[res] == arr[i])
    			count++;
    		else 
    			count --;

    		if(count == 0)
    		{
    			res = i; count = 1;
    		}
    	}

    	count = 0;

    	for(int i = 0; i <arr.length; i++)
    		if(arr[res] == arr[i])
    			count++;

    	if(count <= arr.length/2)
    		res = -1;

    	return res; 
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
		int i=findMajority(arr);
       System.out.println("The Majority element is : "+arr[i]);

    } 

}