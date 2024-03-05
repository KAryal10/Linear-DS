//----------------------------------------------------------------------------
// First_List.java             
//Kritan Aryal
//April 14, 2023
// 
//An unsorted linked list, in which additions always occur at the beginning (i.e., when a
//word read from the file is not already in the list, a new node, containing the word and a 
//count of 1, becomes the list's first new node). This approach does the least amount of
//work on an addition. Obviously, in order to determine whether or not a word just read is
//on the list, you’ll have to start at the beginning of the list, and traverse the list until you
//either find the word, or reach the end of the list (indicating “not found”).
//----------------------------------------------------------------------------

public class First_List extends BaseList
{
	//This method adds the parameter string in the list. If the parameter is null, it does nothing.
	//If the parameter is already in the list it just increases the number of count in the node.
	//If the parameter does not exist in the list, we create a new node with count 1 and set the parameter as word
	@Override
	public void add(String word)
	{
		if (word == null)
		{
			return;
		}
		LLNode lln = search(word);
		if (lln == null)
		{
			LLNode node = new LLNode(word, 1, this.list);
			this.list = node;
			this.refChanges++;
		} else
		{
			lln.setCount(lln.getCount() + 1);
		}
	}

	
	//In this method we check if the word already exist in the list return true if it does else it return false.
	private LLNode search(String word)
	{
		LLNode lln = this.list;
		while (lln != null)
		{
			this.keyCompare++;
			if (word.equals(lln.getWord()))
			{
				return lln;
			}
			lln = lln.getNext();
		}
		return null;
	}
}
