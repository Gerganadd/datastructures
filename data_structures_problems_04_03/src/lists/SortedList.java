package lists;

public class SortedList <T extends Comparable<T>> implements List<T>
{
	Node<T> next;
	int lenght;

	@Override
	public boolean isEmpty() //O(1)
	{
		return this.next == null;
	}

	@Override
	public boolean contains(T item) //O(n)
	{
		return this.findPreviousNode(item) != null;
	}

	@Override
	public void add(T item) //O(n)
	{	
		// if it's the first or less than first 
		if (this.lenght == 0 || item.compareTo(next.data) <= 0) 
		{
			this.next = new Node<T>((T)item, this.next);
			this.lenght++;
			return;
		}
		
		//find position
		Node<T> current = this.next;
		
		while (current.next != null && item.compareTo(current.next.data) >= 0)
		{
			current = current.next;
		}
		
		current.next = new Node<T>(item, current.next);
		lenght++;
		
	}

	@Override
	public void insertAt(T item, int index) {}

	@Override
	public void removeFrom(int index) // O(n)
	{
		checkIndex(index);
		
		int currentIndex = this.lenght;
		Node<T> current = this.next;
		
		if (index == this.lenght) // remove first element
		{
			this.next = next.next;
			return;
		}
		
		while (currentIndex != (index + 1))
		{
			current = current.next;
			currentIndex--;
		}
		
		current.next = current.next.next;
	}

	@Override
	public void remove(T item) // O(n)
	{
		Node<T> previous = this.findPreviousNode(item); //O(n)
		
		if (previous == null)
		{
			throw new IllegalArgumentException("SortedList doesn't contains this item");
		}
		
		if (previous.data.compareTo(item) == 0)
		{
			this.next = next.next;
			return;
		}
		
		previous.next = previous.next.next;
		
	}

	@Override
	public T get(int index) // O(n)
	{
		checkIndex(index);
		Node<T> currentNode = this.next;
		int currentIndex = this.lenght;
		
		while(currentIndex != index) // O(n)
		{
			currentNode = currentNode.next;
			currentIndex--;
		}
		
		return (T) currentNode.data;
	}

	@Override
	public void clear() //O(1)
	{
		this.next = null;
	}
	
	private Node<T> findPreviousNode(T item) // O(n)
	{
		Node<T> previous = this.next;
		Node<T> current = previous;
		
		while(current != null)
		{
			if (current.data == item)
			{
				return previous;
			}
			
			previous = current;
			current = current.next;
		}
		
		return null;
	}
	
	private Node<T> findPositions(T item) // change name
	{
		Node<T> current = this.next;
		
		while (current != null && current.next != null)
		{
			if (((T)current.next.data).compareTo(item) > 0)
			{
				return current;
			}
			current = current.next;
		}
		return this.next;
	}
	
	private void checkIndex(int index) //O(1)
	{
		if (index < 0)
			throw new IllegalArgumentException("Index must be grather than 0!");
		
		if (index > this.lenght)
			throw new IllegalArgumentException("Index must be less than the lenght of the sortedList");
	}
	
	public void print() // O(n)
	{
		Node<T> current = this.next;
		int currentIndex = this.lenght;
		
		while(current != null)
		{
			System.out.println("index : " + currentIndex + " data : " + current.data);
			current = current.next;
			currentIndex--;
		}
	}
}
