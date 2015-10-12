package es.upm.klondike.version030;

public class MoveFromDiscardToDeckView {

    private MoveFromDiscardToDeckController moveFromDiscardToDeckController;

    public MoveFromDiscardToDeckView(MoveFromDiscardToDeckController moveFromDiscardToDeckController) {
        this.moveFromDiscardToDeckController = moveFromDiscardToDeckController;
    }

    public void render() {
        if (moveFromDiscardToDeckController.board.getNumCardsInDiscard() > 0) {
            moveFromDiscardToDeckController.move();
        }
    }
}
