package com.java.atlassian.game;

public class Game {

    private Snake snake;
    private Board board;
    private boolean isGameOver;
    private int direction;

    private static final int LEFT = -1;
    private static final int RIGHT = 1;
    private static final int UP = -2;
    private static final int DOWN = 2;

    public Game(Snake snake, Board board) {
        this.snake = snake;
        this.board = board;
        this.isGameOver=false;
    }

    public void update(){
        if(!isGameOver){
            var nextCell = nextCell(snake.getHead());
            CellType type = nextCell.getCellType();
            if(getSnake().checkIfCrash(nextCell)){
                isGameOver=true;
                //Send Notification
            }else{
                snake.move(nextCell);
                if(type.equals(CellType.FOOD)) {
                    //snake.grow();
                }
            }

        }
    }

    public Cell nextCell(Cell currentPosition){
        int row = currentPosition.getRow();
        int column = currentPosition.getColumn();
        if(direction==LEFT)
            column--;
        else if(direction==RIGHT)
            column++;
        else if(direction==UP)
            row--;
        else if(direction==DOWN)
            row++;
        //ERROR CHECK
        return board.getCells()[row][column];
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
        update();
    }

    public void start(){
        Board board1 = new Board(10,10);
        Snake snake1 = new Snake(board1.getCells()[9][0]);
        Game game = new Game(snake1,board1);
        game.setDirection(RIGHT);
    }


}
