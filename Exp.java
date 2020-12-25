public class Exp
{
	public static void main(String[] args)
	{
		try
		{
			System.out.println(5/0);
            	
		}
	    catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
	/*	catch(NullPointerException e)
		{
			System.out.println(e.getMessage());

		}
	*/	
		catch(ArithmeticException e)
		{
			System.out.println(e.getMessage());

		}	
	}
}