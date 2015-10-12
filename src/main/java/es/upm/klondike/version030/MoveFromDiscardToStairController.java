package es.upm.klondike.version030;

public class MoveFromDiscardToStairController extends MoveController {
    protected MoveFromDiscardToStairController(Board board) {
        super(board);
    }

    @Override
    public void receive(View gameView) {
        gameView.atender(this);
    }

    public boolean move(int stair) {
        return board.moveFromDiscardToStair(stair);
    }

}
