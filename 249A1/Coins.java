
public class Coins {
	// Private instance variables that can only be accessed within this Class
	private  int nickels;
	private  int dimes;
	private  int quarters;
	private int loonies;
	private int toonies;
	
	/**
	 * Default empty constructor thats sets all variables to 0.
	 */
	public Coins()
	{
		nickels=0;
		dimes=0;
		quarters=0;
		loonies=0;
		toonies=0;	
	}
	
	/**
	 * Constructor with 5 specific values.
	 * 
	 * @param nickels - Specific nickel value
	 * @param dimes - Specific dimes value
	 * @param quarters - Specific quarters value
	 * @param loonies - Specific loonies value
	 * @param toonies - Specific toonies value
	 */
	public Coins ( int nickels,int dimes,int quarters,int loonies ,int toonies)
	{
		this.nickels=nickels;
		this.dimes=dimes;
		this.quarters = quarters;
		this.loonies= loonies;
		this.toonies = toonies;
	}
	
	/**
	 * 
	 * @param f - Object of type Coins passed into Constructor
	 */
	public Coins( Coins f)
	{
		nickels=f.nickels;
		dimes=f.dimes;
		quarters=f.quarters;
		loonies =f.loonies;
		toonies = f.toonies;
	}
	
	/**
	 * A Getter for each instance variable
	 * @return returns the number of nickels. Because nickel is a private instance, it needs a getter
	 */
	public int getNickel()
	{
		return nickels; 
	}
	public int getDimes()
	{
		return dimes;
	}
	public int getQuarters()
	{
		return quarters;
	}
	public int getLoonies()
	{
		return loonies;
	}
	public int getToonies()
	{
		return toonies;
	}
	
	/**
	 * Set nickel to specific value
	 * 
	 * @param nickels - Specific value of nickel
	 */
	public void setNickel(int nickels)
	{
		this.nickels = nickels;
	}
	
	/**
	 * Set dimes to specific value
	 * @param dimes - Specific value of dime
	 */
	public void setDimes(int dimes)
	{
		this.dimes = dimes;
	}
	
	/**
	 * Set quarters to specific value
	 * @param quarters - Specific value of quarter
	 */
	public void setQuarter(int quarters)
	{
		this.quarters = quarters;
	}
	
	/**
	 * Set loonies to specific value
	 * @param loonies - Specific value of loonie
	 */
	public void setLoonie(int loonies)
	{
		this.loonies = loonies;
	}
	
	/**
	 * Set toonies to specific value
	 * @param toonies - Specific value of toonie
	 */
	public void setToonie(int toonies)
	{
		this.toonies = toonies;
	}
	
	/**
	 * This is a method that does not return anything. This method will add additional coins in a certain Wallet.
	 * @param num_nickel - Additional nickel passed in  
	 * @param num_dimes - Additional dime passed in  
	 * @param num_quarters - Additional quarter passed in  
	 * @param num_loonies - Additional loonie passed in  
	 * @param num_toonies - Additional toonie passed in  
	 */
	public void addCoins(int num_nickel,int num_dimes,int num_quarters,int num_loonies ,int num_toonies)
	{
		// Adding the new number of coins to the original number of coins.
		this.nickels += num_nickel;
		this.dimes += num_dimes;
		this.quarters += num_quarters;
		this.loonies += num_loonies;
		this.toonies += num_toonies;
	
	}
	

	/**
	 * This method will return the total amount of money in the Wallet, by calculating the number of coins with the money value.
	 * @param num_nickel - Number of nickels
	 * @param num_dimes - Number of dimes
	 * @param num_quarters - Number of quarters
	 * @param num_loonies - Number of loonies
	 * @param num_toonies - Number of toonies
	 * @return
	 */
	public double coinsTotal(int num_nickel,int num_dimes,int num_quarters,int num_loonies ,int num_toonies)
	{
		double total = (double) (num_nickel*0.05 + num_dimes*0.1 + num_quarters*0.25 + num_loonies*1 + num_toonies*2);
		
		return total;
	
	}
	
	/**
	 * This is a to String method that will print out the coin distribution 
	 */
	
public String toString()

{
	
	return "\n" +nickels + " X 5¢ + " + dimes + " X 10¢ + " + quarters + " X 25¢ + " + loonies + " X 1$ + " + toonies + " X 2$ "; 
	

}

/**
 * A Boolean method that takes in a paramerter and checks if number of coins are equal.
 * @param obj1 - Object of type coin
 * @return- returns the result 
 */
public boolean CoinEquals(Coins obj1)
{
	if ( nickels==obj1.nickels && dimes == obj1.dimes && quarters == obj1.quarters && loonies == obj1.loonies &&
		toonies == obj1.toonies)
	{
		return true;
	}

	else return false;

}


}
