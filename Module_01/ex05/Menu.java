import java.util.Scanner;
class Menu
{
    private TransactionsService service;
    private boolean isDevMode;
    private Scanner scan;
    Menu(TransactionsService service,boolean isDevMode)
    {
        this.isDevMode = isDevMode;
        this.service = service;
        scan = new Scanner(System.in);
    }
    private void addUserService()
    {
        System.out.println("-> Enter a user name and a balance");
        System.out.print("-> ");
        String name = scanner.next();
        int balance = scanner.nextInt();
        User user = new User(name,balance);
        service.addUser(user);
        System.out.println("User with id ="+ user.getId() + "is added");
    }

    private void getUserBalanceService()
    {
        System.out.println("-> Enter a user ID");
        System.out.print("-> ");
        int id = scanner.nextInt();
        if (id < 0)
            System.err.println("Error there is no User with this Id");
        else
        {
            User user = service.getUserById(id);
            int balence  = user.getBalance();
            System.out.println(user.getName() + " - " + balance);
        }
    }

    public void performTransfer()
    {
        System.out.println("Enter a sender ID, a recipient ID, and a transfer amount");
        System.out.print("-> ");
        int senderId = scanner.next();
        int reciepentId = scanner.next();
        int amount = scanner.next();
        if (amount <= 0 || reciepentId < 0 || senderId < 0)
            System.err.println("Error something Wrong with Your inputs");
        else
        {
            service.transfer(senderId,reciepentId,amount);
            System.out.println("The transfer is completed");
        }
    }
    public void getAllTransactionForUserService()
    {
        System.out.println("Enter a user ID");
        System.out.print("-> ");
        int userId = scan.nextInt();
        User user = service.getUserById(userId);
        Transaction[] transactions = user.getTransactions();
        int size = user.getSize();
        for(int i = 0;i<size;i++)
        {
            System.out.println("To " + user.getName() + "(id = "+ user.getId() + ") " + transaction[i].getAmount())
        }
    }
    public void entry()
    {
        int cmdNumber = 0;
        while (cmdNumber != 7)
        {
            displayMenu();
            cmdNumber = scan.nextInt();
            switch(cmdNumber)
            {
                case 1:
                    addUserService();
                    break;
                case 2:
                    getUserBalanceService();
                    break;
                case 3:
                    performTransfer();
                    break;
                case 4:

            }
            System.out.println("---------------------------------------------------------");
        }
    }

    private void displayMenu() {
        System.out.println("""
                1. Add a user
                2. View user balances
                3. Perform a transfer
                4. View all transactions for a specific user
                5. DEV - remove a transfer by ID
                6. DEV - check transfer validity
                7. Finish execution
                -> """);
    }

}