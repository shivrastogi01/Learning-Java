class A
{
	public A()
	{
		System.out.println("A");
	}
	
}	
class B extends A
{
	public B() 
	{
		this(4);
		System.out.println("B2");
	}
	public B (int a)
	{
		System.out.println("B");
	}
}
 
 public class Constructor1
 {
	public static void main(String [] args)
	{
		B obj=new B();
	}
	 
 }