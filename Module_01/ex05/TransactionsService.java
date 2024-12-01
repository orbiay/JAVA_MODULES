import java.util.UUID;
class TransactionsService {
    private UsersList users;
    public TransactionsService()
    {
        users = new UsersArrayList();
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
        if (retrieveUserBalance(senderr) < amount)
            throw new IllegalTransactionException("Sender Balance samller than his transfered amount");
        //  IDs of both transactions must be equal
        Transaction transaction = new Transaction(recipent,sender,Transaction.Category.DEBITS,amount);
        // so create it first as a DEBITS for the sender    
        sender.setTransaction(transaction);
        // change the transaxtion category for the reciepent
        transaction.setCategory(Transaction.Category.CREDITS);
        sender.setTransaction(transaction);

        sender.creditTransfer(amount);
        recipent.debitTransfer(amount);
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
        user.deleteTransactionById(transactionId);
   }

//    public Transaction[] checKValidityOfTransaction()
//    {
    
//    }
   
}