package es.upm.klondike.version030;

public class Klondike {
    private Board board;
    
    private MoveControllerFactory moveControllerFactory;
    
    private GameView gameView;
    
    public Klondike() {
        board = new Board();
        moveControllerFactory = new MoveControllerFactory(board);
        gameView = new GameView(moveControllerFactory, board);
    }

    public void play() {
        gameView.render();
    }
    
    public static void main(String[] args) {
        new Klondike().play();
    }
}
