/* Assignment 4
 * File name: DriverPolynomial, class name Polynomial
 * Written by: Andy Nguyen (7333870) , Christopher Wong (7438974) 
 * For Comp 248 Section Q/Fall 2014
 * 
 * 
 */
import java.util.Scanner;
import java.util.Random;

public class Polynomial {
	//instance Variables
	private double value; 
	private final int arraySize=5;
	private final int min=0;
	private final int max=100;
	Random rand = new Random();
	private int randomNumber;
	Scanner keyboard= new Scanner( System.in);
	private double coef []; // array is an object 	

	public Polynomial() // constructor 1
	{
		value=0;
		coef = new double[arraySize];
		for (int i =0; i< coef.length ; i++)
		{
			coef[i] = 0.0;
		}
	}

	public Polynomial(double d1, double d2, double d3, double d4,double d5) // constructor 2
	{ 
		coef = new double[arraySize];
		coef[0] = d1;
		coef[1]=d2;
		coef[2]=d3;
		coef[3]=d4;
		coef[4]=d5;

	}

	public Polynomial(Polynomial poly) // constructor 3
	{
		coef = new double[arraySize]; // call the array
		double[] polyCoef = poly.getCoef(); // assign new array

		for (int i =0; i< coef.length ; i++)
		{
			coef[i] = polyCoef[i];
		}
	}

	public double[] getCoef() { // an accessor method to access private array coef to use it in other methods. 
		return coef;
	}

	public void setCoef(double[] coef) {//mutator that sets the coefficient 
		this.coef = coef;
	}

	public void makePolynomial() // Method that will allow user to input their own values to create there own polynomial
	{

		for (int i =0; i< coef.length ; i++)
		{
			System.out.print("Enter cooeficients# " + (i+1) + " of the polynomial  ");// loop that asked user to input their polynomial coefficients.
			coef[i] = keyboard.nextDouble(); // Scanner input that takes in the values 
		}

	}

	public void setValue(int position, double x) // set value mutator 5
	{
		coef[position] = x; // to set new value in our array
	}

	public double getValue(int position) // accessor 4 
	{
		if (position >= 5) {
			return 0.0;
		}
		return coef[position];
	}

	public void randomPolynomial() // Method that will generate random values for the polynomial
	{
		for(int i =0; i< arraySize;i++)
		{
			randomNumber = rand.nextInt((max - min)+1)+min; // generating the random number

			coef[i]=randomNumber; // assigning the array to a random number

		}
	}

	public Polynomial add(Polynomial p) // Method that will add two polynomials together
	{
		Polynomial result = new Polynomial();

		double[] coeftemp = p.getCoef(); // creating a second array that will hold value of the second polynomial ( there is a getter so that array coef can be accessed)
		for (int i = 0 ; i<coef.length;i++) // looping to add the values together
		{
			double d= coeftemp[i] +coef[i]; // d will now hold the sum of the two array

			result.setValue(i, d); // mutator to set new value // this means at position i it holds value d

		}

		return result; 

	}

	public double evaluate(double x) // a Method that will evaluate the value of x
	{

		double value = 0; // initialize value to 0
		for (int i = arraySize - 1; i >= 0; i--) // loop that will evaluate the variable x and return the evaluated value 
			value = coef[i] + (x * value);// value is the result of the polynomial function with variable x
		return value;

	}

	public Polynomial times(int number) // a Method that will multiply the values of the array by a chosen number 
	{
		Polynomial result = new Polynomial(); // make a new object 

		for (int i=0; i< coef.length; i++) { // loop that will multiply the coefficients of the polynomial by a certain number
			double d = number * coef[i];
			result.coef[i] = d; // d is now the result of the coefficient multiplied by the number
		}

		return result;
	}

	public Polynomial derivative() // a Method that will derive the polynomial
	{
		Polynomial result = new Polynomial();

		for (int i = 0 ; i< coef.length-1; i++) { // loop  that will rearrange the polynomial
			result.setValue(i, coef[i+1]*(i+1)); // at position i, the new coefficient will be itself before multiplied by its power
		}


		return result;


	}
	public int numberOfTerms(){ // a Method that will get the number of terms in each Polynomial
		int numberofterm=0; // initial number of terms is 0
		for (int i = 0; i < coef.length; i++) { // a loop that goes through the array
			if (coef[i] !=0) // if the coefficient is not 0, it adds a term this means if 0 is a value of the coefficient it will not be added
			{
				numberofterm++;
			}
		}
		return numberofterm; 
	}



	public String toString() { // a Method that will allow the polynomial to be printed out.

		String s = ""; // create a new String  called s

		if(coef[0] != 0) // if the first term is not 0, then coef[0] is included in the string
		{
			s += coef[0];
		}

		for (int i = 1; i < arraySize; i++) { // a loop that will evaluate second term to the fifth term

			if (coef[i] == 0) { // if a coefficient is 0,then it will not be printed and the loop will continue
				continue;
			} else {
				if (s.length() != 0) { // if the length of the string is not 0, it continues
					if (coef[i] > 0) {  // if the coefficient is greater 0, it will display a +
						s += " + ";
					} else if (coef[i] < 0) // else it will display a -
					{
						s += " - ";
					} 
				} 

			}

			s += Math.abs(coef[i]); // Set absolute value, so that if we have a negative value it won't show as +- but - instead 

			if (i==1) // for the first term it will display x only or x power 1
			{
				s += "x";
			}
			else {  
				s += "x^";

			}

			if (i > 1) { // i is the power of the polynomial 
				s += i;
			}
		}

		return s; //return String
	}
}
