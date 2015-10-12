package es.upm.klondike.version030;

public class GameView implements View {
    private MoveControllerFactory moveControllerFactory;

    private Board board;

    public GameView(MoveControllerFactory moveControllerFactory, Board board) {
        this.moveControllerFactory = moveControllerFactory;
        this.board = board;
    }

    @Override
    public void render() {
        MoveController controller;
        do {
            controller = moveControllerFactory.getController(new MenuView(board).showMenu());
            if (controller != null) {
                controller.receive(this);
            }
        } while (controller != null);
    }

    @Override
    public void atender(MoveFromDeckToDiscardController moveFromDeckToDiscardController) {
        new MoveFromDeckToDiscardView(moveFromDeckToDiscardController).render();
    }

    @Override
    public void atender(MoveFromDiscardToDeckController moveFromDiscardToDeckController) {
        new MoveFromDiscardToDeckView(moveFromDiscardToDeckController).render();
    }

    @Override
    public void atender(MoveFromDiscardToSuitController moveFromDiscardToSuitController) {
        new MoveFromDiscardToSuitView(moveFromDiscardToSuitController).render();
    }

    @Override
    public void atender(MoveFromDiscardToStairController moveFromDiscardToStairController) {
        new MoveFromDiscardToStairView(moveFromDiscardToStairController).render();
    }

    @Override
    public void atender(MoveFromStairToSuitController moveFromStairToSuitController) {
        new MoveFromStairToSuitView(moveFromStairToSuitController).render();
    }

    @Override
    public void atender(MoveFromStairToStairController moveFromStairToStairController) {
        new MoveFromStairToStairView(moveFromStairToStairController).render();
    }

    @Override
    public void atender(MoveFromSuitToStairController moveFromSuitToStair) {
        new MoveFromSuitToStairView(moveFromSuitToStair).render();
    }

    @Override
    public void atender(TurnOverStairController turnOverStairController) {
        new TurnOverStairView(turnOverStairController).render();
    }
}
