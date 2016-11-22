package hw7;

public class Test {
	public static void main(String[] args){
		BST<Integer> tree = new BST<Integer>(); 
		TBST<Integer> ttree = new TBST<Integer>();
		double a, b;
		
		tree.insert(15);
		tree.insert(8);
		tree.insert(9);
		tree.insert(18);
		tree.insert(19);
		
		ttree.insert(1);
		ttree.insert(8);
		ttree.insert(9);
		ttree.insert(18);
		ttree.insert(19);
		
		tree.insert(15);
		tree.insert(28);
		tree.insert(29);
		tree.insert(118);
		tree.insert(119);
		

		
		a = System.currentTimeMillis();
		//tree.printInOrder();
		b = System.currentTimeMillis();
		System.out.println(b-a + " milliseconds for BST");
		a = System.currentTimeMillis();
		ttree.printOrder();
		b = System.currentTimeMillis();
		System.out.println(b-a + " milliseconds for TBST");
	}
}
