package BlackJack.model.rules;

/**
 *
 * @author Olga Christensen
 */
public interface IAbstractRulesFactory extends IGameRule {
    public INewGameStrategy GetNewGameRule();
    public IHitStrategy GetHitRule();
    public IWinnerStrategy GetWinnerStrategy();
}
