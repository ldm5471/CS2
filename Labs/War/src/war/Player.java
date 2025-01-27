package war;

public class Player {
    private Pile pile;
    private boolean winner;

    public Player(int id){

    }
    public void addCard(Card card){

    }
    public void addCards(Pile cards){

    }
    public Card drawCard(){
        return null;
    }
    public boolean hasCard(){
        return false;
    }
    public void setWinner(){

    }

    public boolean isWinner() {
        return winner;
    }
    @Override
    public String toString() {
        return pile.toString();
    }
}
