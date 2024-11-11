import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        User user1 = new User( "A", 500);
        User user2 = new User( "B", 500);
        try{
            // Adding transactions
            Transaction transactionNum1 = new Transaction(user2,user1,Transaction.Category.DEBITS,-2000);
            Transaction transactionNum2 = new Transaction(user1,user2,Transaction.Category.CREDITS,2000);
            user1.setTransaction(transactionNum1);
            user1.setTransaction(transactionNum2);
            user2.setTransaction(transactionNum1);
            user2.setTransaction(transactionNum2);

            // user.getTransactions().addTransaction(t1);
            // user.getTransactions().addTransaction(t2);

            // Printing all transactions
            int size = user1.getSize();
            Transaction[] transactions = user1.getTransactions();
            for (int i = 0;i < size ; i++) {
                System.out.println(transactions[i].getId() + " " + transactions[i].getCategory());
            }
        }catch(TransactionNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        // // Removing a transaction and catching exception if not found
        // try {
        //     user.getTransactions().removeTransaction(t1.getId());
        //     System.out.println("Transaction removed.");
        // } catch (TransactionNotFoundException e) {
        //     System.out.println(e.getMessage());
        // }
    }
}
