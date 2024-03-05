public class StackDriver extends ArrayBoundedStack<String>
{

	public static void main(String[] args)
	{
		
		ArrayBoundedStack<String> myStack = new ArrayBoundedStack<String>();
		
		System.out.println(myStack.toString());
		
		System.out.println("[push] Lucy");
				
		myStack.push("Lucy");
		
		System.out.println("There are "+myStack.count()+ " elements in the stack:");
				
		System.out.println(myStack.toString());
				
		System.out.println("[push] Ricky Fred Ethel");
		
		myStack.push("Ricky");
		myStack.push("Fred");
		myStack.push("Ethel");
		
		System.out.println("There are "+myStack.count()+ " elements in the stack:");
				
		System.out.println(myStack.toString());
						
		System.out.println("[pop]");
				myStack.pop();
				
		System.out.println("There are "+myStack.count()+ " elements in the stack:");
				
		System.out.println(myStack.toString());
				
		System.out.println("[push] Ricky Jr.");
		myStack.push("Ricky Jr.");
		
		System.out.println("There are "+myStack.count()+ " elements in the stack:");
				
		System.out.println(myStack.toString());
				
		System.out.println("[swapStart]");	
		myStack.swapStart();
				
		System.out.println("There are "+myStack.count()+ " elements in the stack:");
				
		System.out.println(myStack.toString());
				
		System.out.println("[poptop]");
		System.out.println("Just popped: "+ myStack.poptop());
				
		System.out.println("There are "+myStack.count()+ " elements in the stack:");
				
		System.out.println(myStack.toString());
				
		
		System.out.println("[popSome] 2");	
				
		myStack.popSome(2);
		System.out.println("There are "+myStack.count()+ " elements in the stack:");
		
		System.out.println(myStack.toString());
	
		System.out.println("[pop]");
		myStack.pop();
		
		System.out.println(myStack.toString());
		
	}

}
