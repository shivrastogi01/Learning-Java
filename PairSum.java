import java.util.*;
import java.io.*;
import java.lang.*;

class PairSum
{
    static boolean isPresent(int arr[], int sum)
    {
        int l = 0, h = arr.length-1;
        
        
        while(l <= h)
        {
            if(arr[l] + arr[h] == sum)
              return true;
            else if(arr[l] + arr[h] > sum)
                h--;
            else l++;
        }
        
        return false;
    }
    public static void main (String[] args) {
       System.out.println("Enter the no of element you want to enter in Array");
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	System.out.println("Enter array elements in sorted order");
	int arr[]=new int[n];
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
	System.out.println("Enter the Sum vlaue you want to check");
        int sum = sc.nextInt();
        
        System.out.println(isPresent(arr, sum));
        
    }
}