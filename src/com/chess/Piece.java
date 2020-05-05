package com.chess;

public class Piece {
    String type;
    boolean isEmpty;
    int hits;
    char player;
    char direction;

    public Piece(){
        type = "X";
        isEmpty = true;
        hits = 0;
        player = 0;
        direction = 'X';
    }

    public Piece(String type, char player, char direction){
        this.type = type;
        this.player = player;
        this.direction = direction;

        if (type.equals("D")){
            this.hits = 3;
        }
        isEmpty = false;
    }

}
