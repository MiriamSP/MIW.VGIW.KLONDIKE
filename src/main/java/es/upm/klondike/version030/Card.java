package es.upm.klondike.version030;

public class Card {

    private Suit suit;

    private int number;

    private boolean visible;

    private int numSuit;

    public Card(int number, Suit suit, int numSuit, boolean visible) {
        super();
        this.number = number;
        this.suit = suit;
        this.visible = visible;
        this.numSuit = numSuit;

    }

    public Suit getSuit() {
        return suit;
    }

    public int getNumSuit() {
        return numSuit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Color getColor() {
        if (this.suit == Suit.hearts || this.suit == Suit.diamonds) {
            return Color.Red;
        } else
            return Color.Black;
    }

    public boolean isAs() {
        if (this.number == 1) {
            return true;
        } else
            return false;
    }
    
    public boolean isLowerOneNumber(Card card) {
        if (this.number + 1 == card.getNumber()) {
            return true;
        } else
            return false;
    }

}
