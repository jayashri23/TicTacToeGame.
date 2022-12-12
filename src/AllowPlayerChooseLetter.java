import java.util.Scanner;

public class AllowPlayerChooseLetter {
    static Scanner sc=new Scanner(System.in);
    private static char computer;
    private static char player;

    public static void main(String[] args) {
        char[][] gameBoard = {{'_', '|', '_', '|', '_'}, {'_', '|', '_', '|', '_'}, {' ', '|', ' ', '|', ' '}};
        dispayBoard(gameBoard);
        chooseLetter();
    }
    public static void dispayBoard(char[][] gameBoard) {  ///Display the game board
        System.out.println("\n*** WELCOME TO TIC TAC TOE GAME ***");
        for (int row = 0; row < gameBoard.length; row++) {  /// for the rows
            for (int col = 0; col < gameBoard[0].length; col++) {// for column
                System.out.print(gameBoard[row][col]);
            }
            System.out.println();
        }
    }
    public static void chooseLetter(){
        System.out.println("Choose Letter X or O");
        char letter=sc.next().charAt(0);
        if (letter=='X' || letter =='x'){
            player='X';
        }
        else  if (letter=='O' || letter =='o'){
            player='O';
        }System.out.println("Player Choose letter:" +player);
    }
}
