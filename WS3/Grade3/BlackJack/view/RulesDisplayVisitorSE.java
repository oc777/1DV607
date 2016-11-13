package BlackJack.view;

import BlackJack.model.rules.AmericanNewGameStrategy;
import BlackJack.model.rules.BasicHitStrategy;
import BlackJack.model.rules.EqualScoreWinnerDealer;
import BlackJack.model.rules.EqualScoreWinnerPlayer;
import BlackJack.model.rules.IGameRule;
import BlackJack.model.rules.IVisitor;
import BlackJack.model.rules.InternationalNewGameStrategy;
import BlackJack.model.rules.Soft17HitStrategy;

/**
 *
 * @author Olga Christensen
 */
public class RulesDisplayVisitorSE implements IVisitor {

    @Override
    public void visit(IGameRule rules) {
        System.out.println("Hej Black Jack Världen");
        System.out.println("----------------------");
        System.out.println("Reglar: ");
    }

    @Override
    public void visit(Soft17HitStrategy sof17) {
        System.out.println("Hit Strategy: Soft17");
    }

    @Override
    public void visit(BasicHitStrategy basicHit) {
        System.out.println("Hit Strategy: Basic");
    }

    @Override
    public void visit(InternationalNewGameStrategy intGame) {
        System.out.println("Nytt Spel Strategi: Internationellt");
    }

    @Override
    public void visit(AmericanNewGameStrategy usGame) {
        System.out.println("Nytt Spel Strategi: US");
    }

    @Override
    public void visit(EqualScoreWinnerPlayer playerWins) {
        System.out.println("Vinnare för lika resultat: Player");
    }

    @Override
    public void visit(EqualScoreWinnerDealer dealerWins) {
        System.out.println("Vinnare för lika resultat: Dealer");
    }

}
