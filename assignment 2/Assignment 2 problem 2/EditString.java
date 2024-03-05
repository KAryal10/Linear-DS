
public class EditString extends ArrayBoundedStack<String>
{

	public static void main(String[] args)
	{
		//create a stack to store the variables
		ArrayBoundedStack<String> myStack = new ArrayBoundedStack<String>();
		
		// string variable called sentence to store the changed values in the process
		String sentence;
		
		//implementing the push function and printing
		myStack.push("All dogs go to heaven");
		System.out.println(myStack.toString());
		
		//U changes all the letters to uppercase
		System.out.println("U");
		String sentence1= myStack.top();
		sentence1 = sentence1.toUpperCase();
		myStack.push(sentence1);
		
		//R reverses the sentence 
		System.out.println("R");
		StringBuilder sentence2= new StringBuilder (myStack.top());
		sentence = sentence2.reverse().toString();
		myStack.push(sentence);
		
		//Z undos the recent change
		System.out.println("Z");
		myStack.swapStart();
		
		//C O A replaces all O with A
		System.out.println("C O A");
		sentence = myStack.top();
		sentence= sentence.replace('O','A');
		myStack.push(sentence);
		
		// C A t replaces all A with t
		System.out.println("C A t");
		sentence = myStack.top();
		sentence= sentence.replace('A','t');
		myStack.push(sentence);

		//X stops the program and displays the final output
		System.out.println("X");
		System.out.println(myStack.top());
	}

}
