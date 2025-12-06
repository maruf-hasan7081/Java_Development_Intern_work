// Task 3: Factorial Calculation using Recursion
// Description: Write a recursive function to compute the factorial of a number.
// Objectives:
//Implement a recursive method to calculate factorial.
//Ensure the program handles edge cases like factorial of 0 and negative numbers.

import java.util.Scanner;

public class L1task3{
	
	int factorial(int number){
		
		if(number<0){
			System.out.println("Factorial of negative numbers is not defined.");
			return -1;
		}
		if(number==0|| number==1){
			
			return 1;
		}
		
		return number * factorial(number-1);

	}		
	
	public static void main(String[] args){
		
		L1task3 a= new L1task3();
		
		Scanner sca= new Scanner(System.in);
		System.out.print("Enter a number:");
		int x = sca.nextInt();
		
		int output=a.factorial(x);
		
		if(output!=-1){
		
		System.out.println("the factorial "+x+" is :"+output);
		}
		
	}
	
	
}