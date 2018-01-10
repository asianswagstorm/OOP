import java.text.NumberFormat;
import java.util.*; // The * 
/**
 * COMP 249 Assignment 1
 * @author Andy Nguyen 7333870
 */

public class A1Driver {

	public static void main (String [] args)
	{
		Scanner keyboard = new Scanner(System.in);

		Wallet[] wal = new Wallet[5]; // creating 5 new objects of Array of type Wallet. For each of them we hardcode the information

		wal[0] = new Wallet(new Coins(1,3,5,7,2) , new CreditCard []  {new CreditCard("Discover" , "S. Weston" ,11,2023), 
			new CreditCard("MasterCard", "M. Hawke" ,4,2069) }); 

		wal[1] = new Wallet(new Coins(1,3,5,7,2) , new CreditCard [] {new CreditCard("Amex" , "E. Johnson" ,10,2019), 
			new CreditCard("Visa" , "J. Chan" ,7,2015) }); 

		wal[2] = new Wallet(new Coins(0,4,4,8,0) , new CreditCard [] {new CreditCard ("MasterCard" , "A. Smith" ,3,2017), 
			new CreditCard("Visa" , "J. Chan" ,7,2015), 
			new CreditCard("Discover" , "S. Weston" ,11,2023)} ); 

		wal[3] = new Wallet(new Coins(3,8,0,2,8)  , new CreditCard [] {} );

		wal[4] = new Wallet(new Coins(3,8,0,2,8)  ,new CreditCard [] {} );

		int choice;
		int walchoice;
		NumberFormat.getCurrencyInstance(); // using formatters so that the currency format can be displayed neatly.
		NumberFormat formatter = NumberFormat.getCurrencyInstance();

		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n Welcome to Andy's Wallet Application \n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

		//A do while loop that will keep executing until, the choice is = 0;
		do
		{
			System.out.println("\n What would you like to do? \n"
					+ "1. See the content of all wallets\n"
					+ "2. See the content of one wallet\n"
					+ "3. List wallets with same amount of money\n"
					+ "4. List wallets with same coins\n"
					+ "5. List wallets with same amount of money and same number of credit cards\n"
					+ "6. Add a credit card to an existing wallet\n"
					+ "7. Remove an existing credit card from a wallet\n"
					+ "8. Update the expiry date of an existing credit card\n"
					+ "9. Add coins to a wallet\n"
					+ "0. To quit\n"
					+ "Please enter your choice and press <Enter>: ");

			choice = keyboard.nextInt();
			while( choice >9 || choice <0) // a while loop that makes sure that the choices are obeyed.
			{
				System.out.println("Sorry that is not a valid choice. Try again.");
				choice = keyboard.nextInt();
			}
			switch(choice) // switch cases
			{



			case 1: //  See the content of all wallets
			{for(int i=0; i<wal.length ; i++)	
				System.out.println("\n In Wallet #" + i + "  \n" + wal[i]);
			break;
			}


			case 2: //  See the content of one wallet
			{      
				System.out.println(" Which wallet would you like to see wallet ? (Pick number between 0 and 4) ");
				walchoice=keyboard.nextInt();

				while( walchoice >4 || choice <0)
				{System.out.println("Sorry there is no such Wallet. Pick again.");
				walchoice = keyboard.nextInt();
				}

				System.out.println("\n In Wallet # " + walchoice + "\n" + wal[walchoice].toString());
				break;

			}

			case 3: //  List Wallets with same amount of money 
			{
				System.out.println("List of wallets with same amount of money:");


				for(int i=0 ; i<wal.length ;i++) // A for loop that will check if the total Value of the coins are the same for two wallets.
				{	for(int j=0; j<i ; j++)
				{
					if (wal[i].totalValue()  == wal[j].totalValue() )
					{
						System.out.println(" Wallet " + j +" and Wallet " + i + " both have " + formatter.format(wal[i].totalValue()) );
					}

				}
				}

				break;
			}


			case 4://  List wallet with same coins

			{
				System.out.println("List of wallets with same coins: " );
				for(int i=0 ; i<wal.length ;i++) // a nested for loop that checks if two wallets have the same coin distribution
				{	for(int j=i; j<wal.length ; j++)
				{
					if (wal[i].numCoinEqual(wal[j]) && i != j )  // i!=j is so that it does not repeat terms
					{
						System.out.println("\n Wallet " + i +" and Wallet " + j + " both have " + wal[i].coinBreakdown(wal[i]) );
					}

				}
				}

				break;
			}



			case 5://  List of Wallets with same amount of money. and same number of credit cards
			{
				System.out.println("List of wallets with same amount of money and same number of credit cards:");

				for(int i=0 ; i<wal.length ;i++)
				{	for(int j=i; j<wal.length ; j++)
				{
					if (wal[i].equals(wal[i], wal[j])  && i != j )  // 
					{
						System.out.println("\n Wallet " + i +" and Wallet " + j );
					}

				}
				}

				break;
			}

			case 6: // Works Perfectly Add Credit Card
			{ 
				System.out.print("Which wallet to you want to add a credit card to? (Enter number 0 to 4): ");

				walchoice=keyboard.nextInt();

				while( walchoice >4 || choice <0)
				{System.out.println("Sorry there is no such Wallet. Pick again.");
				walchoice = keyboard.nextInt();
				}

				System.out.print("\nPlease enter the following information so that we may complete the transaction");
				System.out.print("\nType of credit card (Mastercard, Visa, etc ..):");	
				String type= keyboard.next();
				System.out.print("\nFull name on credit card:");
				String first_name =keyboard.next();
				String last_name = keyboard.next();
				String full_name = first_name + " " + last_name;
				System.out.print("\n Expiry month number and year (followed by a space ) \n"); 

				String month = keyboard.next(); // we use .next(), because it will hold the string length until there is a space. 
				String year = keyboard.next();

				int year1 = Integer.parseInt(year); // the parse int is used to convert the numbers of a string into an integer
				int month1 = Integer.parseInt(month);

				CreditCard someCard = new CreditCard(type,full_name, month1, year1 ); // creat new object credit card that holds these variables.

				wal[walchoice].addCard(someCard);

				System.out.print("\nYou now have "  +  wal[walchoice].numCards()   + " credit cards \n");
				break;
			}

			case 7: // removes a Credit Card from a Wallet

			{
				int cardChoice;
				System.out.print("Which wallet do you want to remove a credit card from? (Enter number 0 to 4):" );
				walchoice= keyboard.nextInt();


				while( walchoice >4 || walchoice <0)
				{System.out.println("Sorry there is no such Wallet. Pick again.");
				walchoice = keyboard.nextInt();
				}


				while ( wal[walchoice].numCards() == 0)
				{
					System.out.println("\n Sorry this Wallet does not have any Credit Cards. Pick another Wallet" );
					walchoice = keyboard.nextInt();
				}

				System.out.print("\n This wallet has " + wal[walchoice].numCards() + " credit cards which one would you like to remove? (Enter number 0 to " + (wal[walchoice].numCards() -1) +" )" );
				cardChoice = keyboard.nextInt();

				wal[walchoice].removeCard(cardChoice);

				System.out.println(" Card was removed successfully ");
				break;
			}


			case 8: // Update expirery date 
			{
				int cardUpdate;
				int month;
				int year;

				System.out.print("Which wallet do you want to update a credit card from? (Enter number 0 to 4):");

				walchoice= keyboard.nextInt();

				while( walchoice >4 || walchoice <0)
				{System.out.println("Sorry there is no such Wallet. Pick again.");
				walchoice = keyboard.nextInt();
				}

				while ( wal[walchoice].numCards() == 0)
				{
					System.out.println("\n Sorry this Wallet does not have any Credit Cards. Pick another Wallet" );
					walchoice = keyboard.nextInt();
				}


				System.out.print("\n Which card to you want to update? :(Pick 0 to " + (wal[walchoice].numCards()-1) + ")" );
				cardUpdate= keyboard.nextInt();
				while( cardUpdate >wal[walchoice].numCards()-1 ||cardUpdate <0 ) // length of card array
				{System.out.print("Sorry there is no card # " + cardUpdate + " Please pick another. :");
				cardUpdate= keyboard.nextInt();
				}

				System.out.print("\n  Enter new expiry month number and year (separate by a space): ");
				String m = keyboard.next(); 
				String y = keyboard.next();
				month = Integer.parseInt(m);
				year = Integer.parseInt(y);

				wal[walchoice].expireDate(cardUpdate,month,year);
				System.out.print("\n Expiry date updated. \n");

				break;

			}

			case 9: // Works Perfectly
			{

				System.out.println("Which Wallet's Coin would you like to add to? Wallets' 0, 1, 2, 3 or 4 ?");
				walchoice=keyboard.nextInt();

				System.out.println("How many nickels, dimes, quarters, loonies and toonies do you want to add?\n (Enter 5 numbers separated by a space): ");
				String nickel= keyboard.next();
				String dime= keyboard.next();
				String quarter= keyboard.next();
				String loonie= keyboard.next();
				String toonie= keyboard.next();
				
// use string so can input with a space. then parse the string into an integer. 
				int n = Integer.parseInt(nickel);
				int d= Integer.parseInt(dime);
				int q= Integer.parseInt(quarter);
				int l= Integer.parseInt(loonie);
				int t = Integer.parseInt(toonie);
				wal[walchoice].Add_Coins(n,d,q,l,t);//Do you need to use the Setter? 
				double moneyTotal= wal[walchoice].totalValue();
				System.out.println(" You now have " + formatter.format(moneyTotal) );
				break;
			}
			}
		}
		while (choice !=0);
		keyboard.close(); // close the Scanner to prevent ressource leaks.


	}
}



