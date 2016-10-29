package BlackJack.controller;

import BlackJack.model.Game;
import BlackJack.view.IView;

public class PlayGame {

    public boolean Play(Game a_game, IView a_view) {
        a_view.DisplayWelcomeMessage();

        a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
        a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());

        if (a_game.IsGameOver()) {
            a_view.DisplayGameOver(a_game.IsDealerWinner());
        }

        
        IView.Option opt = a_view.GetOption();

        if (opt == IView.Option.NewGame) {
            a_game.NewGame();
        } else if (opt == IView.Option.Hit) {
            a_game.Hit();
        } else if (opt == IView.Option.Stand) {
            a_game.Stand();
        }

        return opt != IView.Option.Quit;

        
    }
}
