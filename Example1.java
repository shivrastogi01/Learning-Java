
class A extends Thread 
{
	public void run()
	{
		int i;
		for(i=1;i<=10;i++)
		System.out.println("i="+i+"Thread A");
	
	}
}

class B extends Thread 
{
	public void run()
	{
		int i;
		for(i=1;i<=10;i++)
		System.out.println("i="+i+"Thread B");
	
	}
}


public class Example1 {
	public static void main(String[] args)
	{
		A o1=new A();
		B o2=new B();
		
		o1.start();
		o2.start();
	}
}

Dear All I've added all the above mentioned ppl in the group and below is the whatsapp group link. Please join WhatsApp using the below link