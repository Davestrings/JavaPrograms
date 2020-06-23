package filematcher;

public class Account {
    private String firstName;
    private String lastName;
    private int acctNumber;
    private double balance;

    public Account(String fName, String lName, int acctNumber, double bal) throws IllegalArgumentException{
        firstName = fName;
        lastName = lName;
        if(acctNumber == 0) {
            throw new IllegalArgumentException("Account Number cannot be zero");
        }
        this.acctNumber = acctNumber;
        balance = bal;
    }
    public Account(String fName, String lName, int acctNumber){
        this(fName, lName, acctNumber, 0.0);
    }

    public void setFirstName(String fName){
        firstName = fName;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setLastName(String lName){
        lastName = lName;
    }
    public String getLastName(){
        return lastName;
    }

    public void setAcctNumber(int acctNumber) throws IllegalArgumentException{
        if(acctNumber == 0)
            throw new IllegalArgumentException("Account Number cannot be zero");

        this.acctNumber = acctNumber;
    }

    public int getAcctNumber() {
        return acctNumber;
    }

    public void setBalance(double balance) {

        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
    public double combine(TransactionRecord record){
       double result = this.getBalance() + record.getAmount();
       return result;
    }

    @Override
    public String toString() {
        return String.format("Account( First Name: {}, Last Name: {}, Account Number: {}, Balance: {}"
                ,getFirstName(), getLastName(), getAcctNumber(), getBalance());
    }
}
