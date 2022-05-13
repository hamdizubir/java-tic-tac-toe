import java.util.*;
public class Main {

  // Function to print the board
  public static void printBoard(char[][] board) {
    System.out.println("4x4 Board:");
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        System.out.print(board[i][j]);
      }
      // separator
      System.out.println();
    }
  }

  // Function to check if the player won
  public static char checkPlayerWon(char[][] board) {

    //Check each row
    for (int i = 0; i < 4; i++) {
      if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][2] == board[i][3] && board[i][0] != '-') {
        return board[i][0];
      }
    }

    //Check each column
    for (int j = 0; j < 4; j++) {
      if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[2][j] == board[3][j] && board[0][j] != '-') {
        return board[0][j];
      }
    }

    //Check the diagonals
    if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] == board[3][3] && board[0][0] != '-') {
      return board[0][0];
    }
    if (board[3][0] == board[2][1] && board[2][1] == board[1][2] && board[1][2] == board[0][3] && board[3][0] != '-') {
      return board[3][0];
    }

    // nobody won yet
    return ' ';

  }

  // Check if board full
  public static boolean checkBoardFull(char[][] board) {
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        if (board[i][j] == '-') {
          return false;
        }
      }
    }
    return true;
  }
  public static void main(String[] args) {

    // initialize scanner
    Scanner in = new Scanner(System.in);

    // false means player 2 turn
    boolean isFirstPlayerTurn = true;

    // true means game ended
    boolean isGameFinished = false;

    // define the board 3x3
    char[][] board = new char[4][4];

    // draw board with dash (-)
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        board[i][j] = '-';
      }
    }

    // start the game
    System.out.println("TIC TAC TOE");
    System.out.println("-----------");
    System.out.println("Mulai Bermain!");
    System.out.print("Masukkan nama pemain 1? ");
    String pemain1 = in .nextLine();
    System.out.print("Masukkan nama pemain 2? ");
    String pemain2 = in .nextLine();

    while (!isGameFinished) {

      //Draw the board
      printBoard(board);

      //Print whose turn it is
      if (isFirstPlayerTurn) {
        System.out.println("Giliran " + pemain1 + " (X):");
      } else {
        System.out.println("Giliran " + pemain2 + " (O):");

      }

      // char to store player character
      char c = '-';
      if (isFirstPlayerTurn) {
        c = 'X';
      } else {
        c = 'O';
      }

      // define row and col
      int row = 0;
      int col = 0;

      // break if position out of boundary
      while (true) {

        // input user position
        System.out.print("Masukkan row (0, 1, 2, or 3): ");
        row = in .nextInt();
        System.out.print("Masukkan column (0, 1, 2, or 3): ");
        col = in .nextInt();

        // check if the row and col are 0, 1, 2 or 3
        if (row < 0 || col < 0 || row > 3 || col > 3) {
          System.out.println("Input salah, harap ulangi sesuai rule");

          // check if position already used
        } else if (board[row][col] != '-') {
          System.out.println("Position sudah terisi, harap ulangi");

        } else {
            // valid input, break the loop 
          break;
        }

      }

      // assign board position with char
      board[row][col] = c;

      // check if either player has won
      if (checkPlayerWon(board) == 'X') {
        System.out.println(pemain1 + " menang!");
        isGameFinished = true;
      } else if (checkPlayerWon(board) == 'O') {
        System.out.println(pemain2 + " menang!");
        isGameFinished = true;
      } else {

        // check if no player won and board is full
        if (checkBoardFull(board)) {
          System.out.println("seri!");
          isGameFinished = true;
        } else {
          // change player turn
          isFirstPlayerTurn = !isFirstPlayerTurn;
        }

      }

    }
    // print board
    printBoard(board);
  }
}