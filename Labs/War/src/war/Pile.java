package war;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

/**
 * Used to represent each players pile of cards to play
 * as well as their winning pile of cards
 */
public class Pile {
    private ArrayList<Card> cards;
    private String name;
    private static Random rng;

    public Pile(String name) {
        this.name = name;
        cards = new ArrayList<Card>();

    }
    public void addCard(Card card) {
        cards.add(card);
    }
    public void clear() {
        cards.clear();
    }
    public Card drawCard(boolean faceUp){
        if (this.cards.get(0).isFaceUp() == true){
            shuffle();
            System.out.println(this.toString());
        }
        Card draw = this.cards.remove(0);
        if (faceUp == true){
            draw.setFaceUp();
        }else {
            draw.setFaceDown();
        }
        return draw;
    }
    public ArrayList<Card> getCards() {
        return cards;
    }
    public boolean hasCard(){
        return !cards.isEmpty();
    }
    public static void setSeed(long seed) {
        rng = new Random(seed);

    }
    public void shuffle() {
        System.out.println("Shuffling " + this.name + " pile");
        Collections.shuffle(cards, rng);
        for (Card c : cards){
            c.setFaceDown();
        }
    }
    @Override
    public String toString() {
        String result = this.name + " pile: ";
        for (Card c : cards){
            result = result + c + " ";
        }
        return result;
    }
}
