package es.upm.klondike.version030;

public class MoveControllerFactory {
    private Board board;

    private MoveController[] moveControllers;

    public MoveControllerFactory(Board board) {
        assert board != null;
        this.board = board;
        moveControllers = new MoveController[8];
        moveControllers[0] = new MoveFromDeckToDiscardController(board);
        moveControllers[1] = new MoveFromDiscardToDeckController(board);
        moveControllers[2] = new MoveFromDiscardToSuitController(board);
        moveControllers[3] = new MoveFromDiscardToStairController(board);
        moveControllers[4] = new MoveFromStairToSuitController(board);
        moveControllers[5] = new MoveFromStairToStairController(board);
        moveControllers[6] = new MoveFromSuitToStairController(board);
        moveControllers[7] = new TurnOverStairController(board);

    }

    public MoveController getController(int controller) {
        if (!board.isFinished()) {
            return moveControllers[controller];
        }
        return null;
    }
}
