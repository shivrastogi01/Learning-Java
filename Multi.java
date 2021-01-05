import java.util.*;

public class Multi{
	public int multiMethod(int a, int b){
		return a*b;
	
	}
	public static void main(String [] args){
		System.out.println("Enter two numbers");
		Scanner sc= new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		Multi ml=new Multi();
		ml.multiMethod(a,b);
		System.out.println("The multiplication of numbers is: "+(a*b));
		
	
	}

}