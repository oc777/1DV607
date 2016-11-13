package BlackJack.model.rules;

import BlackJack.model.Player;

/**
 *
 * @author olgachristensen
 */
public interface IWinnerStrategy extends IGameRule {
    boolean IsDealerWinner(Player a_player, Player a_dealer, int MaxScore);
    @Override
    void accept(IVisitor visitor);
}
