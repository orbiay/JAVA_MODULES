class UserIdsGenerator{
    private static UserIdsGenerator UserIdsGeneratorInsatnce;
    private static int id;
    private UserIdsGenerator(){
        id = 0;
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