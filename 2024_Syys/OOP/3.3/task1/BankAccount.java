public class BankAccount{

    private int accountNumber = 887534;
    private double balance = 0;

    private static int totalAccounts = 0;


    public BankAccount(int balance){
        totalAccounts++;
        this.balance = balance;
        accountNumber = accountNumber + totalAccounts + (int)(Math.random()*1000);
    }

    public boolean deposit(double amount){ balance += amount; return true;

    }

    public boolean withdraw(double amount){
        if (balance >= amount){
            balance -= amount;
            return true;
        }
        return false;
    }

    public String getAccountNumber(){ return Integer.toHexString(accountNumber); }
    public double getBalance(){ return balance; }
    public static int getTotalAccounts(){ return totalAccounts; }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(2000);

        account1.deposit(500);
        account2.withdraw(800);

        System.out.println("Account " + account1.getAccountNumber() + " balance: " + account1.getBalance());
        System.out.println("Account " + account2.getAccountNumber() + " balance: " + account2.getBalance());

        System.out.println("Total number of accounts: " + BankAccount.getTotalAccounts());
    }

}
