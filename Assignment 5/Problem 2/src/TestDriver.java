import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestDriver
{

	public static void main(String[] args) throws FileNotFoundException
	{
		SortedArrayCollection<String> collection = new SortedArrayCollection<String>();
		
		File MyFile= new File("AnimalsPart.txt");
		Scanner file = new Scanner (MyFile);
		
		while(file.hasNextLine())
		{
			collection.add(file.nextLine());
		}
		file.close();
		
		System.out.println(collection.toString());
		
		System.out.println("Enter name of animal for which you want to count number of alphabatically later animals");
		System.out.println("Name>");
		
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine();
		
		input.close();
		System.out.println("Count of animals that are alphabetically later: "+ collection.greater(userInput));
		
	}

}
