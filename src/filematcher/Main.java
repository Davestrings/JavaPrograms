package filematcher;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static Scanner input;
    private static FileOutputStream fileOut;
    private static ObjectOutputStream output;

    public static void main(String[] args){
        createFile("oldmast.txt");
        addMasterRecord();
        createFile("trans.txt");
    }
    public static void createFile(String fileName){
       try{
           File file = new File(fileName);
           fileOut = new FileOutputStream(file, true);
           output = new ObjectOutputStream(fileOut);
       }catch (FileNotFoundException | SecurityException ex){
           System.err.println("Error opening file");
           System.exit(-1);
       }catch(IOException ex){
           System.err.println("Error opening file.");
           System.exit(-1);
       }
    }
    public static void addMasterRecord() {
        Account account = new Account("Alan", "Jones", 100, 348.17);
        Account account1 = new Account("Mary", "Smith", 300, 27.19);
        Account account2 = new Account("Sam", "Sharp", 500, 0.00);
        Account account3 = new Account("Suzy", "Green", 700, -14.22);

       try{
           output.writeObject(account.toString());
           output.writeObject(account1.toString());
           output.writeObject(account2.toString());
           output.writeObject(account3.toString());

           System.out.println("object writing complete");
       }catch (IOException ex){
           System.err.println("Error writing to file");
           System.exit(-1);
       }


    }
    public static void addTransactionRecord(){
        TransactionRecord record = new TransactionRecord();
    }

}
