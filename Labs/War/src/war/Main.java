package war;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    @Test
    public void test() {
        Pile nice = new Pile("hi");
        nice.addCard(new Card(Rank.FIVE, Suit.DIAMOND));
        nice.addCard(new Card(Rank.SEVEN, Suit.HEART));
        assertEquals("hi pile: 5♢(D) 7♥(D) ", nice.toString());
    }
    public static void main(String[] args) {

    }
}
