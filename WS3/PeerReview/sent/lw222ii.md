#Peer Review

_review by Olga Christensen (oc222ba)_   
_of [work] (https://github.com/larswww/BlackJack/releases/tag/1.0) 
by Lars Wöldern	(lw222i) and Nicklas Björkendal (nb222gp)_


I haven't tried to compile and run the code since I don't have the Visual Studio and I didn't have time to install and study it. I have studdied the code and here are my comments.

__1. Implement Game::Stand__

Implemented as required.


***
__2. Remove the bad, hidden, dependency between the controller and view (new game, hit, stand)__

To solve this an `Enum` class `ViewAction` was created in the `controller` namespace.  
I think it is a bad idea to put it there, since our `IView` interface is now dependent on `PlayGame` controller (needs to import/use `BlackJack2.controller`).  
A better idea would be to place the `ViewAction` class into the `view` namespace and even better - to nest it within the `IView` interface (I think C# supports such implementation). This way we make our `IView` independent.  

Othervise the "hidden dependency" was removed.




***
__3. Design and implement Soft 17__

To check if the Soft 17 rule applies to the dealer's hand a condition is passed `if (a_dealer.CalcScore() == 17 && a_dealer.hasAce())`.  
The method `hasAce()` is implemented in the `Player` class, which is good, since it is the information expert.  
I disagree that we should just check if Ace is on the hand, since the dealer can have two Aces, valued 1 each, and still hit 17. But in this case the Soft 17 shouldn't apply. So I would recommend checking if the dealer has __one__ ace in hand.  

However, this was not specified by the assignment's requirements, so I don't think it is important.  


***
__4. Design and implement a variable rules for who wins the game__

An interface `IWinStrategy` in the namespace `model.rules` is now responsible for checking if the dealer is the winner. This allows easy implementation of new winning strategies.  

Since the value of `maxScore` is involved in calculating the winner, this value was made public (originally it was private), so it  can be accessed directly from other namespaces  (i.e. `a_dealer.maxScore`). This is a bad idea to make a private field public since it would allow other members to modify it, instead I would suggest makeing the field private again and passing this value as a parametr to the method `isDealerWinner(Player a_player, Player a_dealer, int maxScore)`.



***
__5. Refactor code to remove duplication__

New method `public void GiveCardToPlayer(Player a_player, bool isShown)` in `Dealer` class replaces all occurences of the duplicate code.  



***
__6. Implement Observer pattern__ 

The interface `GameObserver` was placed in `controller` namespace which led to violation of MVC separation principle - now `model.Player` has an assosiation relation to `controller` [1]. Hence the interface `GameObserver` should be placed in the `model` namespace.  

Also it is a common practice to use a `List` to collect all observers for a certain class, since we might have more than one. So current implementation with a single possible observer may limit future code developments.  

Also I wouldn't recommend subscribing an observer in the main class `Program`, I think that the `PlayGame` class is the information expert in this case. So it should be done there in the constructor.  

***
__7. Class Diagram__

Class `Game` is missing a dependency to `GameObserver` interface.



***
__Additionally__

When working on some else's code it is a good idea to follow the established naming convention. In this case method's name should start with capital letter (e.g. `public void tempGamePause()`, `displayWelcomeMessageAndHands()`, etc).






***
__References:__

1. [Model-View-Controller] (https://msdn.microsoft.com/en-us/library/ff649643.aspx)



