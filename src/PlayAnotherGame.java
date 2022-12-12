import java.util.Random;
import java.util.Scanner;

public class PlayAnotherGame {
    public static final int HEAD = 0;
    public static final int TAIL = 1;
    static Scanner sc = new Scanner(System.in);
    private static char computer;
    private static char player;
    static char[][] gameBoard = {{'_', '|', '_', '|', '_'}, {'_', '|', '_', '|', '_'}, {' ', '|', ' ', '|', ' '}};
    static int playerScore = 0;
    static int computerScore = 0;

    public static void main(String[] args) {
        System.out.println("\n*** WELCOME TO TIC TAC TOE GAME ***");
        dispayBoard(gameBoard);
        tossToPlay();
        chooseLetter();
        System.out.println("Show Current Board: ");
        dispayBoard(gameBoard);
        playerMove(gameBoard);
        computerMove(gameBoard);
        isWnnerOrTie(gameBoard);
        //ChooseCorner(gameBoard);
        boolean gameOver = false;
        boolean playAgain = true;

        while(playAgain) { //ask to play again once win or tie player got.
            while (!gameOver) {
                playerMove(gameBoard);
                gameOver = isWnnerOrTie(gameBoard);
                if (gameOver) {
                    break;
                }
                computerMove(gameBoard);
                gameOver = isWnnerOrTie(gameBoard);
                if (gameOver) {
                    break;
                }
            }
            System.out.println("Player Score: " +playerScore);
            System.out.println("Computer Score: "+ computerScore);
            System.out.println("Would you like to play again? Y/N");
            sc.nextLine();
            String result = sc.nextLine();
            switch (result){
                case "Y":
                case "y":
                    playAgain = true;
                    System.out.println("Dope! Let's play again");
                    resetBoard(gameBoard);
                    gameOver = false;
                    dispayBoard(gameBoard);
                    break;
                case "N":
                case "n":
                    playAgain = false;
                    System.out.println("Thanks for playing");
                    break;
                default:
                    break;
            }
        }
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
        updateBoard(move, 1, gameBoard);
    }

    public static void computerMove(char[][] gameBoard) {// For Playing computer
        Random rand = new Random();  // used random function to play randomly by computer
        int move = rand.nextInt(9) + 1;
        boolean result = isValidMove(move, gameBoard);
        while (!result) {
            move = rand.nextInt(9) + 1;
            result = isValidMove(move, gameBoard);
        }
        System.out.println("Computer moved at position " + move);
        updateBoard(move, 2, gameBoard);
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

    public static void updateBoard(int position, int player, char[][] gameBoard) {
        char character;
        if (player == 1) {
            character = 'X';   // player =1 having X character
        } else {
            character = 'O';  // Computer =2 having O character
        }
        switch (position) {
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

    public static void tossToPlay() {
        int tossResult = (int) (Math.floor(Math.random() * 10) % 2);
        if ((tossResult == HEAD)) {
            System.out.println("Player Turn:");
            System.out.println("Player will start");
            playerMove(gameBoard);
        } else {
            System.out.println("Computer Turn:");
            System.out.println("Computer will start");
            computerMove(gameBoard);

        }
    }

    public static boolean isWnnerOrTie(char[][] gameboard) {// Checking if win condition has met is to check all spaces in combination are samw

        //Horizontal Win
        if (gameboard[0][0] == 'X' && gameboard[0][2] == 'X' && gameboard[0][4] == 'X') {
            System.out.println("Player Wins");
            playerScore++;
            return true;
        }
        if (gameboard[0][0] == 'O' && gameboard[0][2] == 'O' && gameboard[0][4] == 'O') {
            System.out.println("Computer Wins");
            computerScore++;
            return true;
        }
        if (gameboard[1][0] == 'X' && gameboard[1][2] == 'X' && gameboard[1][4] == 'X') {
            System.out.println("Player Wins");
            playerScore++;
            return true;
        }
        if (gameboard[1][0] == 'O' && gameboard[1][2] == 'O' && gameboard[1][4] == 'O') {
            System.out.println("Computer Wins");
            computerScore++;
            return true;
        }
        if (gameboard[2][0] == 'X' && gameboard[2][2] == 'X' && gameboard[2][4] == 'X') {
            System.out.println("Player Wins");
            playerScore++;
            return true;
        }
        if (gameboard[2][0] == 'O' && gameboard[2][2] == 'O' && gameboard[2][4] == 'O') {
            System.out.println("Computer Wins");
            computerScore++;
            return true;
        }
        //Vertical Wins
        if (gameboard[0][0] == 'X' && gameboard[1][0] == 'X' && gameboard[2][0] == 'X') {
            System.out.println("Player Wins");
            playerScore++;
            return true;
        }
        if (gameboard[0][0] == 'O' && gameboard[1][0] == 'O' && gameboard[2][0] == 'O') {
            System.out.println("Computer Wins");
            computerScore++;
            return true;
        }
        if (gameboard[0][2] == 'X' && gameboard[1][2] == 'X' && gameboard[2][2] == 'X') {
            System.out.println("Player Wins");
            playerScore++;
            return true;
        }
        if (gameboard[0][2] == 'O' && gameboard[1][2] == 'O' && gameboard[2][2] == 'O') {
            System.out.println("Computer Wins");
            computerScore++;
            return true;
        }
        if (gameboard[0][4] == 'X' && gameboard[1][4] == 'X' && gameboard[2][4] == 'X') {
            System.out.println("Player Wins");
            playerScore++;
            return true;
        }
        if (gameboard[0][4] == 'O' && gameboard[1][4] == 'O' && gameboard[2][4] == 'O') {
            System.out.println("Computer Wins");
            computerScore++;
            return true;
        }
        //Diagonal Wins
        if (gameboard[0][0] == 'X' && gameboard[1][2] == 'X' && gameboard[2][4] == 'X') {
            System.out.println("Player Wins");
            playerScore++;
            return true;
        }
        if (gameboard[0][0] == 'O' && gameboard[1][2] == 'O' && gameboard[2][4] == 'O') {
            System.out.println("Computer Wins");
            computerScore++;
            return true;
        }
        if (gameboard[2][0] == 'X' && gameboard[1][2] == 'X' && gameboard[0][4] == 'X') {
            System.out.println("Player Wins");
            playerScore++;
            return true;
        }
        if (gameboard[2][0] == 'O' && gameboard[1][2] == 'O' && gameboard[0][4] == 'O') {
            System.out.println("Computer Wins");
            computerScore++;
            return true;
        }
        if (gameboard[0][0] != '_' && gameboard[0][2] != '_' && gameboard[0][4] != '_' && gameboard[1][0] != '_' &&
                gameboard[1][2] != '_' && gameboard[1][4] != '_' && gameboard[2][0] != ' ' && gameboard[2][2] != ' ' && gameboard[2][4] != ' ') {
            System.out.println("-------------Board is full-------------------");
            System.out.println("Its a tie........Try Again");
            return true;
        }
        return false;
    }

    public static void ChooseCorner(char[][] gameboard) {
        boolean corner = false;
        for (int row = 0; row < gameBoard.length; row++) {  /// for the rows
            for (int col = 0; col < gameBoard[0].length; col++) {// for column
            }
            System.out.println();
        }
        if (gameboard[0][0] == '_') {  // if position empty then return true
            System.out.println("Corner 1 is available");
            corner = true;
        } else if (gameboard[0][4] == '_') {
            System.out.println("Corner 3 is available");
            corner = true;
        } else if (gameboard[2][0] == ' ') {
            System.out.println("Corner 7 is available");
            corner = true;
        } else if (gameboard[2][4] == ' ') {
            System.out.println("Corner 9 is available");
            corner = true;
        }
        if (corner!=true){
            System.out.println("No corner available");
            subsequentChoice(gameboard);
        }

    }
    public static void subsequentChoice(char[][] gameboard) {
        boolean middle=false;
        if (gameboard[1][2] == '_') {
            System.out.println("middle 5 is available");
            middle= true;
        }
        if (gameboard[0][2] == '_') {  // if position empty then return true
            System.out.println("Corner 2 is available");
        } else if (gameboard[1][0] == '_') {
            System.out.println("Corner 4 is available");
        } else if (gameboard[1][4] == ' ') {
            System.out.println("Corner 6 is available");
        } else if (gameboard[2][2] == ' ') {
            System.out.println("Corner 8 is available");
        }
    }
    public static void resetBoard(char [][] gameBoard){ // set the board back to beginning state.
        gameBoard[0][0] = '_';
        gameBoard[0][2] = '_';
        gameBoard[0][4] = '_';
        gameBoard[1][0] = '_';
        gameBoard[1][2] = '_';
        gameBoard[1][4] = '_';
        gameBoard[2][0] = ' ';
        gameBoard[2][2] = ' ';
        gameBoard[2][4] = ' ';
    }


}
