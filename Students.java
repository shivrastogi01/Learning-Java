class Person{
String name;
int age;
Person(String name,int age)
	{
	this.name=name;
	this.age=age;
	
	}
	
}
class Students extends Person
{
	int rollno;
	int marks;
	Students(String name,int age, int rollno,int marks)
	{
		super(name,age);
		this.rollno=rollno;
		this.marks=marks;
	}
	public static void main(String[] agrs){
	Students s=new Students("durga",48,101,90);
	
	}
}