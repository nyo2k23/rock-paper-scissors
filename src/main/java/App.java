public class App {
    public static void main(String[] args) {
        Player x = new RealPlayer("tha");
        Player y = new RealPlayer("kfhdjd");
        //Player y = new Computer();
        Game z = new Game(x,y, 3);
        z.playGame();
    }
}
