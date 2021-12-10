import java.util.*;

class CheckPythogorousTiplets{
	public static void main(String [] args){
		int A[]={4,2,6,5,8};
		int n= A.length;
		Arrays.sort(A);
		if(check(A, n))
		System.out.println("Yes");
		else
		System.out.println("No");
		
	}
	
	public static boolean check(int A[] , int n){
		for(int i=0;i<n;i++)
		A[i]=A[i]*A[i];
		
		for(int i=0 ;i<n;i++){
			int j=0 ,k=i-1;
			while(j<k){
				if(A[j] +A[k]==A[i])
				return true;
				
				else if(A[j]+A[k]<A[i])
				j++;
				
				else
				k--;
			}
		}
		return false;
	}
	
}