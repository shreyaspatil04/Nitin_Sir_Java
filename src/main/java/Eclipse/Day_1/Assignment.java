package Eclipse.Day_1;
import java.util.*;
// control flow assignment
public class Assignment {
    /*
//1)	display a table of a particular number

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

    	System.out.println("Enter a number");
    	int n = sc.nextInt();

    	for(int i = 1 ; i<= 10 ; i++) {
    		int ans ;

    		ans = i*n;
    		System.out.println(n+" * "+i+" = "+ans);

    	}

    }
    */



	/*
	//declare two numbers and one operator as a character. e.g. '+'
	//using switch... case check which operator is declared and accordingly perform the action.

	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

    	System.out.println("Enter number 1 : ");
    	int n1 = sc.nextInt();

    	System.out.println("Enter number 2 : ");
    	int n2 = sc.nextInt();

    	System.out.println("Enter a choice :"
    			          +"'+','-','*','/','%'");

    	char ch = sc.next().charAt(0);

    	switch (ch) {

    		case '+' :{
    			System.out.println("Addition is "+(n1+n2));
    			break;
    		}

    		case '-' : {
    			System.out.println("Subtraction  is "+(n1-n2));
    			break;
    		}

    		case '*' : {
    			System.out.println("Multiplication is "+(n1*n2));
    			break;
    		}

    		case '/' : {
    			System.out.println("Division is "+(n1/n2));
    			break;
    		}
    		case '%' : {
    			System.out.println("Remainder is "+(n1%n2));
    			break;
    		}
    		default : {
    			System.out.println("Invalid choice ....");
    		}

    		}

	}
	*/

	/*

	//3)	Display numbers  1 to 10 using loop

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);

		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
	}
	*/



	/*
	//Display numbers from 3 to 30 except number 24  using loop.

	public static void main(String[] args) {

	   for (int i = 3; i <= 30; i++) {
		   if(i == 24) {
			   continue;
		   }
		System.out.println(i);
	 }
	}
	*/


	/*

	// 5)	Using if…….else if….  Else,  display whether result is  fail, pass, second class ,
	// first class, Distinction etc.

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Marks : ");
		int marks = sc.nextInt();

		if(marks >= 90 ) {
			System.out.println("Distinction");
		}else if(marks<= 89 && marks >= 75 ) {
			System.out.println("First class");
		}else if(marks<= 74 && marks >= 60) {
			System.out.println("Second Class");
		}else if(marks<= 59 && marks >= 35) {
			System.out.println("Passs....");
		}else {
			System.out.println("Fail..");
		}
	}
	*/


	/*

	// 6) display all prime numbers between 3 to 30

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int i=3 ; i<= 30 ; i++) {
			if(is_prime(i)== true) {
				System.out.println(i);
			}
		}
	}

	static  boolean is_prime(int n) {
		int num = n/2;

		for(int i=2 ; i<= num ; i++) {
			if(n%i==0) {
				return false;
			}
		}

		return true;
	}

	*/




	/*


	/*
	// 7) using nested for loop display following :
A  a
A  b
A  c

B  a
B  b
B  c

C  a
C  b
C  c

*/
	/*
	public static void main(String[] args) {
		for(int i = 97 ; i<= 99 ; i++) {

			for(int j = 97 ; j<=99 ; j++) {
				char c = (char) (i-32);
				char d = (char) j;
				System.out.println(c+"  "+d);
			}
			System.out.println();
			}

		}

  */


	/*

	// 8) accept a number and display whether it is prime or not.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a number to check it is prime or not ..");
		int n = sc.nextInt();

		if(is_prime(n) == true) {
			System.out.println("Yes !! its a prime Number...");
		}else {
			System.out.println("No !! its not a prime number...");
		}
	}

	static boolean is_prime(int n) {
		int num = n/2;

		for(int i = 2 ; i<= num ; i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}
	*/



	/*
	/*
	// 10) display all twin prime numbers between 1 to 50
Twin prime numbers are a pair of prime numbers whose difference is exactly 2.
	e.g.
		(3,5)
		(5,7)
		(11,13)
		(17,19)
		(29, 31)
		(41, 43)
		*/
	/*

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a range :");
		int n = sc.nextInt();

				for(int i =2 ; i<= n-2 ; i++) {
					if(is_prime(i) && is_prime(i+2)) {
						System.out.println("["+(i)+","+(i+2)+"]");
					}
				}
	}
	static boolean is_prime(int n) {
		int num = n/2;

		for(int i = 2 ; i<= num ; i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}


	*/

	/*

	//11)
	accept a number and print whether it is special or not
	a special number is the one where
		total of all the digit's factorial becomes the number itself.
	e.g.
	145
	1's factorial - 1
	4's factorial  - 24
	5's factorial 120
		Total 145  which is same as the target number i.e. 145
*/
	/*
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);

		System.out.println("Enter a Number to check it is special or not : ");
		int n = sc.nextInt();

		if(is_Special(n) == true) {
			System.out.println("Yes !! it is a Special number...");
		}else {
			System.out.println("No!! its not a special number...");
		}
	}

	static boolean is_Special(int n) {

		int temp = n;
		int r;
		int sum = 0;

		while(temp>0) {
			r = temp%10;
			sum += find_factorial(r);
			temp = temp/10;
	   }

		if(sum == n) {
			return true;
		}
		return false;
	}


	static int find_factorial(int n) {
		int fact = 1;

		for (int i = n ; i>1 ; i--) {
			fact = fact * i;
		}

		return fact;
	}

	*/



	/*




	// 12) display all prime numbers between 1 to 50

	public static void main(String[] args) {
		for(int i= 2 ; i<=50 ; i++) {
			if(is_Prime(i) == true) {
				System.out.println(i);
			}
		}
	}

	static boolean is_Prime(int n) {
		int num = n/2;

		for(int i = 2 ; i<= num ; i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}


	*/



    //
	/*
	 13) print the following pattern using one for loop only

       12345
       2345
       345
       45
       5


	public static void main(String[] args) {

		for(int i = 1 ; i<= 5; i++) {
			for(int j=i; j<=5 ; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}


	*/


// 15) print the following pattern	....

/*



A
ABA
ABCBA
ABCDCBA

*/
	/*
	public static void main(String[] args) {
		for(int i = 1 ; i<=4 ; i++) {

			// inner part
			for(int j = 0 ; j<i; j++) {
				char c = (char) (65+j);
				System.out.print(c);
			}

			for(int k = i-1 ; k<=)
			System.out.println();
		}
	}
	*/




	/*
	 print the following pattern using only one loop:
1
121
12321
1234321
	 */
	/*
	public static void main(String[] args) {
		for(int i = 1 ; i<= 4 ; i++) {

			// first part
			for(int j = 1; j<=i ; j++) {
				System.out.print(j);
			}

			// second part
			for(int k= i-1 ; k>=1 ; k--) {
				System.out.print(k);
			}
			System.out.println();
		}
	}
	*/


	/*

	//17)  display first 10 fibonacii numbers

	public static void main(String[] args) {
		int a = 0;
		int b = 1;

		for(int i = 0 ; i<= 10 ; i++) {
			System.out.print(a+" ");

			int c = a+b;
			    a=b;
			    b=c;
		}
	}
	*/


	/*

	//18) accept a number and display fibonacii numbers till that number
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number : ");
		int n = sc.nextInt();

		int a = 0;
		int b = 1;

		for(int i = 0 ; i<= n ; i++) {
			System.out.print(a+" -> ");

			int c = a+b;
			a=b;
			b=c;
		}
	}
	*/
//








    /// arithmetic operator assignment
    //
    //	/*
    //	// 1) accept two numbers and add them.
    //	2) accept two numbers and subtract them.
    //	3) accept two numbers and multiply them.
    //	4) accept two numbers and devide them.
    //	5) accept two numbers and check whether first number is greater or second number is greater or they are equal.
    //	6) accept a number and check whether it is divisible by 3 or not.
    //
    //	*/
    //
    //
    //	/*
    //	//1
    //	public static void main(String[] args) {
    //
    //		Scanner sc = new Scanner(System.in);
    //
    //		System.out.println("Enter number 1 : ");
    //		int n1= sc.nextInt();
    //
    //		System.out.println("Enter number 2 : ");
    //		int n2= sc.nextInt();
    //
    //		int c = n1+n2;
    //
    //		System.out.println("Answer is : "+c);
    //	}
    //
    //	*/
    //
    //	/*
    //	public static void main(String[] args) {
    //
    //		Scanner sc = new Scanner(System.in);
    //
    //		System.out.println("Enter number 1 : ");
    //		int n1= sc.nextInt();
    //
    //		System.out.println("Enter number 2 : ");
    //		int n2= sc.nextInt();
    //
    //		int c = n1-n2;
    //
    //		System.out.println("Answer is : "+c);
    //	}
    //
    //	*/
    //
    //
    //	/*
    //
    //	// 3 Multiply
    //
    //	public static void main(String[] args) {
    //
    //		Scanner sc = new Scanner(System.in);
    //
    //		System.out.println("Enter number 1 : ");
    //		int n1= sc.nextInt();
    //
    //		System.out.println("Enter number 2 : ");
    //		int n2= sc.nextInt();
    //
    //		int c = n1*n2;
    //
    //		System.out.println("Answer is : "+c);
    //	}
    //	*/
    //
    //
    //	/*
    //	// 4
    //
    //	public static void main(String[] args) {
    //
    //		Scanner sc = new Scanner(System.in);
    //
    //		System.out.println("Enter number 1 : ");
    //		int n1= sc.nextInt();
    //
    //		System.out.println("Enter number 2 : ");
    //		int n2= sc.nextInt();
    //
    //		int c = n1/n2;
    //
    //		System.out.println("Answer is : "+c);
    //	}
    //	*/
    //
    //
    //
    //	/*
    //	// 5
    //
    //	public static void main(String[] args) {
    //	//	accept two numbers and check whether first number is greater or second number is greater or they are equal.
    //
    //Scanner sc = new Scanner(System.in);
    //
    //		System.out.println("Enter number 1 : ");
    //		int n1= sc.nextInt();
    //
    //		System.out.println("Enter number 2 : ");
    //		int n2= sc.nextInt();
    //
    //		if(n1>n2) {
    //			System.out.println("n1 is greater");
    //		}else if(n2> n1){
    //			System.out.println("n2 is greater");
    //		}else {
    //			System.out.println("both are equal");
    //		}
    //
    //	}
    //
    //	*/
    //
    //
    //
    //	/*
    //	// 6 accept a number and check whether it is divisible by 3 or not.
    //
    //	public static void main(String[] args) {
    //		Scanner sc = new Scanner(System.in);
    //
    //		System.out.println("Enter Number : ");
    //		int n1= sc.nextInt();
    //
    //		if(n1 % 3 == 0) {
    //			System.out.println("Yes ! divisible by 3 ");
    //		}else {
    //			System.out.println("No ! its not divisible by 3 ");
    //		}
    //
    //	}
    //	*/
    //}



}
