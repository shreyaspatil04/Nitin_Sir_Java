package Day_6;


/*

// abstract class ->

  abstract class is the one which contain contract + concrete behaviour

  you cant create object of abstract class  //  cant be instantiated


  // can abstract class have a constructor
  -> yes
  Abstract class cannot be instantiated, but its constructor is called when a child class object is created.

abstract class Person
{
    abstract void performDuties();   // contract

    // concrete
	void walk()
	{
		// code to walk
	}
	void talk()
	{
		// code to talk
	}
	void eat()
	{
		// code to eat
	}
	void sleep()
	{
		// code to walk
	}
}








//
create a new project
	EventDemo1 class with main function

abstract class MouseEvent
{
	abstract void mouseClicked();
	abstract void mouseEntered();
	abstract void mouseExited();
}

abstract class WindowEvent
{
	abstract void windowClosing();
	abstract void windowOpening();
}



class GuiApp1
{
	// how can we extend MouseEvent and WindowEvent both in this class?
}

is it possible to say

class GuiApp1 extends MouseEvent,WindowEvent
{
}

No. because multiple inheritance is not allowed in java.

There are two ways we can solve the problem.

one way is

	class GuiApp1 extends MouseEvent
	{
		void mouseClicked()
		{
			S.o.p("mouse clicked");
		}

		void mouseEntered()
		{
			S.o.p("mouse entered");
		}
		void mouseExited()
		{
			S.o.p("mouse exited");
		}
	}

	class GuiApp2 extends WindowEvent
	{
		void windowClosing()
		{
			S.o.p("window closing");
		}
		void windowOpening()
		{
			S.o.p("window opening");
		}
	}

	now create objects of these two classes and invoke their methods from main function.


the other way is:

since our MouseEvent and WindowEvent classes have got only abstract methods ( contracts ) we can have them as "interfaces" instead of "abstract classes".
What is the advantage if they are interfaces?
	GuiApp class can implement more than one interfaces.


// interface is by default public and abstract


create a new project

	StorageDemo class with main function.

interface Storage
{
	void store();
	void load();
	void display();
}
class FileStorage implements Storage     //  filestorage is implementation of storage not a child of storage
{
	public void store()
	{
		S.o.p("store inside filesystem");
	}
	public void load()
	{
		S.o.p("load from filesystem");
	}
	public void display()
	{
		S.o.p("display from filesystem");
	}
}
class DatabaseStorage implements Storage
{
	public void store()
	{
		S.o.p("store inside Database");
	}
	public void load()
	{
		S.o.p("load from Database");
	}
	public void display()
	{
		S.o.p("display from Database");
	}
}








class base
{
	void disp()
	{
		System.out.println("base disp");
	}
}
class sub1 extends base
{
	void disp()
	{
		System.out.println("sub1 disp");
	}
}
class sub2 extends sub1
{
}
public class Demo26
{
	public static void main(String args[])
	{
		base ref=new sub2();  // upcasting
		ref.disp();  // late binding
	}
}


// here sub 1 method will be called








class base
{
	void disp()
	{
		System.out.println("base disp");
	}
}
class sub1 extends base
{
	void disp()
	{
		System.out.println("sub1 disp");
	}
	void print()
	{
		System.out.println("sub1 print");
	}
}
public class Demo27
{
	public static void main(String args[])
	{
		base ref=new sub1();  // upcasting
		ref.disp();  // late binding
		ref.print();
	}
}

/// here you will get compiler error becoz ref belongs to base and base doesnt have print function...












class base
{
	void disp()
	{
		System.out.println("base disp");
	}
}
class sub1 extends base
{
	void disp()
	{
		System.out.println("sub1 disp");
	}
}
public class Demo28
{
	public static void main(String args[])
	{
		base ref1=new sub1(); //upcasting
		sub1 s1=(sub1)ref1; //downcasting
		System.out.println("first test over");

		base ref2=new base(); // no upcasting
		sub1 s2=(sub1)ref2;  // downcasting          // this is not allowed here  // child cant refer to parent obj // parent can refer to child
		System.out.println("second test over");
	}
}










// instance of           - study this

class base
{
}
class sub extends base
{
}
public class myclass extends sub
{

	public static void main(String args[])
	{
		myclass m=new myclass();
		if(m instanceof myclass)
		{
			System.out.println("myclass");
		}
		if(m instanceof sub)
		{
			System.out.println("sub");
		}
		if(m instanceof base)
		{
						System.out.println("base");
		}
		if(m instanceof Object)
		{
			System.out.println("Object");
		}

	System.out.println("**********************");
		base b=new sub();
		if(b instanceof base)
		{
			System.out.println("base");
		}
		if(b instanceof sub)
		{
			System.out.println("sub");
		}
		if(b instanceof myclass)
		{
			System.out.println("myclass");
		}
		if(b instanceof Object)
		{
			System.out.println("Object");
		}
	}
}




when insterface derived from multiple interface it uses extends keyword

interface emp1{
 void  displ();
}

interface emp2{
 void dspl2();
}

interface emp3 extends emp1,emp2{
void displ3();
}





















class base
{
	public void disp()
	{
		System.out.println("in base disp");
	}
}
class sub1 extends base
{
	public void disp()
	{
		System.out.println("in sub1 disp");
	}
}
class sub2 extends base
{
	public void disp()
	{
		System.out.println("in sub2 disp");
	}
}
class sub3 extends base
{
	public void disp()
	{
		System.out.println("in sub3 disp");
	}
}
public class Demo38
{

	public static void main(String args[])
	{
		/*create an array of base class having 3 elements
		store all the child class objects in this array.
		traverse the array and invoke disp of all the classes.

base arr[]=new base[3];
arr[0]=new sub1();
arr[1]=new sub2();
arr[2]=new sub3();

		for(int i=0;i<arr.length;i++)
        {
             arr[i].disp();
		}
     }
  }








// demo 39.......
class base
{
	public void disp()
	{
		System.out.println("in base disp");
	}
}
class sub1 extends base
{
	public void disp()
	{
		System.out.println("in sub1 disp");
	}
}
class sub2 extends base
{
	public void disp()
	{
		System.out.println("in sub2 disp");
	}
}
class sub3 extends base
{
	public void disp()
	{
		System.out.println("in sub3 disp");
	}
}
public class Demo39
{

	public static void main(String args[])
	{
		/*create an array of base class having 3 elements
		store all the child class objects in this array.
		traverse the array and invoke disp of sub2 only.

base arr[]=new base[3];
arr[0]=new sub1();
arr[1]=new sub2();
arr[2]=new sub3();

		for(int i=0;i<arr.length;i++)
        {
        if(arr[i] instanceof sub2)
        {
             arr[i].disp();
				break;
        }
      }
    }
  }




// demo 40

interface base
{
	void disp();
}
class sub1 implements base
{
	public void disp()
	{
		System.out.println("in sub1 disp");
	}
}
class sub2 implements base
{
	public void disp()
	{
		System.out.println("in sub2 disp");
	}
}
class sub3 implements base
{
	public void disp()
	{
		System.out.println("in sub3 disp");
	}
}
public class Demo40
{

	public static void main(String args[])
	{
		/*create an array of base having 3 elements
		store all the child class objects in this array.
		traverse the array and invoke disp of sub2 only.

base arr[]=new base[3];
arr[0]=new sub1();
arr[1]=new sub2();
arr[2]=new sub3();

		for(int i=0;i<arr.length;i++)
        {
        if(arr[i] instanceof sub2)
        {
              arr[i].disp();
				break;
        }
      }
    }
  }

// these questions can be ask for practical exam....
























OOPS - >  Day_1 folder...

do defination and example....

Abstraction - means hiding an implementation





Encapsulation -





4 pillers of oops ->







2 types of polymorphism -
         runtime     compile time
        -overloading  -overrinding




// static block in  inheritance

static block invocation means initialization of class.....

in case inheritance parents class intialization happens first.....

classes gets loaded only once......




Day_4 inheritance 2 . special txt file


special.txt    and special1.txt






inheritance folder 2 -> classCastException
class cast exception
// weapon for upcast and downcast

upcast downcast ex..


we cant create object of class in two scenarios?
-> abstract class and private constructor


abstract class in inheritance......

why we create abstract class without any abstract method?...................








 */
























 public class main {
 static void main() {
  System.out.println("Hello");
 }
}


