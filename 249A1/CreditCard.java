
public class CreditCard {
	/**
	 * Instance Variables for Class CreditCard
	 */
	private String type; // Private instance variables that can only be accessed within this Class
	private String name;
	private int month;
	private int year;

	/**
	 * Default Constructor that sets all values to 0 or null.
	 */
	public CreditCard()
	{
		type = null;
		name = null;
		month= 0;
		year = 0;		
	}
	/**
	 * Constructor with 4 parameters.
	 * @param type - The type of Credit Card 
	 * @param name - The name of the Card Owner
	 * @param month - The expirery Month
	 * @param year - The expirery Year
	 */
	public CreditCard(String type, String name, int month, int year)
	{
		this.type= type;
		this.name= name;
		if (month < 1 && month > 12 )
			this.month=0;
		else
			this.month=month;

		this.year= year;
	}

	/**
	 * This is a copy Constructor with Parameter w. 
	 * @param w type credit card that is going to take values of original credit card
	 */

	public CreditCard(CreditCard w)
	{
		type=w.type;
		name=w.name;
		month=w.month;
		year=w.year;
	}

	/**
	 * A getter that gets the type of card.
	 * @return - the type of card
	 */
	public String getType()
	{ 
		return type;
	}
	/**
	 * A getter that gets the name of the card owner.
	 * @return - the name of the card owner
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * A getter that gets the expirery month of the card.
	 * @return - the expire month
	 */
	public int getMonth()
	{
		return month;
	}
	/**
	 * A getter that gets the expirery year of the card.
	 * @return - the expire year
	 */
	public int getYear() 
	{
		return year;
	}
	/**
	 * A setter for the expirery month.
	 * @param month - the expirery month of the card 
	 */
	public void setMonth(int month)
	{
		this.month=month;
	}
	/**
	 * A setter for the expirery year.
	 * @param year - the expirery year of the card
	 */
	public void setYear(int year)
	{
		this.year=year;
	}
	/**
	 * A setter for the type of card.
	 * @param type- the type of the credit card
	 */
	public void setType(String type)
	{
		this.type= type;
	}
	/**
	 * A setter for the name. Will set a new name.
	 * @param name - the name of the card holder
	 */
	public void setName(String name)
	{
		this.name= name;
	}
	/**
	 * toString method that will display the information of the card.
	 */
	public String toString()
	{

		if (month<10) // if the month number is less than 10 , it is preceded by a zero.
		{
			return  type + "-" + name  + "- 0"+month + "/" + year + "\n";
		}


		else
			return type + "-" + name  + "- "+month + "/" + year + "\n";


	}
	/**
	 * Boolean method that checks if the contents of two credit Cards are equal.
	 * @param z - object1 of type CreditCard
	 * @param f - object2 of type CreditCard
	 * @return - will return truth value of the cards.
	 */
	public boolean equals(CreditCard z, CreditCard f) 
	{
		if ( z==f)
			return true; 
		else 
			return false;

	}


}
