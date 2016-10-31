package BlackJack.model.rules;

import BlackJack.model.Player;

/**
 *
 * @author olgachristensen
 */
public class Soft17HitStrategy implements IHitStrategy {
    
    private final int g_hitLimit = 17;

    public boolean DoHit(Player a_dealer) {
        if (a_dealer.CalcScore() == g_hitLimit && a_dealer.HasAce()) {
            return true;
        }
        
        return a_dealer.CalcScore() < g_hitLimit;
           
    }
    
}
