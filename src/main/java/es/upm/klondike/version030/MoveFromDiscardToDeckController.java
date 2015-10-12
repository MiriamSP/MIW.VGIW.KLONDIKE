package es.upm.klondike.version030;

public class MoveFromDiscardToDeckController extends MoveController {

    protected MoveFromDiscardToDeckController(Board board) {
        super(board);
    }

    @Override
    public void receive(View gameView) {
        gameView.atender(this);
    }

    public void move() {
        assert board.getNumCardsInDiscard() == 0;
        board.moveFromDiscardToDeck();
    }
}
