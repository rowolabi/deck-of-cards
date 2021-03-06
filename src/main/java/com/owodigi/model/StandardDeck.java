package com.owodigi.model;

import java.util.ArrayList;
import java.util.List;

public class StandardDeck implements Deck {
    private final List<Card> cards = new ArrayList<>();

    public StandardDeck() {
        for (final Suit suit : Suit.values()) {
            for (final FaceValue value : FaceValue.values()) {
                cards.add(new Card(suit, value));
            }
        }
    }

    @Override
    public void shuffle() {
        final long numberOfSwaps = Math.round(Math.random() * 1000);
        final int maxIndex = cards.size() - 1;
        for (int i = 0; i < numberOfSwaps; ++i) {
            swap((int)Math.round(Math.random() * maxIndex), (int)Math.round(Math.random() * maxIndex));
        }
    }

    private void swap(final int index1, final int index2) {
        final Card card1 = cards.get(index1);
        final Card card2 = cards.get(index2);
        cards.set(index1, card2);
        cards.set(index2, card1);
    }
    
    @Override
    public Card dealOneCard() {
        return cards.isEmpty() ? null : cards.remove(0);
    }
}
