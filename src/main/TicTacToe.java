package main;

import java.util.Scanner;

public class TicTacToe {
    int[][] gameBoard = new int[3][3];
    Scanner inputScan = new Scanner(System.in);

    String playerX = "X", playerO = "O", currentPlayer = playerX;

    int row, col;

    boolean win=false;

    TicTacToe(){
        initGameBoard();

        while (!win){
            drawGameBoard();

            System.out.println("Ход игрока " + currentPlayer);
            System.out.println("Выбери строку: ");
            row = inputScan.nextInt();

            System.out.println("Выбери столбец: ");
            col = inputScan.nextInt();

            if (gameBoard[row][col]!=0){
                System.out.println("Эта клетка занята! Веберите другую");
                continue;
            }

            currentPlayer = currentPlayer.equals(playerX) ? playerO : playerX;

            if (currentPlayer.equals(playerO)) gameBoard[row][col]=1;
            else gameBoard[row][col]=2;

            checkWin();

        }
        currentPlayer = currentPlayer.equals(playerX) ? playerO : playerX;
        drawGameBoard();
        System.out.println("Победил "+ currentPlayer);

    }

    private void initGameBoard(){
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[row].length ; col++) {
                gameBoard[row][col] = 0;
            }
        }
    }

    private void drawGameBoard(){
        for (int i=0; i<gameBoard.length; i++){
            for (int j=0; j<gameBoard[i].length; j++){
                switch (gameBoard[i][j]){
                    case 0:
                        System.out.print("   ");
                        break;
                    case 1:
                        System.out.print(" X ");
                        break;
                    case 2:
                        System.out.print(" O ");
                        break;
                }
                if(j<gameBoard.length - 1)
                    System.out.print(" | ");
            }
            System.out.println();
            if(i < gameBoard.length - 1)
                System.out.println("---------------");
        }
    }

    private void checkWin(){
        int fullElement = 0;
        for(int i = 0; i<gameBoard.length; i++){
            for (int j = 0; j<gameBoard[i].length; j++){
                if (gameBoard[i][j]!=0) fullElement++;
            }
        }
        if(fullElement==9) {
            System.out.println("Ничья!");
            win = true;
        }

        int [][] winCoodr = {{0,1,2},{0,0,0},{1,1,1},{2,2,2},{2,1,0}};

        for(int i = 0; i<gameBoard.length; i++){
            if (gameBoard[i][0]==gameBoard[i][1] & gameBoard[i][1]==gameBoard[i][2] & gameBoard[i][0]!=0) win = true;
        }

        for(int i = 0; i<gameBoard.length; i++){
            if (gameBoard[0][i]==gameBoard[1][i] & gameBoard[1][i]==gameBoard[2][i] & gameBoard[0][i]!=0) win = true;
        }

        if (gameBoard[0][0]==gameBoard[1][1] & gameBoard[1][1]==gameBoard[2][2] & gameBoard[0][0]!=0) win = true;

        if (gameBoard[0][2]==gameBoard[1][1] & gameBoard[1][1]==gameBoard[2][0] & gameBoard[0][2]!=0) win = true;

    }
}
