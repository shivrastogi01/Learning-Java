 class A
 {
	 public void f1(int i)
	 {
		 System.out.println("class B");
	 }
 }
 class B extends A
 {
	 
	public void f1(int i)
	{
		System.out.println("class A");
	}

 }
 
 
 public class Overload
 {
	 public static void main( String [] args)
	 {
		 B obj=new B();
		 obj.f1(5);
		 obj.f1(3,4);
	 }
 }