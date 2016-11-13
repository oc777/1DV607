package BlackJack;

import BlackJack.controller.*;
import BlackJack.model.Game;
import BlackJack.model.rules.IAbstractRulesFactory;
import BlackJack.model.rules.PrimaryRulesFactory;
import BlackJack.view.*;

/**
 * Use this for console-based application
 * 
 * @author olgachristensen
 */
public class Program {

    public static void main(String[] a_args) {

        IAbstractRulesFactory factory = new PrimaryRulesFactory();
        Game g = new Game(factory);
        IView v = new SimpleView(factory);
        PlayGame ctrl = new PlayGame(g, v);

        v.SetController(ctrl);
        ctrl.Play();
    }
}
