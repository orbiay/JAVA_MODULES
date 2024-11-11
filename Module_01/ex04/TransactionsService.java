class TransactionsService {
    private UsersList users;
    public void addAuser(User user)
    {
        if (user != null)
            users.addUser(user);
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
        if (retrieveUserBalance(senderr) < amount)
            throw new IllegalTransactionException("Sender Balance samller than transfer amount");
        Transaction debit = new Transaction(recipent,sender,Category.DEBITS,amount);
        Transaction credit = new Transaction(recipent,sender,Category.CREDITS,amount);
        sender.setTransaction(credit);
        sender.setTransaction(debit);
        recipent.setTransaction(credit);
        recipent.setTransaction(debit);
        sender.creditTransfer(amount);
        recipent.debitTransfer(amount);
   }

   public Transaction[] getTransfersForUserById(int id)
   {
        User user = users.getUserById(id);
        return user.getTransactions();
   }

   public void  removeTrnsactionById(int userId, UUID transactionId)
   {
        User user = users.getUserById(id);
        user.deleteTransactionById(transactionId);
   }

   public Transaction[] checKValidityOfTransaction()
   {
    
   }

}