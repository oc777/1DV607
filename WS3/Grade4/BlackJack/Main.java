package BlackJack;

import BlackJack.controller.PlayGame;
import BlackJack.model.Game;
import BlackJack.model.rules.IAbstractRulesFactory;
import BlackJack.model.rules.PrimaryRulesFactory;
import BlackJack.view.GUITable;
import BlackJack.view.IView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Use this as main file for GUI application
 * 
 * @author Olga Christensen
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("BlackJack");
        Pane root = new Pane();
        primaryStage.setScene(new Scene(root, 700, 700));
        
        IAbstractRulesFactory factory = new PrimaryRulesFactory();
        Game g = new Game(factory);
        
        IView v = new GUITable(factory, root);
        PlayGame ctrl = new PlayGame(g, v);
        
        v.SetController(ctrl);
        ctrl.Play();
        
        primaryStage.show();
    }

    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
