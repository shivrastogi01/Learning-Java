
import java.util.*;

public class Car
{
	String name;
	int model;
	int price;
	String color;
	
	
	public static void main(String [] args)
	{
		Car c1 =new Car();
		c1.name="Audi";
		c1.model=2019;
		c1.price=80;
		c1.color="Red";
		
		Car c2 =new Car();
		c2.name="BMW";
		c2.model=2019;
		c2.price=80;
		c2.color="Black";
		
		
		Car c3 =new Car();
		c3.name="RR";
		c3.model=2020;
		c3.price=400;
		c3.color="White";
				
		Car c4 =new Car();
		c4.name="McLaren";
		c4.model=2020;
		c4.price=350;
		c4.color="Orange";
		
		
		Car c5=new Car();
		c5.name="Dodge";
		c5.model=2019;
		c5.price=150;
		c5.color="black";
		
		System.out.println(c1.name +" "+ c1.model +" "+c1.price +" "+c1.color);
		System.out.println(c2.name+" "+ c2.model +" "+c2.price +" "+c2.color);
		System.out.println(c3.name +" "+ c3.model +" "+c3.price +" "+c3.color);
		System.out.println(c4.name +" "+ c4.model +" "+c4.price +" "+c4.color);
		System.out.println(c5.name +" "+ c5.model +" "+c5.price +" "+c5.color);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
