package war;

public class Player {
    private final Pile pile;
    private boolean winner;

    public Player(int id){
        if (id == 1){
            pile = new Pile("P1");
        }else{
            pile = new Pile("P2");
        }
        winner = false;

    }
    public void addCard(Card card){
        this.pile.addCard(card);

    }
    public void addCards(Pile cards){
        for (Card c : cards.getCards()){
            this.addCard(c);
        }
    }
    public Card drawCard(){
        return this.pile.drawCard(true);
    }
    public boolean hasCard(){
        return this.pile.hasCard();
    }
    public void setWinner(){
        this.winner = true;
    }

    public boolean isWinner() {
        return winner;
    }
    @Override
    public String toString() {
        return pile.toString();
    }
}
