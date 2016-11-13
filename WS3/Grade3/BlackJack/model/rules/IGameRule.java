package BlackJack.model.rules;

/**
 *
 * @author Olga Christensen
 */
public interface IGameRule {
    public void accept(IVisitor visitor);
}
