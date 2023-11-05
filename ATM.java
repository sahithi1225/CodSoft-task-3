import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            displayMenu();
            System.out.print("Select an option (1-4): ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Your balance is: $" + account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter the amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposited $" + depositAmount);
                    break;

                case 3:
                    System.out.print("Enter the amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawn $" + withdrawAmount);
                    } else {
                        System.out.println("Insufficient funds or invalid amount.");
                    }
                    break;

                case 4:
                    isRunning = false;
                    System.out.println("Thank you for using the ATM.");
                    break;

                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}

class Main{
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initialize with an initial balance of $1000
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}