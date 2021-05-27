public class GameTest {

    public static void main(String[] args) {
        BattleshipGame game = new BattleshipGame();
        GameHelper help = new GameHelper();
        int numOfGuesses = 0;
        int randomNum = (int) (Math.random() * 5);
        int[] locations = {randomNum, randomNum+1, randomNum+2};

        game.setLocationCells(locations);
        boolean isAlive = true;

        while(isAlive) {
            String guess = help.getUserInput("enter a number");
            String result = game.checkYourself(guess);
            numOfGuesses++;
            if(result.equals("kill")) {
                isAlive = false;
                System.out.println("You took " + numOfGuesses + " guesses");
            }
        }
    }
}
