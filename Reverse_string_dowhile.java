import java.util.*;


class Reverse_string_dowhile
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int i=str.length()-1;
		do
		{
			System.out.print(str.charAt(i));
			i--;
		}while(i>=0);
	
	}
}