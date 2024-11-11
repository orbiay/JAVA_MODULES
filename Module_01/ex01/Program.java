class Program{
    static public void main(String args[])
    {
        User user1  = new User("Oussama",20000);
        User user2  = new User("X",10000);

        // Transaction transactionNum1 = new Transaction(user2,user1,Transaction.Category.DEBITS,-2000);
        // Transaction transactionNum2 = new Transaction(user1,user2,Transaction.Category.CREDITS,2000);
        System.out.println(user1.getId() + " has an amount " + user1.getBalance());
        System.out.println(user2.getId() + " has an amount " + user2.getBalance());

    }
}