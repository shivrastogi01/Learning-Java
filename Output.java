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


