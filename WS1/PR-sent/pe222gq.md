
#Peer Review

_review by Olga Christensen (oc222ba)_   
_of [work] (https://github.com/Popniten/1dv607/blob/master/workshop-1/README.md) by Pär Eriksson	(pe222gq) and Oskar Emilsson	(oe222ca)_





In general the model has a clear visual representation of the domain, it is well structured and has a  good redability. In my oppinion, both developer and domain expert should be able to understand the model due to well named classes and associations between them.  



__The strong points of the model__

1. Clear and not cluttered visual presentation [1, ch. 9.10]
2. Good names of the conceptual classes and proper attributes [1, ch. 9.12]
3. Meaningfull and descriptive association names [1, ch. 9.14]
4. Easy readability due to "reading direction errors" [1, ch. 9.14]
5. Well thought-through multiplicity notations [1, ch. 9.13]


__The weaknesses of the model__

1. Municipality is out of scope and is not an interesting actor. According to Larman we should "exclude irrelevant out-of-scope features" [1, ch. 9.10]  
2. Booking class is more relevant for developers since it describes the system and not the reality. According to Larman "a domain model is not a description of software objects" [1, ch. 1.5]. What is of interest in the "real" world is that the Secretary manages the placement of the Boats.
3. Authentication class has the same issue as Booking - it is related to software.
4. According to Larman [1, ch. 9.14] "Associations worth noting usually imply knowledge of the relationship that needs to be preserved for some duration, could be milliseconds or years.", thus the fact that Municipalty inspects Calendar is not of interest. 
5. The connection between the Calendar and Booking classes is hard to understand. I didn't find any requirements stating that the booking of Berths should be registered in the Calendar.
6. I think that notations :Member in the conceptual classes do not belong to domain modeling, rather the interaction diagrams [1, ch. 1.5].


__Conclusion__

I think that the model has passed the passing grade criteria





__References__

1.  Larman, C., Applying UML and Patterns 3rd Ed, 2005, ISBN: 0-13-148906-2


