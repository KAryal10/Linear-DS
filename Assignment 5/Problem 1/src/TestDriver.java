import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestDriver
{
	public static void main(String[] args) throws FileNotFoundException
	{
		ArrayCollection<String> collection = new ArrayCollection<String>();
		
		File MyFile= new File("AnimalsPart.txt");
		Scanner file = new Scanner (MyFile);
		
		while(file.hasNextLine())
		{
			collection.add(file.nextLine());
		}
		file.close();
		
		System.out.println(collection.toString());
		
		System.out.println("Enter the name of animal you want to count:");
		System.out.println("Name> ");
		
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine();
		
		System.out.println("The animal name "+userInput+" appears "+collection.count(userInput)+ " times.");
		
		System.out.println("Enter the name of animal you want to remove:");
		System.out.println("Name> ");
		
		String userInput2=input.nextLine();
		collection.removeAll(userInput2);
		
		input.close();
		
		System.out.println("The collection after removing.");
		System.out.println(collection.toString());
		
	}
}
