package BlackJack.view;

public interface IView {

    enum Option {
        NewGame, Hit, Stand, Quit
    }
    
    void DisplayWelcomeMessage();

    int GetInput();
    
    Option GetOption();

    void DisplayCard(BlackJack.model.Card a_card);

    void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);

    void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);

    void DisplayGameOver(boolean a_dealerIsWinner);
    
}
