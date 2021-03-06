package BlackJack.model;

import BlackJack.model.rules.IAbstractRulesFactory;

public class Game {

    private Dealer m_dealer;
    private Player m_player;

    public Game(IAbstractRulesFactory a_rulesFactory) {
        m_dealer = new Dealer(a_rulesFactory);
        m_player = new Player();
    }

    public boolean IsGameOver() {
        return m_dealer.IsGameOver();
    }

    public boolean IsDealerWinner() {
        return m_dealer.IsDealerWinner(m_player);
    }

    public boolean NewGame() {
        return m_dealer.NewGame(m_player);
    }

    public boolean Hit() {
        return m_dealer.Hit(m_player);
    }

    public boolean Stand() {
        return m_dealer.Stand();
    }

    public Iterable<Card> GetDealerHand() {
        return m_dealer.GetHand();
    }

    public Iterable<Card> GetPlayerHand() {
        return m_player.GetHand();
    }

    public int GetDealerScore() {
        return m_dealer.CalcScore();
    }

    public int GetPlayerScore() {
        return m_player.CalcScore();
    }

    public void AddSubscriber(ICardDealtObserver a_sub) {
        m_dealer.AttachObserver(a_sub);
        m_player.AttachObserver(a_sub);
    }
}
