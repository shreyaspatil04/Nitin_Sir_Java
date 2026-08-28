package Day_3;




/*
// default value of each data types :









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




      static member :-

       class variable

       - : static member gets allocated memory as soon as class gets loaded
       they can access by class name



       // sir che codes myClass




       //static and non static  (learn properly)

       can static member sunction non static data ?
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




// System.out.println();   --> explanation...  System -> jar -> java api -> jre

class System {
public static Printstrem out;   // Printstrem  is like int , char
}

class PrintStream{
public void print(){}
public void println() {}
}

out is member of system of type Printstream  (use ChatGPT ) right to left
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

