import java.util.UUID;

interface TransactionsList {
    Transaction addTransaction(Transaction transaction);
    void deleteTransactionById(UUID id);
    Transaction[] toArray();
    int getSize();
}