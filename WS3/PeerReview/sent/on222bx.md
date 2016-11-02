#Peer Review

_review by Olga Christensen (oc222ba)_   
_of [work] (https://github.com/LokeCarlsson/blackjack_csharp) 
by Oscar Nordquist	(on222bx), Axel Karlsson (ak223fy) and Loke Carlsson (lc222ak)_


I haven't tried to compile and run the code since I don't have the Visual Studio and I didn't have time to install and study it. I have examined the code and here are my comments.



__1. Implement Game::Stand__

Implemented according to the Sequence Diagram.


***
__2. Remove the bad, hidden, dependency between the controller and view (new game, hit, stand)__

To solve this an Enum class `GameEvent` was created in the `view` namespace. The only issue I see with this solution is that the user input is now hardcoded in the `GameEvents` so if we decide to use different characters in `SwedishView` (e.g. 's' for play) we would have to redisgn the current solution. 


***
__3. Design and implement Soft 17__

`SoftHitStrategy` doesn't take into considiration if the dealer has Ace on hand. The dealer should do another hit when `a_dealer.CalcScore() < g_hitLimit` __or__ when `a_dealer.CalcScore() == g_hitLimit` __and__ one of the dealer's cards is Ace. 


***
__4. Design and implement a variable rules for who wins the game__

The current solution for who wins the game makes it hard to implement new winning rules since some calculations are done in the `Dealer` class, some in the `IWinStrategy`. I would recommend moving all the logic of deciding the winner to the `IWinStrategy` to support the requirement "The design should make it easy to add other variants __without changing the Dealer__."

Also the implementation of `PlayerWinEqualStrategy` doesn't make the player a winner if the scores are iqual (from the name of the rule I assumed it should).


***
__5. Refactor code to remove duplication__

A new method `public void AddCard(bool a_isHidden, Player a_player)` was created to solve the problem. The duplicate code was removed from everywhere, except the `InternationalNewGameStrategy` class.




***
__6. Implement Observer pattern__ 

The current implementation of the `IObserver` creates an unnecessary dependency to the `Card` class (both from `IObserver` and `PlayGame`). The `Card` is never actually used in the `PlayGame`, so I don't see the point in passing it to the `IObserver.ShowCard` method. Plain `IObserver.ShowCard();` should suffice. 

Otherwise a good implementation. The `IObserver` is in the model namespace to follow the MVC separation principle. The observers are added to the `Player` class since it is the information expert. 

Additional point for presenting the pause duration as a field in the `PlayGame`.


***
__7. Class Diagram__

The `IObserver` interface and `PlayGame` class are missing a dependency on the `Card` class. However, if you follow my recommendations regarding the Observer implementation, the dependency won't be present.

`PlayGame` class now has an association relations with `Game` and `IView`, not a dependency.


***
__References:__

1. [Model-View-Controller] (https://msdn.microsoft.com/en-us/library/ff649643.aspx)

2. Larman, C., Applying UML and Patterns 3rd Ed, 2005, ISBN: 0-13-148906-2

