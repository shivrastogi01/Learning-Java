class OverloadingConstructor	
{
	OverloadingConstructor (double d)
	{
		this(10);
		System.out.println("Doble args. constructor");
	}
	
	OverloadingConstructor (int i)
	{
		this();
		System.out.println("Int args. constructor");
	}
	OverloadingConstructor ()
	{
		System.out.println("No args. constructor");
	}
	
	public static void main(String[] args){
		OverloadingConstructor t1=new OverloadingConstructor (10.6);//output no args then int then //double
		OverloadingConstructor t2=new OverloadingConstructor (2);//no args then int 
		OverloadingConstructor t3=new OverloadingConstructor ();// no args
		
	
	}
}
