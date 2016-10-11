
#Peer Review

_review by Olga Christensen (oc222ba)_   
_of [work] (https://drive.google.com/open?id=0B3IrSZFmUv5QSTBoalN4SGNMalE	) 
by Jari Beckman	(jb223ra)_


Unfortunately Jari has not provided any source code or a runnable version of the application, 
hence it is impossible to produce a complete review of the assignment and give it a passing grade.

Regarding the diagrams that are available for review:

##1.	Class Diagram

1.1	a good idea would be to show which classes belong to which package so it would be easier to understand how the Model-View 
separation was achieved [1, ch. 13.7].  

1.2	```<<interface>> ApplicationMain``` should not have associations with other classes, rather the class that implements that 
interface should have associations/dependencies with others [1, ch. 16.12], [2]. In case that by ```<<interface>>``` you mean the View 
package, you should show it as Larman suggests in chapter 13 [1].  


##2.	Sequence Diagrams – Create Member / Print compact list

2.1	for proper notations in sequence diagrams, please refer to Larman’s  “Applying UML and Patterns “ [1]; 
e.g.: instead of ```Member``` write ```:Member``` or ```aMember:Member``` (chapter 15.3); 
show execution bars graphically and use ```<- - - -``` errors to show returns (chapter 15.4).  

2.2	I don’t see how the ```Storage Handler``` gets activated, 
i.e. either ```ApplicationMain``` or ```Member``` should make a request first to receive the ```ArrayList``` 
(most likely the ```Storage Handler``` is going to communicate with ```ApplicationMain```).  



__References__
1.	Larman, C., Applying UML and Patterns 3rd Ed, 2005, ISBN: 0-13-148906-2
2.	UML 2 Class Diagramming Guidelines, 2016-10-11, http://agilemodeling.com/style/classDiagram.htm#Interfaces
