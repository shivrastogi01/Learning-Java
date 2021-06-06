import java.util.*;	

class GreaterAndSmall
{
	public static void main(String[] args){
		System.out.println("How many number you want to enter");
	    Scanner sc= new Scanner(System.in);
		int num=sc.nextInt();
		System.out.println("Enter numbers");
		
		int [] a=new int[num];
		int [] b=new int[num];
		for(int i=0;i<num;i++)
		{
			a[i]=sc.nextInt();
		}
		int temp;
		for(int i=0;i<a.length;i++)
		{
			int flag=0;
			for(int j=0;j<a.length-1-i;j++)
			{
				if(a[j]>a[j+1])
				{
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					flag=1;
					
				}
			
			}if(flag==0)
			{
				break;
				
			}
		}
			for(int i=0;i<a.length;i++)
			{
				System.out.println(a[i]+" ");
				
				
			}
		//System.out.println(b[]);
	}
}