package es.upm.klondike.version030;

public class MenuView {

    Board board;

    MoveControllerFactory moveControllerFactory;

    private IO io = new IO();

    public MenuView(Board board) {
        this.board = board;
        moveControllerFactory = new MoveControllerFactory(board);
    }

    private void printDiscard() {
        Card card;
        String detailsCard = "";
        io.write("Descarte: ");

        if (board.getNumCardsInDiscard() > 0) {
            for (int i = 0; i < board.getNumCardsInDiscard(); i++) {
                card = board.discard.get(i);
                if (card.getVisible()) {
                    detailsCard = card.getNumber() + "," + card.getSuit();
                }
                io.write("[" + detailsCard + "]");
            }
            io.write("\n");
        } else {
            writeEmpty(io);
        }
    }

    private void printSuit() {
        Card card;
        
        for (int i = 1; i <= 4; i++) {
            io.write("Palo " + board.cardStairSuit[i].getSuit().toString() + ": ");
            if (board.cardStairSuit[i].getNumCards() > 0) {
                card = board.cardStairSuit[i].getLastCard();
                io.write("[" + card.getNumber() + "," + card.getSuit() + "]");
            } else {
                writeEmpty(io);
            }
        }
    }

   private void printStairUser(){
       Card card;
       String detailsCard = "";
               for (int i = 1; i <= 4 ; i++) {
            if (board.cardStairUser[i].getNumCards() == 0) {
                writeEmpty(io);
            }
            io.write("Escalera " + board.cardStairUser[i].getIdStair()+ ": ");
            for (int j = 1; j <= board.cardStairUser[i].getNumCards() ; j++) {
                io.write("[");
            }
            card = board.cardStairUser[i].getLastCard();
            detailsCard =  card.getNumber() + "," + card.getSuit();
            io.write("[" + detailsCard + "]\n");
        }
    }
    public void printDeck() {
        IO io = new IO();
        io.writeln("===========================");
        io.write("Baraja: ");
        if (board.deck.getCards().size() > 0) {
            io.write("[X,X] \n");
        } else {
            writeEmpty(io);
        }
        printDiscard();
        printSuit();
        printStairUser();
    }

    public int showMenu() {
        printDeck();
        IO io = new IO();
        io.writeln("----------------------------------");
        io.writeln("1. Mover de baraja a descarte");
        io.writeln("2. Mover de descarte a baraja");
        io.writeln("3. Mover de descarte a palo");
        io.writeln("4. Mover de descarte a escalera");
        io.writeln("5. Mover de escalera a palo");
        io.writeln("6. Mover de escalera a escalera");
        io.writeln("7. Mover de palo a escalera");
        io.writeln("8. Volter en escalera");
        io.writeln("9. Salir");
        int option = new LimitedIntDialog("Opción ", 1, 9).read();
        if (option == 9) {
            io.write("Adios!!!");
            System.exit(0);
        }
        return option;
    }

    public void writeEmpty(IO io) {
        io.write("<vacío> \n");
    }
}
