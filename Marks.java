import java.util.*;

public class Marks{

public void grades(int a)
{
	
	if(0<=a && a<=100){
		
	if(90<a && a<=100)
	System.out.println("The grades is AA");
	
	else if(80<a && a<=90)
	System.out.println("The grades is AB");
	
	else if(70<a && a<=80)
	System.out.println("The grades is BB");
	
	else if(60<a && a<=70)
	System.out.println("The grades is BC");
	
	else if(50<a && a<=60)
	System.out.println("The grades is CD");
	
	else if(40<a && a<=50)
	System.out.println("The grades is DD");
	
	else
	System.out.println("Fails");
	}
	
	else{
	System.out.println("Enter Your Correct marks");
	}

}

public static void main(String [] args){
	System.out.println("Enter your Marks");
	Scanner sc= new Scanner(System.in);
	int a=sc.nextInt();
	Marks mr=new Marks();
	mr.grades(a);
}

}