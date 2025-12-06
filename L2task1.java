//Task 1: Employee Management System
//Description: Create a basic Employee Management System with CRUD functionality (Create, Read,Update, Delete) using Object-Oriented Programming.
// Objectives:
//Define an Employee class with fields like name, ID,salary, etc.
//Implement methods for adding, viewing, updating, and deleting employee records.
//Store employee data in an in-memory collection (e.g.,ArrayList

import java.util.Scanner;
import java.util.ArrayList;
public class L2task1{
	
	public static class employee{
		
		private String name;
		private String id;
		private double salary;
		
		public employee(String name,String id,double salary){
			
			this.name= name;
			this.id=id;
			this.salary=salary;
			
		}
		public void setname(String name){
			this.name=name;
		}
		public String getname(){
			return name;
		}
		public void setid(String id){
			this.id=id;
		}
		public String getid(){
			return id;
		}
		public void setsalary(double salary){
			this.salary=salary;
		}
		public double getsalary(){
			return salary;
		}
		
		public void display(){
			System.out.println(" employee Name:"+name+", employee Id:"+id+", employee salary:"+salary);
		}

		

		
		
		
	}
	public static void main (String [] args){
		
		Scanner sca=new Scanner(System.in);
		
		ArrayList<employee> empList=new ArrayList<employee>();
		int choice;
		do{
			System.out.println("1. Add Employee");
			System.out.println("2. View Employees");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			choice=sca.nextInt();
			
			switch(choice){
				case 1:
					System.out.print("Enter employee Name: ");
					String name=sca.next();
					System.out.print("Enter employee Id: ");
					String id=sca.next();
					System.out.print("Enter employee Salary: ");
					double salary=sca.nextDouble();
					
					employee emp=new employee(name,id,salary);
					empList.add(emp);
					System.out.println("Employee added successfully!");
					break;
				case 2:
					System.out.println("Employee List:");
					for(employee e: empList){
						e.display();
					}
					break;
				case 3:
					System.out.print("Enter employee Id to update: ");
					String updateId=sca.next();
					boolean found=false;
					for(employee e: empList){
						if(e.getid().equals(updateId)){
							System.out.print("Enter new Name: ");
							String newName=sca.next();
							System.out.print("Enter new Salary: ");
							double newSalary=sca.nextDouble();
							
							e.setname(newName);
							e.setsalary(newSalary);
							System.out.println("Employee updated successfully!");
							found=true;
							break;
						}
					}
					if(!found){
						System.out.println("Employee not found!");
					}
					break;
				case 4:
					System.out.print("Enter employee Id to delete: ");
					String deleteId=sca.next();
					found=false;
					for(int i=0;i<empList.size();i++){
						if(empList.get(i).getid().equals(deleteId)){
							empList.remove(i);
							System.out.println("Employee deleted successfully!");
							found=true;
							break;
						}
					}
					if(!found){
						System.out.println("Employee not found!");
					}
					break;
				case 5:
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid choice! Please try again.");
			}
		}while(choice!=5);
		

		
		
	}
	
	
	
}
