package lists;

public class Node <T>
{
	T data;
	Node<T> next;
	
	Node()
	{
		this.data = null;
		this.next = null;
	}
	
	Node(T data, Node<T> next)
	{
		this.data = data;
		this.next = next;
	}
	
	Node(T data)
	{
		this.data = data;
		this.next = null;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s -> %s", this.data, this.next);
	}
}
