import java.util.*;

public class Browser
{
	public void browserName(String br){
		System.out.println("The browser is :"+br);
		
	}
	
	public static void main(String[] args)
	{
		System.out.println("Enter the  browser name");
		Scanner sc= new Scanner(System.in);
		String str= sc.nextLine();
		Browser sr= new Browser();
		sr.browserName(str);
		

		switch(str)
		{
			case "chrome"||"Chrome":
			System.out.println("chrome");
			break;
			
			case "ff":
			System.out.println("ff");
			break;
			
			case "ie":
			System.out.println("ie");
			break;	
			
			default:
			System.out.println("Please enter valid browser");
			
		}
		
		
		
		
	}
}