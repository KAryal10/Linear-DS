/*This is a class for the first hash*/
public class First_Hash extends BaseList
{

	LLNode[] firstNodes;
	final int size = 256;

	// Every element is a reference of LLNode and assigned to null in the beginning
	public First_Hash()
	{
		firstNodes = new LLNode[size];
		for (int i = 0; i < firstNodes.length; i++)
		{
			firstNodes[i] = null;
		}
	}

	// hash function
	public int hashing(String input)
	{
		String word = input.toLowerCase();
		int total = 0;
		for (int i = 0; i < word.length(); i++)
		{
			int value = (int) word.charAt(i);
			total += value;
		}
		return total % size;
	}

	@Override
	public void add(String word)
	{
		insert(word, hashing(word));
	}

	// returns the total number of words
	@Override
	public int getTotalWords()
	{
		int totalWords = 0;
		for (int i = 0; i < firstNodes.length; i++)
		{
			LLNode LLNode = firstNodes[i];
			while (LLNode != null)
			{
				totalWords += LLNode.getCount();
				LLNode = LLNode.getNext();
			}
		}
		return totalWords;
	}

	// returns the total number of unique words
	@Override
	public int getDistinctWords()
	{
		int totalWords = 0;
		for (int i = 0; i < firstNodes.length; i++)
		{
			LLNode LLNode = firstNodes[i];
			while (LLNode != null)
			{
				totalWords++;
				LLNode = LLNode.getNext();
			}
		}
		return totalWords;
	}

	// insert function for the hash
	protected void insert(String word, int hashValue)
	{
		int index = hashValue % size;

		if (firstNodes[index] == null)
		{
			firstNodes[index] = new LLNode(word, 1, null);
			refChanges++;
		} else
		{
			LLNode LLN = firstNodes[index];
			if (LLN.getWord().equals(word))
			{
				keyCompare++;
				LLN.setCount(LLN.getCount() + 1);
			} else
			{

				LLNode prev = find(word, LLN);
				LLNode curr = prev.getNext();

				if (curr == null)
				{
					LLNode node = new LLNode(word, 1, LLN);
					refChanges++;
					firstNodes[index] = node;
				} else
				{
					refChanges++;
					prev.setNext(curr.getNext());

					refChanges++;
					curr.setNext(LLN);
					curr.setCount(curr.getCount() + 1);

					refChanges++;
					firstNodes[index] = curr;
				}
			}
		}
	}

	private LLNode find(String word, LLNode head)
	{
		LLNode prev = null;
		LLNode curr = head;
		while (curr != null)
		{
			keyCompare++;
			if (curr.getWord().equals(word))
			{
				break;
			}
			prev = curr;
			curr = curr.getNext();
		}
		return prev;
	}
}
