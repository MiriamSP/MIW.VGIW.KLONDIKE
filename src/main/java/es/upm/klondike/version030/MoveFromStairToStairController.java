package es.upm.klondike.version030;

public class MoveFromStairToStairController extends MoveController {

    protected MoveFromStairToStairController(Board board) {
        super(board);
    }

    @Override
    public void receive(View gameView) {
        gameView.atender(this);
    }

    public boolean moveFromStairToStair(int origStair, int destStair, int numCards) {
        return board.moveFromStairToStair(origStair, destStair, numCards);
    }
}
