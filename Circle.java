import java.util.*;

public class Circle
{
	public void areaCal(int r){
	 System.out.println("The area of the circle is : "+(3.14*r*r));
	}
	
	public void perimeterCal(int r){
	System.out.println("The perimeter of the circle is : "+(3.14*2*r));
	
	}
	
	public static void main(String [] args){
		System.out.println("Enter the radius of the circle");
		Scanner sc=new Scanner(System.in);
		int r=sc.nextInt();
		Circle cr=new Circle();
		cr.areaCal(r);
		cr.perimeterCal(r);
		
	}
}