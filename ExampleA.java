class Car
{
	public void A1(int i)
	{
		System.out.println("class  Car");
	}
}
 class Car1
 {
 public void A1(int i, int j)
	{
	System.out.println("class  Car1");
	}
 }
 public class ExampleA
 {
 public static void main(String [] args)
 {
 
 Car1 obj= new Car1();
 Car obj1= new Car();
 obj1.A1(3);
 obj.A1(3,5);
 }
 
 }