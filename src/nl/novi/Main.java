package nl.novi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welkom bij Boterrrrr, kaas ennnnnn ...... eieren !!!");

        //  1. Een bord maken
        String[] board = new String[9];

        for (int i = 0; i < 9; i++) {
            board[i] = Integer.toString(i + 1);
        }

        printBoard(board);

        String currentPlayer = "X";


        while(true) {

            System.out.println("\n Kies een getal van 1 tot 9 voor het plaatsen van een " + currentPlayer + " op het bord");

            Scanner boardInput = new Scanner(System.in);
            int selectedField = boardInput.nextInt();

            board[selectedField - 1] = currentPlayer;

            printBoard(board);

            //  Kijken of speler gewonnen heeft
            if(checkWin(board, currentPlayer)) {
                System.out.println("\n Het spel is klaar, speler " + currentPlayer + " heeft gewonnen");
                break;
            }

            // 3. Wissel van speler
            currentPlayer = switchPlayer(currentPlayer);

        }
    }

    public static void printBoard (String[]board){
            for (int i = 0; i < board.length; i++) {
                System.out.print(board[i]);

                boolean isEndOfRow = (i + 1) % 3 == 0;
                boolean isLastField = i == 8;

                if (!isEndOfRow) {
                    System.out.print(" | ");
                }

                if (isEndOfRow && !isLastField) {
                    System.out.println("\n _______");
                }
            }
        }

    public static String switchPlayer(String currentPlayer)  {
        if(currentPlayer == "X")    {
            return "O";
        }   else    {
            return "X";
        }
        }

    public static boolean checkWin(String[] board, String currentPlayer)    {
        // horizontale opties om te winnen
        if (board[0] == currentPlayer && board [1] == currentPlayer && board[2] == currentPlayer)    {
            return true;
        } else if (board[3] == currentPlayer && board [4] == currentPlayer && board[5] == currentPlayer)  {
            return true;
        } else if (board[6] == currentPlayer && board [7] == currentPlayer && board[8] == currentPlayer)  {
            return true;
        }

        // verticale opties om te winnen
        else if (board[0] == currentPlayer && board [3] == currentPlayer && board[6] == currentPlayer)    {
            return true;
        } else if (board[1] == currentPlayer && board [4] == currentPlayer && board[7] == currentPlayer)  {
            return true;
        } else if (board[2] == currentPlayer && board [5] == currentPlayer && board[8] == currentPlayer)  {
            return true;
        }

        // diagonale opties om te winnen
        else if (board[0] == currentPlayer && board [4] == currentPlayer && board[8] == currentPlayer)    {
            return true;
        } else if (board[2] == currentPlayer && board [4] == currentPlayer && board[6] == currentPlayer)  {
            return true;
        }   else    {
            return false;
        }
    }
    }

