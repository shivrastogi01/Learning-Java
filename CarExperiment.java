
import java.util.*;

public class CarExperiment
{
	String name;
	int model;
	int price;
	String color;
	
	
	public static void main(String [] args)
	{
		CarExperiment c1 =new CarExperiment();
		c1.name="Audi";
		c1.model=2019;
		c1.price=80;
		c1.color="Red";
		
		CarExperiment c2 =new CarExperiment();
		c2.name="BMW";
		c2.model=2019;
		c2.price=80;
		c2.color="Black";
		
		
		CarExperiment c3 =new CarExperiment();
		c3.name="RR";
		c3.model=2020;
		c3.price=400;
		c3.color="White";
				
		CarExperiment c4 =new CarExperiment();
		c4.name="McLaren";
		c4.model=2020;
		c4.price=350;
		c4.color="Orange";
		
		
		CarExperiment c5=new CarExperiment();
		c5.name="Dodge";
		c5.model=2019;
		c5.price=150;
		c5.color="black";
		
		System.out.println(c1.name +" "+ c1.model +" "+c1.price +" "+c1.color);
		System.out.println(c2.name+" "+ c2.model +" "+c2.price +" "+c2.color);
		System.out.println(c3.name +" "+ c3.model +" "+c3.price +" "+c3.color);
		System.out.println(c4.name +" "+ c4.model +" "+c4.price +" "+c4.color);
		System.out.println(c5.name +" "+ c5.model +" "+c5.price +" "+c5.color );
		System.out.println();
		
		
		
		c1=c2;
		c2=c3;
		c3=c4;
		c4=c5;
		
		System.out.println(c1.name +" "+ c1.model +" "+c1.price +" "+c1.color);
		System.out.println(c2.name+" "+ c2.model +" "+c2.price +" "+c2.color);
		System.out.println(c3.name +" "+ c3.model +" "+c3.price +" "+c3.color);
		System.out.println(c4.name +" "+ c4.model +" "+c4.price +" "+c4.color);
		System.out.println(c5.name +" "+ c5.model +" "+c5.price +" "+c5.color);
		System.out.println();
		
		c2=c4;
		c4=c3;
		c5=c3;
		c3=c1;
		
		
		System.out.println(c1.name +" "+ c1.model +" "+c1.price +" "+c1.color);
		System.out.println(c2.name+" "+ c2.model +" "+c2.price +" "+c2.color);
		System.out.println(c3.name +" "+ c3.model +" "+c3.price +" "+c3.color);
		System.out.println(c4.name +" "+ c4.model +" "+c4.price +" "+c4.color);
		System.out.println(c5.name +" "+ c5.model +" "+c5.price +" "+c5.color);
		
		
		
		
		
		
		
		
	}

}
