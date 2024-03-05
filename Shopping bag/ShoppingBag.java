
/*This is a class called ShoppingBag where all the methods to calculate total items,
 * total costs and tax info are written. 
 */

public class ShoppingBag {
	
	int number=0;	//declaring and initializing number which represents number of item in the bag to zero 
	double retailCost=0;		//declaring and initializing retailCost which represents total cost of item in the bag
	double tax ; //declaring tax which represents the percentage of tax to be added
	
	//Constructor that takes double value to represent the tax
	public ShoppingBag(double tax) {
		this.tax=tax;
	}
	
	// method to place the items in the bag which takes integer as the number of item and double as the cost of each item.
	//This method increases the number by the  integer it received in the parameter and increases the retailCost by the total cost of all items
	//it received in the parameter
	public void place(int number, double price) {
		this.number=this.number+number;
		retailCost=retailCost+(number*price);
	}
	
	//this method returns the total number of items in the bag
	public int getNumberOfItem() {
		return number;
	}
	
	//this method returns the total cost of all the items in the bag
	public double getRetaillCost() {
		return retailCost;
	}
	
	//this method returns the total cost of all the items in the bag including the tax
	//It is calculated by  multiplying total cost by 1+(tax/100)
	// here math.round() is used to get the rounded up value 
	public double totalCost() {
		double total = (double)Math.round((1+(tax/100))*retailCost*100)/100;
		return total;
	}
	
	//This method overrides the toSring() method and returns the message which include total number of items in the bag,
	//retail cost and the total cost
	@Override
	public String toString() {
		return "The bag contains "+number+" items. The retail cost of the items is $"+retailCost+".\n"
				+"The total cost of the items, including tax, is $"+totalCost();
	}
	
}
