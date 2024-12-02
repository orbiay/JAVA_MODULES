import java.util.UUID;

class TransactionsLinkedList implements TransactionsList{
    private Transaction head;
    private int size;
    static private int INITIALE_SIZE = 10;
    TransactionsLinkedList(){
        head = null;
        size = 0;
    }

    public Transaction addTransaction(Transaction transaction){
        // Whenever want to add an element to your linked list the head become the new tranaction that u wanna add and the nex is the previous head
        transaction.setNextTransaction(head);
        // the head gonna poit to the new transaction by reference
        head = transaction;
        size++;
        return head;
    }

    public void deleteTransactionById(UUID id){
        Transaction previous = null;
        Transaction cuurent = head;
        while (cuurent != null)
        {
            if (cuurent.getId() == id && previous != null)
            {
                
                previous.setNextTransaction(cuurent.getNextTransaction());            
                head = previous;
                size--;
                return ;
            }
            else if (cuurent.getId() == id && previous == null)
            {
                head = cuurent.getNextTransaction();
                size--;
                return ;
            }
            previous = cuurent;
            cuurent = cuurent.getNextTransaction();
        }
        throw new TransactionNotFoundException("Transaction with this Id" + id+ " not Found");
    }
    public int getSize()
    {
        return size;
    }
    public Transaction[] toArray(){
        int newSize = INITIALE_SIZE;
        if (size >= INITIALE_SIZE)
        {   
            newSize = INITIALE_SIZE + INITIALE_SIZE / 2;
            INITIALE_SIZE += INITIALE_SIZE / 2;
        }
        Transaction[] linkedListToArray = new Transaction[newSize];
        Transaction curent = head;
        int  i = 0;
        while (curent != null)
        {
            linkedListToArray[i] = curent;
            curent = curent.getNextTransaction();
            i++;
        }
        curent = head;
        return linkedListToArray;
    }
}