 import java.util.*;

public class NewPattern
{
public static void main(String[] args)
	{
		int i, j;
   char input='E', alphabet = 'A';
	 for (i = 1; i <= (input - 'A' + 1); ++i) {
      for (j = 1; j <= i; ++j) {
		  if(i>2){
		if(j==1 || j==i)
		System.out.print(alphabet);
		else
		System.out.print("*");
		  }
		  else
		  System.out.print(alphabet);
      }
      ++alphabet;
     System.out.println("");
   }
	}

}