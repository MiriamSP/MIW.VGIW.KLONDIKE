package es.upm.klondike.version030;

import java.util.ArrayList;

public class CardStairUser {
    
    private ArrayList<Card> cards;

    private int idStair;

    public CardStairUser(int idStair, ArrayList<Card> cards) {
        super();
        this.idStair = idStair;
        this.cards = cards;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getIdStair() {
        return idStair;
    }

    public void setIdStair(int idStair) {
        this.idStair = idStair;
    };

    public void removeLastCard() {
        cards.remove(getLastNumberCard());
    }
    
    public void removeCardIndex(int i) {
        cards.remove(i);
    }

    public int getLastNumberCard() {
        int i = 0;
        while (!cards.isEmpty()) {
            i++;
        }
        return i--;
    }

    public Card getLastCard() {
        int i = 0;
        while (!cards.isEmpty()) {
            i++;
        }
        return cards.get(i--);
    }
    
    public Card getCardIndex(int i) {
        return cards.get(i);
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getNumCards() {
        return this.cards.size();
    }
}
