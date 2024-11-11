import java.util.UUID;

class TransactionsLinkedList implements TransactionList{
    private Transaction head;
    private int size;
    private final int INITIALE_SIZE = 10;
    TransactionsLinkedList(){
        head = null;
        size = 0;
    }
    public int getSize()
    {
        return size;
    }
    
    @Override
    public Transaction addTransaction(Transaction transaction){
        // Whenever want to add an element to your linked list the head become the new tranaction that u wanna add and the nex is the previous head
        transaction.setNextTransaction(head);
        // the head gonna poit to the new transaction by reference
        head = transaction;
        size++;
        return head;
    }

    @Override
    public void deleteTransactionById(UUID id){
        Transaction previousTransaction = null;
        Transaction cuurent = head;
        while (cuurent != null)
        {
            if (cuurent.getId().equals(id) && previousTransaction != null)
            {
                previousTransaction.setNextTransaction(cuurent.getNextTransaction());
                size--;
                return ;
            }
            else if (cuurent.getId().equals(id) && previousTransaction == null)
            {
                head = cuurent.getNextTransaction();
                size--;
                return ;
            }
            previousTransaction = cuurent;
            cuurent = cuurent.getNextTransaction();
        }
        throw new TransactionNotFoundException("Transaction with this Id" + id+ " no Found");
    }

    @Override
    public Transaction[] toArray(){
        int newSize = INITIALE_SIZE;
        if (size > INITIALE_SIZE)
            newSize = INITIALE_SIZE + INITIALE_SIZE / 2;
        Transaction[] linkedListToArray = new Transaction[newSize];
        Transaction curent = head;
        int  i = 0;
        while (curent != null )
        {
            linkedListToArray[i] = curent;
            curent = curent.getNextTransaction();
            i++;
        }
        size = i;
        System.out.println(linkedListToArray.length);
        return linkedListToArray;
    }
}