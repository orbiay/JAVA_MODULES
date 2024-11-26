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
            // Printing all transactions
            int size = user2.getSize();
            Transaction[] transactions = user2.getTransactions();
            System.out.println("--------->" + size);
            for (int i = 0;i < size ; i++) {
                System.out.println(transactions[i].getId() + " " + transactions[i].getCategory());
            }
            // delete TRansaction
            user1.deleteTransactionById(transactionNum2.getId());
            transactions = user1.getTransactions();
            size = user1.getSize();
            System.out.println("--------->" + size);
            for (int i = 0;i < size ; i++) {
                System.out.println(transactions[i].getId() + " " + transactions[i].getCategory());
            }
            // delete TRansaction With no-existing UUID
            user1.deleteTransactionById(UUID.randomUUID());
        }catch(TransactionNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
