public class Exp1
{
	public static void main(String[] args)
	{
		int balance =5000;
		int withdrawl=300000;
		
		try{
		if(withdrawl>balance)
		throw new ArithmeticException("Insufficent Balance Enter");
		balance=balance-withdrawl;
		System.out.println("Transaction completed");
		System.out.println("New Balance " +balance);
		}
		
		catch(ArithmeticException ex)
		{
			System.out.println(ex.getMessage());
		}
		System.out.println("continue ");
	}
}