import java.util.*;

public class WordcountString{

public static void main(String[] args){

	Scanner sc = new Scanner(System.in);
	System.out.println("Enter any String");
	String str = sc.nextLine();
	
	String str1 = str.trim();
	int count=1;
	if(str1.length()==0)
	System.out.println(0);
	
	else{
	for(int i=0; i <str1.length(); i++){
	
		if(((str1.charAt(i)==' ') || (str1.charAt(i)=='\t')) && ((str1.charAt(i-1)!=' '))&&((str1.charAt(i-1)!='\t')))
		{
		count++;
		}
		
	}
	System.out.println(count);
	}
}


}