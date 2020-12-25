import java.util.Scanner;	


public class Compare
{
public static void main(String[] args)
	{
	System.out.println("Enter your first string");
	Scanner s1= new Scanner(System.in);
	String str1= s1.nextLine();
	String a=str1.toLowerCase();
	//System.out.println(str);
	System.out.println("Enter your Second string");
	String str2= s1.nextLine();
	 String b=str2.toLowerCase();
	int var=a.compareTo(b);
	if (var==0)
	System.out.println("Same strings");
	else
	System.out.println("Not Same strings");
	
	}

}