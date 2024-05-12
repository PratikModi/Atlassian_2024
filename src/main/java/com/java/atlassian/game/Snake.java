package com.java.atlassian.game;

import java.util.LinkedList;
import java.util.List;

public class Snake {

    private List<Cell> body;
    private Cell head;

    public Snake(Cell initialPosition) {
        this.head = initialPosition;
        this.head.setCellType(CellType.SNAKE);
        this.body = new LinkedList<>();
        this.body.addFirst(head);
    }

    public void move(Cell nextCell){
        Cell tail = body.removeLast();
        tail.setCellType(CellType.EMPTY);
        this.head = nextCell;
        this.head.setCellType(CellType.SNAKE);
        this.body.addFirst(head);
    }

    public boolean checkIfCrash(Cell nextCell){
        for(var cell : body){
            if(cell.equals(nextCell)){
                return true;
            }
        }
        return false;
    }


    public List<Cell> getBody() {
        return body;
    }

    public void setBody(List<Cell> body) {
        this.body = body;
    }

    public Cell getHead() {
        return head;
    }

    public void setHead(Cell head) {
        this.head = head;
    }
}
