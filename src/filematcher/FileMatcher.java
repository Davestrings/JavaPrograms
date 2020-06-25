package filematcher;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class FileMatcher {

    private static FileInputStream fileIn;
    private static FileWriter writer;
    private static ObjectInputStream input;
    private static List<Account> accounts = new ArrayList<>(4);
    private static List<TransactionRecord> transactionRecords = new ArrayList<>(4);

    public static void openFile(String fileName) throws FileNotFoundException {
        if(fileName == null)
            throw new NullPointerException("File cannot be null");
        if(Main.isValidPath(fileName))
            throw new IllegalArgumentException("Invalid input. Add file extension");
        if(!doesFileExist(fileName))
            throw new FileNotFoundException("File does not exist");

        try{
            fileIn = new FileInputStream(fileName);
            input = new ObjectInputStream(fileIn);
        }catch (IOException ex){
            System.err.println("Error reading file");
            ex.printStackTrace();
            System.exit(-1);
        }
    }
    public static boolean doesFileExist(String fileName){
        boolean exist = Files.exists(Paths.get(fileName));
        if(exist)
            return true;
        return false;
    }
    public static void readMasterRecord(){
       try{
           int count =0;//tentative value
           while (count <4){
               Account account = (Account) input.readObject();
//               System.out.println(account);
               accounts.add(account);
               count ++;
           }
       }catch (ClassNotFoundException |IOException ex){
           System.err.println("Error reading from file");
           System.exit(-1);
       }
    }
    public static void readTransactions(){
        try{
            TransactionRecord transaction = (TransactionRecord) input.readObject();
            transactionRecords.add(transaction);
        }catch(IOException | ClassNotFoundException ex){
            System.err.println("Error reading from file");
            System.exit(-1);
        }
    }
    public static void processRecords(){
//        ListIterator<Account> iterator1 = accounts.listIterator();
//        ListIterator<TransactionRecord> iterator2 = transactionRecords.listIterator();

//        while (iterator1.hasNext()){
//            Account account = iterator1.next();
//            TransactionRecord transactionRecord = iterator2.next();
//
//            if(account.getAcctNumber() == transactionRecord.getAccountNumber()){
//                account.combine(transactionRecord);
//                Main.createFile("newMast.txt", false);
//                Main.addMasterRecord();
//            }else{
//                logFile();
//                writeLog(account);
//            }
//
//        }
        for(Account account : accounts) {
            for(TransactionRecord record : transactionRecords){
                if(account.getAcctNumber() == record.getAccountNumber()){
                    account.combine(record);
                    Main.createFile("newMast.txt", false);
                    Main.addMasterRecord();
                }else{
                    logFile();
                    writeLog(account);
                }
            }
        }
        System.out.println("File processed successfully");
    }

    public static void logFile(){
        try{
            writer = new FileWriter("log.txt");
            System.out.println("Log created successfully");
        }catch (IOException ex){
            System.err.println("Error creating file");
            System.exit(-1);
        }
    }
    public static void writeLog(Account account){
        try{
            String message = String.format("Unmatched Transaction record for account number %d", account.getAcctNumber());
            writer.write(message);
            System.out.println("Log written successfully");
        }catch (IOException ex){
            System.err.println("Error writing log");
        }
    }
}
