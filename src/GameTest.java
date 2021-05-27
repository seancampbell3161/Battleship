public class GameTest {

    public static void main(String[] args) {
        BattleshipGame game = new BattleshipGame();
        int[] locations = {2,3,4};
        game.setLocationCells(locations);
        String userGuess = "2";
        String result = game.checkYourself(userGuess);
    }
}
