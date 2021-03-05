package lists;

public class LinkedList <T> implements List
{
	Node <T> linkedList;
	int index;
	
	public LinkedList()
	{
		this.index = 0;
	}
	
	@Override
	public boolean isEmpty() 
	{
		return index == 0;
	}

	@Override
	public boolean contains(Object item) 
	{
		Node<T> current = this.linkedList;
		
		while(current != null)
		{
			if (current.data == item)
			{
				return true;
			}
			current = current.next;
		}
		
		return false;
	}

	@Override
	public void add(Object item) 
	{
		this.linkedList = new Node<T>((T)item, this.linkedList);
		this.index++;
	}

	@Override
	public void insertAt(Object item, int index) 
	{
		checkIndex(index);
		//...
		
	}

	@Override
	public void removeFrom(int index) 
	{
		checkIndex(index);
		//...
	}

	@Override
	public void remove(Object item) 
	{
		Node<T> current = this.linkedList;
		
		while(current != null)
		{
			if (current.data == item)
			{
				//...
			}
			current = current.next;
		}
		
	}

	@Override
	public Object get(int index) 
	{
		checkIndex(index);
		//...
		return null;
	}

	@Override
	public void clear() 
	{
		//this.lastIndex = 0;
	}
	
	public void print()
	{
		Node<T> current = this.linkedList;
		
		while(current != null)
		{
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	private void checkIndex(int index)
	{
		if(index < 0)
			throw new IllegalArgumentException("index must be bigger than 0!");
		if(index > this.index)
			throw new IllegalArgumentException("index must be less than the length of list!");
	}
}
