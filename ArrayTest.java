import java.util.*;
public class ArrayTest {

public static void main(String args[]){

	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the values for 5 users");
	String names[] = new String[5];
	
	for(int i=0; i < 5; i++){
		names[i]=sc.nextLine();	
	}
	
	for(String st : names){
		System.out.println(st);		
	}
	
	
}



}
