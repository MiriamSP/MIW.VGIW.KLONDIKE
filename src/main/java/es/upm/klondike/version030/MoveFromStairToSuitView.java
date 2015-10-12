package es.upm.klondike.version030;

public class MoveFromStairToSuitView {

    private MoveFromStairToSuitController moveFromStairToSuitController;

    public MoveFromStairToSuitView(MoveFromStairToSuitController moveFromStairToSuitController) {
        this.moveFromStairToSuitController = moveFromStairToSuitController;
    }

    public void render() {
        int stair;
        stair = new LimitedIntDialog("De qué escalera? ", 1, 7).read();
        boolean result = moveFromStairToSuitController.moveFromStairToSuitController(stair);
        if (!result) {
            new IO().writeln("ERROR!!!! Movimiento incorrecto");
        } else {
            if (moveFromStairToSuitController.getBoard().isFinished()) {
                new IO().writeln("WIN WIN!!!! ");
            } else {
                moveFromStairToSuitController.close();
            }
        }
    }
}
