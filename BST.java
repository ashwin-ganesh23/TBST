package hw7;
/*
 * Name: <Ashwin Ganesh>   
 * ID: <A10210060>
 * Login: <asganesh@ucsd.edu>
 */

import java.io.*;

public class BST<T extends Comparable <? super T>> {
	
	private int numElem;
	private Node root;
	
	
	//Constructor to create an empty tree
	public BST(){
		root = null; 
		numElem = 0;
	}
	
	//Inserts a new node in BST
	public void insert(T val)
	{
		inserthelp(root, val);
		numElem++;
	}

	//helper method. Must be recursive
	private Node inserthelp(Node rt, T val)
	{
		Node temp=rt;
		if(rt == null){
			root = new Node(val);
			return root;
		}
		if(temp.getElement() == val){
			return null;
		}
			
		if(temp.getElement().compareTo(val) > 0){
			if(temp.getLeftChild() == null){
				temp.setLeftChild(new Node(val));
			}else{
				temp=temp.getLeftChild();
				inserthelp(temp, val);
			}
		}else if(temp.getElement().compareTo(val) < 0){
			if(temp.getRightChild() == null){
				temp.setRightChild(new Node(val));
			}else{
				temp=temp.getRightChild();
				inserthelp(temp, val);
			}
		}
		return temp;
	}

    //traverses BST in order
	public void printInOrder()
	{
		printHelper(root);
	}
	
	public void printHelper(Node rt){
		if(rt != null){
			printHelper(rt.getLeftChild());
			System.out.println(rt.getElement());
			printHelper(rt.getRightChild());
		}
	}
	
	
	//A class that implements nodes to be used 
	//in BST
	protected class Node{
		T data;
		Node rChild;
		Node lChild;
		

		//Constructor to create singleton Node
		public Node(T element){
		 data = element;
		 rChild = null;
		 lChild = null;
		}
		
		//Constructor to create singleton Node
		//that points to a given children
		public Node(T element, Node right, Node left){
			data = element;
			rChild = right;
			lChild = left;
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
