import java.util.*;
import java.io.*;
class OddOccurence{
	
static int findOdd(int arr[],int num){
		int temp=0;
		for(int i=0;i<num;i++)
		temp=temp^arr[i];
		
		return temp;
	}
	public static void main(String[] args){
	System.out.println("Enter the no. of elements in the array");
	Scanner sc =new Scanner(System.in);
	int num=sc.nextInt();
	System.out.println("Enter the elements of array");
	int[] arr=new int[num];
	for(int i=0;i<num;i++)
		arr[i]=sc.nextInt();
		int result=findOdd(arr ,num);
		
		System.out.println("The result is : "+result);
	}
	
}