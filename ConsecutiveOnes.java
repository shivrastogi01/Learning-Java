import java.util.*;
import java.io.*;
import java.lang.*;
class ConsecutiveOnes
{ 
    

    static int maxConsecutiveOnes(int arr[])
    {
    	int res = 0, curr = 0;

    	for(int i = 0; i < arr.length; i++)
    	{
    		if(arr[i] == 0)
    			curr = 0;
    		else
    		{
    			curr++;

    			res = Math.max(res, curr);
    		}
    	}
    	
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

       System.out.println(maxConsecutiveOnes(arr));

    } 

}