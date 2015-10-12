package es.upm.klondike.version030;

public class MoveFromDiscardToStairView {
    
    private MoveFromDiscardToStairController moveFromDiscardToStairController;

    public MoveFromDiscardToStairView(MoveFromDiscardToStairController moveFromDiscardToStairController) {
        this.moveFromDiscardToStairController = moveFromDiscardToStairController;
    }

    public void render() {
        int numStair;
        numStair = new LimitedIntDialog("A qué escalera? ",1,7).read();
        boolean result = moveFromDiscardToStairController.move(numStair);       
        if(!result){
            new IO().writeln("ERROR!!!! Movimiento incorrecto");
        }else{
            if(moveFromDiscardToStairController.getBoard().isFinished()){
                new IO().writeln("WIN WIN!!!! ");
            }
            else{
                moveFromDiscardToStairController.close();
            }
        }
    }
}
