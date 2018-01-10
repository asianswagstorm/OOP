
public class Wallet {

	/** 
	 * Instance variables for the Class Wallet
	 */
	private CreditCard[] cards; // instance variable called "cards" of type CreditCard which is an Array
	private Coins coin; // instance variable called "coin" of type Coins
	

	/**
	 * Default Constructor that sets the instance variables to 0 or empty.
	 */
	public Wallet() 
	{
		cards = new CreditCard[]{};
		coin = new Coins();
	}
	/**
	 * A copy constructor .
	 * @param r - an onject of type Coins
	 * @param q - an object or array of type CreditCard
	 */
	public Wallet(Coins r, CreditCard [] q)
	{

		coin =new Coins(r);
		cards= new CreditCard[q.length] ;

		for(int i =0; i<q.length ; i++) // a for loop that will set the contents of the cards array into another array 

		{
			cards[i] = new CreditCard(q[i]); 
		}
	}

	/**
	 * This method will check if the dollar amount in the wallet are the same
	 * @param coin1 - Object1 of type Wallet
	 * @param coin2- Object2 of type Wallet
	 * @return - the result 
	 */
	public boolean coinTotalEquals(Wallet coin1, Wallet coin2) //1
	{
		if( coin1.equals(coin2))
			return true;
		else 
			return false;
	}
	/**
	 * This method will check if two wallets have the same amount of coins
	 * @param a - object of type Wallet
	 * @return - the result
	 */
	public boolean numCoinEqual(Wallet a)
	{if (a.coin.CoinEquals(coin))
		return true;
	else 
		return false;
	}
	/**
	 * This method will return the amount of money in a Wallet.
	 * @return the total value of all the coins together.
	 */
	public double totalValue()
	{	
		return coin.coinsTotal(coin.getNickel(),coin.getDimes() , coin.getQuarters() , coin.getLoonies(), coin.getToonies());
	}
	/**
	 * This method will return the number of cards in a Wallet.
	 * @return - the number of cards
	 */
	public int numCards()
	{
		return cards.length;
	}

	/**
	 * This Method will add a credit card to an existing Wallet.
	 * @param card1 - A new object type CreditCard that will be added to a Wallet
	 * @return - Will return the number of cards in the Wallet including the additional card
	 */
	public int addCard(CreditCard card1)
	{

		int num = numCards(); // returns number of cards in the array


		if (num==0) // if the number of cards =0, then a card will be automatically added
		{CreditCard card11 []= new CreditCard[1]; // a new object of Array is created 
		card11[0]= new CreditCard(card1); // 
		cards=card11;
		return 1;
		}

		else
		{CreditCard [] card11= new CreditCard[cards.length+1]; // create a new Object of Array 1 size greater.


		for(int i=0; i<cards.length ; i++) // A for loop that takes in the contents of the old array and puts it into the new array
		{
			card11[i]=cards[i]; 
		}


		card11[cards.length]= new CreditCard(card1); //// 
		cards=card11;

		return cards.length;
		}
	}
	/**
	 * This method Will remove a credit card 
	 * @param ind - The location of in the Credit Card Array that you wish to remove
	 * @return - return true if the card was removed, false if the card was not removed.
	 */
	public boolean removeCard(int ind) 
	{

		CreditCard [] new_card = new CreditCard[cards.length-1]; // make a new array that is smaller by 1 position
		if (cards.length > 0) // if the wallet contains a credit card we remove it 
		{
			int j = 0; // j is the index of position of the new array
			for (int i =0; i<cards.length ; i++)
			{
				if (i == ind )
					continue;
				new_card[j] = cards[i]; // copying the content in one array into another
				j++; // increment the position

			}
			cards = new_card; // referencing the array cards into the array new_card
			return true;
		}
		else 
			return false;
	}
	/**
	 * This method will update the expirery date of an existing card.
	 * @param i - the location of the credit card Array. i.e the card you wish to update
	 * @param month - the expirery month of the card
	 * @param year - the expirery year of the card
	 */
	public void expireDate(int i,int month, int year)

	{
		cards[i].setMonth(month) ; // at position i, a new expirery month is set
		cards[i].setYear(year); // at position i, a new expirery year is set
	}

	/**
	 * This method will add coins to an existing Wallet.
	 * @param num_nickel - the addtional nickels being added
	 * @param num_dimes - the addtional dimes being added
	 * @param num_quarters - the addtional quarters being added
	 * @param num_loonies - the addtional loonies being added
	 * @param num_toonies - the addtional toonies being added
	 * @return - the new total Value of the Coins
	 */
	public double Add_Coins(int num_nickel,int num_dimes ,int num_quarters ,int num_loonies  ,int num_toonies ) 
	{

		coin.addCoins(num_nickel,num_dimes , num_quarters , num_loonies, num_toonies); 
		// using the parameters into the addCoins method from the Coins Class to add the coins


		return coin.coinsTotal(num_nickel, num_dimes, num_quarters, num_loonies, num_toonies); // return the new total value 
	}

	/**
	 * This method will check if the contents of two Wallets are the same (same total, same cards) 
	 * @param obj1 - The first object of type Wallet
	 * @param obj2 - The second object of type Wallet
	 * @return - the true if they are equal else return false.
	 */
	public boolean equals(Wallet obj1, Wallet obj2) //case 5
	{
		if(obj1.totalValue() == obj2.totalValue() && obj1.numCards() == obj2.numCards())
			return true;

		else return false;
	}
	/**
	 * A toString method that will display the full contents of a Wallet.
	 */
	public String toString()
	{
		String s = coin.toString();

		s += "\n";

		if (cards.length==0) { // if the size of the cards array is empty this means that there are no cards in this Array
			s += "No Credit Cards ";

		}
		else { 
			for (int i =0; i< cards.length; i++)  
			{
				s += cards[i].toString() ;


			}
		}

		return s;	

	}


	/**
	 * A method that will display the breakdown of coins in a Wallet
	 * @param obj -The Object of Type Wallet
	 * @return - a String that returns the breakdown of coins
	 */

	public String coinBreakdown(Wallet obj)
	{
		return obj.coin.toString();
	}

}
