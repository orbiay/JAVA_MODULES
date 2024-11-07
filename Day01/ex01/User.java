class User {
    private int Identifier;
    String Name;
    int Balance;
    
    public User(String Name,int Balance)
    {
        this.Identifier = UserIdsGenerator.getInstance().generateId();
        this.Name = Name;
        setBalance(Balance);
        // System.out.println("Balance is "  +  this.Balance + " Name is " + this.Name);
        System.out.println("Parmeterized Constructor of User Class Called.");
    }
    public int getId() {
        return Identifier;
    }

    public String getName() {
        return Name;
    }

    public int getBalance() {
        return Balance;
    }
    public void setBalance(int balance) {
        if (balance < 0) {
            System.out.println("Balance must be a positive amount.");
        }
        this.Balance = balance;
    }
}