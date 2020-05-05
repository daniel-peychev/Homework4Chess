package com.chess;

public class Board {
    Piece[][] boardMatrix = new Piece[6][6];
    int winner = 0;

    public void setBoard(){
        boardMatrix[0][0] = boardMatrix[0][5] = new Piece("Dw", 'w', 'f');
        boardMatrix[0][1] = new Piece("D", 'w', 'f');
        boardMatrix[0][2] = new Piece("Q", 'w', 'f');
        boardMatrix[0][3] = new Piece("K", 'w', 'f');
        boardMatrix[0][4] = new Piece("M", 'w', 'f');

        for (int i = 1; i < 5; i++){
            for (int j = 0; j < 6; j++) {
                boardMatrix[i][j] = new Piece();
            }
        }

        boardMatrix[5][0] = boardMatrix[5][5] = new Piece("Dw", 'b', 'b');
        boardMatrix[5][1] = new Piece("M", 'b', 'b');
        boardMatrix[5][2] = new Piece("K", 'b', 'b');
        boardMatrix[5][3] = new Piece("Q", 'b', 'b');
        boardMatrix[5][4] = new Piece("D", 'b', 'b');
    }
    public boolean movePiece(int fromX, int fromY, int toX, int toY, int player){
        Piece p = boardMatrix[fromX][fromY];

        if (p.type.equals("Dw")){
            return moveDw(fromX, fromY, toX, toY, player);
        } else if (p.type.equals("M")) {
            return moveM(fromX, fromY, toX, toY, player);
        } else if (p.type.equals("K")){
            return moveK(fromX, fromY, toX, toY, player);
        } else if (p.type.equals("Q")){
            return moveQ(fromX, fromY, toX, toY, player);
        } else if (p.type.equals("D")){
            return moveD(fromX, fromY, toX, toY, player);
        }
        return false;
    }

    private boolean moveDw(int fromX, int fromY, int toX, int toY, int player){
        Piece p = boardMatrix[fromX][fromY];
        if (player == 1 && p.player == 'b' ||
                player == 2 && p.player == 'w'){
            System.out.println("You can't move other player's peices");
            return false;
        }

        if (p.direction == 'f' && (fromY + 1 != toY || fromX != toX) && fromY < 5 ||
                p.direction == 'b' && (fromY - 1 != toY || fromX != toX) && fromY > 0){
            System.out.println("Wrong coordinates!");
            return false;
        }

        if (toY == 5){
            p.direction = 'b';
        } else if (toY == 0){
            p.direction = 'f';
        }

        boardMatrix[toY][toX] = new Piece(p.type, p.player, p.direction);
        clearField(fromX, fromY);

        return true;
    }
    private boolean moveM(int fromX, int fromY, int toX, int toY, int player){
        Piece p = boardMatrix[fromX][fromY];
        if (player == 1 && p.player == 'b' ||
                player == 2 && p.player == 'w'){
            System.out.println("You can't move other player's peices");
            return false;
        }

        if (!((Math.abs(fromX - toX) == 1) && fromY == toY) ||
        !(Math.abs(fromY - toY) == 1 && fromX == toX) ||
        !legidCoordinates(fromX, fromY, toX, toY)){
            System.out.println("Invalid coordinates!");
            return false;
        }

        boardMatrix[toX][toY] = p;
        clearField(fromX, fromY);

        return true;
    }

    private boolean moveK(int fromX, int fromY, int toX, int toY, int player){
        Piece p = boardMatrix[fromX][fromY];
        if (player == 1 && p.player == 'b' ||
                player == 2 && p.player == 'w'){
            System.out.println("You can't move other player's peices");
            return false;
        }

        if (!(Math.abs(fromX - toX) <= 1) ||
                !(Math.abs(fromY - toY) <= 1) ||
                !legidCoordinates(fromX, fromY, toX, toY)){
            System.out.println("Invalid coordinates!");
            return false;
        }

        boardMatrix[toX][toY] = p;
        clearField(fromX, fromY);

        return true;
    }

    private boolean moveQ(int fromX, int fromY, int toX, int toY, int player){
        Piece p = boardMatrix[fromX][fromY];
        if (player == 1 && p.player == 'b' ||
                player == 2 && p.player == 'w'){
            System.out.println("You can't move other player's peices");
            return false;
        }

        if (!(Math.abs(fromX - toX) == 1 && Math.abs(fromY - toY) == 1) ||
                !legidCoordinates(fromX, fromY, toX, toY)){
            System.out.println("Invalid coordinates!");
            return false;
        }

        boardMatrix[toX][toY] = p;
        clearField(fromX, fromY);

        return true;
    }

    private boolean moveD(int fromX, int fromY, int toX, int toY, int player){
        Piece p = boardMatrix[fromX][fromY];
        if (player == 1 && p.player == 'b' ||
                player == 2 && p.player == 'w'){
            System.out.println("You can't move other player's peices");
            return false;
        }

        if (!(Math.abs(fromX - toX) <= 2) ||
                !(Math.abs(fromY - toY) <= 2) ||
                !legidCoordinates(fromX, fromY, toX, toY)){
            System.out.println("Invalid coordinates!");
            return false;
        }

        boardMatrix[toX][toY] = p;
        clearField(fromX, fromY);

        return true;
    }

    private boolean legidCoordinates(int fromX, int fromY, int toX, int toY){
        return fromX >= 0 && fromX < 6 && toX >= 0 && toX < 6 && fromY >=0 && toY >=0 && toY < 6;
    }

    private void clearField(int x, int y){
        boardMatrix[x][y] = new Piece();
    }

    public void printBoard(){
        for (int i = 0; i < 6; i++){
            System.out.println("==========================");
            for(int j = 0; j < 6; j++){
                if (!boardMatrix[i][j].isEmpty) {
                    System.out.print(boardMatrix[i][j].player + boardMatrix[i][j].type + " ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
