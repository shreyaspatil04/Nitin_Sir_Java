package Day_4;

/*


// Scanner sc = new Scanner(System.in)    // in is a static member of System class

int n = sc.nextInt();


sc.nextInt();
sc.nextDouble();
sc.next();
sc.nextLine();   // this will not take input becoz previous next line will be read by nextLine();


to solve this problem we will add another sc.nextLine();


// this will solve the problem
int a = sc.nextInt();
double d =sc.nextDouble();
String r = sc.next();
sc.nextLine();
String s = sc.nextLine();


//









Final Keyword :-

final can be applied to 5 -:

1) instance member
2) class variable
3) local var
4) member function
5) class


final keyword in Java
final can be applied to:

Instance variable
Static/class variable
Local variable
Method
Class
1. Final instance variable
Once assigned, its value cannot be changed.

class Student {
    final int age = 20;
}

You cannot do:

age = 25;  // Error

2. Final class variable (static)
A static final variable is commonly called a constant.

class Student {
    static final int MAX_AGE = 100;
}

You cannot change it:

MAX_AGE = 120;  // Error

3. Final local variable
A local variable declared final cannot be reassigned.

void show() {
    final int x = 10;

    x = 20;  // Error
}

4. Final method
A final method cannot be overridden by a child class.

class Parent {
    final void display() {
        System.out.println("Hello");
    }
}

class Child extends Parent {
    // Error: cannot override final method
    void display() {
    }
}

5. Final class
A final class cannot be inherited/extended.

final class Parent {
}

This is not allowed:

class Child extends Parent {  // Error
}

Easy way to remember
final means "cannot be changed further":

Where used	Meaning
final variable	Value cannot be reassigned
static final variable	Constant
final local variable	Local value cannot be reassigned
final method	Cannot be overridden
final class	Cannot be inherited











// singleton class

is a class where :
a) only one object is created and that too inside the class itself by the developer.
b) users are not allowed to create the object or instance of the class.
 They can use the same instance or object which has been created inside the class.
c) may have some non-static methods.
d) developer must share one and only one object created of the class among all the users ,
so that they can invoke non-static methods of the class.

developer share obj to client by static method

class Singleton{

    private static Singleton s = new Singleton();   // this will be static  because getsingleton is static so you cant call non static

    private Singleton(){
                             // private constructor user cant create object
     }

     // static method to client to share our object
     public static Singleton getsingleton(){
         return s;
     }


     // client cant called this directly we have to give him static method
     public void disl_1(){
     System.out.println("In dspl_1);
     }

     public void disl_2(){
     System.out.println("In dspl_2);
     }
}

class Main{
   psvm(){
      Singleton client_reference = new Singleton(); // not allowed

      Singleton client_reference = Singleton.getsingleton(); // now this is allowed
      client_reference.displ_1();
      client_reference.displ_2();
   }
}






// classloader

ClassLoader — Very Simple Explanation
A ClassLoader in Java is responsible for loading .class files into memory when Java needs them.

Think of it like this:

📦 ClassLoader = a person who brings Java classes from storage into memory so the JVM can use them.

Example
Suppose you write:

class Student {
    void study() {
        System.out.println("Studying");
    }
}

After compilation, Java creates:

Student.class

When your program needs the Student class, the ClassLoader loads Student.class into JVM memory.

Student.class
      ↓
  ClassLoader
      ↓
     JVM
      ↓
 Class is ready to use

Why do we need ClassLoaders?
Java doesn't load every class at once.

It loads a class when it is needed.

For example:

Student s = new Student();

When the JVM needs Student, the ClassLoader finds and loads the Student class.

Types of ClassLoaders
You will commonly hear about these 3:

Bootstrap ClassLoader → loads core Java classes such as String, Object, etc.
Platform ClassLoader → loads Java platform classes.
Application/System ClassLoader → loads classes from your application/classpath.

One-line definition for exams
ClassLoader is a part of the JVM that loads Java class files into memory when they are required.








// lazy or eager resolution.....



// initial discussion... this is for primitive data type
class Sample {

           int num1 = 10; // this instance member will be allocated memory only after object is created

           static int num2 = 100; // num2 will be allocated when  as soon as class gets loaded
}



for reference type - :

class A {           }
class B {           }

class Sample
{
	private A ob1=new A();  // class A will be loaded only after {first} object of Sample gets created.  - lazy resolution

	private static B ob2=new B();  // class B will be loaded immediately after class Sample gets loaded  -  eager resolution
}



comapre side by side
class Sample {
reference type -
 private A ob1=new A();  // class A will be loaded only after {first} object of Sample gets created.  - lazy resolution

 int num1 = 10; // this instance member will be allocated memory only after object is created

 // similarity - allocated and  loaded only when object is created...
}

{ -- learn what is class class  --}




package firstpro;


class A
{
	static
	{
		System.out.println("inside A static block");
	}
}
class B
{
	static
	{
		System.out.println("inside B static block");
	}
}
public class Demo1
{
	private A ref1=new A();    // lazy resolution
	private static B ref2=new B(); // eager resolution
	public static void main(String[] args)
	{
		System.out.println("in main");
		new Demo1();  // class A will be loaded now
	}

}

/*
output:

inside B static block
in main
inside A static block



package firstpro;


class A
{
	static
	{
		System.out.println("inside A static block");
	}
}
class B
{
	static
	{
		System.out.println("inside B static block");
	}
}
public class Demo2
{
	private A ref1=new A();    // lazy resolution
	private static B ref2=new B(); // eager resolution
	public static void main(String[] args)
	{
		new Demo2();  // class A will be loaded now
		System.out.println("in main");
		new Demo2(); // class A will not be loaded again as
					// classes are loaded only once in Java

	}

}



// Array .............

Then Java creates 3 separate row arrays:

arr[0] → [  ][  ][  ]
arr[1] → [  ][  ][  ]
arr[2] → [  ][  ][  ]

So:

             arr
              ↓
        [ reference ][ reference ][ reference ]
              ↓           ↓           ↓
           [ ][ ][ ]   [ ][ ][ ]   [ ][ ][ ]
             row 0       row 1       row 2

Therefore:

1 main array + 3 row arrays = 4 arrays

And each array has its own .length:

arr.length       // length of main array = 3

arr[0].length    // length of row 0 = 3
arr[1].length    // length of row 1 = 3
arr[2].length    // length of row 2 = 3

So you can access 4 .length values.

But remember
If your question is "How many .length do I need to use to traverse a 3×3 matrix?", you normally use only 2:

arr.length
arr[i].length

For example:

for (int i = 0; i < arr.length; i++) {
    for (int j = 0; j < arr[i].length; j++) {
        System.out.println(arr[i][j]);
    }
}

So 4 arrays are created, but only 2 .length expressions are needed for looping.


// jagged array....





final int[]arr = {10,20,30};
arr[0] = 11; // possible

arr = new int[6];  // not possible becoz of final....




// array of instance  ....
array of object....



// package......

package -> import -> class


// jar info....

// document of java...


 */
























import java.util.Scanner;

public class main {
    /*
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter int");
        int n = sc.nextInt();

        System.out.println("Enter double");
        double d = sc.nextDouble();

        System.out.println("Enter 1st String");
        String s = sc.nextLine();

        // to solve this problem we will use another sc.nextLine();
        sc.nextLine();

        System.out.println("Enter another string");
        String s1 = sc.nextLine();
    }

     */
    static void main() {

    }
}
