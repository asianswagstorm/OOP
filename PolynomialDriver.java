/* Assignment 4
 * File name: driver name: PolynomialDriver, class name: Polynomial
 * Written by: Andy Nguyen (7333870) , Christopher Wong (7438974)  
 * For Comp 248 Section Q/Fall 2014
 * 
 * 
 */
import java.util.Scanner;
public class PolynomialDriver {

	public static void main(String [] args)
	{
		double x; // this part is used to get the value that we want to be evaluated
		Scanner keyboard = new Scanner(System.in);
		Polynomial[] poly = new Polynomial[8]; // array that creates the objects 

		for(int i=0 ; i<poly.length;i++) // a loop that creates the objects of the polynomial
		{

			poly[i]= new Polynomial();
		}

		System.out.println("Enter Coefficients for the first Polynomial "); // User input polynomial 1 
		poly[0].makePolynomial(); // 0 Calling method that allows user to input array
		System.out.println(" Polynomial #1 at (Location 0) is: "+ poly[0].toString() + "\n");

		
		System.out.println("Enter Coefficients for the Second Polynomial ");// User input polynomial 2 
		poly[1].makePolynomial(); //1 Calling method that allows user to input array
		System.out.println(" Polynomial #2 at (Location 1) is: " + poly[1].toString() + "\n");


		poly[2].randomPolynomial(); //2 Calling method that creates random polynomial
		System.out.println("First Random Polynomial");
		System.out.println(" Polynomial #3 at (Location 2) is: " +poly[2].toString()+ "\n");


		poly[3].randomPolynomial(); //3 Calling method that creates random polynomial
		System.out.println("Second Random Polynomial");
		System.out.println(" Polynomial #4 at (Location 3) is: " +poly[3].toString()+ "\n");


		poly[4].randomPolynomial(); //4 Calling method that creates random polynomial
		System.out.println("Third Random Polynomial");
		System.out.println(" Polynomial #5 at (Location 4) is: " +poly[4].toString()+ "\n");

		// The  sum of location 0 and location 2 
		poly[5]=poly[0].add(poly[2]);// reassigning new object poly5 to the add method
		System.out.println("Sum Of Polynomial #1 and Polynomial #3");
		System.out.println(" Polynomial #6 at (Location 5) is: " +poly[5].toString()+ "\n");

		// 3 times polynomial 2 ( location 1)
		poly[6]=poly[1].times(3);// reassigning new object poly6 to methods that multiplies the polynomial, calling number 3,therefore multiply by 3 
		System.out.println("Three times Polynomial #2  ");
		System.out.println(" Polynomial #7 at (Location 6) is: "+ poly[6].toString()+ "\n"); //6

		// The derivative of location4(polynomial 5) 
		poly[7] = poly[4].derivative(); // reassigning new object to a method that takes the derivative
		System.out.println("Derivative of Polynomial #5");		
		System.out.println(" Polynomial #8 at (Location 7) is: " +poly[7].toString() + "\n");


		System.out.print("\n Enter the value of x that will be evaluated by each polynomial:" );
		x= keyboard.nextDouble(); // taking in input to be evaluated
		//
		for ( int i=0; i< poly.length;i++) // making a loop that will output each polynomial with the number of terms , and the value that resulted from evaluation
		{
			System.out.println(" Polynomial #"+(i+1) +": " + poly[i].toString() +
					" has " + poly[i].numberOfTerms() + " terms and  evaluates to: " + poly[i].evaluate(x)  + " for x ="+ x +"\n"); 

		}
	}

}
