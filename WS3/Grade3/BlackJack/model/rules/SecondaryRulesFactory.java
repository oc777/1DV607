package BlackJack.model.rules;

/**
 *
 * @author Olga Christensen
 */
public class SecondaryRulesFactory implements IAbstractRulesFactory {

    IGameRule[] rules;

    public SecondaryRulesFactory() {
        rules = new IGameRule[] {
            new BasicHitStrategy(),
            new InternationalNewGameStrategy(),
            new EqualScoreWinnerDealer()
        };
    }

    @Override
    public IHitStrategy GetHitRule() {
        return new BasicHitStrategy();
    }

    @Override
    public INewGameStrategy GetNewGameRule() {
        return new InternationalNewGameStrategy();
    }
    
    @Override
    public IWinnerStrategy GetWinnerStrategy() {
        return new EqualScoreWinnerDealer();
    }
    
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
        for (int i = 0; i < rules.length; i++) {
            rules[i].accept(visitor);
        }
    }
    
}
