package es.upm.klondike.version030;

import java.util.ArrayList;

public class CardStairSuit {
    
    private ArrayList<Card> cards;

    private Suit suit;
    private int numSuit;
    
    public CardStairSuit(Suit suit, int numSuit) {
        super();
        this.cards = new ArrayList<Card>();
        this.suit = suit;
        this.setNumSuit(numSuit);
        
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public int getNumCards() {
        return this.cards.size();
    }

    public boolean fullSuit() {
        return cards.size() == 12;
    }
    
    public void addCard(Card card){
        cards.add(card);
    }
    
    public void removeLastCard(){
        cards.remove(getLastNumberCard());
    }
    
    public int getLastNumberCard(){
        int i = 0;
        while (! cards.isEmpty()){
            i++;
        }
        return i--;   
     }
    
    public Card getLastCard(){
        int i = 0;
        while (! cards.isEmpty()){
            i++;
        }
        return cards.get(i--);   
     }

    public int getNumSuit() {
        return numSuit;
    }

    public void setNumSuit(int numSuit) {
        this.numSuit = numSuit;
    }

}
