import java.util.UUID;
class TransactionsService {
    private static Transaction[] transactions;
    private final int INITIALE_SIZE = 10;
    static private int size;
    private UsersList users;
    private static int capacity;
    TransactionsService(){
        users = new UsersArrayList();
        if(transactions == null)
        {
            transactions = new Transaction[INITIALE_SIZE];
            capacity = INITIALE_SIZE;
        }
        else if (size >= INITIALE_SIZE)
        {
            Transaction[] saver = new Transaction[transactions.length + transactions.length / 2];
            capacity = transactions.length + transactions.length / 2;
            for (int i = 0; i < size;i++)
                saver[i] = transactions[i];
            transactions = saver;
        }
    }
    public void addAuser(User user)
    {
        if (user != null)
            users.addUser(user);
        // System.out.println("User name is" + user.getName());
        else
            throw new UserNotFoundException("There is no user");
    }

    public int retrieveUserBalance(int id)
    {
        return users.getUserById(id).getBalance();
    }
    public User getUserById(int id)
    {
        return users.getUserById(id);
    }
   public void transfer(int senderr , int recipentt,int amount)
   {
        User sender = users.getUserById(senderr);
        User recipent = users.getUserById(recipentt);
        if (retrieveUserBalance(senderr) < amount * (-1))
            throw new IllegalTransactionException("Sender Balance samller than his transfered amount");
        //  IDs of both transactions must be equal
        Transaction transaction = new Transaction(recipent,sender,Transaction.Category.DEBITS,amount);
        // so create it first as a DEBITS for the sender    
        sender.setTransaction(transaction);
        // change the transaxtion category for the reciepent
        transaction.setCategory(Transaction.Category.CREDITS);
        recipent.setTransaction(transaction);

        sender.creditTransfer(amount * (-1));
        recipent.debitTransfer(amount * (-1));
   }

   public Transaction[] getTransfersForUserById(int id)
   {
        User user = users.getUserById(id);
        return user.getTransactions();
   }
   public int getSizeTransactionsForUser(int id)
   {
        return users.getUserById(id).getSize();
   }
   public void  removeTransactionById(int userId, UUID transactionId)
   {
        User user = users.getUserById(userId);
        Transaction[] tran = user.getTransactions();
        int len = user.getSize();
        Transaction lookingFor = null;
        for (int i = 0; i < len;i++)
        {
            if (tran[i].getId().equals(transactionId))
            {
                lookingFor = tran[i];
                break;
            }
        }
        user.deleteTransactionById(transactionId);
        boolean found = false;
        if (size == 0 && lookingFor != null)
        {
            transactions[size] = lookingFor;
            size++;
        }
        else if (lookingFor != null )
        {
            for (int i = 0;i < size;i++)
            {
                if (transactions[i].getId().equals(lookingFor.getId()))
                    found = true;
                    break;
            }
            if (found)
            {
                Transaction[] newArray = new Transaction[capacity];
                for (int i = 0; i < size;i++)
                {
                    if (!transactions[i].getId().equals(lookingFor.getId()))
                        newArray[i] = transactions[i];
                }
                size--;
                transactions = newArray;
            }
            else
            {
                transactions[size] = lookingFor;
                size++;
            }
        }
   }

   public Transaction[] checKValidityOfTransaction()
   {
        return transactions;
   }
   
}