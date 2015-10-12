package es.upm.klondike.version030;

public class TurnOverStairController extends MoveController {

    protected TurnOverStairController(Board board) {
        super(board);
    }

    @Override
    public void receive(View gameView) {
        gameView.atender(this);
    }

    public boolean move(int numStair) {
        assert board.getNumCardsInDiscard() > 0;
        return board.turnOverStair(numStair);
    }
}
