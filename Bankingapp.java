import java.util.*;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String pin;

    public BankAccount(String accountNumber, String accountHolder, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.pin = pin;
        this.balance = balance;
    }

    public boolean login(String accNo, String pin) {
        return this.accountNumber.equals(accNo) && this.pin.equals(pin);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

public class BankingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Dummy account
        BankAccount account = new BankAccount("12345", "Atharva", "1111", 5000);

        System.out.println("Enter Account Number:");
        String accNo = sc.nextLine();

        System.out.println("Enter PIN:");
        String pin = sc.nextLine();

        if (account.login(accNo, pin)) {
            System.out.println("Login Successful!");
            while (true) {
                System.out.println("\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Exit");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        double dep = sc.nextDouble();
                        account.deposit(dep);
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double wd = sc.nextDouble();
                        account.withdraw(wd);
                        break;
                    case 3:
                        account.checkBalance();
                        break;
                    case 4:
                        System.out.println("Thank you for using our Banking App!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice!");
                }
            }
        } else {
            System.out.println("Invalid Account Number or PIN!");
        }

        sc.close();
    }
}
