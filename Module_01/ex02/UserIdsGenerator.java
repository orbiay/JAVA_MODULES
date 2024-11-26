class UserIdsGenerator{
    private static UserIdsGenerator UserIdsGeneratorInsatnce;
    private static int id;
    private UserIdsGenerator(){
        id = -1;
        System.out.println("UserIdsGenerator: Default Constructor called privately");
    }
    public static UserIdsGenerator getInstance(){
        if (UserIdsGeneratorInsatnce == null)
        {
            UserIdsGeneratorInsatnce = new UserIdsGenerator();
            return UserIdsGeneratorInsatnce;
        }
        return UserIdsGeneratorInsatnce ;
    }
    public int generateId(){
        id++;
        return id ;
    }
}
