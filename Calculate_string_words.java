import java.util.*;

public class Calculate_string_words
{
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		String str=sc.nextLine();
		sc.close();	
		String str1=str.trim();
		int count=1;
		for(int i=0;i<str1.length();i++)
		{
			if((str1.charAt(i)==' ')||(str1.charAt(i)=='/t'))
			{	
				count++;
			}
			
		}System.out.println(count);
	}
}