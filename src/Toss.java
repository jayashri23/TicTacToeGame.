import java.util.Random;
import java.util.Scanner;

public class Toss {
    public static final int HEAD = 0;
    public static final int TAIL = 1;
    static Scanner sc = new Scanner(System.in);
    private static char computer;
    private static char player;
    private static  char[][] gameBoard = {{'_', '|', '_', '|', '_'}, {'_', '|', '_', '|', '_'}, {' ', '|', ' ', '|', ' '}};
    public static void main(String[] args) {
        System.out.println("\n*** WELCOME TO TIC TAC TOE GAME ***");
        System.out.println("Tic Tac Toe Board: ");
        displayBoard(gameBoard);
        tossToPlay();
        chooseLetter();
        System.out.println("Show Current Board: ");
        displayBoard(gameBoard);
        playerMove(gameBoard);
        computerMove(gameBoard);
    }
    public static void displayBoard(char[][] gameBoard) {  ///Display the game board
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
    public static void playerMove(char[][] gameBoard) {  //Ask player Position where would like to move
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
    public static void computerMove(char [][] gameBoard){// For Playing computer
        Random rand = new Random();  // used random function to play randomly by computer
        int move = rand.nextInt(9)+1;
        boolean result = isValidMove(move,gameBoard);
        while(!result){
            move = rand.nextInt(9)+1;
            result = isValidMove(move, gameBoard);
        }
        System.out.println("Computer moved at position "+ move);
        updateBoard(move,2,gameBoard);
    }

    public static boolean isValidMove(int move, char[][] gameBoard) { // Takes Move input from player
        switch (move) {
            case 1:
                if (gameBoard[0][0] == '_') {  // if position empty then return true
                    return true;
                } else {
                    return false;
                }
            case 2:
                if (gameBoard[0][2] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (gameBoard[0][4] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 4:
                if (gameBoard[1][0] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 5:
                if (gameBoard[1][2] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 6:
                if (gameBoard[1][4] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 7:
                if (gameBoard[2][0] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 8:
                if (gameBoard[2][2] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 9:
                if (gameBoard[2][4] == ' ') {
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
                displayBoard(gameBoard);
                break;
            case 2:
                gameBoard[0][2] = character;
                displayBoard(gameBoard);
                break;
            case 3:
                gameBoard[0][4] = character;
                displayBoard(gameBoard);
                break;
            case 4:
                gameBoard[1][0] = character;
                displayBoard(gameBoard);
                break;
            case 5:
                gameBoard[1][2] = character;
                displayBoard(gameBoard);
                break;
            case 6:
                gameBoard[1][4] = character;
                displayBoard(gameBoard);
                break;
            case 7:
                gameBoard[2][0] = character;
                displayBoard(gameBoard);
                break;
            case 8:
                gameBoard[2][2] = character;
                displayBoard(gameBoard);
                break;
            case 9:
                gameBoard[2][4] = character;
                displayBoard(gameBoard);
                break;
            default:
                break;
        }
    }
    public static void tossToPlay(){
        int tossResult=(int) (Math.floor(Math.random()*10)%2);
        System.out.println("Tossing between Player and Computer who play first :");
        if ((tossResult==HEAD))
        {
            System.out.println("Player will start");
            playerMove(gameBoard);
        }
        else {
            System.out.println("Computer will start");
            computerMove(gameBoard);

        }
    }
}
