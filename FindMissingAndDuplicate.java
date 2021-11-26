import java.util.*;

class FindMissingAndDuplicate{
	public static void main(String [] args){
		System.out.println("Enter the size of Array");
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		 System.out.println("Array elements are :");
		 int arr []= new int[n];
		 for(int i=0;i<n;i++){
			 arr[i]=sc.nextInt();
		 }
		 int sum1=n*(n+1)/2;
		 int sum2=n*(n+1)*(2 *n+1)/6;
		 //let  miss be the missing value and dup is a duplicate value in an array
		 int miss,dup;
		 int actualSum=0;
		 int actaulSqSum =0;
		 for(int i=0;i<n;i++){
			 actualSum +=arr[i];
			 actaulSqSum +=arr[i]*arr[i];
		 }
		 int res1=sum1 - actualSum;
		 int res2=sum2-actaulSqSum;
		int  res3=res2/res1;
		 miss=(res1+res3)/2;
		dup =(res3 - res1)/2;
		 System.out.println("missing number is : "+ miss);
		 System.out.println("duplicate number is : " + dup);
	}


}