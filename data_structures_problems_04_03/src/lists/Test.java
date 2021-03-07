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
		//list.insertAt(444, 4);
		//System.out.println(list.get(4));
		//list.removeFrom(4);
		//list.remove(45);
		list.clear();
		list.print();
		//System.out.println(list.get(4));
		
		
		
	}

}
