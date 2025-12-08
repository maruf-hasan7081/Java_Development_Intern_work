// Task 2: File Handling - Reading and Writing to a File
//Description: Write a program that reads data from a file, processes it, and writes the output to another file.
// Objectives:
//Read a text file and process the content (e.g., count words, lines).
 //Write the processed data (e.g., word count) to a new file.
 //Handle file-related exceptions like FileNotFoundException.

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;


 public class L2task2{


  
    public static void main (String [] args){
       
        Scanner sca=new Scanner(System.in);
        System.out.print("Enter input file name: ");
        String inputFileName=sca.nextLine();
        System.out.print("Enter output file name: ");
        String outputFileName=sca.nextLine();
        
        int lineCount=0;
        int wordCount=0;
        
        try{
            File inputFile=new File (inputFileName);
            Scanner fileScanner=new Scanner(inputFile);
            
            while(fileScanner.hasNextLine()){
                String line=fileScanner.nextLine();
                lineCount++;
                String[] words=line.split("\\s+");
                wordCount+=words.length;
            }
            fileScanner.close();
            
            FileWriter writer=new FileWriter(outputFileName);
            writer.write("Line Count: "+lineCount+"\n");
            writer.write("Word Count: "+wordCount+"\n");
            writer.close();
            
            System.out.println("Processing complete. Check output file: "+outputFileName);
            
        }catch(FileNotFoundException e){
            System.out.println("Error: Input file not found.");
        }catch(IOException e){
            System.out.println("Error: An I/O error occurred.");
        }
        
        

        
    }
}
