
#Peer Review

_review by Olga Christensen (oc222ba)_   
_of [work] (https://github.com/sticky4loop/ooad-workshop-2) by Tomas Vaedelund	(tr222cj), Christoffer Ekblom (cekmw09) 
and Mikael Melander (mm222ev)_

First of all I would like to state that I am not acquainted with PHP and client-based programming, 
thus my review will be limited to that effect. 

The runnable version is easy to use and while testing I haven’t found any bugs. 
However the fact that the Boat Length is a string seems strange, i.e. I could register a boat with length _“blabla”_. 
This wasn’t specified in the requirements, but I would recommend changing this to numbers (integer or floating point) 
to support the general business logic.


When looking at the source code (exercise folder) I had really hard time grasping the structure and general logic of the application. 
I have expected to see two or three packages (depending on if the MV or MVC was used), but found 6 folders instead.

I guess the Core package should have been merged with Model, where the classes currently located in Model would be joined in some kind of 
DBHandler package. Also Settings should be in Model, instead of a separate folder/package (according to Class Diagram). 
Additionally, Larman [1, ch. 13.2] suggests putting “general purpose objects and subsystems” in a Technical Service layer, 
so Config, Session and Settings objects in this case could just stay in Core package.  
Also CSS package should belong in View. I think I would place App in Controller, but I do not fully understand its functionality, 
so I might be mistaken. 

Otherwise the architecture seems to have a good model view separation with all domain rules placed in Model.

The class and sequence diagrams are good and helpful. I would suggest adding OPT notation to the UML frames instead of IF [1, ch. 15.4]. 

The main issue I see with the application is that it is not really Object Oriented. 
First of all, it is implemented with PHP, which is used here mostly as scripting language. 
The objects in the application are connected through IDs and not through associations. 
This also shows in the sequence diagrams when the objects Member and Boat are not involved in any processes. 
Instead the application works directly with the DB. 

Additionally, the Unique Member ID is assigned by SQL using auto increment feature. 
Since the requirements are vague on how exactly this should be implemented, 
the only possible issue I see with this approach is a need to reset DB for some reason, 
where a member would suddenly get a new ID.



In conclusion, I wouldn’t give the assignment a passing grade since it has failed to implement the very basics of 
Object Oriented programming. 



__References__  
1.	Larman, C., Applying UML and Patterns 3rd Ed, 2005, ISBN: 0-13-148906-2








