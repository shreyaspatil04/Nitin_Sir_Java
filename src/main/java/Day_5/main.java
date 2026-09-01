package Day_5;

/*
//  Reusability - Inheritence (is a relationship )  &  composition -   (has a relationship)

-- > A child class can reuse the features of its parent class.



  java allows only three types   (there are 5 types )
  // Java does NOT support multiple inheritance using classes.
 // Hybrid inheritance is also not directly supported with classes.

  1) single level   A -> B

  2) multilevel      A -> B -> C

  3) hirerarchical      A
                        |
                      -    -
                      |     |
                      B      C


                      every class is derived from Object...so by default every class has single level inheritance




   // accessibility modifiers

-// 1) public
// 2) protected
// 3) default    (when you dont provide any modifiers) it uses default
// 4) private


only applicabe to class members (instance member)
local member destroyed after execution of function


private - only in class not outside class

default - accessible in same package

protected -  accessible in same package and every child class(inside or outside class)

public - accessible every where


in java - top level classes (can have only two access specifiers)
    - public and <default>


       public class Main{}    // public
       class A{}              //<default>
       class B{}              // <default>

       nested class - class inside class
       private /  <dafault> / protected / public



       // nitin sir's  codes  20 - 30 codes {day-3}




       // when you create object in child class
        {...... control goes to child class constructor and then immediately parent class default constructor
         and goes to Object...... }
         and flow is up -> down   parent -> child


         // {..... super should be on 1st line to call parent constructor......}



         //class base
         //{
         //	int num1=10;
         //	void disp1()
         //	{
         //		System.out.println(num1);
         //	}
         //	base(int num1)
         //	{
         //		this.num1=num1;
         //		System.out.println("in base param");
         //	}
         //}
         //class sub1 extends base
         //{
         //	int num2=20;
         //	void disp2()
         //	{
         //		System.out.println(num2);
         //	}
         //	sub1()
         //	{
         //		super(5);
         //	}
         //	sub1(int num2)
         //	{
         //		super(8);
         //		this.num2=num2;
         //	}
         //}
         //class sub2 extends sub1
         //{
         //	int num3=30;
         //	void disp3()
         //	{
         //		System.out.println(num3);
         //	}
         //	sub2(int num3)
         //	{
         //
         //		this.num3=num3;
         //	}
         //}
         //public class Demo10
         //{
         //	public static void main(String args[])
         //	{
         //		sub2 s1=new sub2(10);
         //		s1.disp1();
         //		s1.disp2();
         //		s1.disp3();
         //	}
         //}


    ... when parent constructor have only parameterized constructor then all child class constructor must pass parameter by super keyword

  // all 27 code refer for constructor....




         // overriden vs overriding

         4 rule of overriding - :

         1) argumemts must be same {otherwise it is a overloading}

         2) return type of overrriding can be co-variant (covarient return type are possible only in case of "reference type"
         and not in case of primitive)
         covarient return type means if overridden method type is parent and overriding method return type is "child"

         class A{
           int fun(){}
         }
         class B extends A {
           fun(){}                      // this must be int type to be override
         }



         // reference
         class X{
           Object  fun(){}                     // overrriden
         }
         class Y extends X {
          Object  fun(){}                      // return type is same
         }


         // reference
         class X{
           Object  fun(){}                     // overrriden
         }
         class Y extends X {
          String  fun(){}                      // return type is not same - covarient return type  - overrride
         }


         // String class is child of Object


          // super to invoke parent class method....
          //

         class FourWheeler{
           Object  start(){}  // basic instruction of 4 wheeler
         }
         class car extends FoueWheeler {
         // here i want basic instruction o4 wheeler too...
          super.start();
          Object  start(){}          // instruction to start the class
         }


          3) overrding method must have same or more accessibilty as compare to overriden method

          lass FourWheeler{
           Object  start(){}  // basic instruction of 4 wheeler
         }
         class car extends FoueWheeler {
         // here i want basic instruction o4 wheeler too...
          super.start();
         <default>/public/procted/private (check which one is allowed) same or more Object  start(){}          // instruction to start the class
         }


             method overrinding possible
         // if overriden method return type is parent and overriding method return type is child then



         // Dynamic polymorphism ...

         // upcasting.....

         // binding.....
         -early (private , static , final ) and late binding (remaining other)




         // instanceof operator
         // downcasting.....

         // pattern matching instanceof




         Sure. Let's understand **all of these concepts using one simple idea**.

Your main topic is:

> **Dynamic polymorphism = one parent reference can refer to different child objects, and Java decides at runtime which overridden method to call.**

---

# 1. Dynamic Polymorphism     /// refer dynamic polymorphism txt file....

**Very simple definition:**

> A parent reference can point to different child objects, and the child's overridden method is called at runtime.

Example:

```java
Animal ref = new Tiger();
ref.makeSound();
```

Here:

```text
Reference type → Animal
Actual object  → Tiger
```

Because `Tiger` has overridden `makeSound()`:

```java
Tiger → makeSound() → "roar"
```

So output is:

```text
roar
```

Now:

```java
Animal ref = new Dog();
ref.makeSound();
```

Output:

```text
bark
```

Same reference type (`Animal`), but different object → different behavior.

That's **dynamic polymorphism**.

---

# 2. Upcasting

You wrote:

```java
perform(new Tiger());
```

and:

```java
static void perform(Animal ref)
```

`perform()` wants an `Animal` reference.

But you're giving it:

```java
new Tiger()
```

Why is this allowed?

Because:

```text
Tiger IS-A Animal
```

So Java automatically treats the `Tiger` object as an `Animal`.

This is called **upcasting**.

### Simple definition:

> **Upcasting means using a parent reference to refer to a child object.**

Example:

```java
Animal ref = new Tiger();
```

```text
Animal reference
      ↓
  Tiger object
```

---

# 3. Binding

**Binding means:**

> Deciding which method should be called.

There are two types.
----------------------------------------------------------------------------------------------------------------------------
## Early Binding

 {........The method is decided at **compile time**. ....}}]

Common examples:

```text
private
static
final
```

For example:

```java
class Test
{
    static void show()
    {
        System.out.println("Hello");
    }
}
```

The compiler knows exactly which `show()` to call.

So:

> **Early binding = compiler decides.**

---

## Late Binding

 {....The method is decided at **runtime**......}

It happens with **overridden instance methods**.

Example:

```java
Animal ref = new Tiger();

ref.makeSound();
```

At compile time:

```text
ref → Animal
```

At runtime:

```text
ref → Tiger object
```

So Java calls:

```java
Tiger.makeSound()
```

Therefore:

> **Late binding = runtime decides based on the actual object.**

### Easy memory trick

```text
Early binding → Compile time
Late binding  → Runtime
```

---

lass base
{
	void disp() // overridden
	{
		System.out.println("base disp");
	}
}
class sub1 extends base
{
	void disp() // overriding
	{
		System.out.println("sub disp");

	}
}
public class Demo14
{
	public static void main(String args[])
	{
		sub1 s1=new sub1();
		s1.disp();
	}
}

In the above example when compiler encounters the statement "s1.disp()", what compiler does?
	ans: For the compiler "s1" is of type "sub1". Compiler will search "disp()" in "sub1"
is it there ? yes
is it accessible from main ?  yes
is it final ?  no
is it static ?  no

now compiler writes an instruction for runtime to follow. What is that instruction ?
ans: during runtime check the content of "s1" and invoke "disp()" of that content (object).

so what happens in the above example?
	during runtime content of "s1" is "sub1's object", hence "disp()" of "sub1" gets invoked.


---------------------------------------------------------------------------------------------------------------------------------------
# 4. `instanceof`

`instanceof` asks:

> **"Is this object actually an instance of this class?"**

Example:

```java
Animal ref = new Tiger();

if(ref instanceof Tiger)
{
    // yes
}
```

The answer is `true`.

Because:

```text
ref
 ↓
Tiger object
```

You can think of:

```java
ref instanceof Tiger
```

as:

> "Does `ref` point to a Tiger?"

---

# 5. Downcasting

Suppose:

```java
Animal ref = new Tiger();
```

Because `ref` is an `Animal` reference, you cannot directly do:

```java
ref.hunting();   // ❌
```

Why?

Because `Animal` doesn't have `hunting()`.

`hunting()` belongs to `Tiger`:

```java
class Tiger extends Animal
{
    void hunting()
    {
        System.out.println("hunt");
    }
}
```

So we convert the `Animal` reference back to a `Tiger` reference:

```java
Tiger temp = (Tiger) ref;
```

This is **downcasting**.

### Simple definition:

> **Downcasting means converting a parent reference back into a child reference.**

Then:

```java
temp.hunting();
```

works.

---

# 6. Why do we need `instanceof` before downcasting?

Consider:

```java
Animal ref = new Dog();
```

If you do:

```java
Tiger temp = (Tiger) ref;
```

This is wrong.

Why?

Because the actual object is:

```text
Dog object
```

not:

```text
Tiger object
```

So Java will throw:

```text
ClassCastException
```

That's why we check first:

```java
if(ref instanceof Tiger)
{
    Tiger temp = (Tiger) ref;
    temp.hunting();
}
```

Meaning:

```text
Is ref a Tiger?
       ↓
      YES
       ↓
Convert it to Tiger
       ↓
Call hunting()
```

---

# 7. Pattern Matching with `instanceof`

Traditional way:

```java
if(ref instanceof Tiger)
{
    Tiger temp = (Tiger) ref;
    temp.hunting();
}
```

Java provides a shorter way:

```java
if(ref instanceof Tiger temp)
{
    temp.hunting();
}
```

Here Java does **both things automatically**:

```text
1. Check → Is ref a Tiger?
2. Convert → Make a Tiger reference called temp
```

So:

```java
if(ref instanceof Tiger temp)
{
    temp.hunting();
}
```

is basically a shorter version of:

```java
if(ref instanceof Tiger)
{
    Tiger temp = (Tiger) ref;
    temp.hunting();
}
```

### Simple definition:

> **Pattern matching `instanceof` checks the type and creates the correctly typed reference at the same time.**

---

# 8. Now understand your `perform()` method

You have:

```java
static void perform(Animal ref)
{
    ref.makeSound();

    if(ref instanceof Tiger)
    {
        Tiger temp = (Tiger)ref;
        temp.hunting();
    }
}
```

And:

```java
perform(new Tiger());
perform(new Dog());
```

### First call

```java
perform(new Tiger());
```

Inside `perform`:

```text
ref
 ↓
Tiger object
```

Then:

```java
ref.makeSound();
```

Because the actual object is Tiger:

```text
Tiger.makeSound()
      ↓
    roar
```

Then:

```java
ref instanceof Tiger
```

is `true`.

So:

```java
Tiger temp = (Tiger)ref;
temp.hunting();
```

Output:

```text
roar
hunt
```

---

### Second call

```java
perform(new Dog());
```

Now:

```text
ref
 ↓
Dog object
```

So:

```java
ref.makeSound();
```

calls:

```text
Dog.makeSound()
      ↓
    bark
```

Then:

```java
ref instanceof Tiger
```

is `false`.

So `hunting()` isn't called.

Output:

```text
bark
```

---

# 9. Your `Demo14` example

You have:

```java
sub1 s1 = new sub1();
s1.disp();
```

There are two important things:

```text
sub1 s1       → reference
new sub1()    → object
```

So:

```text
s1
 ↓
sub1 object
```

When compiler sees:

```java
s1.disp();
```

it first looks at the **reference type**:

```java
sub1 s1
```

Compiler asks:

### Question 1

Does `sub1` have `disp()`?

```java
class sub1 extends base
{
    void disp()
    {
        System.out.println("sub disp");
    }
}
```

Yes. ✅

### Question 2

Is `disp()` accessible?

Yes. ✅

### Question 3

Is it `static`?

No. ❌

### Question 4

Is it `final`?

No. ❌

So this is an overridden instance method.

Therefore the compiler basically says:

> "At runtime, look at the actual object and call the appropriate overridden method."

At runtime:

```text
s1
 ↓
sub1 object
```

So:

```java
sub1.disp();
```

is called.

Output:

```text
sub disp
```

---

# 10. The most important difference

This is probably the part you should remember for exams/interviews.

Suppose:

```java
base ref = new sub1();
```

There are **two types** involved:

```text
base ref = new sub1();
^^^^       ^^^^^^^^^
reference   object
type        type
```

### Compiler cares about the reference type

The compiler asks:

> "Does `base` have this method?"

### Runtime cares about the actual object

The JVM asks:

> "What object is actually inside `ref`?"

Then it calls the overridden method of that object.

So:

```java
base ref = new sub1();

ref.disp();
```

means:

```text
COMPILE TIME
     ↓
Look at reference type → base
     ↓
Does base have disp()? → YES
     ↓
Allow the call
     ↓
RUNTIME
     ↓
Look at actual object → sub1
     ↓
Call sub1.disp()
```

---

# 11. One picture to remember everything

```text
                    POLYMORPHISM
                         |
              Parent reference
              points to child
                         |
                     UPCASTING
                         |
                         ↓
              Animal ref = new Tiger()
                         |
                         ↓
                  ref.makeSound()
                         |
                  LATE BINDING
                         |
                         ↓
                Actual object?
                         |
                      Tiger
                         |
                         ↓
                 Tiger.makeSound()
                         |
                       roar
                         |
             Need Tiger-specific method?
                         |
                         ↓
                    instanceof
                         |
                    Is it Tiger?
                     /       \
                   YES        NO
                    |
                    ↓
                DOWNCAST
                    |
                    ↓
             Tiger temp = (Tiger)ref
                    |
                    ↓
               temp.hunting()
```

### Final cheat sheet 🧠

| Concept                  | Very simple meaning                             |
| ------------------------ | ----------------------------------------------- |
| **Dynamic polymorphism** | Same parent reference, different child behavior |
| **Upcasting**            | Child object → parent reference                 |
| **Binding**              | Deciding which method to call                   |
| **Early binding**        | Decided at compile time                         |
| **Late binding**         | Decided at runtime                              |
| **`instanceof`**         | Checks what type the actual object is           |
| **Downcasting**          | Parent reference → child reference              |
| **Pattern matching**     | `instanceof` + casting in one step              |

The **golden rule** is:

> **Compiler checks the reference type; runtime checks the actual object for an overridden method.**

 */

public class main {
    static void main() {

    }
}
