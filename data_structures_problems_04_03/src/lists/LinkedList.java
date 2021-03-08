package lists;

public class LinkedList <T> implements List
{
	Node <T> linkedList;
 
	@Override
	public boolean isEmpty() 
	{
		return this.getLastIndex() == 0;
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
	}

	@Override
	public void insertAt(Object item, int index)
	{
		Node<T> nextNode = (Node<T>) this.get(index - 1);
		Node<T> newNode = new Node<T>((T)item, nextNode);
		Node<T> current = (Node<T>) this.get(index);
		
		current.next = newNode;
		
		return;
	}

	@Override
	public void removeFrom(int index) 
	{
		Node<T> element = (Node<T>) this.get(index);
		
		int lenght = this.getLastIndex();
		
		if (index == lenght)
		{
			this.linkedList = (Node<T>) this.get(index - 1);
		}
		else
		{
			Node<T> previous = (Node<T>) this.get(index + 1);
			previous.next = element.next;
		}
		
		return;
	}

	@Override
	public void remove(Object item) 
	{
		Node<T> current = this.linkedList;
		
		int index = this.getLastIndex();
		
		if (this.contains(item))
		{
			while(current != null && current.data != item)
			{
				current = current.next;
				index--;
			}
			this.removeFrom(index);
		}
		else 
		{
			throw new IllegalArgumentException("The list doesn't contains this item");
		}
	}

	@Override
	public T get(int index) 
	{
		checkIndex(index);
		
		Node<T> currentNode = linkedList;
		
		int lenght = this.getLastIndex();
		while(lenght != index)
		{
			currentNode = currentNode.next;
			lenght--;
		}
		
		return (T) currentNode;
	}

	@Override
	public void clear() 
	{
		int index = this.getLastIndex();
		while(index > 0)
		{
			this.removeFrom(index);
			index--;
		}
	}
	
	public int getLastIndex()
	{
		Node<T> current = this.linkedList;
		int counter = 0;
		
		while(current != null)
		{
			counter++;
			current = current.next;
		}
		return counter;
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
		int lenght = this.getLastIndex();
		
		if(index < 0)
			throw new IllegalArgumentException("index must be bigger than 0!");
		
		if(index > lenght)
			throw new IllegalArgumentException("index must be less than the length of list!");
	}
}
