package es.upm.klondike.version030;

public interface View {
    void render();

    void atender(MoveFromDeckToDiscardController moveFromDeckToDiscardController);

    void atender(MoveFromDiscardToDeckController moveFromDiscardToDeckController);

    void atender(MoveFromDiscardToSuitController moveFromDiscardToSuitController);

    void atender(MoveFromDiscardToStairController moveFromDiscardToStairController);

    void atender(MoveFromStairToSuitController moveFromStairToSuitController);

    void atender(MoveFromStairToStairController moveFromStairToStairController);

    void atender(MoveFromSuitToStairController moveFromSuitToStairController);

    void atender(TurnOverStairController turnOverStairController);

}
