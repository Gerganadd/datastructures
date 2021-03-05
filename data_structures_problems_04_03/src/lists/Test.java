package lists;

public class Test {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(123);
		list.add(134);
		list.print();
		System.out.println("*********");
		//list.remove(123);
		list.print();
		System.out.println(list.index);
	}

}
