import java.util.*;
import java.lang.*;
import java.io.*;

class IntersectionElement
{
    public static void main (String[] args) 
    {
		System.out.println("Enter the no of element you want to enter in Array 1");
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	System.out.println("Enter array elements");
	int arr1[]=new int[n];
	for(int i=0;i<n;i++)
	arr1[i]=sc.nextInt();
       
	    System.out.println("Enter the no of element you want to enter in Array 2");
	int m=sc.nextInt();
	System.out.println("Enter array elements");
	int arr2[]=new int[m];
	for(int i=0;i<m;i++)
	arr2[i]=sc.nextInt();
        
	    intersection(arr1,arr2);
        
    }
    
    static void intersection(int arr1[], int arr2[]){
    
         int i=0,j=0;
        while(i<arr1.length && j<arr2.length){
            if(i>0 && arr1[i-1]==arr1[i]){
                i++;
                continue;
            }
            if(arr1[i]<arr2[j]){
                i++;
            }
            else if(arr1[i]>arr2[j]){
                j++;
            }
            else{
                System.out.print(arr1[i]+" ");
                i++;j++;
            }
        }   
    }
}
