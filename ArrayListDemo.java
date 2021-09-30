import java.util.*;

class ArrayListDemo{
	public static void main(String [] args){
		ArrayList l= new ArrayList();
		l.add("A");
		l.add(10);
		l.add(null);
		System.out.println(l);//[A,10,null]
		l.remove(2);
		System.out.println(l);//[A,10]
		l.add(1,"M");
		System.out.println(l);//[A,M,10]
		l.add("N");
		System.out.println(l);//[A,M,10,N]
		
		
		
	}

}