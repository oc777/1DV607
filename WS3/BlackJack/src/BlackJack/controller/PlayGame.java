package BlackJack.controller;

import BlackJack.model.Game;
import BlackJack.model.ICardDealtObserver;
import BlackJack.view.IView;
import BlackJack.view.IView.Option;

public class PlayGame implements ICardDealtObserver {
    
    private Game a_game;
    private IView a_view;
    
    public PlayGame(Game game, IView view) {
        a_game = game;
        a_view = view;
        a_game.AddSubscriber(this);
    }
    
    public boolean Play() {
        Option opt = a_view.GetOption();
        
        if (opt == Option.NewGame) {
            a_game.NewGame();
        } else if (opt == Option.Hit) {
            a_game.Hit();
        } else if (opt == Option.Stand) {
            a_game.Stand();
        } 
        
        return opt != Option.Quit;
    }
    
    @Override
    public void CardDealt() {
        try {
            DisplayCards();
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (a_game.IsGameOver()) {
            a_view.DisplayGameOver(a_game.IsDealerWinner());
        }
   
    }
    
    public void DisplayCards() {
        a_view.DisplayWelcomeMessage();

        a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
        a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());

    }
}
