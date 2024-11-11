class UsersArrayList implements UsersList
{
    private final int INITIALE_SIZE = 10;
    private User[] users;
    private int numberOfUsers;
    private int capacity;

    UsersArrayList()
    {
        users = new User[INITIALE_SIZE];
        numberOfUsers = 0;
        capacity = INITIALE_SIZE;
    }

    private void resizingArrayOfUsers()
    {

        int newCapacity = users.length + (users.length / 2);
        System.out.println("Resizing methods called with curent length is " + users.length + " and new Capacity is " + newCapacity);
        User[] newArrayOfUsers = new User[newCapacity];
        System.arraycopy(users,0,newArrayOfUsers,0,users.length);
        users = newArrayOfUsers;
        capacity = newCapacity;
    }

    @Override
    public User addUser(User user){
        if (numberOfUsers == capacity)
            resizingArrayOfUsers();
        users[numberOfUsers] = user;
        numberOfUsers++;
        return user;
    }

    @Override
    public User getUserById(int id)
    {
        for (int i = 0;i < numberOfUsers;i++)
        {
            System.out.println("===> " + users[i].getName()+ " id is  "+ id + " getId is "+ users[i].getId() +  " numberof users is "+ numberOfUsers);
            if (users[i].getId() == id)
                return users[i];
        }
        throw new UserNotFoundException("User with this id " + id + " not found");
    }
    @Override
    public int getNumberOfUsers()
    {
        return numberOfUsers;
    }

    @Override
    public User getUserByIndex(int index)
    {
        if (index <= numberOfUsers)
            return users[index];
        throw new UserNotFoundException("User with this id " + index + " not found");
    }
}