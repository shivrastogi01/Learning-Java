class San{
	
	public void show(){
		System.out.println("In San");
	}

}

class Shiv extends San{
	public void show(){
		System.out.println("In Shiv");
	
	super.show();
	}
}

public class OverR{
	public static void main(String[] args){
		Shiv sh = new Shiv();
		sh.show();
		
		San sa = new San();
		sa.show();
	}
}