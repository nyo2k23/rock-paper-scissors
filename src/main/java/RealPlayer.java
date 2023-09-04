public class RealPlayer extends Player {
    private String name;
    private UserType userType;
    public RealPlayer(String name) {
        this.name = name;
        this.userType = UserType.REAL_PERSON;
    }


    @Override
    public Enum<UserType> getUserType() {
        return userType;
    }

    @Override
    public String getName() {
        return name;
    }
}
