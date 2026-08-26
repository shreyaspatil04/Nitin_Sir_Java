package Day_1;


// Notes...

/*

// Founder of java.. -->  James Gosling Canadian developer --> Working at sun Microsystem

source code  -> compiler  --> .class   --> JRE (contains [JVM/API])  --> Windows / mac (Application)
 *-> JRE converts platform understandable language for MAC its diff and for Windows its diffrent

          Java Source Code
              (.java)
                 │
                 ▼
          ┌──────────────┐
          │   Compiler   │
          │   javac      │
          └──────────────┘
                 │
                 ▼
          Bytecode (.class)
          Platform Independent
                 │
                 ▼
        ┌───────────────────┐
        │       JRE         │
        │ ┌───────────────┐ │
        │ │      JVM      │ │
        │ │   + Java API  │ │
        │ └───────────────┘ │
        └───────────────────┘
                 │
        ┌────────┴─────────┐
        ▼                  ▼
   Windows JVM          Mac JVM
        │                  │
        ▼                  ▼
 Windows Machine       Mac Machine
        │                  │
        ▼                  ▼
    Application         Application

** - The JVM executes the same Java bytecode on different operating systems. --*

diff - JDK JRE JVM
✅ JDK contains the Java compiler and runtime components
✅ JRE conceptually contains the JVM + Java APIs/libraries
✅ JVM executes Java bytecode on the target OS

// * Api  -->
  contains jar files (java archive) -> it consist java compiled code  and dll(it consist c/c++ compiled code) files


 in jar -->
 developer developed lots of classes and method
 that inbuild and compiled code is in jar file


 * why c/c++ called in here

Because the JVM itself and some Java libraries need to interact with the operating system,
and parts of Java are implemented using native code, traditionally C/C++.






* Standalone applicaion ?
where program starts from main function
Yes. In Java, a standalone application generally means a program
that runs directly on a computer without needing a web browser or web server.

Where does it start?
For a traditional Java standalone application, execution starts from the:

public static void main(String[] args)

method.

The flow is:

        Java Source Code
              │
              ▼
        Compiler (javac)
              │
              ▼
          .class file
          (Bytecode)
              │
              ▼
             JVM
              │
              ▼
     main() method is called
              │
              ▼
       Java Application


 *like for html css website we have to use port 8000 to run here we dont have to do this
 Exactly 👍 — for a normal Java standalone application, you don't need a port like 8000.

The difference is application type.

HTML/CSS website

If you have:

HTML + CSS
     ↓
Web Server
     ↓
localhost:8000
     ↓
Browser


A port is needed because your browser communicates with a web server over a network connection.

For example:

Browser
   │
   │ HTTP request
   ▼
localhost:8000
   │
   ▼
Web Server
   │
   ▼
HTML/CSS

Java standalone application

A normal Java program works differently:

Java Code
   ↓
Compiler
   ↓
.class
   ↓
JVM
   ↓
main()
   ↓
Application runs

There is no web server and no network communication, so no port is required.

For example:
class Test {
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}


Run it:
javac Test.java
java Test


Output:
Hello


No localhost:8000, no browser, and no port.

But Java CAN use ports

If you create a Java web application/server, then ports come into the picture:

Java Standalone App
       │
       └── No port required


Java Web Application
       │
       ▼
   Web Server
       │
       ▼
 localhost:8080
       │
       ▼
    Browser


For example, frameworks such as Spring Boot commonly run a web application on a port like 8080.

So the easy rule is:

Standalone Java program → main() → no port required
Java web application → server → port required




Data type -

     Primitive                         Reference Type
   - byte - 1 byte (8 bits)            -Classes and interfaces
   - short - 2 byte (16 bits)          -Arrays
   - int   - 4 byte (32 bits)          -eString
   - long  - 8 byte (64 bits)
   - float - 4 byte  (32 bits)
   - double - 8 byte  (64 bits)
   - char   - 2 byte (16 bits)(in other lang its 1 but here 2)becoz of unicode character set

   -- reason for 2byte
   internationalization (i18n) - means designing software in a way that it can easily adapted
   to diffrent languages and region

   ** make sure to use (i18n) in your project


// revise conditional logial bitwise operator on your own..
// ternary operator

// number system - binary - octal - decimal - hexadecimal (conversion)

// MSB and LSB (most significant bit and least significant bit)

// binary of negative (shortcut trick direct  2's compliment)
when the 1st 1 occurs then flip all number in the left

// decimal of binary..
 (something is missing )


// shifting (all three types ) and try 1 - 2 shifts


 */
public class main {
    static void main() {

        if((4 & 1) == 0){
            System.out.println("Even");
        }else {
            System.out.println("false");
        }
    }

}
//
