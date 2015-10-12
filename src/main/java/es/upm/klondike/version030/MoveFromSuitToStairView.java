package es.upm.klondike.version030;

public class MoveFromSuitToStairView {

    private MoveFromSuitToStairController moveFromSuitToStairController;

    public MoveFromSuitToStairView(MoveFromSuitToStairController moveFromSuitToStairController) {
        this.moveFromSuitToStairController = moveFromSuitToStairController;
    }

    public void render() {
        int suit;
        suit = new LimitedIntDialog("De qué palo? ", 1, 4).read();
        int stair;
        stair = new LimitedIntDialog("A qué escalera [1-7]", 1, 7).read();
        boolean result = moveFromSuitToStairController.moveFromSuitToStair(suit, stair);
        if (!result) {
            new IO().writeln("ERROR!!!! Movimiento incorrecto");
        } else {
            if (moveFromSuitToStairController.getBoard().isFinished()) {
                new IO().writeln("WIN WIN!!!! ");
            } else {
                moveFromSuitToStairController.close();
            }
        }
    }
}
