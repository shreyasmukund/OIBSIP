import java.util.Scanner;

class Account {
    protected String user_Id;
    protected String user_Pass;
    Scanner sc = new Scanner(System.in);

    void createAcc() {
        System.out.print("Enter username: ");
        user_Id = sc.nextLine();
        System.out.print("Enter Password: ");
        user_Pass = sc.nextLine();
        System.out.println("Account created succesfully!!!!");
    }
}

class LoginAccount extends Account {
    private String id;
    private String password;

    void login() {
        do {
            System.out.print("Enter username: ");
            id = sc.nextLine();
            if (user_Id.equals(id)) {
                do {
                    System.out.print("Enter Password: ");
                    password = sc.nextLine();
                    if (password.equals(user_Pass)) {
                        System.out.println("Login successful !");
                    } else {
                        System.out.println("Please enter a valid Password!");
                    }

                } while (password.equals(user_Pass) == false);
            } else {
                System.out.println("Username doesn't match!!");
            }
        } while (user_Id.equals(id) == false);

    }
}

class Deposit {
    int amount;
    int balance = 50000;
    int previousTransaction = 0;
    String TransactionHistory = "";
    Scanner sc = new Scanner(System.in);

    void Display() {
        System.out.print("Enter the amount to be deposited: ");
        amount = sc.nextInt();
        if (amount != 0) {
            previousTransaction++;
            balance = balance + amount;
            previousTransaction = amount;
            String str = amount + " Rs deposited\n";
            TransactionHistory = TransactionHistory.concat(str);
            System.out.println("Money deposited successfully!!!");
        }
    }
}

class Withdraw extends Deposit {

    void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        amount = sc.nextInt();
        if (balance >= amount) {
            if (amount <= 20000) {
                previousTransaction++;
                balance = balance - amount;
                previousTransaction = previousTransaction - amount;
                System.out.println("Amount withdrawn successfully !");
                String str = amount + "rs Withdrawed\n";
                TransactionHistory = TransactionHistory.concat(str);
            } else {
                System.out.println("Sorry !.........limit is 20000");
            }
        } else {
            System.out.println("Insufficient amount to withdraw !");
        }
    }
}

class Transfer extends Withdraw {
    void forward() {
        int bank_acc;
        int ac;
        int receiverAccountBalance = 0;
        System.out.print("Enter amount to transfer: ");
        amount = sc.nextInt();
        if (balance < amount) {
            System.out.println("Insufficient Balance!");
        } else {
            System.out.print("Enter the account number of receiver: ");
            ac = sc.nextInt();

            this.balance = this.balance - amount;
            receiverAccountBalance += amount;
            System.out.println("Available Balance: " + this.balance);
            System.out.println("Succesfully transferred " + receiverAccountBalance +" Rs");
            String str = amount + " Rs transfered";
            TransactionHistory = TransactionHistory.concat(str);
        }

    }
}

class CheckBalance extends Transfer {
    void checkBalance() {
        System.out.println("\n Available Balance::" + balance + " Rs");
    }

}

class TransactionHistory extends CheckBalance {
    void history() {
        if (previousTransaction == 0) {
            System.out.println("\nNo transaction history to show!!");
        } else {

            System.out.println("\n" + TransactionHistory);
        }
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        System.out.println("=======================WELCOME TO ATM=======================");
        LoginAccount l = new LoginAccount();
        l.createAcc();
        System.out.println("=======================WELCOME BACK=======================");
        System.out.println("=======================WELCOME TO LOGIN PAGE=======================");
        l.login();

        int ch;
        Scanner sc = new Scanner(System.in);
        TransactionHistory t = new TransactionHistory();
        while (true) {
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("Menu: ");
            System.out.println("1. Check Account Balance");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Transaction History");
            System.out.println("5. Transfer money to another account");
            System.out.println("6. Exit");
            System.out.println("=================================================");
            System.out.print("Enter your Choice:");
            ch = sc.nextInt();
            System.out.println("=================================================");
            switch (ch) {
                case 1:
                    t.checkBalance();
                    break;

                case 2:

                    t.Display();
                    break;

                case 3:

                    t.withdraw();
                    break;

                case 4:

                    t.history();
                    break;

                case 5:

                    t.forward();
                    break;

                case 6:
                    System.out.println("Thank you for using the services of ATM");
                    System.exit(ch);
                    break;

                default:
                    System.out.println("Please Enter a valid choice!!!");
                    break;
            }

        }

    }

}
