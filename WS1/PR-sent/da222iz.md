
#Peer Review

_review by Olga Christensen (oc222ba)_   
_of [work] (https://github.com/da222iz/1DV607/blob/master/Domain%20model.pdf) by David Andersson	(da222iz), Mattias Gustavsson (mg222ws) and Robin Stempa	(rs222nv)_


The domain model has an appealing visual presentation, but, in my oppinion, it is hard to read and comprehend the connections between different conceptual classes. A domain expert might be able to understand the model, but for a non-expert I find it confusing.


__The strong points of the model__

1. Good names for conceptual classes, however I would recommend changing Berths to singular form
2. Good graphics 


__The weaknesses of the model__

1. Login class is related to software and according to Larman "a domain model is not a description of software objects" [1, ch. 1.5]
2. Associations are hard to read since they don't show "reading direction errors" where needed [1, ch. 9.14]. E.g. the model states that Boat updates Secretary where it should be the opposite. 
3. Associations do not clearly describe the connection between classes. E.g. Berth and Boat - I do not understand the "read" connection.
4. Some attributes duplicate the conceptual classes, e.g. Boat's owner which is also Member; and others could actually be a separate class due their complexity, e.g. Member's fee [1, ch. 9.12]
5. The multiplicity notations are done incorrectly (1* instead of 1..*) and are missing in some places (e.g. Boat can be paked only at 1 Birth) [1, ch. 9.13]. Also I think that a Member can be a part of the club without owning a boat, but it is not clarified in the requirements.


__Conclusion__

It is hard for me to decide if the model has passed the passing grade criteria, but once the necessary changes are done, I'm sure it will be accepted. 





__References__

1.  Larman, C., Applying UML and Patterns 3rd Ed, 2005, ISBN: 0-13-148906-2
