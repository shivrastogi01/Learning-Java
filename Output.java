import java.util.Scanner; 
  
class Output
{ 
    public static void main(String args[]) 
    { 
        // Using Scanner for Getting Input from User 
        Scanner sc = new Scanner(System.in); 
		int b= sc.nextInt();
		int n= sc.nextInt();
		int a= sc.nextInt();
		int p=0;
		for(int i=0;i<n;i++)
		{
			//p=(a+(2^i)*b);
			System.out.println((a+(2^i)*b));
			//System.out.print("Hi");
			
			
		}
		
  
        
      
    } 
} 


00 01 02 03 04
10 11 12 13 14
20 21 22 23 24
30 31 32 33 34
40 41 42 43 44
.


00 01 02 03 04
10 11 12 13 14
20 21 22 23 24
30 31 32 33 34
40 41 42 43 44


System.out.println(i+0+" "+i+1+" "+i+2+" "+i+3+" "+i+4);