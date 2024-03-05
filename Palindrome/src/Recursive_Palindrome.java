import java.util.*;

public class Recursive_Palindrome
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a string ('q' to quit):");
		String userInput=input.nextLine();
		userInput.replace(" ", "");
		
		while(!userInput.equals("q"))
		{
			
			if(isSameChar(userInput))
			{
				System.out.println("'"+userInput+"'"+" is a palindrome.\n");
			}
			else
			{
				System.out.println("'"+userInput+"'"+" is not a palindrome.\n");
			}
			
			System.out.print("Enter a string ('q' to quit):");
			userInput=input.nextLine();
			userInput.replace(" ", "");
			
		}
		
	}
	
	public static boolean isSameChar(String string)
	{
		boolean returnValue = false;
		int endValue = string.length()-1;
		int startValue = 0;
		
		if(startValue == endValue )
		{
			returnValue = true;
		}
		else if (startValue == endValue-1)
		{
			if(string.charAt(startValue)==string.charAt(endValue))
				returnValue =true;
			else 
				returnValue= false;
		}
		else
		{
			if(string.charAt(startValue)==string.charAt(endValue))
			{
				returnValue = isSameChar(string.substring(1,endValue));
			}
		}
		
		return returnValue;
	}

}
