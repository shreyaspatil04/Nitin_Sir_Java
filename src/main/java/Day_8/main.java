package Day_8;

/*

when two objects are equals u must produce same hashcode.......


-------------------------------------------------------------------------------------------------------------------------

Day-5 Folder............ string



using interface reference you can call all the object method


interface A{

}

class sub implements A{

}

 A ref  = new sub();
 ref.toString();
 ref.hashcode();






 --------------------------------------------------------------------------------------------------------------------------
 String -:

 String is a class in java

 String class is immutable

 immutable means once object is created it cant be modified

 that means any operation performed on object of string it will create a new object.....


 how to create immutable class :-
 // dont provide setter  method in immutable class...
 // and return new object dont modify original object.....





class Immutable
{
	private int num;

	public Immutable(int num)
	{
		this.num=num;
	}
	int getNum()
	{
		return num;
	}
	public String toString()
	{
		return "["+num+"]";
	}
	public Immutable add(int k)
	{
		return new Immutable(num+k);
	}
}
public class ImmutableDemo
{
	public static void main(String args[])
	{
		Immutable i1=new Immutable(10);
		System.out.println(i1);
		Immutable i2=i1.add(20);
		System.out.println(i1);
		System.out.println(i2);
	}
}
	explanation :-
	Sure. Let's focus only on this line:

i1.add(20);

Step 1: What is i1?
Earlier you created:

Immutable i1 = new Immutable(10);

So i1 is a reference pointing to an Immutable object:

i1
 ↓
┌─────────────┐
│ num = 10    │
└─────────────┘

Step 2: What does i1.add(20) mean?
The general syntax:

object.method(argument);

So:

i1.add(20);

means:

Call the add() method on the object referred to by i1, and pass 20 as the argument.

Your method is:

public Immutable add(int k)
{
    return new Immutable(num + k);
}

Therefore:

i1.add(20)

i1 → object whose num = 10

20 → passed to k

So inside the method:

num = 10
k   = 20

Then:

return new Immutable(num + k);

becomes:

return new Immutable(10 + 20);

which means:

return new Immutable(30);

A new object is created:

Old object                    New object

i1                            returned object
 ↓                                  ↓
┌─────────────┐                ┌─────────────┐
│ num = 10    │                │ num = 30    │
└─────────────┘                └─────────────┘

Step 3: What happens to the returned object?
This depends on how you call it.

Case 1
i1.add(20);

The new object is created and returned, but you don't store the returned reference anywhere.

So effectively:

i1 → [10]

       add(20)
          ↓
      creates [30]
          ↓
      returned
          ↓
    not stored anywhere

The original i1 is still:

i1 → [10]

Case 2
Your original program does:

Immutable i2 = i1.add(20);

Now the returned object is stored in i2:

i1                  i2
 ↓                   ↓
[10]                [30]

So:

i1.add(20);

does NOT mean "change i1 to 30".

It means:

"Ask the i1 object to create a new object whose value is i1.num + 20, and return that new object."

That's why this class is immutable.



------------------------------------------------------------------------------------------------------------------------

day 5 - string folder - string demo -.....

demo1 -

public class StringDemo1
{
	public static void main(String args[])
	{
		String str1=new String("hello");

		System.out.println(str1);  // toString() of String //String class uses toSting methos to print the String
	}
}



String pool - Heap memory
                    |-------------------------------------------
STACK               |  HEAP                    STRING POOL     |
                    |                                          |
 str                |                                          |
  │                 |                                          |
  └──────────────→  | String "Hello"      +      "Hello"       |
                    |(new object)                (literal)     |
                    |--------------------------------------------



demo 3 -

public class StringDemo3
{
	public static void main(String args[])
	{
		String s1=new String("hello");
		String s2="hello";                 /// here hello will directly refer to the string pool

		System.out.println(s1);
		System.out.println(s2);

		if(s1.equals(s2))
		{
			System.out.println("s1 and s2 are equals");
		}
		else
		{
			System.out.println("s1 and s2 are not equals");
		}

		if(s1==s2)
		{
			System.out.println("s1 and s2 are ==");
		}
		else
		{
			System.out.println("s1 and s2 are not ==");
		}
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
	}
}

we are direct referring to string pool
s1 = new String("hello")
        ↓
   Heap object

s2 = "hello"
        ↓
   String Pool object

Therefore:

s1.equals(s2)  → true
s1 == s2       → false
s1.hashCode()  → same
s2.hashCode()  → same




demo 4 -

public class StringDemo4
{
	public static void main(String args[])
	{
		String s1=new String("hello");
		String s2="hello";
		String s3="hello";

		System.out.println(s1);
		System.out.println(s2);

		System.out.println(s3);

		if(s2.equals(s3))
		{
			System.out.println("s2 and s3 are equals");
		}
		else
		{
			System.out.println("s2 and s3 are not equals");
		}

		if(s2==s3)
		{
			System.out.println("s2 and s3 are ==");
		}
		else
		{
			System.out.println("s2 and s3 are not ==");
		}
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
	}
}


                    HEAP
              ┌──────────────┐
s1 ─────────→ │   "hello"    │
              │  new String  │
              └──────────────┘


                 STRING POOL
              ┌──────────────┐
s2 ─────────→ │   "hello"    │
              └───────▲──────┘
                      │
s3 ───────────────────┘








demo 6-


public class StringDemo6
{
    public static void main(String args[])
    {
        String s1="hello";
        String s2=new String("hello");


        if(s1==s2)
        {
            System.out.println("s1 and s2 are ==");
        }
        else
        {
            System.out.println("s1 and s2 are not ==");
        }

    }
}

So:

STACK

s1 ─────────→ STRING POOL "hello"

s2 ─────────→ HEAP "hello"

They are two different objects.

Therefore:

s1 == s2

is:

false

Hence:

s1 and s2 are not ==





demo 7 - >   intern


public class StringDemo7_a
{
	public static void main(String args[])
	{
		String s1="hello";
		String s2=new String("hello");


		if(s1==s2.intern())
		{
			System.out.println("s1 and s2 are ==");
		}
		else
		{
			System.out.println("s1 and s2 are not ==");
		}

	}
}

Yes — this will print:

s1 and s2 are ==

The important part is:

s1 == s2.intern()

Let's see exactly what happens.

Step 1: s1
String s1 = "hello";

Because "hello" is a literal, it is in the String Pool.

STACK                  HEAP / STRING POOL

s1 ─────────────────→  "hello"
                         ↑
                    String Pool



What is intern()?
intern() is a method of the String class.

Its job is very simple:
------------------------------------------------------------------------------------
*****_____intern() gives you the String object address from the String Pool that has the same content.____******
-----------------------------------------------------------------------------------------------
Example
String s1 = "hello";
String s2 = new String("hello");

Here:

s1 ─────────→ "hello"  ← String Pool

s2 ─────────→ "hello"  ← separate heap object

So:

System.out.println(s1 == s2);

Output:

false

because they are different objects.

Now use intern()
System.out.println(s1 == s2.intern());

intern() searches for "hello" in the String Pool.

Since "hello" is already there:

s2.intern()
     ↓
returns
     ↓
"hello" in String Pool
So the comparison becomes:

s1 ─────────────→ "hello" ←──────────── s2.intern()
                   Pool

Both refer to the same object.
Therefore:
true

Very simple definition for viva
intern() returns the canonical String from the String Pool.

Or even simpler:

intern() gives me the pooled version of a String.

One important point
intern() does not change s2 automatically.

s2.intern();

Only returns the pooled reference.

If you want s2 itself to point to the pool:

s2 = s2.intern();

Then:

s1 ────────→ "hello" ←────── s2
             Pool

and:

s1 == s2

will be true.
/*


demo 8 - :

 */

/* When the intern method is invoked, if the pool already contains a string equal to this String object
 as determined by the equals(Object) method, then the string from the pool is returned




public class StringDemo8_intern
{
    public static void main(String args[])
    {
        // Example 1

        String s1="hello";
        String s2=s1.intern();     // this is same as s1 = s2 ;
        System.out.println(s1==s2);

        // Example 2

        String s3=new String("world");
        String s4=s3.intern();

    }
}

if not in pool then it add it into pool returns the address in pool............................







demo 9 -




/* When the intern method is invoked, if the pool already contains a string equal to this String object as determined by the equals(Object) method, then the string from the pool is returned.
Otherwise, this String object is added to the pool and a reference to this String object is returned.



public class StringDemo9_intern
{
    public static void main(String args[])
    {
        String s1="hello";
        String s2="world";
        String s3=s1.concat(s2); // what will happen here?
        System.out.println(s3);
        s3.intern(); // what will happen here?

        char[] c = {'J', 'A', 'V', 'A'};

        String s6 = new String(c);
        s6.intern(); // what will happen here?


    }
}


Let's go step by step. The important thing is to understand concat() first, then intern().

String s1 = "hello";
String s2 = "world";
String s3 = s1.concat(s2);

1. s1 and s2
Both are literals, so they are in the String Pool:

                 STACK

s1 ──────────────────────┐
                         ▼
                   STRING POOL
                   ┌───────────┐
                   │ "hello"   │
                   └───────────┘

s2 ──────────────────────┐
                         ▼
                   ┌───────────┐
                   │ "world"   │
                   └───────────┘

2. What happens with concat()?
String s3 = s1.concat(s2);

This means:

"hello" + "world"

gives:

"helloworld"

Since concat() creates a new String for the result, s3 refers to a new String object.

Conceptually:

STACK

s1 ─────────→ Pool "hello"

s2 ─────────→ Pool "world"

s3 ─────────→ HEAP "helloworld"

So:

System.out.println(s3);

Output:

helloworld

3. Now s3.intern()
s3.intern();

What does intern() do?

It checks the String Pool for:

"helloworld"

If "helloworld" is NOT already in the pool
Java puts/associates the canonical String for "helloworld" in the pool and returns that pooled reference.

But you wrote:

s3.intern();

You ignored the returned reference.

So s3 still points to its original object.

s3 ─────────→ HEAP "helloworld"

              STRING POOL
                  │
                  ▼
             "helloworld"

Important:

s3.intern();

does not change s3.

If you wrote:

s3 = s3.intern();

then s3 would refer to the canonical pooled String.

4. Now the character array
You have:

char[] c = {'J', 'A', 'V', 'A'};

String s6 = new String(c);

This creates a String from the characters:

J A V A

So:

s6 → "JAVA"

The String "JAVA" is not necessarily already in the String Pool just because you created it with new String(c).

The new String(c) creates a String object from the array.

5. s6.intern()
s6.intern();
Again, Java checks the String Pool for:
"JAVA"
If "JAVA" is not already pooled, its canonical form is added to the pool.
But again, you are ignoring the returned reference.
So:

s6 ─────────→ HEAP "JAVA"

              STRING POOL
                  │
                  ▼
                "JAVA"

s6 still points to its original String object.
⭐ The biggest point to remember
These two:
s3.intern();
s6.intern();
do not make s3 or s6 point to the pool.
They only ask for/obtain the canonical pooled reference, and you're throwing that returned reference away.

If you want the variable itself to point to the pool:

s3 = s3.intern();
s6 = s6.intern();

Then:
s3 ─────────→ Pool "helloworld"

s6 ─────────→ Pool "JAVA"

Your program's output
Only this line prints anything:

System.out.println(s3);

So output is:
helloworld








demo 10 - :

public class StringDemo10
{
	public static void main(String args[])
	{
		String s1="hello";

		String s2=s1.concat(" world");

		System.out.println(s1);
		System.out.println(s2);
	}
}

concat () will not add to string pool it will be on heap only....






demo - 13



public class StringDemo13
{
	public static void main(String args[])
	{
		String s1="hello";
		  2000	  2000
		if(s1=="hel"+"lo")  // compiler adds "hel" and "lo" and creates "hello"
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}


	}
}

demo - 14


public class StringDemo14
{
	public static void main(String args[])
	{
		String s1="hello";
		String s2="hel";
		//2000	4000
		if(s1==(s2+"lo"))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}


	}
}



demo 15 -

public class StringDemo15
{
	public static void main(String args[])
	{
		String s1=new String("hello");

		if(s1==("hel"+"lo"))  // compiler will add "hel" and "lo"
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}


	}
}

// false




demo 16 -


public class StringDemo16
{
	public static void main(String args[])
	{
		String s1="hello";
		final String s2="hel";

		if(s1==(s2+"lo"))  // compiler adds "hel" and "lo"
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}


	}
}






demo 17-
public class StringDemo17
{
	public static void main(String args[])
	{
		String str1="hello world";
		System.out.println(str1.charAt(0));

		String str2=str1.concat(" welcome");
		System.out.println("str1 is \t"+str1);
		System.out.println("str2 is \t"+str2);

		int val=str1.compareTo(str2);
		System.out.println("comparison is\t"+val);

		System.out.println(str1.indexOf('e'));

		System.out.println(str1.lastIndexOf('l'));

		System.out.println("Length of str1 is \t"+str1.length());

		String str3=str1.replace('e','i');
		System.out.println(str1);
		System.out.println(str3);

		System.out.println(str1.substring(2));

		String str4="ABCDEFG";
		String str5=str4.toLowerCase();
		System.out.println(str4);
		System.out.println(str5);

		String str6=str1.toUpperCase();
		System.out.println(str1);
		System.out.println(str6);

		String str7="  how are you  ";
		System.out.println(str7);

		String str8=str7.trim();
		System.out.println(str7);
		System.out.println(str8);

	}
}




------------------------------------------------------------------------------------------------------------------------------------------


StringBuilder -:
Day 5 - mutable demo



string builder - it is mutable.....




 mutable demo -:


class Mutable
{
	private int num;

	public Mutable(int num)
	{
		this.num=num;
	}
	public void setNum(int num)
	{
		this.num=num;
	}
	int getNum()
	{
		return num;
	}
	public String toString()
	{
		return "["+num+"]";
	}
	public Mutable add(int k)
	{
		num+=k;
		return this;
	}
}
public class MutableDemo
{
	public static void main(String args[])
	{
		Mutable i1=new Mutable(10);
		System.out.println(i1);
		i1.add(20).add(50).add(100);
		System.out.println(i1);
	}
}





	String builder Demo -


	// StringBuilder class is mutable

	there is no concept of string pool in stringBuilder its only in String

public class StringBuilderDemo
{
	public static void main(String args[])
	{
		StringBuilder sb1=new StringBuilder("hello");
		System.out.println(sb1);
		sb1.append("world");
		System.out.println(sb1);
	}
}
	--> helloworld

----------------------------------------------------------------------------------------------------------------------------------


Enum
enum is userdefined data type

enum is used when you want to deal with predefined valued....

eg. weekdays
   months
   font styles...






   demo 1 -


enum MyFont
{
	PLAIN,BOLD,ITALIC
}


class MyComponent
{
	public 	void setStyle(MyFont font)
	{
		switch(font)
		{
			case PLAIN: System.out.println("plain");
					break;
			case BOLD: System.out.println("bold");
					break;
			case ITALIC: System.out.println("italic");
					break;
		}
	}
}
public class Demo1
{
	public static void main(String args[])
	{
		MyComponent mc=new MyComponent();
		mc.setStyle(MyFont.BOLD);
		mc.setStyle(MyFont.ITALIC);
		mc.setStyle(MyFont.PLAIN);
		// mc.setStyle(1); // will not compile hence there is no {compiler error is better than run time/ unpredictable error}
		// risk of unpredictable result

	}
}




internal working of enum - :


public enum Color
{
    RED, GREEN, BLUE;
}

is internally

public final class Color extends Enum<Color>
{
    public static final Color RED = new Color("RED", 0);
    public static final Color GREEN = new Color("GREEN", 1);
    public static final Color BLUE = new Color("BLUE", 2);

    private Color(String name, int ordinal) {
        super(name, ordinal);
    }

    // Additional methods and fields can be added here
}






---------------------

{.....enum -> more info ....}




enum is internally derived from {..java.lang.Enum ...} which is an abstract class (without any abstract method).
so enum cannot be derived from some other class but it can implement interface/s.

 a class can have enum/s inside it the way we have nested class.

enum cannot be defined inside the method as enum cannot be local.

enum was introduced in Java 5

enum is a special type of datatype which is a collection of constants.

actually enum is just like a class that can have constant, method and a private constructor. ( private constructor is added implicitly by the compiler)

because of private constructor we cannot instantiate enum with "new" keyword.

enum constants are by default "public", "final" and "static"





// learn info on chatgpt and thodasa sir ka internal working..









----------------------------------------------------------------------------------------------------------------------------




Day-5 imp_info _protected


proteced member can be accessed in a diffrent package inside child class "through inheritance"






----------------------------------------------------------------------------------------------------------------------------

***** command line argument...

What is String[] args?
In:

public static void main(String[] args)

String[] args is an array of Strings used to receive command-line arguments when you start a Java program.

Think of it as:

String[] args
     ↓
Array of String values

Simple example
public class Demo {
    public static void main(String[] args) {

        System.out.println(args[0]);
        System.out.println(args[1]);
    }
}

If you run:

java Demo hello world

Then:

args[0] → "hello"
args[1] → "world"

Output:

hello
world

Diagram
                args
                 ↓
        ┌───────────────────┐
        │ 0 │ 1             │
        ├───┼───────────────┤
        │hello│ world       │
        └───┴───────────────┘

Why is it String[]?
Because command-line arguments are received as Strings.

For example:

java Demo 100 200

Java receives:

args[0] → "100"
args[1] → "200"

They are not integers.

If you want integers:

int a = Integer.parseInt(args[0]);
int b = Integer.parseInt(args[1]);

System.out.println(a + b);

Running:
java Demo 100 200
Output:
300

Is args compulsory?
The name args is not compulsory.

You can write:
public static void main(String[] x)

or:
public static void main(String[] values)

They work the same way.

What matters is:
String[]

and the main method's required signature.


{...........


Viva answer
String[] args is an array of String objects used to receive command-line arguments passed to the Java program.
         .....}


For example:

java Demo A B C

args[0] = "A"
args[1] = "B"
args[2] = "C"



You said:

but whats the use

ChatGPT said:
The use of String[] args is to allow the person running the program to give input to the program from outside, without changing the Java code.

Example
public class Demo {
    public static void main(String[] args) {

        System.out.println("Hello " + args[0]);
    }
}

Run it like:

java Demo Rahul

Output:

Hello Rahul

Here:

Rahul
  ↓
args[0]
  ↓
program uses it

So the flow is:

User
  ↓
java Demo Rahul
  ↓
String[] args
  ↓
args[0] = "Rahul"
  ↓
Program uses "Rahul"

Why is this useful?
Imagine you have:

int a = 10;
int b = 20;

Every time you want different numbers, you have to change the source code.

With command-line arguments:

public static void main(String[] args) {

    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);

    System.out.println(a + b);
}

You can run:

java Demo 10 20

Output:

30

Then without changing the code:

java Demo 100 200

Output:

300

In one sentence
String[] args allows us to pass values to a Java program from outside when starting the program.
And one important point: you don't have to use args. If your program doesn't need command-line input, you can simply leave the array unused.

if i dont pass values will args be null

ChatGPT said:
No. args will normally NOT be null when you start the program normally.

If you don't pass any values:

public static void main(String[] args) {

    System.out.println(args);
    System.out.println(args.length);
}

You will get something like:

[]
0

Conceptually:

args
 ↓
┌─────────────┐
│ empty array │
└─────────────┘
length = 0

So:

args == null

is normally:

false

and:

args.length

is:

0

Important difference
No arguments
     ↓
args = empty String array
     ↓
length = 0
     ↓
NOT null

But if you manually call the method like:

main(null);

then args can be null, because you explicitly passed null.

Viva answer
If no command-line arguments are provided, the JVM normally passes an empty String array, not null. Therefore args.length is 0.



----------------------------------------------------------------------------------------------------------------------------

main function signature -


    Public static void main(String[] args) explain this...

-> main function's signature is:

	public static void main(String args[])
		or
	public static void main(String ...args)


	public - JVM should be able to access it from outside the class.

	static - JVM should be able to invoke it without the object of a class in which main function is defined.

	void - main function is not supposed to return anything to the JVM

	String args[] - main function should be ready to accept command line arguments
			command line arguments are those which we pass at the time of executing the program. These are the arguments which are passed to the main function.




---------------------------------------------------------------------------------------------------------------------------

Wrapper classes -:



why introduced

While designing the langauage , Java founders realized that:

public class Demo
{
	static void show(Object ref)
	{
		S.o.p(ref);
	}
	main()
	{
		show(new String("hello")); // possible
		show(new ArrayList());  // possible
		show(new LinkedList()); // possible
			int num=10;
		show(num); // was not possible

	}
}

Solution: Wrapper classes were introduced


above program can be written as:


public class Demo
{
	static void show(Object ref)
	{
		S.o.p(ref);
	}
	main()
	{
		show(new String("hello")); // alld
		show(new ArrayList());  // alld
		show(new LinkedList()); // alld
			int num=10;
		// show(num); // was not possible

		Integer ob=new Integer(num);

		show(ob); // this is possible


	}
}



// autoboxing and unboxing ........................................



 */








/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------
 */

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------
 */







/*
public class main {
    static void main() {
        Choose_Color s1 = new Choose_Color();
        s1.Get_colors(Colours.White);
        s1.Get_colors(Colours.Black);
        s1.Get_colors(Colours.Red);
        s1.Get_colors(Colours.Purple);
    }
}

enum Colours {
    Red,White,Purple,Black
}

class Choose_Color{

    public void Get_colors(Colours colors){

        switch (colors){
            case Red -> System.out.println("Your color is red...");
            case White -> System.out.println("Your color is White..");
            case Purple-> System.out.println("Your color is Purple..");
            case Black -> System.out.println("Your color is Black..");

        }
    }
}



 */



public class main {
    static void main() {
        Show s1 = new Show();
        s1.zoo(new Dog());
        s1.zoo(new Cat());
        s1.zoo(new Tiger());
    }
}

class Show{
    private Animal ref;
    void zoo(Animal ref){
        this.ref = ref;
        this.ref.run();

        if(ref instanceof Tiger){
            Tiger t = (Tiger)ref;
            t.hunt();
        }
    }
}

class Animal {
    void run(){
        System.out.println("Animal is running...");
    }
}

class Dog extends Animal{
    void run(){
        System.out.println("Dog is running");
    }
}

class Cat extends Animal{
    void run(){
        System.out.println("cat is running");
    }
}

class Tiger extends Animal{
    void run(){
        System.out.println("Tiger is runnung");
    }
    void hunt(){
        System.out.println("tiger is hunting");
    }
}

