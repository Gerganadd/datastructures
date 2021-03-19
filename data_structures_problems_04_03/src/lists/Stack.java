package lists;

import java.util.EmptyStackException;

public class Stack<T extends Comparable<T>> 
{
	Node<T> previous;

	public boolean isEmpty() // O(1)
	{
		return previous == null;
	}

	public boolean contains(T item) // O(n)
	{
		Node<T> current = this.previous;
		
		while (current != null)
		{
			if (item.compareTo(current.data) == 0)
			{
				return true;
			}
			
			current = current.next;
		}
		
		return false;
	}

	public void push(T item) // O(1)
	{
		this.previous = new Node(item, previous);
	}

	public void pop() // O(1)
	{
		this.previous = previous.next;
	}

	public T peek() // O(1)
	{
		if (this.previous == null)
		{
			throw new EmptyStackException();
		}
		return this.previous.data;
	}
	
	public void clear() // O(1)
	{
		this.previous = null;
	}
	
	public void print() // O(n)
	{
		Node<T> current = this.previous;
		
		while(current != null)
		{
			System.out.println(current.data);
			current = current.next;
		}
	}
}
