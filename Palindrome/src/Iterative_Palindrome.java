import java.util.Scanner;

public class Iterative_Palindrome
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a string ('q' to quit):");
		String userInput=input.nextLine();
		userInput.replace(" ", "");
		while(!userInput.equals("q"))
		{
			
			if(isPalindrome(userInput))
			{
				System.out.println("'"+userInput+"'"+" is a palindrome.\n");
			}
			else
			{
				System.out.println("'"+userInput+"'"+" is not a palindrome.\n");
			}
			
			System.out.print("Enter a string ('q' to quit):");
			userInput=input.next();
		}
		
	}
	
	public static boolean isPalindrome(String string)
	{
		boolean returnValue = false;
		
		int endValue = string.length();
		int startValue = 0;
		
		while(endValue > startValue)
		{
			
			if(string.charAt(startValue) == string.charAt(endValue-1))
			{
			 startValue++;
			 endValue--;
			 
			 returnValue = true;
			}
			else if(endValue==1) 
			{
				System.out.println("Enter a valid word");
			}
			else
			{
				returnValue = false;
				break;
			}
		
		}	
		
		return returnValue;
	}

}
