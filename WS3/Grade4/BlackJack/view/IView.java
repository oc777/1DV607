package BlackJack.view;

import BlackJack.controller.PlayGame;

public interface IView {

    void SetController(PlayGame controller);
    
    void DisplayWelcomeMessage();
    
    void DisplayRules();
    
    void GetInput();
    
    void DisplayCard(BlackJack.model.Card a_card);

    void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);

    void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);

    void DisplayGameOver(boolean a_dealerIsWinner);
    
}
