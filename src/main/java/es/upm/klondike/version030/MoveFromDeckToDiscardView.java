package es.upm.klondike.version030;

public class MoveFromDeckToDiscardView {

    private MoveFromDeckToDiscardController moveFromDeckToDiscardController;

    public MoveFromDeckToDiscardView(MoveFromDeckToDiscardController moveFromDeckToDiscardController) {
        this.moveFromDeckToDiscardController = moveFromDeckToDiscardController;
    }

    public void render() {
        moveFromDeckToDiscardController.move();
    }
}