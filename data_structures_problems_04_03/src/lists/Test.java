package lists;

public class Test {

	public static void main(String[] args) {
		/*LinkedList<Integer> list = new LinkedList<>();
		list.add(12);  // index : 1
		list.add(23);  // index : 2
		list.add(34);  // index : 3
		list.add(45);  // index : 4
		list.print();
		//System.out.println("*********");
		//list.clear();
		//list.print();
		*/
		
		/*SortedList<Integer> sortedList = new SortedList<Integer>();
		//System.out.println(sortedList.contains(12));
		sortedList.add(-1);
		sortedList.add(0);
		sortedList.add(3);
		sortedList.add(12);
		sortedList.add(5);
		sortedList.add(2);
		sortedList.add(-1);
		sortedList.add(11); 
		sortedList.print();
		System.out.println("***");
		//System.out.println("item : " + sortedList.get(3));
		sortedList.removeFrom(8);
		sortedList.print();
		//System.out.println(sortedList.lenght);
		//System.out.println(sortedList.contains(15));
		//sortedList.remove(15);
		//System.out.println(sortedList.contains(15));
		*/
		
		Stack stack = new Stack();
		stack.push(12);
		stack.push(23);
		stack.push(14);
		stack.push(43);
		
		System.out.println(stack.contains(14));
		stack.pop();
		
		stack.print();
		
	}

}
