package lists;

public class LinkedList <T> implements List
{
	Node <T> linkedList;
 
	@Override
	public boolean isEmpty() // O(1)
	{
		return this.linkedList == null;
	}

	@Override
	public boolean contains(Object item) // O(n)
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
	public void add(Object item) // O = 1
	{
		this.linkedList = new Node<T>((T)item, this.linkedList);
	}

	@Override
	public void insertAt(Object item, int index) // O(2n)
	{
		Node<T> nextNode = (Node<T>) this.get(index - 1); // O(n)
		Node<T> newNode = new Node<T>((T)item, nextNode);
		Node<T> current = (Node<T>) this.get(index); // O(n)
		
		current.next = newNode;
		
		return;
	}

	@Override
	public void removeFrom(int index) // O(7n)
	{
		Node<T> element = (Node<T>) this.get(index); // O(3n)
		
		int lenght = this.getLastIndex(); // O(n)
		
		if (index == lenght)
		{
			if (lenght == 1)
			{
				this.linkedList = null;
			}
			else 
			{
				this.linkedList = (Node<T>) this.get(index - 1); // O(3n)
			}
		}
		else
		{
			Node<T> previous = (Node<T>) this.get(index + 1); // O(3n)
			previous.next = element.next;
		}
		
		return;
	}

	@Override
	public void remove(Object item) // O(9n)
	{
		Node<T> current = this.linkedList;
		
		int index = this.getLastIndex(); // O(n)
		
		if (this.contains(item)) 
		{
			while(current != null && current.data != item) // O(n)
			{
				current = current.next;
				index--;
			}
			this.removeFrom(index); // O(7n)
		}
		else 
		{
			throw new IllegalArgumentException("The list doesn't contains this item");
		}
	}

	@Override
	public T get(int index) // O(3n)
	{
		checkIndex(index); // O(n)
		
		Node<T> currentNode = linkedList;
		
		int lenght = this.getLastIndex(); // O(n)
		
		while(lenght != index) // O(n)
		{
			currentNode = currentNode.next;
			lenght--;
		}
		
		return (T) currentNode.data;
	}

	@Override
	public void clear() // O(1)
	{
		this.linkedList = null;
	}
	
	public int getLastIndex() // O(n)
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
	
	public void print() // O(n)
	{
		Node<T> current = this.linkedList;
		
		while(current != null)
		{
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	private void checkIndex(int index) // O(n)
	{
		int lenght = this.getLastIndex(); // O(n)
		
		if(index < 0) 
			throw new IllegalArgumentException("index must be bigger than 0!");
		
		if(index > lenght)
			throw new IllegalArgumentException("index must be less than the length of list!");
	}
}
