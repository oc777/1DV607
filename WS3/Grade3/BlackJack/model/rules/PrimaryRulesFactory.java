package BlackJack.model.rules;

public class PrimaryRulesFactory implements IAbstractRulesFactory {

    IGameRule[] rules;
    
    public PrimaryRulesFactory() {
        rules = new IGameRule[] {
            new Soft17HitStrategy(),
            new AmericanNewGameStrategy(),
            new EqualScoreWinnerPlayer(),
        };
    }

    @Override
    public IHitStrategy GetHitRule() {
        return new Soft17HitStrategy();
    }

    @Override
    public INewGameStrategy GetNewGameRule() {
        return new AmericanNewGameStrategy();
    }
    
    @Override
    public IWinnerStrategy GetWinnerStrategy() {
        return new EqualScoreWinnerPlayer();
    }
    
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
        for (int i = 0; i < rules.length; i++) {
            rules[i].accept(visitor);
        }
    }
    
}
