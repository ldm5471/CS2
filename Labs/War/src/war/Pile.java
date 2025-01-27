package war;

import java.util.ArrayList;
import java.util.Random;

/**
 * Used to represent each players pile of cards to play
 * as well as their winning pile of cards
 */
public class Pile {
    private ArrayList<Card> cards;
    private String name;
    private static Random rng;

    public Pile(String name) {

    }
    public void addCard(Card card) {

    }
    public void clear() {

    }
    public Card drawCard(boolean faceUp){
       return null;
    }
    public ArrayList<Card> getCards() {
        return cards;
    }
    public boolean hasCard(){
        return false;
    }
    public static void setSeed(long seed) {

    }
    public void shuffle() {

    }
    @Override
    public String toString() {
        return name;
    }
}
