package Day_2;

// Lec notes - of Day-2

import java.util.Arrays;
import java.util.Scanner;

/*
* Automatic and Explicit convesion (type-casting)
*
* byte c = 10;
* int b;
* b=c // automatic casting
*
* becoz byte is small
*
* but b=c;  // not possible
*
* but if we do explicit convesion
*
* b = (byte) c; // now its possible  but it will go in circle (-128 to 127)
*
*
  // boolean cant be type-cast
  *
  *
  * // learn more on type-casting
*
*
*
* // java 10 -- feature
*
* // new keyword --> var  <--
*
* var x = 10;
* var y = 10.5;
* var z = 'A';
*
* here :
* x -> int
* y -> double
* z - char
*
* var  doesnt mean the variable has no type
* the  compiler determines on compile time


*
*
*
*
*
*  {// local variable intialize before use....}
*
*
*
*  { Decision making  & loop } --:
*
* Decision making -:
*     if ->  else-if  -> else --> switch ---> case
*
* Loop :-
*     for -> while -> Do while
*
*
*
*
*
* Switch  syntax ->  old one
*
*  switch (expression)
* {
* case 1 :{
* break;
*   }
* case 2 : {
* break;
* }
* default {
* }
*
*
*
* new switch syntax.................
* int day = 2;
*
* switch(day){
* case 1 -> System.out.println("Monaday");
* case 2 -> System.out.println("Tuesday");
* case 3 -> System.out.println("Wednesday");
* case 4 -> System.out.println("Thursday");
* case 5 -> System.out.println("Friday");
* default -> System.out.println("Invalid");
* };
*
*
* // here no break and ':'
*
*
* you can check multiple cases
*
* switch(day){
* case 1,2,3,4,5 -> System.out.println("Weekday");
* case 6,7 -> System.out.println("Weekend");
* default -> System.out.println("Invalid");
* };
*
*
*
*
* {  Yield }
*
* we use return keyword in function  & here in switch we use --> yield <--
*
* int marks = 85;
*
* String grade = switch(marks/10){
* case 10,9  ->  "A+"; // here no need to write yield
*
* case 8 -> {
* System.out.println("good performance :");
* yield "A";                 // here we have to use yield becoz we have used block and did mmultiple things
* }
*
* case 7 -> yield "B";
* default -> "invalid";
* };
*
*
*
* for loop --> continue and break ;
*
*
*
* // label for for loops
*  A: for(int i = 0 ; i<= 5 ; i++){
*
*    }
*
*
* what is object ?
* ->
*
* ///object has attribute and behaviour
*
* attributes ?
* -->

what is class?
--> class is blueprint class and doesn't occupy memory + (extra real life understanding)





types of comments - :
   1) single line -    /
   2) multi line  -    //
   3) document comment - /**  **/




/*

there no concept call global member in java
 we called it as instance member

 public class MyNumber {

 private int num;   // instance member...


 public static void main(String[] args){
   int number ;    // local member...
 }
 }


 instance member get allocated memory when object is created....

 // instace member should be private

 we give indirect access by using member function eg. setter and getter..


 objects are created only on heap... in java   in c++ it can be on stack or heap...

*****-----
 // no matter how many object are created only one copy member function is created
 thats why we use m1.setter()  m2.setter()
******----

 but N number of instance member are created for n number of objects..

 { this keyword } learn concept

 this is reference
 // we cant use this keyword with static member....

 local and instance member can have same name.....
 it will create confusion local member has higher precendence  it will assign value to itself

 public  void setNum(int num){
    this.num = num;
 }


 // { Automatic garbage collection }  // concept of unreachable object


 m1 = null;
 sysout(m1.getter());

 // whenever reference contains null and that reference we invoke a member function

 // exception always come at runtime never at compile time...


 m1 = null
 if(m1 != null){
 sysot(m1.getNum());
 }

 if error can solve by if else no need to write try catch exception




 // java only have call by value learn this...


  refer call by value text file provided by nitesh sir
  call by value by reference Demo ref



    // Demo 4 ->
    class MyNumber
{
	private int num;   // instance member or member variable

	// setter and getter

	public void setNum(int num)  // member function
	{
		this.num=num;
	}
	public int getNum()   // member function
	{
		return num;
	}
}
public class Demo4
{
	public static void main(String args[])
	{
		MyNumber m1=new MyNumber();   // instance or object creation
		m1.setNum(150);
		System.out.println(m1.getNum());
		MyNumber m2=new MyNumber();
		m2.setNum(200);
		System.out.println(m2.getNum());
		m1=null;    /* what will happen to object where "m1" refers to ?
			the object to which "m1" was referring to will be marked for Garbage Collection ( provided no other reference referring to that object) and after some time ( depends on JVM implementation) it will be garbage collected.
  		System.out.println("done");
	}
            }

                 STACK                         HEAP

          ┌─────────────────┐          ┌──────────────────┐
          │ m1              │ ───────► │ MyNumber Object  │
          └─────────────────┘          │ num = 150        │
                                       └──────────────────┘


          ┌─────────────────┐          ┌──────────────────┐
          │ m2              │ ───────► │ MyNumber Object  │
          └─────────────────┘          │ num = 200        │
                                       └──────────────────┘


   after n1 = null ;

                    STACK                         HEAP

          ┌─────────────────┐          ┌──────────────────┐
          │ m1 = null       │          │ MyNumber Object  │
          └─────────────────┘          │ num = 150        │
                                       └──────────────────┘
                                                ❌
                                           No reference


          ┌─────────────────┐          ┌──────────────────┐
          │ m2              │ ───────► │ MyNumber Object  │
          └─────────────────┘          │ num = 200        │
                                       └──────────────────┘

// if we null the reference variable then it  will  not refer to the object in a heap
   so  that object will be marked for garbage collection




// demo 5 (Null pointer exception )
class MyNumber
{
	private int num;   // instance member or member variable

	// setter and getter

	public void setNum(int num)  // member function
	{
		this.num=num;
	}
	public int getNum()   // member function
	{
		return num;
	}
}
public class Demo5
{
	public static void main(String args[])
	{
		MyNumber m1=new MyNumber();   // instance or object creation
		m1.setNum(150);
		System.out.println(m1.getNum());
		MyNumber m2=new MyNumber();
		m2.setNum(200);
		System.out.println(m2.getNum());
		m1=null;
		System.out.println(m1.getNum()); // NullPointerException
// when reference contains "null" and we use it to invoke a member or member function, we get "NullPointerException".
  		System.out.println("done");
	}
}




STACK                         HEAP

m1 ───────────────────────► ┌─────────────────┐
                            │ MyNumber        │
                            │ num = 150       │
                            └─────────────────┘


m2 ───────────────────────► ┌─────────────────┐
                            │ MyNumber        │
                            │ num = 200       │
                            └─────────────────┘

STACK                         HEAP

m1 → null                    ┌─────────────────┐
                             │ Object 1        │
                             │ num = 150       │
                             └─────────────────┘
                                    ❌
                              no reference


m2 ───────────────────────► ┌─────────────────┐
                            │ Object 2        │
                            │ num = 200       │
                            └─────────────────┘



// demo 6 --> dont use try catch every time for error handling if you can handle error by if - else

class MyNumber
{
	private int num;   // instance member or member variable

	// setter and getter

	public void setNum(int num)  // member function
	{
		this.num=num;
	}
	public int getNum()   // member function
	{
		return num;
	}
}
public class Demo6
{
	public static void main(String args[])
	{
		MyNumber m1=new MyNumber();   // instance or object creation
		m1.setNum(150);
		System.out.println(m1.getNum());
		MyNumber m2=new MyNumber();
		m2.setNum(200);
		System.out.println(m2.getNum());
		m1=null;
		if(m1!=null)  // this is the way you can avoid "NullPointerException"
		{
			System.out.println(m1.getNum());
		}
  		System.out.println("done");
	}
}

m1 = null will not give error we are just removing the reference variable but if we call
m1.getNum() then it will give an error






// class MyNumber
//{
//	private int num;   // instance member or member variable
//
//	// setter and getter
//
//	public void setNum(int num)  // member function
//	{
//		this.num=num;
//	}
//	public int getNum()   // member function
//	{
//		return num;
//	}
//}
//public class Demo8
//{
//	public static void main(String args[])
//	{
//		MyNumber m1=new MyNumber();   // instance or object creation
//		m1.setNum(150);
//		System.out.println(m1.getNum());
//		MyNumber m2=new MyNumber();
//		m2.setNum(200);
//		System.out.println(m2.getNum());
//		MyNumber m3=m2;  // m3 refers to the same object where "m2" refers to
//		m3.setNum(500);
//		System.out.println(m2.getNum());   // 500
//		m2=null;  // no problem for the object since it is still referred by "m3"
//		System.out.println(m2.getNum());  // NullPointerException
//
//
//	}
//}


STACK                         HEAP

m1 ───────────────────────► ┌─────────────────┐
                            │ Object 1        │
                            │ num = 150       │
                            └─────────────────┘


m2 ────────────┐
               │             ┌─────────────────┐
               └────────────►│ Object 2        │
m3 ────────────┘             │ num = 200       │
                             └─────────────────┘

------------------------------------------------------------------------
STACK                         HEAP

m2 ──► null


m3 ───────────────────────► ┌─────────────────┐
                            │ Object 2        │
                            │ num = 500       │
                            └─────────────────┘


-------------------------------------------------------------------------------------

m3 ─────► Object 2


// here m3 refer to the same object m2 is referring to
obj 2 will not mark for garbage collection becoz we remove m2 reference to obj 2
but m3 is referring to obj 2


 */























public class main {

    /*
    static void main() {
//        char d = (char)99;
//        System.out.println(d);

        for (int i = 97; i <= 99; i++) {
            for (int j =97; j <=99 ; j++) {
                char c = (char) (i-32);
                char d = (char)j;
                System.out.println(c+" "+d);
            }
            System.out.println();
        }
    }

     */

    /*
    static void main() {
        Scanner sc = new Scanner(System.in);
        // third highest 2nd and highest

        int max = Integer.MIN_VALUE;
        int second_highet = Integer.MIN_VALUE;
        int third_highest = Integer.MIN_VALUE;

        for (int i = 0; i < 5; i++) {
            System.out.println("enter a number : ");
            int n = sc.nextInt();

            if(n > max){
                third_highest = second_highet;
                second_highet = max;
                max = n;

            } else if (n>second_highet) {
                third_highest = second_highet;
                second_highet = n;
            }else if(n > third_highest){
                third_highest = n;
            }
        }

        System.out.println("Highest : "+max);
        System.out.println("2nd highest : "+second_highet);
        System.out.println("3rd Highest : "+third_highest);
    }

     */


    /*
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number :  ");
        int n = sc.nextInt();
        boolean ans = is_prime(n);
        if(ans){
            System.out.println("it is a prime number ");
        }else {
            System.out.println("not a prime number ");
        }
    }

    static boolean is_prime(int n){
        int num = n/2;

        if(n<= 1){
            return false;
        }
        for (int i = 2; i < num; i++) {

            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

     */



    /*
    // twin prime number

    static void main() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter range : ");
        int range = sc.nextInt();

        for (int i = 2; i <= range-2 ; i++) {
            if(is_prime(i) && is_prime(i+2)){
                System.out.println("[ "+(i)+", "+(i+2)+" ]");
            }
        }

    }

    static boolean is_prime(int n){
        int num = n/2;

        if(n <= 1){
            return false;
        }
        for (int i = 2; i <= num ; i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

     */



    /*
    // recurssion

    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number to get its factorial :");
        int n = sc.nextInt();

        int ans = find_factorial(n);
        System.out.println(ans);
    }

    static int find_factorial(int n){

        if(n == 1){
            return 1;
        }
        return n* find_factorial(n-1);
    }

     */


    /*

    //  quick sort
    static void main() {
        int[]arr =  {4,2,3,6,1,7,5};
        quick_sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void quick_sort(int[]arr,int s , int e){
        if (s<e){
            int pivot_index = find_pivot_index(arr,s,e);
            quick_sort(arr,s,pivot_index-1);
            quick_sort(arr,pivot_index+1,e);
        }
    }

    static int find_pivot_index(int[]arr, int s , int e){
        int pivot = arr[e];

        int index = s-1;

        for (int i = s; i < e ; i++) {
            if(arr[i] < pivot){
                index++;
                swap(arr,index,i);
            }
        }

        index++;
        swap(arr,index,e);
        return index;
    }

    static void swap(int[]arr, int a , int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b]= temp;
    }

     */


    /*
    static void main() {
      A:  for (int i = 1; i <= 5; i++) {
          B:  for (int j = 1; j<=i; j++) {
              System.out.print("* ");
              if(j==3){
                  break B;
              }
            }
        }
    }

     */
/*
    static void main() {
        int n = 5;
        int start = 1;
        int max = 5;

        for (int i = 1; i <= 5; i++) {
            System.out.print(i);

            if (i == max) {
                System.out.println();
                start++;
                i = start - 1;
                max--;
            }
        }

    }


 */

    /*
    static void main() {
        for (int i = 1; i <=5 ; i++) {
            // print blank spaces
            for (int j = 5-i; j >= 1 ; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <=i ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

     */
    /*

    static void main() {
        int n = 1;
        for (int i = 1; i <=4 ; i++) {
            System.out.println(n*n);
            n = (n*10)+1;
        }
    }

     */

    /*
    static void main() {
        for (int i = 1; i <= 5 ; i++) {

            // print  blank spaces
            for (int j = 1; j <i ; j++) {
                System.out.print(" ");
            }
            // print star
            for (int k = 0; k <= 5-i ; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

     */


    /*
    kaju-katli

     */

    /*

    static void main() {
        for (int i = 1; i <= 5 ; i++) {
            // print blank spaces
            for (int j = 5-i; j >=1 ; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i  ; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // lower part

        for (int i = 5-1; i>=1 ; i--) {

            // print blank spaces
            for (int j = i ; j<5; j++) {
                System.out.print(" ");
            }

            // print star
            for (int k = 1; k <= i ; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }



    }



     */





    /*

12345
2345
345
45
5
     */
    /*
    static void main() {
        int n=5;
        int count=1;
        for(int row=1;row<=n;){
            if(count<=n){
                System.out.print(count++);
            }else if(row<n){
                count=++row;
                System.out.println();
            }
        }
    }

     */
// rotate array by K
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter value for k : ");
        int k = sc.nextInt();

        int[]arr = {1,2,3,4,5,6,7,8,9};

        k = k% arr.length;

        reverse_array(arr,0,arr.length-1);
        reverse_array(arr,0,k-1);
        reverse_array(arr,k,arr.length-1);

        System.out.println(Arrays.toString(arr));

    }

    static void reverse_array(int[]arr, int s, int e){
        while (s<e){
            swap(arr,s,e);
            s++;
            e--;
        }
    }

    static void swap(int[]arr, int a , int b){
        int temp = arr[a];
        arr[a] =arr[b];
        arr[b] =temp;
    }
}



