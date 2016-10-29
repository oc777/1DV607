package BlackJack.view;

public class SwedishView implements IView {

    public void DisplayWelcomeMessage() {

        for (int i = 0; i < 50; i++) {
            System.out.print("\n");
        };

        System.out.println("Hej Black Jack Världen");
        System.out.println("----------------------");
        System.out.println("Skriv 'p' för att Spela, 'h' för nytt kort, 's' för att stanna 'q' för att avsluta\n");
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
        int input = GetInput();

        switch (input) {
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
        if (a_card.GetColor() == BlackJack.model.Card.Color.Hidden) {
            System.out.println("Dolt Kort");
        } else {
            String colors[]
                    = {"Hjärter", "Spader", "Ruter", "Klöver"};
            String values[]
                    = {"två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio", "knekt", "dam", "kung", "ess"};
            System.out.println("" + colors[a_card.GetColor().ordinal()] + " " + values[a_card.GetValue().ordinal()]);
        }
    }

    public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
        DisplayHand("Spelare", a_hand, a_score);
    }

    public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
        DisplayHand("Croupier", a_hand, a_score);
    }

    public void DisplayGameOver(boolean a_dealerIsWinner) {
        System.out.println("Slut: ");
        if (a_dealerIsWinner) {
            System.out.println("Croupiern Vann!");
        } else {
            System.out.println("Du vann!");
        }
    }

    private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score) {
        System.out.println(a_name + " Har: " + a_score);
        for (BlackJack.model.Card c : a_hand) {
            DisplayCard(c);
        }
        System.out.println("Poäng: " + a_score);
        System.out.println("");
    }
}
