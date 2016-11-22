package hw7;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class SuperLottoPlus {
	
	static ArrayList<Integer> numbers = new ArrayList<Integer>();
	 
	
	public static ArrayList<Integer> generateSuperLottoNumbers(){
		
		for(int y = 0; y<5; y++){
			numbers.add((int) (47 * Math.random()) + 1);
		}
		numbers.add((int) (27 * Math.random()) + 1);

		return numbers;
	}

	public static void printTicket(ArrayList<Integer> array){
		for(int x = 0; x<= 4; x++){
			System.out.print(array.get(x) + " ");
		}
		System.out.print(" MEGA (" + array.get(5) + ")");

	}
	
	public static ArrayList<Integer> generateSuperLottoNoDupes(){
		
		for(int y = 0; y<5; y++){
			int temp = (int) (47 * Math.random()) + 1;
			while(Arrays.asList(numbers).contains(temp)){
				temp = (int) (47 * Math.random()) + 1;
			}
			numbers.add(y, temp);
		}
		numbers.add(5, (int) (27 * Math.random()) + 1);

		return numbers;
	}

	public static void main(String args[]){

		Scanner scan = new Scanner(System.in);
		
		System.out.println("How many Super Lotto tickets do you want?");
		int tickets = scan.nextInt();
		
		for(int i = 0; i<tickets; i++){
			printTicket(generateSuperLottoNoDupes());
			System.out.println(" ");
		}

	}	

}