import java.util.*;

public class Reverse_string_words
{
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in); 
		System.out.print("Enter a string: ");  
		String s= sc.nextLine();  
		
		String stringTokens[]=s.split("[ ,.	?@'!]+");
		
			for(int len = stringTokens.length-1;len>=0;len--)
			System.out.print(stringTokens[len]+" ");
		
		
	}
	
}
