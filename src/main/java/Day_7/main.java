package Day_7;


/*
DAY_3 constructor invocation  static block in inheritance --








class A{
	static
	{
		System.out.println("A static");
	}
}
class B
{
	static
	{
		System.out.println("B static");
	}
}

public class StaticTest
{
	private A ob1;
	private static B ob2;
	static
	{
		System.out.println("in StaticTest static");
	}
	public static void main(String args[])
	{
		StaticTest ref=new StaticTest();
		ref.ob1=new A();
		ob2=new B();

	}
}









/// inheritance folder 3 - DAY-4


    is vs has a relationship

    is-a   vs has-a  relationship?




Aggregation vs Composition ?
   ->
   parent-child


   these are examples of Aggregation vs Composition
   prractice this for practical exam...



  -:

    this is example of aggregation... (
   package aggregation;

class Teacher
{
	private String name;
	private	int age;
	public Teacher(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void work()
	{
		System.out.println("Teacher is working");
	}
};

class Department
{
	private Teacher teacher;
	private String dname;
	public	Department(String dname)
	{
		teacher=null;
		this.dname=dname;
	}
	public String getDname()
	{
		return dname;
	}
	public void addTeacher(Teacher teacher)
	{
		this.teacher=teacher;
	}
	public void perform()
	{
		System.out.println(dname+"\t");
		teacher.work();
	}
}

public class AggregationDemo
{
	public static void main(String[] args)
	{
		Department sd=new Department("Science Department");
		Department md=new Department("Maths Department");
		System.out.println(sd.getDname());
		System.out.println(md.getDname());
		Teacher t1=new Teacher("Abc",35);
		System.out.println(t1.getName()+"\t"+t1.getAge());
		md.addTeacher(t1);
		md.perform();
		System.out.println("Lets close the maths department");
		md=null;  // delete maths department
		System.out.println(t1.getName()+" still exists and can join some other department");
		sd.addTeacher(t1);
		sd.perform();
		// ..... after some time ......
		sd=null;  //delete science department
		System.out.println(t1.getName()+" still exists and can join some other department");

	}

}








// composite - (tightly coupled)


package composition;

import java.util.Scanner;

class Room
{
	private String name;
	public Room(String name)
	{
		this.name=name;
	}
	public Room()
	{
		name=null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
};

class House
{
	private Room rooms[];
	private String name;
	private String address;
	private int no_rooms;
	public	House(String name,String address,int no_rooms)
	{
		this.name=name;
		this.address=address;
		this.no_rooms=no_rooms;
		this.rooms=new Room[no_rooms];
		String rname;
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<no_rooms;i++)
		{
			System.out.println("enter room name");
			rname=sc.next();
			this.rooms[i]=new Room();
			this.rooms[i].setName(rname);
		}
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	void showRooms()
	{
		for(int i=0;i<no_rooms;i++)
		{
			System.out.println(rooms[i].getName());
		}
	}
}
public class CompositeDemo
{
	public static void main(String args[])
	{
		House house=new House("Samrat Mansion","Juhu,Mumbai",4);
		System.out.println(house.getName());
		System.out.println(house.getAddress());
		System.out.println("house has following rooms");
		house.showRooms();
		System.out.println("Lets renovate the house");
		house=null;
	}
}


this is imp -- study this properly.................









white-box and black-box reuse ?
->


concept + example code......   (program to implments) and (program to interfacee)
in implements we create object......
in interface user pass the object...so this is better....



 when programmer create obj of a class is program to implementation
 when prograamer allows user to create an object and just pass the reference.....

private Engine engine = new Engine();  // progarm to implementation



private engine engine;     // program to interface

 public Car(Engine engine){
   this.engine = engine
 }

 program to implemantation is {....tight coupling ....}

 program to interface is {.....loose coupling.......}



class Soldier {
   Gun gun = new Gun();   // tightly coupled

   weapon ref;

    Soldier (Weapon ref){    // loosely coupled
       this.ref = ref;
   }
}



 class Developer{
    Python p  = new Python();

    Technology ref;

    public Technology(Technology ref){
    this.ref = ref;
    }






    class Weapon
{
	void attack()
	{
	}
	// some other stuff
}
class Gun extends Weapon
{
	void attack()
	{
		System.out.println("Gun attack");
	}
}
class Sword extends Weapon
{
	void attack()
	{
		System.out.println("Sword attack");
	}
}
class Bomb extends Weapon
{
	void attack()
	{
		System.out.println("Bomb attack");
	}
}

class Soldier
{
	// program to implementation

	// Soldier class here is tightly coupled with a specific Weapon ie. Gun or Bomb or Sword
	// it gives us maintenance drawback

	//Gun ob=new Gun();  // Soldier has Gun
	//Bomb ob=new Bomb();
	Sword ob=new Sword();
	void fight()
	{
		ob.attack();
	}
}

public class SoldierDemo1
{
	public static void main(String args[])
	{
		Soldier s1=new Soldier();
		s1.fight();
	}
}









class Weapon
{
	void attack()
	{
	}
	// some other stuff
}
class Gun extends Weapon
{
	void attack()
	{
		System.out.println("Gun attack");
	}
}
class Sword extends Weapon
{
	void attack()
	{
		System.out.println("Sword attack");
	}
}
class Bomb extends Weapon
{
	void attack()
	{
		System.out.println("Bomb attack");
	}
}

class Soldier
{


	// Soldier class here is loosely coupled with a specific Weapon ie. Gun or Bomb or Sword
	// it gives us maintenance advantage

	Weapon ref;    // program to interface
	void fight(Weapon ref)
	{
		this.ref=ref;
		ref.attack();
	}
}

public class SoldierDemo2
{
	public static void main(String args[])
	{
		Soldier s1=new Soldier();
		s1.fight(new Gun());
		// or
		s1.fight(new Sword());
	}
}












class Driver
{
// program to implementation
// Driver is tightly coupled with Car or Bus

	Car c=new Car();
		or
	Bus b=new Bus();

	void perform()
	{
		c.drive();
			or
		b.drive();
	}
}


	vs
class Driver
{
	// program to interface

	// Driver is loosely coupled with a specific FourWheeler

	FourWheeler ref;

	void perform(FourWheeler ref)
	{
		this.ref=ref;
		ref.drive();
	}
}










// this.......

{.........DAY-4 inheritancefolder 3 - this demo......}


this is use to call constructor of same class.....
must be on 1st line...





public class trial
{
	trial()
	{
		this(30);
		System.out.println("in def const");
		// this(30); error
	}
	trial(int k)
	{
		this(20,40);
		System.out.println("in 1 param");
	}
	trial(int x,int y)
	{
		System.out.println("in 2 param");
	}
	public static void main(String args[])
	{
		trial t=new trial();
	}
}


trial() -> trial()1param -> trial()2 param -> obj
printing 2 -> 1 -> default









class base
{
	base()
	{
		System.out.println("in base no-arg");
	}
}
public class trial1 extends base
{
	trial1()
	{
		this(30);
		System.out.println("in def const");
	}
	trial1(int k)
	{
		this(20,40);
		System.out.println("in 1 param");
	}
	trial1(int x,int y)
	{
		System.out.println("in 2 param");
	}
	public static void main(String args[])
	{
		trial1 t=new trial1();
	}
}

rial() -> trial()1param -> trial()2 param -> base -> obj.......







// super and this............


class base
{
	base(int k)
	{
		System.out.println("in base param");
	}
}
public class trial2 extends base
{
	trial2()
	{
		this(30);
		System.out.println("in def const");
	}
	trial2(int k)
	{
		this(20,40);
		System.out.println("in 1 param");
	}
	trial2(int x,int y)
	{
		super(30); // super is required here
		System.out.println("in 2 param");
	}
	public static void main(String args[])
	{
		trial2 t=new trial2();
	}
}









// application of this....

public class MyDynamicArray
{
	public MyDynamicArray()
	{
		this(10);
	}

	public MyDynamicArray(int capacity)
	{
		create dynamic array with the given capacity
	}
}

we want to make capacity by default 10 if not provided


MyDynamicArray array1=new MyDynamicArray(50);

MyDynamicArray array2=new MyDyanamicArray();




Early binding - DAY-4 folder name as early binding

 8 Demo code.............





 // some more programs...
     Day-4 inheri 3 - some more prog

     // about overloading  Day-4 inheri 3 - some more prog


     //



     // special .1

     class base
{
	int i;
	base()
	{
		add(1);
	}
	private void add(int v)
	{
		i+=v;
	}
	void print()
	{
		System.out.println(i);
	}
}
class sub extends base
{
	sub()
	{
		add(2);
	}
	void add(int v)
	{
		i+=v*2;
	}
}
public class Special1
{
	static void disp(sub b)
	{
		b.add(8);
		b.print();
	}
	public  static void main(String args[])
	{
		disp(new sub());
	}
}















// assignment - Day-4   -> inheritance folder 3 - assignment



// object_method_demo


 // @Override

"==" and (equals)

// ref1 on left side and we pass ref 2

class A{
void disp(A ref){
  some code

}

}

A ref1 = new A();
A ref2 = new A();

ref1.disp(ref2);






client - developer jar project...











*/




















































/*

public class main {

    int num;

    main(int num){
        this.num = num;
    }

    public boolean equals(main ref) {
//	MyNum temp = (MyNum) ref;
        return this.num == ref.num;
    }
    static void main() {
        Object m1 = new main(200);
        main m2 = new main(200);

        if(m1.equals(m2)) {
            System.out.println("Equal");
        }else {
            System.out.println("Not Equal");
        }
    }
}


// tight coupling example......
 */
/*
public class main {
    static void main() {
        Teacher t1 = new Teacher("Anushka",24);
        Teacher t2 = new Teacher("gadha",68);
        t1.work();

        Department science = new Department("Science department");
        science.add_teacher(t1);
        science.department_work();
        science.add_teacher(t2);
        science.department_work();

    }
}

class Department{
    private Teacher teacher;
    private String depart_name;


    Department(String depart_name){
        this.teacher = null;
        this.depart_name = depart_name;
    }

    public void get_department_name(){
        System.out.println(depart_name);
    }

    public void add_teacher(Teacher teacher){
        this.teacher = teacher;
    }

    public void department_work(){
        System.out.println("In department "+depart_name);
        teacher.work();
    }


}

class Teacher{
    private String name;
    private int age;

    public Teacher(String name,int age)
    {
        this.name=name;
        this.age=age;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(){
        this.age = age;
    }

    public void Get_Name(){
        System.out.println("age");
    }
    public void Get_Age(){
        System.out.println("name");
    }

    void work(){
        System.out.println(name+" is working...");
    }

}

 */


// another timepass loose coupling example.....

/*
public class main {
    static void main() {
        Driver d1 = new Driver("makad");
        d1.get_name();
        Driver d2 = new Driver("manjar");
        d2.get_name();


        vehicle v1 = new vehicle("bus");
        v1.assigning_driver(d1);
        v1.driving_vehicle();

        vehicle v2 = new vehicle("Train");
        v2.assigning_driver(d2);
        v2.driving_vehicle();
    }
}

class Driver{
    private String name;

    Driver(String name){
        this.name = name;
    }

    public void get_name(){
        System.out.println(name+ "is a driver..");
    }

    public void driving(){
        System.out.println(name+" is driving a vehicle..");
    }
}


class vehicle {
    private Driver driver ;
    private String vehicle_name;

    vehicle(String vehicle_name){
        driver = null;
        this.vehicle_name = vehicle_name;
    }

    public void assigning_driver(Driver driver){
        this.driver = driver;
    }

    public void driving_vehicle(){
        System.out.println("Vehicle is "+vehicle_name);
        driver.driving();
    }
}


 */









// tight coupling..........................................................................................................
/*
public class main{
    static void main() {
        car c1 = new car();
        c1.strat_car();
    }
}

class engine{
    void start(){
        System.out.println("engine started...");
    }
}

class car {
    engine e1 = new engine();

    void strat_car(){
        e1.start();
        System.out.println("car started.....");
    }
}

 */









class MyNum{

    int num;

    MyNum(int num){
        this.num = num;
    }

    public boolean equals(Object ref) {
	MyNum temp = (MyNum) ref;
        return this.num == temp.num;
    }

}

public class main {
    public static void main(String[] args) {
        Object m1 = new MyNum(200);
        MyNum m2 = new MyNum(200);

        if(m1.equals(m2)) {
            System.out.println("Equal");
        }else {
            System.out.println("Not Equal");
        }
    }
}

// downcasting code practice animal tiger

