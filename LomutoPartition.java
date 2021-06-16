import java.util.*;
import java.io.*;

class LomutoPartition{
	public static void main(String[] agrs){
		System.out.println("Enter the no of element you want to enter in the array ");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		System.out.println("Enter Array elements");
		for(int i=0;i<n;i++)
		arr[i]=sc.nextInt();
		iPartition(arr,0,n-1);
		System.out.println("The output is : ");
		for(int x:arr)
		System.out.print(x+ " ");
		
	}
	static int iPartition(int arr[],int l ,int h){
        int pivot=arr[h];
        int i=l-1;
        for(int j=l;j<=h-1;j++){
            if(arr[j]<pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[h];
        arr[h]=temp;
        return i+1;
    }

}