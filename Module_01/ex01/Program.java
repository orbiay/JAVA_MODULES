class Program{
    static public void main(String args[])
    {
        User user1  = new User("Oussama",20000);
        User user2  = new User("X",10000);
        System.out.println(user1.getId() + " has an amount " + user1.getBalance());
        System.out.println(user2.getId() + " has an amount " + user2.getBalance());

    }
}