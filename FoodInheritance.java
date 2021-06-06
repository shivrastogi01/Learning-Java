public class VegFood
{    public void milkProuct(){
	System.out.println("Paneer");
}
}
public class NonVegFood extends VegFood
{
	public void chicken(){
	System.out.println("Khadai_Chicken ");
	}
}

public class FoodInheritance{

public static void main(String[] args)
{
	NonVegFood nv = new NonVegFood();
	nv.milkProuct();
	nv.chicken();
	
}


}