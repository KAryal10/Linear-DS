/*Assignment 1
 * Kritan Aryal
 * 
 * This is the the application for the assignment 1 where we get information about the items in the shopping bag and 
 * we return the value of number of items, total cost and total cost with tax to the user. This class only has the application 
 * and all the methods are in another class called ShoppingBag
 */

import java.util.Scanner;

public class ShoppingBagApplication
{
	public static void main (String [] args) {
		int numberOfItem=0; //	Declaring an integer called nuberOfItem which represents the number of item user is putting in the bag 
		double costOfItem=0; // Declaring a double called costOfItem which represents the cost per item being put in the bag
		
		ShoppingBag myBag =new ShoppingBag(6);//Creating a ShoppingBag object called myBag with the parameter 6 which represents the tax percentage
		
		// Creating a Scanner object called input to take input from user
		Scanner input = new Scanner(System.in);// 
		
		//Creating a loop which will first ask the user for number of item and cost of item and exits the loop if number of item is zero 
		do {
				System.out.println("Enter count (use 0 to stop):"); //prompts user to enter the number of item
				numberOfItem= input.nextInt(); //assign the next integer value entered by user to the numberOfItem
				
				//if number of item is zero, exit the loop
				if(numberOfItem == 0) {
					break;
				}
				
				System.out.println("Enter cost: "); // 	prompts user to enter the cost per item
				costOfItem=input.nextDouble(); //	assign the next double value to costOfItem
				
				myBag.place(numberOfItem,costOfItem); //	call place(integer, double) method in the myBag object
			}
			while(numberOfItem!=0);
		
		//closing scanner object called input
		input.close();	
		
		//Print the result of myBag object (this will call toString method in myBag)
		System.out.println(myBag);
		}
	
}
