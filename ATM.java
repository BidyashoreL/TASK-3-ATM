import java.util.Scanner;
public class ATM {
    private BankAccount account;
    public ATM(BankAccount account) {
        this.account = account;
    }
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    handleWithdraw(scanner);
                    break;
                case 2:
                    handleDeposit(scanner);
                    break;
                case 3:
                    showBalance();
                    break;
                case 4:
                    System.out.println("Thanks for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please select a valid action.");
            }
        }
    }
    private void showMenu() {
        System.out.println("\nATM Options:");
        System.out.println("1. WITHDRAW MONEY");
        System.out.println("2. DEPOSIT MONEY");
        System.out.println("3. CHECK BALANCE");
        System.out.println("4. EXIT");
        System.out.print("Choose an option: ");
    }
    private void handleWithdraw(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (account.takeMoney(amount)) {
            System.out.println("Withdrawal successful. New balance: $" + account.getBalance());
        } else {
            System.out.println("You don't have enough funds for this withdrawal.");
        }
    }
    private void handleDeposit(Scanner scanner) {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();

        account.addMoney(amount);
        System.out.println("Deposit successful. New balance: $" + account.getBalance());
    }
    private void showBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }
}
class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public double getBalance() {
        return balance;
    }
    public boolean takeMoney(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
    public void addMoney(double amount) {
        balance += amount;
    }
}
