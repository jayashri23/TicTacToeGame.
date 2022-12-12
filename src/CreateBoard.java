public class CreateBoard {
    public static void main(String[] args) {
        char[][] gameBoard = {{'_', '|', '_', '|', '_'}, {'_', '|', '_', '|', '_'}, {' ', '|', ' ', '|', ' '}};
        displayBoard(gameBoard);
    }

    public static void displayBoard(char[][] gameBoard) {  ///Display the game board
        System.out.println("\n*** WELCOME TO TIC TAC TOE GAME ***");
        for (char[] chars : gameBoard) {  /// for the rows
            for (int col = 0; col < gameBoard[0].length; col++) {// for column
                System.out.print(chars[col]);
            }
            System.out.println();
        }
    }
}
