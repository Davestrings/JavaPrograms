package filematcher;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static Scanner input;
    private static FileOutputStream fileOut;
    private static ObjectOutputStream output;

    public static void main(String[] args){
        createFile("oldmast.txt", false);
        addMasterRecord();
        createFile("trans.txt", false);
        addTransactionRecord();
        try{
            FileMatcher.openFile("oldmast.txt");
        }catch (FileNotFoundException ex){
            System.err.println("File does not exist");
        }
        FileMatcher.readMasterRecord();
        FileMatcher.processRecords();
    }
    protected static boolean isValidPath(String fileName){
        String[] token = fileName.split("\\.");
        if(token.length < 2)
            return true;

        return false;
    }
    public static void createFile(String fileName, boolean canAppend) throws IllegalArgumentException{
        /**
         * create a file with fileName argument
         * */
        if(fileName == null)
            throw new NullPointerException("Null value not accepted");

        if(isValidPath(fileName))
            throw new IllegalArgumentException("Path should have a (.) extension");

       try{
           File file = new File(fileName);
           fileOut = new FileOutputStream(file, canAppend);
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
           output.writeObject(account);
           output.writeObject(account1);
           output.writeObject(account2);
           output.writeObject(account3);

           System.out.println("object writing complete");
       }catch (IOException ex){
           System.err.println("Error writing to file");
           System.exit(-1);
       }


    }
    public static void addTransactionRecord(){
        TransactionRecord record = new TransactionRecord(100, 27.14);
        TransactionRecord record1 = new TransactionRecord(300, 62.11);
        TransactionRecord record2 = new TransactionRecord(400, 100.56);
        TransactionRecord record3 = new TransactionRecord(900, 82.17);

        try{
            output.writeObject(record);
            output.writeObject(record1);
            output.writeObject(record2);
            output.writeObject(record3);
        }catch (IOException ex){
            System.err.println("Error writing to file");
            ex.printStackTrace();
            System.exit(-1);
        }
    }

}
