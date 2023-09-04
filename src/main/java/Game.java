import java.util.*;

public class Game {
    public Player playerOne;
    public Player playerTwo;

    public int numberOfRounds;
    public String currentPick;
    public List<String> picks = Arrays.asList("rock", "paper", "scissors");
    //private List<String> picks = Arrays.asList(Arrays.toString(Pick.values()));
    private Scanner userInput = new Scanner(System.in);


    public Game(Player playerOne, Player playerTwo, int numberOfRounds) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.numberOfRounds = numberOfRounds;
    }


    public void playGame() {
        System.out.println("game-play initiated");
        String pick;
        int playerOnePoints = 0;
        int playerTwoPoints = 0;

        for(int i = 1; i <= numberOfRounds; i++) {
            pick = setPick();
            String playerTwoPick;
            if(!picks.contains(pick)) {
                System.out.println("Please pick from the given options");
                pick = setPick();
            }

            if(playerTwo.getUserType()==UserType.COMPUTER){
                System.out.println("is computer");
                playerTwoPick = getRandomPick();
                }   else {
                playerTwoPick = setPick();
            }
            System.out.println("Computer picked: " + playerTwoPick);
            if(pick.equals(playerTwoPick)) {
                playerOnePoints++;
                playerTwoPoints++;
            } else if (pick.equals("rock")) {
                if (playerTwoPick.equals("scissors")) {
                    playerOnePoints++;
                } else {
                    playerTwoPoints++;
                }
            } else if (pick.equals("paper")) {
                if(playerTwoPick.equals("rock")) {
                    playerOnePoints++;
                }   else {
                    playerTwoPoints++;
                }
            }
            System.out.println("Results:\n"+ playerOne.getName() + " - " + playerOnePoints);
            System.out.println(playerTwo.getName() + " - " + playerTwoPoints);
        }
        displayWinner(playerOnePoints, playerTwoPoints);
    }

    public String setPick(){
        System.out.println("rock, paper, scissors?");
        return userInput.next().toLowerCase();
    }

    private void displayWinner(int playerTally, int computerTally) {
        String winner;
        if(playerTally>computerTally) {
            winner = playerOne.getName();
            System.out.println("Winner is... " + winner);
        } if(playerTally<computerTally) {
            winner = playerTwo.getName();
            System.out.println("Winner is... " + winner);
        } else {
            winner = "... OOPS It's a draw";
            System.out.println("Winner is... " + winner);
            System.out.println("Rematch initiated");
            this.playGame(); // starts the game over
        }
    }
    private String getRandomPick() {
        Random randomNum = new Random();
        return picks.get(randomNum.nextInt(picks.size()));
    }
}