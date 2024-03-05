//----------------------------------------------------------------
// ArrayBoundedStack.java
//
// Implements StackInterface using an array to hold the 
// stack elements.
//
// Two constructors are provided: one that creates an array of a 
// default size and one that allows the calling program to 
// specify the size.
//----------------------------------------------------------------
public class ArrayBoundedStack<T> implements StackInterface<T> 
{
  protected final int DEFCAP = 100; // default capacity
  protected T[] elements;           // holds stack elements
  protected int topIndex = -1;      // index of top element in stack

  public ArrayBoundedStack() 
  {
    elements = (T[]) new Object[DEFCAP];
  }

  public ArrayBoundedStack(int maxSize) 
  {
    elements = (T[]) new Object[maxSize];
  }

  public void push(T element)
  // Throws StackOverflowException if this stack is full,
  // otherwise places element at the top of this stack.
  {      
    if (isFull())
      throw new StackOverflowException("Push attempted on a full stack.");
    else
    {
      topIndex++;
      elements[topIndex] = element;
    }
  }

  public void pop()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise removes top element from this stack.
  {                  
    if (isEmpty())
      throw new StackUnderflowException("Pop attempted on an empty stack.");
    else
    {
      elements[topIndex] = null;
      topIndex--;
    }
  }

  public T top()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise returns top element of this stack.
  {                 
    T topOfStack = null;
    if (isEmpty())
      throw new StackUnderflowException("Top attempted on an empty stack.");
    else
      topOfStack = elements[topIndex];
    return topOfStack;
  }

  public boolean isEmpty()
  // Returns true if this stack is empty, otherwise returns false.
  {              
    return (topIndex == -1); 
  }

  public boolean isFull()
  // Returns true if this stack is full, otherwise returns false.
  {              
    return (topIndex == (elements.length - 1));
  }
  
  @Override
  public String toString()
  {
	  String newString = "";
	  String lineSeparator = "\n";
	  
	  StringBuilder toReturn = new StringBuilder (newString);
	  if(topIndex > -1)
	  {
		 
		  for (int i=topIndex;i>-1;i--)
		  {
			  toReturn.append(elements[i]);
			   
				   toReturn.append(lineSeparator);
			   
			  
		  }
		 
		  return toReturn.toString();
	  }
	  else
	  {
		  return "The stack is empty.";
	  }
	  
	 
  }
  
  public int count() 
  {
	  return topIndex+1;
  }
  
  public void popSome(int count) 
  {
	  if(elements.length < count)
		  throw new StackUnderflowException("Top attempted on an empty stack.");
	  else
		  for(int i=0;i<count;i++) 
		  {
			  elements[topIndex] = null;
		      topIndex--;
		  }
  }
  
  boolean swapStart() 
  {
	  if (elements.length<2)
	  {
		  return false;
	  }
	  else
	  {
		  T x =elements[topIndex];
		  elements[topIndex] = null;
	      topIndex--;
	      
		  T y =elements[topIndex];
		  elements[topIndex] = null;
	      topIndex--;
		  
	      topIndex++;
	      elements[topIndex] = x;
		
	      topIndex++;
	      elements[topIndex] = y;
		 
		 return true;
	  }
  }
  
  T poptop()
  {
	 T top = null;
	  if (isEmpty())
	      throw new StackUnderflowException("PopTop attempted on an empty stack.");
	    else
	      top = elements[topIndex];
	  elements[topIndex] = null;
      topIndex--;
	   
      return top;
	  
  }
}