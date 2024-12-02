import java.util.*;
// import java.util.;
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
        String name = scan.next();
        int balance = scan.nextInt();
        User user = new User(name,balance);
        service.addAuser(user);
        System.out.println("User with id ="+ user.getId() + "is added");
    }

    private void getUserBalanceService()
    {
        System.out.println("-> Enter a user ID");
        System.out.print("-> ");
        int id = scan.nextInt();
        if (id < 0)
            System.err.println("Error there is no User with this Id");
        else
        {
            User user = service.getUserById(id);
            int balance  = user.getBalance();
            System.out.println(user.getName() + " - " + balance);
        }
    }

    public void performTransfer()
    {
        System.out.println("Enter a sender ID, a recipient ID, and a transfer amount");
        System.out.print("-> ");
        int senderId = scan.nextInt();
        int reciepentId = scan.nextInt();
        int amount = scan.nextInt();
        if (reciepentId < 0 || senderId < 0)
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
        int size = user.getSize();
        System.out.println("------> " + size);
        Transaction[] transactions = user.getTransactions();
        // int size = user.getSize();
        for(int i = 0;i<size;i++)
            System.out.println("To " + transactions[i].getRecipient().getName() + "(id = "+ transactions[i].getRecipient().getId() + ") " + transactions[i].getAmount() + " with id = " + transactions[i].getId());
    }

    public void removeTransactionByIdService()
    {
        System.out.println("Enter a user ID and a transfer ID");
        System.out.print("-> ");
        int userId = scan.nextInt();
        String transactionId = scan.next();
        UUID idFormat = UUID.fromString(transactionId);
        User user = service.getUserById(userId);
        Transaction[] transactions = user.getTransactions();
        System.out.println("------>" + idFormat.toString());
        int size = user.getSize();
        Transaction save = null;
        for (int i = 0;i < size;i++)
        {
            if (transactions[i].getId().equals(idFormat))
            {
                save = transactions[i];
                break;
            }
        }
        if (save == null)
        {
            System.out.println("No Transation with this Id found");
            return;
        }
        System.out.println("******"+ save.getId());
        service.removeTransactionById(userId,idFormat);
        System.out.println("Transfer To " + save.getRecipient().getName() + "(id = " + save.getRecipient().getId() + " ) " + save.getAmount() +" removed");
        
    }

    public void checKValidityOfTransactionService()
    {
        System.out.println("Check results:");
        // System.out.print("-> ");
        // int userId = scan.next();
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
                    getAllTransactionForUserService();
                    break;
                case 5:
                    if(isDevMode == false)
                    {
                        System.out.println("It's not Dev Mode");
                        break;
                    }
                    removeTransactionByIdService();
                    break;
                case 6:
                    if(isDevMode == false)
                    {
                        System.out.println("It's not Dev Mode");
                        break;
                    }
                    checKValidityOfTransactionService();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter one of those numbers that are mention");

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