import java.util.UUID;

public class Program {
    static public void display(Transaction[] transactions,int size)
    {
         
        for(int i = 0; i < size ;i++ )
        {
            Transaction tran = transactions[i];
            System.out.println("Sender " + tran.getSender().getName() + " recipent is " + tran.getRecipient().getName() + " amount " + tran.getAmount());
        }
    }
    public static void main(String[] args) {
        try{
            User userA = new User("A",2000);
            TransactionsService service = new TransactionsService();
            service.addAuser(userA);
            service.addAuser(new User("B",2000));
            service.addAuser(new User("C",2000));
            System.out.println("A Balance is "+ service.retrieveUserBalance(1));
            service.transfer(1,2,-200);
            service.transfer(2,1,-300);
            service.transfer(3,1,-300);
            Transaction[] userATransactions = service.getTransfersForUserById(1);
            Transaction[] userBTransactions = service.getTransfersForUserById(2);
            Transaction[] userCTransactions = service.getTransfersForUserById(3);
            System.out.println("Transaction for User A");
            display(userATransactions,3);
            System.out.println("Transaction for User B");
            display(userBTransactions,2);
            System.out.println("Transaction for User C");
            display(userCTransactions,1);
            service.removeTransactionById(1,userATransactions[0].getId());
            userATransactions = service.getTransfersForUserById(1);
            System.out.println("After Remove Transaction for User A");
            display(userATransactions,2);
            System.out.println("Checking validity");
            display(service.checKValidityOfTransaction(),1);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
