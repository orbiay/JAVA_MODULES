interface TransactionList {
    Transaction addTransaction(Transaction transaction);
    void deleteTransactionById(UUID id);
    Transaction[] toArray();
}