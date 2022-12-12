import java.util.Scanner;

public class MoveDesiredLocation {
    static Scanner sc = new Scanner(System.in);
    private static char computer;
    private static char player;

    public static void main(String[] args) {
        System.out.println("\n*** WELCOME TO TIC TAC TOE GAME ***");
        char[][] gameBoard = {{'_', '|', '_', '|', '_'}, {'_', '|', '_', '|', '_'}, {' ', '|', ' ', '|', ' '}};
        dispayBoard(gameBoard);
        chooseLetter();
        System.out.println("Show Current Board: ");
        dispayBoard(gameBoard);
        playerMove(gameBoard);
    }

    public static void dispayBoard(char[][] gameBoard) {  ///Display the game board
        for (int row = 0; row < gameBoard.length; row++) {  /// for the rows
            for (int col = 0; col < gameBoard[0].length; col++) {// for column
                System.out.print(gameBoard[row][col]);
            }
            System.out.println();
        }
    }

    public static void chooseLetter() {
        System.out.println("Choose Letter X or O");
        char letter = sc.next().charAt(0);
        if (letter == 'X' || letter == 'x') {
            player = 'X';
        } else if (letter == 'O' || letter == 'o') {
            player = 'O';
        }
        System.out.println("Player Choose letter:" + player);
    }

    public static void playerMove(char[][] gameBoard) {  //Ask player Position where whould like to move
        System.out.println("Please make a move. (1-9)");
        System.out.println("-----------------------------------------------------------");
        int move = sc.nextInt();
        boolean result = isValidMove(move, gameBoard);
        while (!result) {
            System.out.println("Sorry! Invalid Move. Try again");
            move = sc.nextInt();
            result = isValidMove(move, gameBoard);
        }
        System.out.println("Player moved at position " + move);
        updateBoard(move,1,gameBoard);
    }

    public static boolean isValidMove(int move, char[][] gameboard) { // Takes Move input from player
        switch (move) {
            case 1:
                if (gameboard[0][0] == '_') {  // if position empty then return true
                    return true;
                } else {
                    return false;
                }
            case 2:
                if (gameboard[0][2] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (gameboard[0][4] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 4:
                if (gameboard[1][0] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 5:
                if (gameboard[1][2] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 6:
                if (gameboard[1][4] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 7:
                if (gameboard[2][0] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 8:
                if (gameboard[2][2] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 9:
                if (gameboard[2][4] == ' ') {
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }
    public static void updateBoard( int position, int player, char [][] gameBoard){
        char character;
        if(player==1){
            character = 'X';   // player =1 having X character
        }else{
            character = 'O';  // Computer =2 having O character
        }
        switch (position){
            case 1:
                gameBoard[0][0] = character; //  if the player or computer chose first position.
                dispayBoard(gameBoard);
                break;
            case 2:
                gameBoard[0][2] = character;
                dispayBoard(gameBoard);
                break;
            case 3:
                gameBoard[0][4] = character;
                dispayBoard(gameBoard);
                break;
            case 4:
                gameBoard[1][0] = character;
                dispayBoard(gameBoard);
                break;
            case 5:
                gameBoard[1][2] = character;
                dispayBoard(gameBoard);
                break;
            case 6:
                gameBoard[1][4] = character;
                dispayBoard(gameBoard);
                break;
            case 7:
                gameBoard[2][0] = character;
                dispayBoard(gameBoard);
                break;
            case 8:
                gameBoard[2][2] = character;
                dispayBoard(gameBoard);
                break;
            case 9:
                gameBoard[2][4] = character;
                dispayBoard(gameBoard);
                break;
            default:
                break;
        }
}
}
