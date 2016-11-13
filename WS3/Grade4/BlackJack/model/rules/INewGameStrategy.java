package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

public interface INewGameStrategy extends IGameRule {
    boolean NewGame(Dealer a_dealer, Player a_player);
    @Override
    void accept(IVisitor visitor);
}