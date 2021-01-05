import java.util.*;

public class Add{
	public void addMethod(int a, int b){
	System.out.println("The sum of numbers is : "+(a+b));
	
	}
	public static void main(String [] args){
		System.out.println("Enter two numbers");
		Scanner sc= new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		Add ad=new Add();
		ad.addMethod(a,b);
		
	
	}

}