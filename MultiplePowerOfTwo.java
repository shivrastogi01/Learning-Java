import java.util.*;
import java.io.*;

class MultiplePowerOfTwo{
	static boolean isPow2(int n){
		return (n!=0)&&((n&(n-1))==0);
		
	}
	public static void main(String [] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println(isPow2(n));
		
	}
}