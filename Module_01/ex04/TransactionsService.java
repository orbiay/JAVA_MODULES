import java.util.UUID;

class TransactionsService {
    private UsersList users;
    TransactionsService(){
        users = new UsersArrayList();
    }
    public void addAuser(User user)
    {
        if (user != null)
            users.addUser(user);
        else
            throw new UserNotFoundException("There is no user");
    }

    public int retrieveUserBalance(int id)
    {
        return users.getUserById(id).getBalance();
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

   public void  removeTransactionById(int userId, UUID transactionId)
   {
        User user = users.getUserById(userId);
        user.deleteTransactionById(transactionId);
   }

//    public Transaction[] checKValidityOfTransaction()
//    {
    
//    }

}