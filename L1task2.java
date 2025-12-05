//Task 2: Simple Number GuessingGame
//Description: Develop a number guessing game where the program generates a random number, and the user has to guess it.
//Objectives:
// Use Java’s Random class to generate a random number.
//Give feedback to the user (e.g., “too high,” “too low”).
//Limit the number of attempts and handle invalid inputs.
//Skills Covered: Random number generation, loops,conditional st


import java.util.Scanner;
import java.util.Random;

public class L1task2
{
	
	public static void main(String[] args)
	{
		
		Random r=new Random();
		int secret =r.nextInt(5)+1;
		
		int attamps=5;
		for(int i=1; i<=attamps; i++){
			System.out.println("attamps"+i);
		
		
		Scanner sca= new Scanner(System.in);
		System.out.println("Enter your gress number(1-5):");
		int number = sca.nextInt();
		
		if(secret==number){
			System.out.println("Correct! You guessed it!");
			break;
			
		}
		else if(secret<number){
			System.out.println("opps! your guessed is high ");
			System.out.println("The secret number is :"+secret);
		}
		else if(secret>number){
			System.out.println("opps! your guessed is low ");
			System.out.println("The secret number is :"+secret);
			
		}
		}
		System.out.println("game over beacuse your attamps is close ");
		
	}		
	
}


