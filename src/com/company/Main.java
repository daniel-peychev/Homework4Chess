package com.company;
import com.chess.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        board.setBoard();
        int player = 1;
        String command;
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.flush();
            board.printBoard();
            System.out.println("Enter move Command(oldX,oldY,newX,newY) ");
            command = scan.nextLine();
            String[] com = command.split(",");
            int oldX = Integer.parseInt(com[0]);
            int oldY = Integer.parseInt(com[1]);
            int newX = Integer.parseInt(com[2]);
            int newY = Integer.parseInt(com[3]);

            boolean ok = board.movePiece(oldX, oldY, newX, newY, player);
            if(ok){
                player = player == 1 ? 2 : 1;
            }
        }
    }
}
