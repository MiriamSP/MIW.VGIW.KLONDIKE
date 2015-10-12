package es.upm.klondike.version030;

public class MoveFromStairToSuitController extends MoveController {

    protected MoveFromStairToSuitController(Board board) {
        super(board);
    }

    @Override
    public void receive(View gameView) {
        gameView.atender(this);
    }

    public boolean moveFromStairToSuitController(int stair) {
        return board.moveFromStairToSuit(stair);
    }
}
