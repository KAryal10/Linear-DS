
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//----------------------------------------------------------------------------
//           
//Kritan Aryal
//April 26, 2023
//
//This is the main class where we create two Hash. We read the word from text file store it in both the Hash.
//We then compare the time taken to store all the word in both the lists and the total number of key comparisons
//We then print the run time, vocabulary, Total words, and number of key comparisons of both the list in tabular form.
//----------------------------------------------------------------------------
public class MainClass
{

	public static void main(String[] args) throws FileNotFoundException
	{
		ListInterface[] Lists = new ListInterface[4];// By creating the lists as an
		// array, we can iterate with a subscript
		Lists[0] = new First_List();// Unsorted, insertions at beginning, no self-
		//optimization
		Lists[1] = new Second_List(); // Sorted linked list
		Lists[2]= new First_Hash();// First Hash
		Lists[3]= new Second_Hash();// Second Hash
		String[] ListNames = {"List1", "List2","Hash1","Hash2"};
		
		float timeDifference; 
		
		String fileName="Hamlet.txt";
		
		System.out.printf("%4s %14s  %14s %14s %14s   %14s\n", "#", "Hash Name", "Run Time", "Vocabulary",
				"Total Words", "Key Comp");
		System.out.printf("---- --------------- ----------- -------------- ----------- ------------\n");

		for (int i = 0; i < ListNames.length; i++)
		{
			long begin = System.currentTimeMillis();
			File file = new File(fileName);
			Scanner input = new Scanner(file);
			while (input.hasNext())
			{
				add(Lists[i], input.next());
			}
			input.close();
			long end = System.currentTimeMillis();

			 timeDifference = (float) ((end - begin) / 1000.0);

			System.out.printf("%4s %14s  %14s %14s %14s   %14s\n", i + 1, ListNames[i], timeDifference,
					Lists[i].getDistinctWords(), Lists[i].getTotalWords(), Lists[i].getKeyCompare());
		}

	}

	//In this method we check if the word contains punctuation and trim the leading and trailing punctuation and store the word
	//in the list by converting it to lower case.
	private static void add(ListInterface List, String word)
	{

		String punctuations = "!@#$%^&*()_+-=[]\\{}|;':\"`~,./<>?";

		int left = 0;
		int right = word.length() - 1;
		for (int i = 0; i < word.length(); i++)
		{
			String check = word.charAt(i) + "";
			if (punctuations.contains(check) == false)
			{
				break;
			}
			left++;
		}

		for (int i = right; i>=0; i--)
		{
			String check = word.charAt(right) + "";
			if (punctuations.contains(check) == false)
			{
				break;
			}
			right--;
		}

		String finalWord = "";
		for (int i = left; i <= right; i++)
		{
			finalWord += word.charAt(i);
		}

		finalWord = finalWord.toLowerCase();
		if (finalWord.length() > 0)
		{
			List.add(finalWord);
		}
	}

}
