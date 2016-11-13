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
public class RulesDisplayVisitor implements IVisitor {

    String visitor = "";
    
    @Override
    public void visit(IGameRule rules) {
        System.out.println("\n \nHello Black Jack World \n");
        System.out.println("This game rules are ");
        visitor += "This Game rules are \n";
    }

    @Override
    public void visit(Soft17HitStrategy sof17) {
        System.out.println("Hit Strategy: Soft17");
        visitor += "Hit Strategy: Soft17 \n";
    }

    @Override
    public void visit(BasicHitStrategy basicHit) {
        System.out.println("Hit Strategy: Basic");
        visitor += "Hit Strategy: Basic \n";
    }

    @Override
    public void visit(InternationalNewGameStrategy intGame) {
        System.out.println("New Game Strategy: International");
        visitor += "New Game Strategy: International \n";
    }

    @Override
    public void visit(AmericanNewGameStrategy usGame) {
        System.out.println("New Game Strategy: American");
        visitor += "New Game Strategy: American \n";
    }

    @Override
    public void visit(EqualScoreWinnerPlayer playerWins) {
        System.out.println("Winner for Equal Scores: Player");
        visitor += "Winner for Equal Scores: Player \n";
    }

    @Override
    public void visit(EqualScoreWinnerDealer dealerWins) {
        System.out.println("Winner for Equal Scores: Dealer");
        visitor += "Winner for Equal Scores: Dealer \n";
    }
    
    public String getText() {
        return visitor;
    }
    
    public void clearText() {
        visitor = "";
    }

}
