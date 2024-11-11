interface UsersList{
    User addUser(User user);
    User getUserById(int id);
    User getUserByIndex(int index);
    int  getNumberOfUsers();
}