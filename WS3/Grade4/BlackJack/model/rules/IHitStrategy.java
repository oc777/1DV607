package BlackJack.model.rules;

import BlackJack.model.Player;

public interface IHitStrategy extends IGameRule {
    boolean DoHit(Player a_dealer);
    @Override
    void accept(IVisitor visitor);
}