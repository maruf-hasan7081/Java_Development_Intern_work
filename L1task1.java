//Description: Write a simple Java console application that performs basic 
//arithmetic operations (addition,subtraction, multiplication, division).
//Objectives:
//Create a class with methods for each arithmeticoperation.
//Take input from the user for numbers and the desired operation.
//Handle edge cases like division by zero.

import java.util.Scanner;
public class L1task1{
	
	double add(double x , double y){
		return x+y;
		
	}
	double sub(double x , double y){
		return x-y;
		
	}
	double multi(double x , double y){
		return x*y;
		
	}
	double div(double x , double y){
		
		return x/y;
		
	}
	
public static void main(String[] args)
{
	
	L1task1 a=new L1task1();
	Scanner sca= new Scanner(System.in);
	System.out.println("Enter 2 numbers: ");
	double x=sca.nextDouble();
	double y= sca.nextDouble();
	
	
    System.out.println("Enter operation (+ , -, *,/): ");
	char op = sca.next().charAt(0);
	
	if(op=='+'){
	double sum=a.add(x,y);
	System.out.println("Sum is :"+sum);
	}
	else if (op=='-'){
	
	double subtraction=a.sub(x,y);
	System.out.println("subtraction is :"+subtraction);
	}
	else if (op=='*'){
	double multiplication=a.multi(x,y);
	System.out.println("multiplication is :"+multiplication);
	}
	else if (op=='/'){
	double division=a.div(x,y);
	if (y == 0) {
            System.out.println("Error: Cannot divide by zero!");
            
        }
		else{
	System.out.println("division is :"+division);
		}
	}
	else{
		System.out.println("invalid operation");
	}
	
}
	
 }
