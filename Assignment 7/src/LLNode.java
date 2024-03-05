//----------------------------------------------------------------------------
// LLNode.java               
//
// Implements <T> nodes for a Linked List.
//----------------------------------------------------------------------------

public class LLNode
{
	private String word;
	private int count;
	protected LLNode next;

	public LLNode()
	{
		count = 0;
		next = null;
		word = null;
	}

	public LLNode(String words, int counter, LLNode nextNode)
	{
		word = words;
		count = counter;
		next = nextNode;
	}

	public String getWord()
	{
		return word;
	}

	public void setWord(String word)
	{
		this.word = word;
	}

	public int getCount()
	{
		return count;
	}

	public void setCount(int count)
	{
		this.count = count;
	}

	public LLNode getNext()
	{
		return next;
	}

	public void setNext(LLNode next)
	{
		this.next = next;
	}

}
