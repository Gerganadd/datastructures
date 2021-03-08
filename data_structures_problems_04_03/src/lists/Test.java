package lists;

public class Test {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(12);  // index : 1
		list.add(23);  // index : 2
		list.add(34);  // index : 3
		list.add(45);  // index : 4
		list.print();
		System.out.println("*********");
		list.clear();
		list.print();
		
		
		
	}

}
