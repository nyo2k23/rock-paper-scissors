public class Computer extends Player{
    public String name;
    private UserType userType = UserType.COMPUTER;
    private static int numberOfRobotUserInstances=0;
    public Computer() {
        this.name = userType.toString() + "_" + numberOfRobotUserInstances;
        numberOfRobotUserInstances++;  // incremment robot user instances so the next user is COMPUTER-n
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
