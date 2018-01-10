import java.util.Random;
import java.util.Scanner;


public class Numbers {

	final int TABLE_SIZE = 5; // table size is so that it simplifies if we want to change the size of our array // final so we cannot change it ( fixed constant)
	final int ROWS = TABLE_SIZE;
	final int COLUMNS = TABLE_SIZE;
	final int LENGTH = ROWS*COLUMNS;
	final int MIN_VALUE = 1; 
	final int MAX_VALUE = 100; 
	int[] board = new int[LENGTH]; 
	Random rand = new Random();
	int randomNumber;    // an integer to be chosen at random
	boolean isDuplicate;
	String name; // to get the name of user



	public Numbers(String name) // set name so we can call it
	{  
		this.name = name;
	}

	public String getName() {
		return name;
	}



	public void buildNumbers() // method that will generate unique random numbers from 1 to 100
	{ // generate random numbers // human board
		// for every cell i in the board
		for (int i = 0; i < board.length; ++i)
		{
			do
			{     // Generate a random number between MAX_VALUE and MIN_VALUE inclusive
				randomNumber = rand.nextInt((MAX_VALUE - MIN_VALUE) + 1) + MIN_VALUE;

				isDuplicate = false; // initialy, let's assume this is not a duplicate

				// check if this random value has already been inserted in the array in a previous cell
				for (int j = 0; j < i; ++j) {
					if (board[j] == randomNumber) {
						isDuplicate = true;
					}
				}
			}
			while (isDuplicate); // pick a new random number until we pick a non-duplicate
			board[i] = randomNumber;  // this random number is not a duplicate, assign it to the ith cell
		}
	    // sorting number in ascending order 
		for (int j = 0; j < board.length-1; j++)  {   
            int Min = j;    // Finding the smallest integer between the array   
             for (int scan = j+1; scan < board.length; scan++)      
                 if (board[scan] < board[Min])         
                 Min = scan;      // Swap the smallest number with position j      
             int temp = board[Min];     
             board[Min] = board[j];    
             board[j] = temp; }  
	}

	public int pickNumber() // a returning method that will allow user to pick his numbers
	{
		System.out.println("\nPick a number between 0 and 100 ");
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);

		return keyboard.nextInt();
	}

	public int[] pickComputerNumber(int size) // a method that allows the computer to generate 3 unique numbers (picking his numbers)
	{
		int[] numbers = new int[size];
		for (int i = 0 ; i<size ;i++)
		{
			numbers[i] = rand.nextInt((MAX_VALUE - MIN_VALUE) + 1) + MIN_VALUE;
		}
		return numbers;
	}


	public void buildBoard() // void method that prints the board 
	{
		int i;
		System.out.print("=========================================================================================");
		for ( i = 0; i < board.length; ++i) // 25 numbers   // split in to 5 
		{

			if (i% TABLE_SIZE ==0) // remainder of table size so that it can be a 5 by 5 otherwise it will be a long array
			{
				System.out.println();
			}

			System.out.print( "|\t" +  board[i] + " \t" );


		}
		System.out.println("\n=========================================================================================");
	}

	public void changeNumber(int targetNumber) // changes number to 0 human choice
	{
		int match = checkMatchNumber(targetNumber);
		if (match > -1) {
			board[match]=0;
		}

	}

	/**
	 * Check if number match any number in board
	 * 
	 * @param num - number to check
	 * 
	 * @return Matching position
	 */
	private int checkMatchNumber(int num) {
		int match = -1;
		for (int i =0; i< board.length; i++)
		{
			if (num == board[i] ) 
			{
				match = i;
				break;
			}  
		}
		return match;
	}



	public boolean isWinning(String name) // 
	{ 
		boolean win = false; // will check for all rows if there is a winning case.
		for (int i=0; i<=(TABLE_SIZE*(TABLE_SIZE -1));) { 
			win = checkHorizontal(i);
			if (win) {
				System.out.println(" Row Win Detected");
				System.out.println("\n" + name + " is the Winner!");
				return win;
			}
			i += (TABLE_SIZE);
		}

		for (int i=0; i<=(TABLE_SIZE-1); i++) {  // will check for all columns if there's a winning case.
			win = checkVertical(i);
			if (win) {
				System.out.println(" Column Win Detected");
				System.out.println("\n" + name + " is the Winner!");
				return win;
			}
		}

		win = checkDiagonal(); // will check the diagonal if winning case 
		if (win) {
			System.out.println(" Diagonal Win Detected");
			System.out.println("\n" + name + " is the Winner!");
		}

		return win;
	}

	// private method, because it is used within this class Numbers.  A public class will allow you to use the method in your main method.
	
	private boolean checkHorizontal(int i) // private method that will check a single row if it is all 0's
	{ 
		boolean result = true;
		for ( int j=i ; j<= (i+(TABLE_SIZE-1)) ; j++)
		{
			if (board[j] != 0 )
			{
				result = false;
				break;
			}

		}

		return result;

	}

	private boolean checkVertical(int i) // private method that will check a single column if it is all 0's
	{
		boolean result = true;
		for (int j=i ; j<= (i+(TABLE_SIZE*(TABLE_SIZE-1))) ;) 
		{
			if(board[j] !=0)
			{
				result = false;
				break;
			}
			j +=TABLE_SIZE;
		}

		return result;
	}

	private boolean checkDiagonal () // private method that will check a both diagonal if they are 0's
	{
		boolean result = true;
		for (int j=0 ; j<=((TABLE_SIZE*(TABLE_SIZE-1)) + (TABLE_SIZE-1));) 
		{
			if(board[j] !=0)
			{
				result = false;
				break;
			}

			j +=(TABLE_SIZE+1);
		}

		if (!result){
			result= true;

			for (int j=(TABLE_SIZE-1) ; j<=(TABLE_SIZE*(TABLE_SIZE-1));) {
				if(board[j] !=0)
				{
					result = false;
					break;
				}

				j +=(TABLE_SIZE-1);
			}
		}

		return result;

	}

}
