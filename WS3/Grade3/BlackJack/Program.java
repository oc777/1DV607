package BlackJack;

import BlackJack.controller.*;
import BlackJack.model.Game;
import BlackJack.model.rules.IAbstractRulesFactory;
import BlackJack.model.rules.PrimaryRulesFactory;
import BlackJack.view.*;

public class Program {

    public static void main(String[] a_args) {

        IAbstractRulesFactory factory = new PrimaryRulesFactory();
        Game g = new Game(factory);
        IView v = new SimpleView(factory); //new SwedishView(factory);
        PlayGame ctrl = new PlayGame(g, v);

        while (ctrl.Play());
    }
}
