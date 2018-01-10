import java.util.Random;
import java.util.Scanner;
public class Game_of_Ognib 
	{
	public static void main(String[]args)
	{

		//@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to Ognib! Let's Play.");
		System.out.println("What is your name? ");
		String name = keyboard.next();

		Numbers myNumbers = new Numbers(name); // calling my class Numbers
		Numbers compNumber = new Numbers("Computer");

		myNumbers.buildNumbers(); // generating numbers for user's board
		compNumber.buildNumbers(); // generating numbers for computer's board
	
	
		displayTable(myNumbers); // private method to display the table

		while (!myNumbers.isWinning(name) && !compNumber.isWinning("Computer"))
		{
			System.out.println("\nNobody wins yet! :( ");
			int[] computerChoices = compNumber.pickComputerNumber(3); 

			int number = myNumbers.pickNumber();

			
			for(int i = 0 ; i < computerChoices.length ; i++)
			{
				System.out.println(" Computer's Values:  " +computerChoices[i] + ", ");
			}
			
			System.out.println(name +"'s Value: " + number); 
			

			compNumber.changeNumber(number); // Checking if user inputed number matches the computers board and replaces it by 0
			myNumbers.changeNumber(number); // Checking if user inputed number matches his own board and replaces it by 0

			for(int i = 0 ; i < computerChoices.length ; i++)
			{
				compNumber.changeNumber(computerChoices[i]);   // Checking if Computer selected number matches the computers board and replaces it by 0
				myNumbers.changeNumber(computerChoices[i]);    // Checking if Computer selected number matches the users board and replaces it by 0

			}
			displayTable(myNumbers); // display users board
		}
		
		// shows the final result
		System.out.println(" Final Result \n =================================================================================================");
		displayTable(myNumbers);
		System.out.println();
		displayTable(compNumber);

	}

	private static void displayTable(Numbers displayNumber) // This method display's the Player's Board
	{
		System.out.println("\n"+ displayNumber.getName() + "'s Board");
		displayNumber.buildBoard();
		System.out.println("\n");
	}


}

