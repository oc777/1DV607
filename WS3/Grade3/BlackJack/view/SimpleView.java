package BlackJack.view;

import BlackJack.model.rules.IAbstractRulesFactory;

public class SimpleView implements IView {
    
    final private char play = 'p';
    final private char hit = 'h';
    final private char stand = 's';
    final private char quit = 'q';
    
    IAbstractRulesFactory rulesFactory;

    public SimpleView(IAbstractRulesFactory factory) {
        rulesFactory = factory;
        DisplayRules();
        DisplayIntroMessage();
    }
    
    public void DisplayRules() {
        rulesFactory.accept(new RulesDisplayVisitor());
    }
    
    public void DisplayIntroMessage() {
        System.out.println("Type '"+ play +"' to Play, '"+ hit +"' to Hit, '"+ stand +"' to Stand or '"+ quit +"' to Quit\n");
    }
    
    public void DisplayWelcomeMessage() {
        for (int i = 0; i < 50; i++) {
            System.out.print("\n");
        };
        System.out.println("Type '"+ play +"' to Play, '"+ hit +"' to Hit, '"+ stand +"' to Stand or '"+ quit +"' to Quit\n");
    }
    
    public int GetInput() {
        try {
            int c = System.in.read();
            while (c == '\r' || c == '\n') {
                c = System.in.read();
            }
            return c;
        } catch (java.io.IOException e) {
            System.out.println("" + e);
            return 0;
        }
    }

    public Option GetOption() {
        Option opt = null;

        switch (GetInput()) {
            case 'p':
                opt = Option.NewGame;
                break;
            case 'h':
                opt = Option.Hit;
                break;
            case 's':
                opt = Option.Stand;
                break;
            case 'q':
                opt = Option.Quit;
                break;
        }

        return opt;
    }

    public void DisplayCard(BlackJack.model.Card a_card) {
        System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
    }

    public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
        DisplayHand("Player", a_hand, a_score);
    }

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

    public void DisplayGameOver(boolean a_dealerIsWinner) {
        System.out.println("GameOver: ");
        if (a_dealerIsWinner) {
            System.out.println("Dealer Won!");
        } else {
            System.out.println("You Won!");
        }

    }
    
}
