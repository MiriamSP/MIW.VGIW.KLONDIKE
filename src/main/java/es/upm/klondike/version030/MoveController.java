package es.upm.klondike.version030;

public abstract class MoveController extends Controller {
    protected MoveController(Board board) {
        super(board);
    }

    public void close() {
        new MenuView(board).showMenu();
    }

    public Board getBoard() {
        return board;
    }

    public abstract void receive(View gameView);

}
