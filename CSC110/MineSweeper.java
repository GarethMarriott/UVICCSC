/*
  Created by gareth on 11/5/2016.
  v00875748
 */
import java.util.*;

public class MineSweeper {

    public static void main(String[] args) {

        int[][] gameBoard = new int[8][8];

        boolean[][] gameState = new boolean[8][8];

        initializeFullGrid(gameBoard);

        boolean game = true;
        while (game == true) {

            int y = getInput("Row");
            int x = getInput("Column");

            revealGridCell(gameBoard, gameState , y , x);

            drawFullGrid(gameBoard, gameState);

            game = checkGameState(gameState);

//            printGridTrue(gameBoard); // *Testing*


        }
    }

    public static int[][] initializeFullGrid(int[][] gameBoard) {

        // 9 = bomb
        for (int i = 0; i < 10; i++) {

            Random ran = new Random();

            int y = ran.nextInt(8);
            int x = ran.nextInt(8);


            if (gameBoard[y][x] == 9) {

                while (gameBoard[y][x] == 9) {

                    y = ran.nextInt(8);
                    x = ran.nextInt(8);

                }
            }

            gameBoard[y][x] = 9;

        }
        gameBoard = numberOfBombs(gameBoard);

        return gameBoard;
    }

    public static int[][] numberOfBombs(int[][] gameBoard) {

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                int counter = 0;
                if (gameBoard[y][x] == 9) {
                    continue;
                }

                if (y != 0 && x != 0) {
                    if (gameBoard[y - 1][x - 1] == 9) {
                        counter++;
                    }
                }
                if (x != 0) {
                    if (gameBoard[y][x - 1] == 9) {
                        counter++;
                    }
                }
                if (x != 0 && y != 7) {
                    if (gameBoard[y + 1][x - 1] == 9) {
                        counter++;
                    }
                }
                if (y != 7) {
                    if (gameBoard[y + 1][x] == 9) {
                        counter++;
                    }
                }
                if (y != 7 && x != 7) {
                    if (gameBoard[y + 1][x + 1] == 9) {
                        counter++;
                    }
                }
                if (x != 7) {
                    if (gameBoard[y][x + 1] == 9) {
                        counter++;
                    }
                }
                if (x != 7 && y != 0) {
                    if (gameBoard[y - 1][x + 1] == 9) {
                        counter++;
                    }
                }
                if (y != 0) {
                    if (gameBoard[y - 1][x] == 9) {
                        counter++;
                    }
                }

                gameBoard[y][x] = counter;
            }
        }
        return gameBoard;
    }

    public static boolean[][] revealGridCell(int[][] gameBoard, boolean[][] gameState , int y , int x) {


        if (gameBoard[y][x] == 9) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    gameState[i][j] = true;
                }
            }
            System.out.println("BOOM!!! GAMEOVER");
            drawFullGrid(gameBoard , gameState);
            System.exit(1);

        }else if(gameBoard[y][x] == 0){
            gameState[y][x] = true;

            if ((y != 0 && x != 0)&& (gameState[y - 1][x - 1] == false)) {

                if(gameState[y-1][x-1] == false) {
                    gameState = revealGridCell(gameBoard, gameState, y - 1, x - 1);
                }
            }
            if ((x != 0)&& (gameState[y][x - 1] == false)) {
                if(gameState[y][x-1] == false) {
                    gameState = revealGridCell(gameBoard, gameState, y, x - 1);
                }
            }
            if ((x != 0 && y != 7)&& (gameState[y + 1][x - 1] == false)) {
                if(gameState[y+1][x-1] == false) {
                    gameState = revealGridCell(gameBoard, gameState, y + 1, x - 1);
                }
            }
            if ((y != 7) && (gameState[y + 1][x] == false)) {
                if(gameState[y+1][x] == false) {
                    gameState = revealGridCell(gameBoard, gameState, y + 1, x);
                }
            }
            if ((y != 7 && x != 7)&& (gameState[y + 1][x + 1] == false)) {
                if(gameState[y+1][x+1] == false) {
                    gameState = revealGridCell(gameBoard, gameState, y + 1, x + 1);
                }
            }
            if ((x != 7)&& (gameState[y][x + 1] == false)) {
                if(gameState[y][x+1] == false) {
                    gameState = revealGridCell(gameBoard, gameState, y, x + 1);
                }
            }
            if ((x != 7 && y != 0)&& (gameState[y - 1][x + 1] == false)) {
                if(gameState[y-1][x+1] == false) {
                    gameState = revealGridCell(gameBoard, gameState, y - 1, x + 1);
                }
            }
            if ((y != 0)&& (gameState[y - 1][x] == false)) {
                if(gameState[y-1][x] == false) {
                    gameState = revealGridCell(gameBoard, gameState, y - 1, x);
                }
            }

            //revealZeros(gameState , gameBoard , y , x);
        }else{
            gameState[y][x] = true;
        }


        return gameState;
    }

    public static void drawFullGrid(int[][] gameBoard, boolean[][] gameState) {

        System.out.println("+ | 0 1 2 3 4 5 6 7");
        System.out.println("-------------------");
        for (int i = 0; i < 8; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < 8; j++) {
                if (gameState[i][j] == true) {
                    if (gameBoard[i][j] == 9) {
                        System.out.print("* ");
                    }else if(gameBoard[i][j] == 0){
                        System.out.print("  ");
                    }else {
                        System.out.print(gameBoard[i][j] + " ");
                    }
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }


    }


    // FOR TESTING
    public static void printGridTrue(int[][] gameBoard){

        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++) {
                if (gameBoard[i][j] == 9) {
                    System.out.print("* ");
                } else {
                    System.out.print(gameBoard[i][j] + " ");
                }
            }
            System.out.println();
        }
    }


    public static int getInput(String axis) {
        Scanner sc = new Scanner(System.in);

        int var = 0;

        try {
            System.out.println("Please enter a valid " + axis + " value (a digit between 0 and 7): ");
            var = sc.nextInt();
            if ((var < 0) || (var > 7)){
                throw new Exception();
            }

        } catch (Exception ex) {
            System.out.print("ERROR!! ");
            var = getInput(axis);
        }
        return var;
    }



    public static boolean checkGameState(boolean[][] gameState){
        int counter = 0;
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (gameState[i][j] == false){
                    counter++;
                }
            }
        }
        if (counter == 10){
            return false;
        }else{
            return true;
        }
    }
}