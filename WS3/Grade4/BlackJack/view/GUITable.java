package BlackJack.view;

import BlackJack.controller.PlayGame;
import BlackJack.model.Card;
import BlackJack.model.rules.IAbstractRulesFactory;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author Olga Christensen
 */
public class GUITable implements IView {
    
    private HBox dealer = new HBox(20);
    private HBox player = new HBox(20);
    
    private PlayGame ctrl;
    IAbstractRulesFactory rulesFactory;
    Pane root;
    
    private Text welcome;
    private Text rules;
    private Text dealerHand;
    private Text playerHand;
    private Text gameOver;
    
    private Button play;
    private Button hit;
    private Button stand;
    private Button quit;
    
    RulesDisplayVisitor visitor;
    
    int hand;
    String dealerCards;
    String playerCards;
    
    public GUITable(IAbstractRulesFactory factory, Pane pane) {
        rulesFactory = factory;
        visitor = new RulesDisplayVisitor();
        root = pane;
        
        init();
        
        hand = 0; // dealer
        DisplayRules();
    }
    
    public void init() {        
        
        HBox rootLayout = new HBox();
        
        StackPane lStack = new StackPane();
        Rectangle left = new Rectangle(500, 700);
        left.setFill(Color.GREEN);
        
        VBox lBox = new VBox(50);
        lBox.setAlignment(Pos.TOP_CENTER);
        lBox.setPadding(new Insets(15,15,15,15));
        
        welcome = new Text("Welcome to Black Jack table");
        rules = new Text();
        dealerHand = new Text();
        playerHand = new Text();
        gameOver = new Text();
        
        lBox.getChildren().addAll(rules, welcome, dealerHand, playerHand, gameOver);
        lStack.getChildren().addAll(left, lBox);
        
        StackPane rStack = new StackPane();
        Rectangle right = new Rectangle(200, 700);
        right.setFill(Color.BEIGE);
        
        VBox rBox = new VBox(20);
        rBox.setAlignment(Pos.TOP_CENTER);
        rBox.setPadding(new Insets(15,15,15,15));
        
        play = new Button("PLAY");
        play.setMaxWidth(100);
        
        hit = new Button("HIT");
        hit.setMaxWidth(100);
        
        stand = new Button("STAND");
        stand.setMaxWidth(100);
        
        quit = new Button("QUIT");
        quit.setMaxWidth(100);
        
        rBox.getChildren().addAll(play, hit, stand, quit);
        rStack.getChildren().addAll(right, rBox);
        
        rootLayout.getChildren().addAll(lStack, rStack);
        root.getChildren().addAll( rootLayout);
        
    }

    @Override
    public void SetController(PlayGame controller) {
        ctrl = controller;
    }
    
    @Override
    public void DisplayWelcomeMessage() {
        welcome.setText("Let's play!");
    }

    @Override
    public void DisplayRules() {
        visitor.clearText();
        rulesFactory.accept(visitor);
        rules.setText(visitor.getText());
    }

    @Override
    public void GetInput() {
        play.setOnAction(event -> {
            welcome.setText("");
            gameOver.setText("");
            ctrl.NewGame(); 
        });
        
        hit.setOnAction(event -> {
            ctrl.Hit();
        });
        
        stand.setOnAction(event -> {
            ctrl.Stand();
        });
        
        quit.setOnAction(event -> {
            ctrl.Quit();
        });
        
    }

    @Override
    public void DisplayCard(Card a_card) {
        if (hand == 0) {
            dealerCards += a_card.GetValue() + " of " + a_card.GetColor() + "\n";
        } else {
            playerCards += a_card.GetValue() + " of " + a_card.GetColor() + "\n";
        }
    }

    @Override
    public void DisplayPlayerHand(Iterable<Card> a_hand, int a_score) {
        hand = 1;
        DisplayHand("Player", a_hand, a_score);
    }

    @Override
    public void DisplayDealerHand(Iterable<Card> a_hand, int a_score) {
        hand = 0;
        DisplayHand("Dealer", a_hand, a_score);
    }
    
    private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score) {
        if (hand == 0) { //dealer's hand
            dealerCards += a_name + " Has: \n";
            DisplayAllCards(a_hand);
            dealerCards += "Score: " + a_score + "\n";
            
            dealerHand.setText(dealerCards);
            dealerCards = "";
            
        } else { //player's hand
            playerCards += a_name + " Has: \n";
            DisplayAllCards(a_hand);
            playerCards += "Score: " + a_score + "\n";
            
            playerHand.setText(playerCards);
            playerCards = "";
            
        }
        
        
    }
    
    private void DisplayAllCards(Iterable<BlackJack.model.Card> a_hand) {
        for (BlackJack.model.Card c : a_hand) {
            DisplayCard(c);
        }
    }

    @Override
    public void DisplayGameOver(boolean a_dealerIsWinner) {
        if (a_dealerIsWinner) {
            gameOver.setText("Dealer Won!");
        } else {
            gameOver.setText("You Won!");
        }
    }

    public void ClearFields() {
        
    }
}
