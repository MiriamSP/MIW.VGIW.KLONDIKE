package es.upm.klondike.version030;

import java.util.ArrayList;
import java.util.Collections;


public class Deck {

    private static ArrayList<Card> cards;
    private static ArrayList<Card> cardsShuffle;

    private int totalCards = 48;
    private int totalCardsperSuit = totalCards/4;

    private void InitSuitOfDeck(Suit suit,int numSuit){
       for(int i=0; i<totalCardsperSuit; i++){
            cards.add(new Card(i+1, suit,numSuit,false));
        }
    }
    
    public Deck() {
        cards = new ArrayList<Card>(totalCards);
        InitSuitOfDeck(Suit.hearts,1);
        InitSuitOfDeck(Suit.diamonds,2);
        InitSuitOfDeck(Suit.spades,3);
        InitSuitOfDeck(Suit.clubs,4);
    }
    
    public void Shuffle(){
        // barajear
        cardsShuffle = cards; 
        Collections.shuffle(cardsShuffle);
    }
    
    public ArrayList<Card> getCards(){
        return cards;
    }
    
    public ArrayList<Card> getCardsShuffle(){
        return cardsShuffle;
    }
    
    public ArrayList<Card> getPackCardsShuffle(int ini, int numTotal){
        ArrayList<Card> packCards= new ArrayList<Card>(numTotal);
        for(int i=ini; i<=ini+numTotal;i++){
            packCards.add(cardsShuffle.get(i));
        }
        return packCards;
    }
}
