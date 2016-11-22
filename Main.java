package hw7;
/*
 * Name: <Ashwin Ganesh>   
 * ID: <A10210060>
 * Login: <asganesh@ucsd.edu>
 */
import java.util.Scanner;
import java.io.*;

public class Main {

	static double a, b;
	public static void main(String[] args) {
		BST<Integer> tree = new BST<Integer>(); 
		TBST<Integer> ttree = new TBST<Integer>();
		if(args.length != 1)
		{
			System.err.println("Expected only 1 argument");
			return;
		}
		try{
			Scanner scanner = new Scanner(new File(args[0]));
			while(scanner.hasNextInt())
			{
			     int val = scanner.nextInt();
			     tree.insert(new Integer(val));
			     ttree.insert(new Integer(val));
			}
		}catch(FileNotFoundException ex)
		{
			System.err.println("File not found: "+args[0]);
			return;
		}
		a = System.currentTimeMillis();
		tree.printInOrder();
		b = System.currentTimeMillis();
		System.out.println(a-b + " milliseconds for BST");
		a = System.currentTimeMillis();
		ttree.printOrder();
		b = System.currentTimeMillis();
		System.out.println(a-b + " milliseconds for TBST");

	}
	

}
