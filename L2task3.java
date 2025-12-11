// Task 3: Simple Banking Application
// Description: Build a simple banking system where users can deposit, withdraw, and check their balance
// Objectives:
//Create a BankAccount class with methods for deposit,withdraw, and check balance.
 //Implement basic error handling (e.g., insufficient funds).
 //Simulate user interactions with the system via the console

import java.util.Scanner;
public  class L2task3{
    
    public static class BankAccount{
        private double balance;
        
        public BankAccount(){
            balance=0.0;
        }
        
        public void deposit(double amount){
            if(amount>0){
                balance+=amount;
                System.out.println("Deposited: "+amount);
            }else{
                System.out.println("Invalid deposit amount.");
            }
        }
        
        public void withdraw(double amount){
            if(amount>0 && amount<=balance){
                balance-=amount;
                System.out.println("Withdrew: "+amount);
            }else{
                System.out.println("Insufficient funds or invalid amount.");
            }
        }
        
        public double getBalance(){
            return balance;
        }
    }
    
    public static void main (String [] args){
        Scanner sca=new Scanner(System.in);
        BankAccount account=new BankAccount();
        int choice;
        do{
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice=sca.nextInt();
            
            switch(choice){
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount=sca.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount=sca.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current Balance: "+account.getBalance());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }while(choice!=4);
        
        sca.close();
        
        
    }
}