import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class ApplicationProblem3
{
 public static void main(String[] args) throws FileNotFoundException
 {
	 ArrayCollection<String> collection = new ArrayCollection<String>(600);
	 ArrayCollection<String> userString = new ArrayCollection<String>();
		
		File MyFile= new File("Animals.txt");
		Scanner file = new Scanner (MyFile);
		
		while(file.hasNextLine())
		{
			collection.add(file.nextLine());
		}
		file.close();
		
		Scanner input = new Scanner(System.in);
		
		Random r = new Random();
		char c = (char)(r.nextInt(26) + 'A');
		
		String userInput="";
		int count = -1;
		
		System.out.println("Enter names of animals that begins with the character:" + c);
		do
		{
			System.out.println("Name> ");
			 userInput = input.nextLine();
			 count++;
			 if(userString.contains(userInput))
				 break;
			 else
				 userString.add(userInput);
			 
		}
		while(userInput.charAt(0)==c && collection.contains(userInput));
		
		System.out.println("You successfully entered "+count+" unique animal name(s) that begins with the character "+c+".");
		
		
 }
}
