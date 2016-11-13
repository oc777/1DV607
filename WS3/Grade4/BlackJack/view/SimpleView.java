package BlackJack.view;

import BlackJack.controller.PlayGame;
import BlackJack.model.rules.IAbstractRulesFactory;

public class SimpleView implements IView {
    
    final private char play = 'p';
    final private char hit = 'h';
    final private char stand = 's';
    final private char quit = 'q';
    
    private PlayGame ctrl;
    private int ch;
    
    IAbstractRulesFactory rulesFactory;

    public SimpleView(IAbstractRulesFactory factory) {
        rulesFactory = factory;
        DisplayRules();
        DisplayIntroMessage();
    }
    
    @Override
    public void SetController(PlayGame controller) {
        ctrl = controller;
    }
    
    @Override
    public void DisplayRules() {
        rulesFactory.accept(new RulesDisplayVisitor());
    }
    
    public void DisplayIntroMessage() {
        System.out.println("Type '"+ play +"' to Play, '"+ hit +"' to Hit, '"+ stand +"' to Stand or '"+ quit +"' to Quit\n");
    }
    
    @Override
    public void DisplayWelcomeMessage() {
        for (int i = 0; i < 50; i++) {
            System.out.print("\n");
        };
        System.out.println("Type '"+ play +"' to Play, '"+ hit +"' to Hit, '"+ stand +"' to Stand or '"+ quit +"' to Quit\n");
    }
    
    @Override
    public void GetInput() {
        try {
            ch = System.in.read();
            while (ch == '\r' || ch == '\n') {
                ch = System.in.read();
            }
        } catch (java.io.IOException e) {
            System.out.println("" + e);
        }
        
        GetAction();
    }

    public void GetAction() {
        switch (ch) {
            case 'p':
                ctrl.NewGame();
                break;
            case 'h':
                ctrl.Hit();
                break;
            case 's':
                ctrl.Stand();
                break;
            case 'q':
                ctrl.Quit();
                break;
            default:
                GetInput();
                break;
        }
    }
    
    @Override
    public void DisplayCard(BlackJack.model.Card a_card) {
        System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
    }

    @Override
    public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
        DisplayHand("Player", a_hand, a_score);
    }

    @Override
    public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
        DisplayHand("Dealer", a_hand, a_score);
    }

    private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score) {
        System.out.println(a_name + " Has: ");
        for (BlackJack.model.Card c : a_hand) {
            DisplayCard(c);
        }
        System.out.println("Score: " + a_score);
        System.out.println("");
    }

    @Override
    public void DisplayGameOver(boolean a_dealerIsWinner) {
        System.out.println("GameOver: ");
        if (a_dealerIsWinner) {
            System.out.println("Dealer Won!");
        } else {
            System.out.println("You Won!");
        }

    }
    
}
