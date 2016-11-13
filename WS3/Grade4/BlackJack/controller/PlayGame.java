package BlackJack.controller;

import BlackJack.model.Game;
import BlackJack.model.ICardDealtObserver;
import BlackJack.view.IView;

public class PlayGame implements ICardDealtObserver {
    
    private Game a_game;
    private IView a_view;
    
    public PlayGame(Game game, IView view) {
        a_game = game;
        a_view = view;
        a_game.AddSubscriber(this);
    }
    
    public void Play() {
        a_view.GetInput();
        
    }
    
    public void NewGame() {
        a_game.NewGame();
        Play();
    }
    
    public void Hit() {
        a_game.Hit();
        Play();
    }
    
    public void Stand() {
        a_game.Stand();
        Play();
    }
    
    public void Quit() {
        System.exit(0);
    }
    
    @Override
    public void CardDealt() {
        try {
            DisplayCards();
            Thread.sleep(1500);
            
            if (a_game.IsGameOver()) {
                a_view.DisplayGameOver(a_game.IsDealerWinner());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
   
    }
    
    public void DisplayCards() {
        a_view.DisplayWelcomeMessage();

        a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
        a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());

    }
}
