import java.util.ArrayList;

public class GameTest {

    private GameHelper helper = new GameHelper();
    private ArrayList<BattleshipGame> shipList = new ArrayList<>();
    private int numOfGuesses = 0;

    public void setUpGame() {
        BattleshipGame ship1 = new BattleshipGame();
        ship1.setName("Red October");
        BattleshipGame ship2 = new BattleshipGame();
        ship2.setName("The Black Pearl");
        BattleshipGame ship3 = new BattleshipGame();
        ship3.setName("Davey Jones");
        shipList.add(ship1);
        shipList.add(ship2);
        shipList.add(ship3);

        System.out.println("Your goal is to sink three ships:");
        System.out.println("Red October, The Black Pearl, and Davey Jones");
        System.out.println("Try to sink them all in the fewest number of guesses");

        for(BattleshipGame shipToSet : shipList) {
            ArrayList<String> newLocation = helper.placeShip(3);
            shipToSet.setLocationCells(newLocation);
        }

    }

    public void startPlaying() {
        while(!shipList.isEmpty()) {
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    public void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "miss";
        for(BattleshipGame ship : shipList) {
            result = ship.checkYourself(userGuess);
            if(result.equals("hit")) {
                break;
            }
            if(result.equals("kill")) {
                shipList.remove(ship);
                break;
            }
        }
        System.out.println(result);
    }

    public void finishGame() {
        System.out.println("Game Over");
        if(numOfGuesses <= 18) {
            System.out.println("Congratulations! You did well.");
        } else {
            System.out.println("You didn't do so hot, there.");
        }
    }

    public static void main(String[] args) {
        GameTest game = new GameTest();
        game.setUpGame();
        game.startPlaying();
    }
}
