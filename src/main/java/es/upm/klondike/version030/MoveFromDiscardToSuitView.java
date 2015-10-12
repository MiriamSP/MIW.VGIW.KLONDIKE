package es.upm.klondike.version030;

public class MoveFromDiscardToSuitView {
    private MoveFromDiscardToSuitController moveFromDiscardToSuitController;

    public MoveFromDiscardToSuitView(MoveFromDiscardToSuitController moveFromDiscardToSuitController) {
        this.moveFromDiscardToSuitController = moveFromDiscardToSuitController;
    }

    public void render() {
        moveFromDiscardToSuitController.move();
    }

}
