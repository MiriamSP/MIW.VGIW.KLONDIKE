package es.upm.klondike.version030;

public class MoveFromStairToStairView {

    private MoveFromStairToStairController moveFromStairToStairController;

    public MoveFromStairToStairView(MoveFromStairToStairController moveFromStairToStairController) {
        this.moveFromStairToStairController = moveFromStairToStairController;
    }

    public void render() {
        int origStraight;
        origStraight = new LimitedIntDialog("De qué escalera [1-7]", 1, 7).read();
        int numCards;
        numCards = new LimitedIntDialog("Cuantas cartas? ", 1, 11).read();
        int destStraight;
        destStraight = new LimitedIntDialog("A qué escalera [1-7]", 1, 7).read();
        boolean result = moveFromStairToStairController.moveFromStairToStair(origStraight, destStraight,numCards);
        if (!result) {
            new IO().writeln("ERROR!!!! Movimiento incorrecto");
        } else {
            if (moveFromStairToStairController.getBoard().isFinished()) {
                new IO().writeln("WIN WIN!!!!");
            } else {
                moveFromStairToStairController.close();
            }
        }

    }
}
