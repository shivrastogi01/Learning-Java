import java.util.*;

public class Anystring
{
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in); 
		System.out.print("Enter a string: ");  
		String s= sc.nextLine();  
		//int num=0;
		//s=s.toUpperCase();
		String stringTokens[]=s.split(" ");
		String fToken = stringTokens[0].toUpperCase();
		String secToken = stringTokens[1].toUpperCase();
		int len = stringTokens.length;
		System.out.println(fToken.charAt(0)+"."+secToken.charAt(0)+". "+stringTokens[len-1]);
		
	}
	
}
