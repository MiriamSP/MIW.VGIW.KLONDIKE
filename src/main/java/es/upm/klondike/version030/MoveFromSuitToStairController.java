package es.upm.klondike.version030;

public class MoveFromSuitToStairController extends MoveController {
    protected MoveFromSuitToStairController(Board board) {
        super(board);
    }

    @Override
    public void receive(View gameView) {
        gameView.atender(this);
    }

    public boolean moveFromSuitToStair(int numSuit, int stair) {
        return board.moveFromSuitToStair(numSuit, stair);
    }
}
