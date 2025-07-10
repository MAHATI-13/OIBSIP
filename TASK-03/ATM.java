
import java.util.Scanner;

public class ATM {
    private BankAccount account = new BankAccount("user123", "1234", 1000);
    private Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.print("Enter User ID: ");
        String userId = sc.next();
        System.out.print("Enter PIN: ");
        String pin = sc.next();

        if (account.login(userId, pin)) {
            System.out.println("Login Successful!");
            showMenu();
        } else {
            System.out.println("Invalid credentials!");
        }
    }

    private void showMenu() {
        while (true) {
            System.out.println("\n1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: account.printTransactionHistory(); break;
                case 2: account.withdraw(); break;
                case 3: account.deposit(); break;
                case 4: account.transfer(); break;
                case 5: System.out.println("Thank you for using ATM."); return;
                default: System.out.println("Invalid option!"); break;
            }
        }
    }
}
