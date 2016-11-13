package BlackJack.model.rules;

/**
 *
 * @author Olga Christensen
 */
public interface IVisitor {
    public void visit(IGameRule rules);
    public void visit(Soft17HitStrategy sof17);
    public void visit(BasicHitStrategy basicHit);
    public void visit(InternationalNewGameStrategy intGame);
    public void visit(AmericanNewGameStrategy usGame);
    public void visit(EqualScoreWinnerPlayer playerWins);
    public void visit(EqualScoreWinnerDealer dealerWins);
}
