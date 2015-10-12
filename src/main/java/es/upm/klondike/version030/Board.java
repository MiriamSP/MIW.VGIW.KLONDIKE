package es.upm.klondike.version030;

import java.util.ArrayList;

public class Board implements BoardForView {

    public static final int NUM_SUITS = 4;

    public static final int NUM_STAIRS = 7;

    public Deck deck;

    public ArrayList<Card> discard;

    private int numDiscard = 0;

    public CardStairSuit[] cardStairSuit;

    public CardStairUser[] cardStairUser;

    public Board() {
        deck = new Deck();
        deck.Shuffle();
        ArrayList<Card> cardsShuffle = deck.getCardsShuffle();

        cardStairSuit = new CardStairSuit[Board.NUM_SUITS + 1];
        cardStairUser = new CardStairUser[Board.NUM_STAIRS + 1];

        initStairUser(cardsShuffle);
        discard = deck.getPackCardsShuffle(29, 20);
        discard.get(0).setVisible(true);
        numDiscard++;

        for (int i = 1; i <= Board.NUM_SUITS; i++) {
            initStairSuit(i);
        }
    }

    private void initStairSuit(int i) {
        Suit suit = null;

        switch (i) {
        case 1:
            suit = Suit.hearts;
        case 2:
            suit = Suit.diamonds;
        case 3:
            suit = Suit.spades;
        case 4:
            suit = Suit.clubs;
        }
        cardStairSuit[i] = new CardStairSuit(suit, i);
    }

    private void initStairUser(ArrayList<Card> cardsShuffle) {
        int idStair = Board.NUM_STAIRS;
        int i = 1;
        cardStairUser[1] = new CardStairUser(1, deck.getPackCardsShuffle(i, idStair));
        i += idStair;
        idStair--;
        cardStairUser[2] = new CardStairUser(2, deck.getPackCardsShuffle(i, idStair));
        i += idStair;
        idStair--;
        cardStairUser[3] = new CardStairUser(1, deck.getPackCardsShuffle(i, idStair));
        i += idStair;
        idStair--;
        cardStairUser[4] = new CardStairUser(2, deck.getPackCardsShuffle(i, idStair));
        i += idStair;
        idStair--;
        cardStairUser[5] = new CardStairUser(1, deck.getPackCardsShuffle(i, idStair));
        i += idStair;
        idStair--;
        cardStairUser[6] = new CardStairUser(2, deck.getPackCardsShuffle(i, idStair));
        i += idStair;
        idStair--;
        cardStairUser[7] = new CardStairUser(1, deck.getPackCardsShuffle(i, idStair));

        for (i = 1; i <= idStair; i++) {
            cardStairUser[i].getLastCard().setVisible(true);
        }

    }

    public boolean isFinished() {
        if (cardStairSuit[1].fullSuit() && cardStairSuit[2].fullSuit() && cardStairSuit[3].fullSuit() && cardStairSuit[4].fullSuit()) {
            return true;
        }
        return false;
    }

    public Card getLastDiscard() {
        if (discard.size() == 0) {
            return null;
        }
        return discard.get(discard.size() - 1);
    }

    public void moveFromDiscardToDeck() {
        for (Card card : discard) {
            card.setVisible(false);

        }
    }

    public void moveFromDeckToDiscard() {
        int i = 0;
        while (i < discard.size() && !discard.get(i).getVisible()) {
            i++;
        }
        numDiscard = i;
        discard.get(i).setVisible(true);
    }

    public void moveFromDiscardToSuit() {
        Card lastCard = discard.get(numDiscard);
        int suitNumber = lastCard.getNumSuit();
        Card cardSuit = cardStairSuit[suitNumber].getLastCard();
        if ((lastCard.isLowerOneNumber(cardSuit) || lastCard.isAs()) && (lastCard.getColor() == cardSuit.getColor())) {
            cardStairSuit[suitNumber].addCard(lastCard);
            discard.remove(numDiscard);
            numDiscard--;
        }
    }

    public boolean moveFromSuitToStair(int numSuit, int numStair) {
        Card cardSuit = cardStairSuit[numSuit].getLastCard();
        Card cardStair = cardStairUser[numStair].getLastCard();
        if ((cardSuit.isLowerOneNumber(cardStair)) && (cardSuit.getColor() != cardStair.getColor())) {
            cardStairUser[numStair].addCard(cardSuit);
            cardStairSuit[numSuit].removeLastCard();
            return true;
        }
        return false;
    }

    public boolean moveFromStairToSuit(int numStair) {
        Card cardStair = cardStairUser[numStair].getLastCard();
        int numSuit = cardStair.getNumSuit();
        Card cardSuit = cardStairSuit[numSuit].getLastCard();

        if ((cardStair.isLowerOneNumber(cardSuit) || cardStair.isAs()) && (cardSuit.getColor() != cardStair.getColor())) {
            cardStairSuit[numSuit].addCard(cardStair);
            cardStairUser[numStair].removeLastCard();
            return true;
        }
        return false;
    }

    public boolean moveFromStairToStair(int origStair, int destStair, int numCards) {

        Card cardStairOrig;
        int num=1;

        if (numCards == 1) {
            cardStairOrig = cardStairUser[origStair].getLastCard();
        } else {
            num = cardStairUser[origStair].getLastCard().getNumber() + numCards;
            cardStairOrig = cardStairUser[origStair].getCardIndex(num);
        }
        ;

        Card cardStairDest = cardStairUser[destStair].getLastCard();

        if (cardStairOrig.isLowerOneNumber(cardStairDest) && (cardStairOrig.getColor() != cardStairDest.getColor())) {
            for (int i = num; i > numCards; i--) {
                cardStairUser[destStair].addCard(cardStairUser[origStair].getCardIndex(i));
                cardStairUser[origStair].removeCardIndex(i);
            }
            return true;
        }
        return false;
    }

    public boolean turnOverStair(int numStair) {
        if (!cardStairUser[numStair].getLastCard().getVisible()) {
            cardStairUser[numStair].getLastCard().setVisible(true);
            return true;
        }
        return false;
    }

    public boolean moveFromDiscardToStair(int numStair) {
        Card lastCard = discard.get(numDiscard);
        int suitNumber = lastCard.getNumSuit();
        Card cardStair = cardStairUser[suitNumber].getLastCard();
        if (lastCard.isLowerOneNumber(cardStair) && (lastCard.getColor() != cardStair.getColor())) {
            cardStairUser[suitNumber].addCard(lastCard);
            discard.remove(numDiscard);
            numDiscard--;
            return true;
        }
        return false;
    }

    public int getNumCardsInDiscard() {
        return numDiscard;
    }

}
