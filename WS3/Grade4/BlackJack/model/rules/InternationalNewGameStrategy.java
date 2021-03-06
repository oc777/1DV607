package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

public class InternationalNewGameStrategy implements INewGameStrategy {

    public boolean NewGame(Dealer a_dealer, Player a_player) {
        a_dealer.DealCard(a_player, true);
        
        a_dealer.DealCard(a_dealer, true);
        
        a_dealer.DealCard(a_player, true);
        
        return true;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);    
    }
}
