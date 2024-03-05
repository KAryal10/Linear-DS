//----------------------------------------------------------------------
// Towers.java   
//
// Driver class for doTowers method that gets initial values and
// calls the method.
//----------------------------------------------------------------------

import java.util.Scanner;

public class Towers
{
	public static int count = 0;

  public static void doTowers(
         int n,              // Number of rings to move
         int startPeg,       // Peg containing rings to move
         int auxPeg,         // Peg holding rings temporarily
         int endPeg )   // Peg receiving rings being moved
  		
  {
	
    if (n == 1) // Base case - Move one ring
    {
    	count++;
    	
    }
    	
    else
    {
      // Move n - 1 rings from starting peg to auxiliary peg
      doTowers(n - 1, startPeg, endPeg, auxPeg);
     
 count++;
      // Move n - 1 rings from auxiliary peg to ending peg
      doTowers(n - 1, auxPeg, startPeg, endPeg);
     
    }
  }

  public static void main(String[] args)
  {

    Scanner conIn = new Scanner(System.in);
    // Number of rings on starting peg.
    int n;       
    do
    {
    	System.out.print("Input the number of rings(0 to stop) : ");
        if (conIn.hasNextInt())
          n = conIn.nextInt();
        else
        {
          System.out.println("Error: you must enter an integer.");
          System.out.println("Terminating program.");
          return;
        }
        
        if (n < 1)
        {
          System.out.println("Error: you must enter an integer >= 1.");
          System.out.println("Terminating program.");
          return;
        }
        
        System.out.println("Towers of Hanoi with " + n + " rings\n");
        doTowers(n, 1, 2, 3);
        System.out.println("Number of moves: " + count +"\n");
        count=0;
    }
    while(n!=0);
  }
}