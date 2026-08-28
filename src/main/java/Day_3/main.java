package Day_3;




/*
// default value of each data types :

Data Type	Default Value
byte         	0
short	        0
int          	0
long         	0L
float       	0.0f
double      	0.0
char	        '\u0000'
boolean	         false
Reference types (String, objects, arrays)	null

// for long we write L at end of the value

and for float f






// constructor :

constructor is special member function

- it is used to initialize instance member
- it has got same name of class
- it does not have return type

default constructor -
if no constructor is defined then compiler provide default constructor
Student s1 = new Student();

parameteried constructor -
Student s1 = new Student(20);



what happens when object is created -:

1) memory is allocated to all instance member
2) constructor is called




// method and constructor overloading (compile time polymorphism)







// named and anonymous object

Student s1 = new Student(); // named

new Student();   // this will be created but no reference to it so it will marked for garbage collection










{// Application of Default constructor....}

1. Example using Default Constructor
class Student {
    private int rollNo;
    private String name;

    // Default constructor
    Student() {
        rollNo = 0;
        name = "Unknown";
    }

    // Setter methods
    void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    void setName(String name) {
        this.name = name;
    }

    // Getter methods
    int getRollNo() {
        return rollNo;
    }

    String getName() {
        return name;
    }

    public static void main(String[] args) {

        Student s1 = new Student();

        // Setting values using setters
        s1.setRollNo(101);
        s1.setName("Rahul");

        // Getting values using getters
        System.out.println("Roll No: " + s1.getRollNo());
        System.out.println("Name: " + s1.getName());
    }
}

Output
Roll No: 101
Name: Rahul


2. Example using Parameterized Constructor
A parameterized constructor accepts values while creating the object.

class Student {
    private int rollNo;
    private String name;

    // Parameterized constructor
    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    // Setter methods
    void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    void setName(String name) {
        this.name = name;
    }

    // Getter methods
    int getRollNo() {
        return rollNo;
    }

    String getName() {
        return name;
    }

    public static void main(String[] args) {

        // Passing values to parameterized constructor
        Student s1 = new Student(101, "Rahul");

        // Getting values using getters
        System.out.println("Roll No: " + s1.getRollNo());
        System.out.println("Name: " + s1.getName());

        // Changing values using setters
        s1.setRollNo(102);
        s1.setName("Amit");

        System.out.println("After changing values:");
        System.out.println("Roll No: " + s1.getRollNo());
        System.out.println("Name: " + s1.getName());
    }
}

Output
Roll No: 101
Name: Rahul

After changing values:
Roll No: 102
Name: Amit

Difference
Default Constructor	           Parameterized Constructor
Student()	                   Student(int rollNo, String name)
Takes no arguments	           Takes arguments
new Student()	               new Student(101, "Rahul")
Values can initially be set
inside constructor or through
 setters	                     Values are passed during object creation
Getters/setters can still be
used	                         Getters/setters can still be used






// if you provide any constructor compiler doesnt provide default constructoor

eg if you provide parameteried constructor then you you dont provide parameter
then it will throw an error




// destructor : -
      use to release the resources (file , database , connection , socket )

      Java doesnt have destructor java had Finalize till java.8

      finalize method is called just before object gets garbage collected

      its not reliable becoz it gets called just before object gets garbage collected
      . but when exactly object gets garbage collected is not guarentted
      across various implementation

      hence in java we mainly rely on finally block to release resources



What is a Destructor?
A destructor is used to clean up resources when an object is no longer needed.

For example, your program may use:

A file
A database connection
A network connection/socket
After you're finished using them, they should be closed/released.

Think of it like:

Constructor → Get resources
Destructor → Release resources

Does Java have a Destructor?
No. Java does not have a destructor like C++.

Java has Garbage Collection, which automatically removes objects that are no longer needed.

For example:

Student s = new Student();

s = null;

Now the Student object has no reference pointing to it.

Java's Garbage Collector (GC) can eventually remove that object.

What was finalize()?
Java previously had a method called:

finalize()

It was intended to be called before an object was garbage collected.

Think:

Object is no longer needed
          ↓
Garbage Collector
          ↓
finalize()
          ↓
Object removed

But there was a problem.

The problem
We don't know exactly when Garbage Collection will happen.

For example:

Student s = new Student();
s = null;

You might think:

"Okay, s is null, so the object will be deleted now."

❌ Not necessarily.

Java's Garbage Collector decides when to clean it up.

It could be:

After 1 second
After 10 seconds
After 1 minute
Or even later

So finalize() was not reliable for releasing important resources.

Then what do we use?
For resources like files and database connections, Java generally uses finally or, even better, try-with-resources.

For example:

try {
    // use file
}
finally {
    // close file
}

The idea is:

Use resource
     ↓
Do your work
     ↓
finally
     ↓
Close/release resource

finally is designed to run when control leaves the try/catch flow, making it much more predictable for cleanup.

Easy example
Imagine you borrow a book from a library.

Constructor:

"I got the book."

Using the object:

"I'm reading the book."

Cleanup:

"I'm returning the book."

You shouldn't say:

"I'll return it whenever the garbage collector feels like it." 😄

You should explicitly return it when you're done.

Remember this
Constructor
    ↓
Creates/initializes object

Object is used
    ↓
Do your work

finally / try-with-resources
    ↓
Release resources

And one correction to your notes: finalize() was deprecated in Java 9 and removed from modern Java use; Java 8 was not the last Java version to have it.

example - :
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        FileReader file = null;

        try {
            file = new FileReader("test.txt");

            System.out.println("File opened");

            // Use the file
            int data = file.read();
            System.out.println(data);

        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());

        }
        finally {

            // Release the resource
            try {
                if (file != null) {
                    file.close();
                    System.out.println("File closed");
                }
            }
            catch (IOException e) {
                System.out.println("Error while closing file");
            }
        }
    }
}

What is happening?
Think of the FileReader as a connection to the file.

First:

file = new FileReader("test.txt");

means:

"Open this file so I can use it."

Then we use it:

file.read();

When we're finished, we need to close the file.

That's what this does:

file.close();

And we put that inside finally:

finally {
    file.close();
}

So the flow is:

Open file
   ↓
Use file
   ↓
Something happens
   ↓
finally
   ↓
file.close()
   ↓
Resource released

Why not just write file.close() at the end?
Suppose this happens:

try {
    file = new FileReader("test.txt");
    int data = file.read();
    // ERROR happens here
}

If you put:
file.close();

after the try-catch, the error might prevent your normal code from reaching it.
But finally is specifically for cleanup:

finally {
    file.close();
}

So even if an exception occurs, Java executes the cleanup code.

In very simple words
finally {
    file.close();
}

means:

"Whatever happens while using this file, when we're leaving this operation, close the file."

The same idea can be used for things like database connections:

finally {
    connection.close();
}

or sockets:

finally {
    socket.close();
}

So finally doesn't magically release the resource. You tell it what cleanup operation to perform,
 such as file.close(), connection.close(), or socket.close().


If you're learning Java basics/OOP right now, don't spend much time on finalize().

What you should know
Just remember this:

finalize() was an old Java mechanism intended to run before garbage collection,
 but it was unreliable and is deprecated/obsolete in modern Java.

"What is finalize()?"


********************
You can answer:

"finalize() was a method associated with garbage collection that could be called
before an object was garbage collected. It was unreliable because the exact time
of garbage collection was not guaranteed, and it is deprecated in modern Java."

*********************







      static member :-

       class variable

       - : static member gets allocated memory as soon as class gets loaded
       they can access by class name



       // sir che codes myClass




       //static and non static  (learn properly)

       can static member function  access  non static data ?
       no

       can non ststic member function  access static data ?
       yes










   *** -----    // what is class "Class" in java ?   ***----------

       Sample.java

       javac Sample.java

       Sample.class

       java Sample



       what happens when you say "java Sample"

       1) Sample class gets loaded in the memory
       2) JVM invokes "main" function




// you can have multiple classes but only one public class and that name should be use to ceate java file



// reflection Api (side concept)



// static block or static initializer
- static block is used to access static variable
- static block gets invkoed as soon as class gets loaded
- u can can define more than one static block inside class



static block  vs static member function  (ChatGPT)....
-static block will called in a order in which they defined
-static block


this

ChatGPT said:
Sure 👍 Let's understand static block in very simple words.

What is a Static Block?
A static block is a block of code written using the static keyword:

static {
    // code
}

It is used for initialization, especially when you want to initialize static variables.

1. When does a static block run?
The important point is:

A static block runs automatically when the class is loaded.

You don't call it yourself.

Example:

class Demo {

    static {
        System.out.println("Static block executed");
    }
}

When Java loads Demo, this runs automatically.

You don't write:

Demo.static();

There is nothing to call.

2. Example with main()
class Demo {

    static {
        System.out.println("Static block");
    }

    public static void main(String[] args) {
        System.out.println("Main method");
    }
}

Output:

Static block
Main method

Why?

Java loads the class first:

Class loaded
     ↓
Static block runs
     ↓
main() runs

3. Multiple static blocks
Yes, you can have more than one static block.

class Demo {

    static {
        System.out.println("First");
    }

    static {
        System.out.println("Second");
    }

    static {
        System.out.println("Third");
    }

    public static void main(String[] args) {
        System.out.println("Main");
    }
}

Output:

First
Second
Third
Main

Why?
Static blocks execute in the order in which they are written.

First static block
        ↓
Second static block
        ↓
Third static block
        ↓
main()

Static Block vs Static Method
This is the important part.

Static block
static {
    System.out.println("Hello");
}

You don't call it.

It runs automatically when the class is loaded.

Static method
static void show() {
    System.out.println("Hello");
}

You have to call it:

Demo.show();

Easy comparison
Static Block	Static Method
Runs automatically	You call it
Runs when class is loaded	Runs when you call it
Mainly used for initialization	Used to perform an operation
Can have multiple blocks	Can have multiple methods
Executes in written order	Executes when called

Think of it like this 🧠
Static block:

"When the class enters the room, do this immediately."

Static method:

"When someone asks you to do this, then do it."

So:

static {
    System.out.println("I run automatically");
}

vs.

static void show() {
    System.out.println("I run when called");
}

And one correction to your note:

❌ "Static block is used to access static variable"

More accurately:

✅ A static block is mainly used to initialize static variables or perform one-time class initialization.



You said:

what is use of static and non static block

ChatGPT said:
Very simple way to understand it:

1. Static block
static {
    System.out.println("Static block");
}

Use:
A static block is used for work that should happen once when the class is loaded.

For example, initializing a static variable:

class Student {

    static int count;

    static {
        count = 100;
        System.out.println("Static initialization");
    }
}

The static block runs automatically, before the class is used.

Think:

Static block = one-time setup for the class

2. Non-static block (Instance block)
A non-static block looks like:

{
    System.out.println("Non-static block");
}

Use:
It is used for initialization that should happen every time an object is created.

Example:

class Student {

    {
        System.out.println("Non-static block");
    }

    Student() {
        System.out.println("Constructor");
    }
}

Now:

Student s1 = new Student();
Student s2 = new Student();

Output:

Non-static block
Constructor

Non-static block
Constructor

The non-static block runs for every object.

Think:

Non-static block = setup for each object

Static vs Non-static block
Static block	Non-static block
Uses static	No static
Runs when class is loaded	Runs when object is created
Runs once	Runs every time an object is created
Used for class/static initialization	Used for object/instance initialization
Runs before objects are created	Runs before constructor

Easy example
class Car {

    static {
        System.out.println("Static block");
    }

    {
        System.out.println("Non-static block");
    }

    Car() {
        System.out.println("Constructor");
    }
}

If you do:

Car c1 = new Car();
Car c2 = new Car();

You get:

Static block

Non-static block
Constructor

Non-static block
Constructor

Notice:

Static block       → 1 time
Non-static block   → 2 times
Constructor        → 2 times

🧠 Remember
STATIC BLOCK
     ↓
Class-level setup
     ↓
Runs once


NON-STATIC BLOCK
     ↓
Object-level setup
     ↓
Runs for every object

And the order for creating an object is generally:

Static block
     ↓
Non-static block
     ↓
Constructor

The static block happens when the class is initialized, while the non-static block runs as part of creating each instance.











// System.out.println();   --> explanation...  System -> jar -> java api -> jre

class System {
public static Printstrem out;   // Printstrem  is like int , char
}

class PrintStream{
public void print(){}
public void println() {}
}

out is member of system of type Printstream  (use ChatGPT ) right to left

Yes 👍 Your statement is correct:

out is a member of System of type PrintStream.

The trick is to read this from right to left.

Let's look at this
public static PrintStream out;


Read it right to left:

out
 ↓
PrintStream

1. out

This is the name of the member/variable.

out


Think:

"There is something called out."

2. PrintStream

Now look to its left:

PrintStream out


This tells us the type of out.

So:

"out is of type PrintStream."

Just like:

int age;


means:

"age is of type int."

Similarly:

PrintStream out;


means:

"out is of type PrintStream."

3. static

Now:

static PrintStream out;


means:

"out belongs to the System class, not to individual System objects."

That's why we can write:

System.out


instead of:

someSystemObject.out

4. public
public static PrintStream out;


public means it can be accessed from outside the class.

So the complete meaning
class System {
    public static PrintStream out;
}


means:

The System class has a public static member called out, and the type of out is PrintStream.

Or even simpler:

System
  │
  └── out → PrintStream


And PrintStream has:

class PrintStream {
    public void print() {}
    public void println() {}
}


Therefore:

System.out.println("Hello");


means:

System
  ↓
get "out"
  ↓
out is a PrintStream
  ↓
use PrintStream's println()
  ↓
"Hello"

⭐ Remember this rule

When you see:

PrintStream out;


read it right to left:

out is a PrintStream.

When you see:

static PrintStream out;


out is a static PrintStream.

When it's inside:

class System {
    public static PrintStream out;
}


out is a member of System, and its type is PrintStream.

That's exactly what your note means.
 */
public class main {
    /*
    static void main() {

        // define class and create n number of objects (with/without parameter) and at the end display how many objects
        // have been created
        Sample s1 = new Sample();
        Sample s2 = new Sample(45);
        Sample s3 = new Sample();
        Sample s4 = new Sample(78);
        System.out.println(Sample.getCounter());
    }
}

class Sample {
    private static  int counter = 0;

    Sample(){
        counter++;
    }

    Sample(int n){
        counter++;
    }

    public static int getCounter(){
        return counter;
    }

     */


    // if we forgot to write couter++ in constructor then
    // then it will give wrong counnter



    // garbage collection :-


    // static method calling another static method (we did all code in this format)

    static void main() {
        Sample s1 = new Sample();
        Sample s2 = new Sample(45);
        Sample s3 = new Sample();
        Sample s4 = new Sample(78);
        System.out.println(Sample.getCounter());
    }
}

class Sample {
    private static int counter = 0;

    {
       counter++;   // non static block
    }
    // non static block will execute when we create object

    Sample() {

    }

    Sample(int n) {

    }

    public static int getCounter() {
        return counter;
    }
}

