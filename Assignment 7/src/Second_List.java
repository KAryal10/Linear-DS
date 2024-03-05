//----------------------------------------------------------------------------
// First_List.java             
//Kritan Aryal
//April 14, 2023
// 
//A sorted (alphabetically) linked list. This list should have shorter average search times,
//because once you’ve determined where a word should be, if it’s not there, there is no use
//in searching the rest of the list (if you’re trying to add “absolute”, and you reach
//“absolve”, you know that “absolute” isn’t in the list, and there’s no sense checking the
//remainder of the list). You do, however, have to create a new node and link it in between
//the two existing nodes (or perhaps this is a new first node, or a new last node – there will
//be multiple cases to consider for add). 
//----------------------------------------------------------------------------


public class Second_List extends BaseList
{

	//This method adds the parameter string in the list. If the parameter is null, it does nothing.
	//If the parameter is already in the list it just increases the number of count in the node.
	//If the parameter does not exist in the list, we create a new node in between two existing nodes
	//to maintain the order of list with count 1 and set the parameters word
	@Override
	public void add(String word)
	{
		if (word == null)
		{
			return;
		}
		LLNode pre = null;
		LLNode lln = this.list;
		while (lln != null)
		{
			this.keyCompare++;
			if (word.equals(lln.getWord()))
			{
				lln.setCount(lln.getCount() + 1);
				return;
			}
			if (word.compareTo(lln.getWord()) < 0)
			{
				break;
			}
			pre = lln;
			lln = lln.getNext();
		}
		LLNode node = new LLNode(word, 1, lln);
		if (pre == null)
		{
			this.list = node;
		} else
		{
			pre.setNext(node);
		}
		this.refChanges++;
	}

}
