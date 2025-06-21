import java.util.Scanner;

public class SimpleBankingSystem {
    private static String accountHolderName;
    private static String accountNumber;
    private static double balance = 0.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("Welcome to Simple Banking System");
        System.out.print("Enter your name to create an account: ");
        accountHolderName = scanner.nextLine();
        accountNumber = "ACC" + (int)(Math.random() * 10000); // Simple account number

        System.out.println("Account created successfully!");
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);

        while (isRunning) {
            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using Simple Banking System. Goodbye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please select between 1 and 4.");
            }
        }

        scanner.close();
    }

    public static void checkBalance() {
        System.out.printf("Your current balance is: ₹%.2f\n", balance);
    }

    public static void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ₹");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.printf("Successfully deposited ₹%.2f\n", amount);
        } else {
            System.out.println("Enter a valid amount greater than 0.");
        }
    }

    public static void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Successfully withdrew ₹%.2f\n", amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Enter a valid amount greater than 0.");
        }
    }
}
