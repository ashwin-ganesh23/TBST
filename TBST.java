package hw7;

/*
 * Name: <Ashwin Ganesh>
 * ID: <A10210060>
 * Login: <asganesh@ucsd.edu>
 */


import hw7.BST.Node;

public class TBST <T extends Comparable <? super T>>{

	private Node root;
	private int nelems;


	public TBST(){
		root = new Node(true, true);
	}

	public void clear(){
		root = new Node(true, false);
	}

	public Node successor(Node n){
		Node r;
		r = n.getRightChild();
		if(!n.rightThread){
			while(!r.leftThread){
				r = r.getLeftChild();
			}
		}
		return r;
	}

	public void printOrder(){
		Node t = root;
		for(int x = 0; x < nelems; x++){
			if(t.getLeftChild()!= null){
				t = t.getLeftChild();
			}
		}
		System.out.print(t.getElement() + " ");
		for(int i = 1; i < nelems; i++){
			t = successor(t);
			if(t == root){
				return;
			}
			System.out.print(t.getElement() + " ");

		}
	}

	//Inserts a new node in BST
	public void insert(T val)
	{
		if(nelems == 0){
			root.setElement(val);
			nelems++;
			return;
		}
		Node r = root;
		for(int x = 0; x<nelems; x++){
			if(r.getElement().compareTo(val) < 0){
				if(r.rightThread){
					break;
				}
				r = r.getRightChild();
			}else if(r.getElement().compareTo(val) > 0){
				if(r.leftThread){
					break;
				}
				r = r.getLeftChild();
			}else{
				return;
			}
		}

		Node t = new Node(val);
		t.leftThread=t.rightThread=true;
		if(r.getElement().compareTo(val) < 0){
			t.setRightChild(r.getRightChild());
			t.setLeftChild(r);
			r.setRightChild(t);
			r.rightThread = false;
			nelems++;
		}else{
			t.setRightChild(r);
			t.setLeftChild(r.getLeftChild());
			r.setLeftChild(t);
			r.leftThread = false;
			nelems++;
		}

	}

	public Node find(Node a, T t){

		if(a.getElement() == null){
			return null;
		}
		if(a.getElement().compareTo(t) < 0){
			if(a.rightThread){
				return a;
			}
			return find(a.getRightChild(), t);
		} else if(a.getElement().compareTo(t) > 0){
			if(a.leftThread){
				return a;
			}
			return find(a.getLeftChild(), t);
		} else{
			return null;
		}
	}

	//A class that implements nodes to be used
	//in TBST
	protected class Node{
		T data;
		Node rChild;
		Node lChild;
		boolean leftThread, rightThread;

		//Constructor to create singleton Node
		public Node(T element)
		{
			data = element;
			rChild = null;
			lChild = null;
			leftThread = true;
			rightThread = true;
		}

		//Constructor to create singleton Node
		//that points to a given children
		public Node(T element, Node right, Node left, boolean lt, boolean rt)
		{
			data = element;
			rChild = right;
			lChild = left;
			leftThread = lt;
			rightThread = rt;
		}

		public Node(boolean lt, boolean rt)
		{
			data = null;
			rChild = null;
			lChild = null;
			leftThread = lt;
			rightThread = rt;
		}

		//Returns the data of a node
		public T getElement(){
			return data;
		}

		//Sets the data of a node
		public void setElement(T element){
			data = element;
		}

		//returns the left child pointer
		public Node getLeftChild(){
			return lChild;
		}

		//returns the right child pointer
		public Node getRightChild(){
			return rChild;
		}

		//sets the left child pointer
		public void setLeftChild(Node left){
			lChild = left;
		}

		//sets the right child pointer
		public void setRightChild(Node right){
			rChild = right;
		}

	}  //end of class Node
}
