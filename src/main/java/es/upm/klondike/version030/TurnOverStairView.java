package es.upm.klondike.version030;

public class TurnOverStairView {

    private TurnOverStairController turnOverStairController;

    public TurnOverStairView(TurnOverStairController turnOverStairController) {
        this.turnOverStairController = turnOverStairController;
    }

    public void render() {
        int numStair;
        numStair = new LimitedIntDialog("De qué escalera? ", 1, 7).read();
        boolean result = turnOverStairController.move(numStair);
        if (!result) {
            new IO().writeln("ERROR!!!! No se puede voltear una carta descubierta");
        } else {
            if (turnOverStairController.getBoard().isFinished()) {
                new IO().writeln("WIN WIN!!!");
            } else {
                turnOverStairController.close();
            }
        }
    }

}
