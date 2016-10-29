package BlackJack.model;

import BlackJack.model.rules.*;

public class Dealer extends Player {

    private Deck m_deck;
    private INewGameStrategy m_newGameRule;
    private IHitStrategy m_hitRule;
    private IWinnerStrategy m_winnerStrategy;

    public Dealer(RulesFactory a_rulesFactory) {

        m_newGameRule = a_rulesFactory.GetNewGameRule();
        m_hitRule = a_rulesFactory.GetHitRule();
        m_winnerStrategy = a_rulesFactory.GetWinnerStrategy();

        /*
        for(Card c : m_deck.GetCards()) {
        c.Show(true);
        System.out.println("" + c.GetValue() + " of " + c.GetColor());
        }    
        */
    }

    public boolean NewGame(Player a_player) {
        if (m_deck == null || IsGameOver()) {
            m_deck = new Deck();
            ClearHand();
            a_player.ClearHand();
            return m_newGameRule.NewGame(this, a_player);
        }
        return false;
    }

    public boolean Hit(Player a_player) {
        if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
            /*
            Card c;
            c = m_deck.GetCard();
            c.Show(true);
            a_player.AddCardToHand(c);
            */
            
            DealCard(a_player, true);

            return true;
        }
        return false;
    }

    public boolean IsDealerWinner(Player a_player) {
        /*
        if (a_player.CalcScore() > g_maxScore) {
            return true;
        } else if (CalcScore() > g_maxScore) {
            return false;
        }
        return CalcScore() >= a_player.CalcScore();
        */
        
        return m_winnerStrategy.IsDealerWinner(a_player, this, g_maxScore);
    }

    public boolean IsGameOver() {
        if (m_deck != null && m_hitRule.DoHit(this) != true) {
            return true;
        }
        return false;
    }

    public boolean Stand() {
        if (m_deck != null) {
            ShowHand();

            while (m_hitRule.DoHit(this)) {
                DealCard(this, true);
                /*
                Card c;
                c = m_deck.GetCard();
                c.Show(true);
                AddCardToHand(c);
                */
            }

            return true;
        }

        return false;
    }
    
    public void DealCard(Player a_player, boolean show) {
        Card c = m_deck.GetCard();
        c.Show(show);
        a_player.AddCardToHand(c);
    }

    
}
