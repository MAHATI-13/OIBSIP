
import java.util.ArrayList;
import java.util.Scanner;

public class BankAccount {
    private String userId;
    private String pin;
    private double balance;
    private ArrayList<String> history = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public BankAccount(String userId, String pin, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
    }

    public boolean login(String userId, String pin) {
        return this.userId.equals(userId) && this.pin.equals(pin);
    }

    public void printTransactionHistory() {
        if (history.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("Transaction History:");
            for (String entry : history) {
                System.out.println(entry);
            }
        }
    }

    public void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            history.add("Withdrawn: ₹" + amount);
            System.out.println("Withdrawal successful. Balance: ₹" + balance);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    public void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        if (amount > 0) {
            balance += amount;
            history.add("Deposited: ₹" + amount);
            System.out.println("Deposit successful. Balance: ₹" + balance);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void transfer() {
        System.out.print("Enter recipient name: ");
        String recipient = sc.next();
        System.out.print("Enter amount to transfer: ");
        double amount = sc.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            history.add("Transferred ₹" + amount + " to " + recipient);
            System.out.println("Transfer successful. Balance: ₹" + balance);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }
}
