class Program {
    static public void main(String arg[])
    {
        UsersArrayList userList = new UsersArrayList();
        
        userList.addUser(new User("A", 500));
        userList.addUser(new User("B", 300));
        userList.addUser(new User("C", 500));
        userList.addUser(new User("D", 300));
        userList.addUser(new User("E", 500));
        userList.addUser(new User("F", 300));
        userList.addUser(new User("G", 500));
        userList.addUser(new User("H", 300));
        userList.addUser(new User("I", 500));
        userList.addUser(new User("J", 300));
        userList.addUser(new User("K", 500));
        userList.addUser(new User("L", 300));
        userList.addUser(new User("M", 500));
        userList.addUser(new User("N", 300));
        userList.addUser(new User("P", 500));
        userList.addUser(new User("O", 300));
        
        try {
            System.out.println(userList.getUserById(1).getName());
            System.out.println(userList.getUserById(15).getName());
            System.out.println(userList.getUserById(-1).getName());
            System.out.println(userList.getUserById(16).getName());
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Total users: " + userList.getNumberOfUsers());
    }
}