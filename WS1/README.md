#Workshop 1  

Olga Christensen  (oc222ba)


##Fixes

__Comments:__

- YachtClub should not be a concept. The whole system you model is a yacht club.  
- There must be some connection entity Booking/Reservation between a boat and a berth, since it should be possible to look back at previous assignments.  
- There can also be boats and berths in the system that currently has no assignment.  
- A Calendar shall have 0 to many events. This is best shown by having one Calendar and one Event concepts. 


![domain model](https://raw.githubusercontent.com/oc777/1DV607/master/WS1/WS1-Domain-Model-fixes.jpg)


##Initial 



__Assumptions:__

- a yacht club can own boat(s)
- a person can be a member of the club without owning a boat
 


![domain model](https://raw.githubusercontent.com/oc777/1DV607/master/WS1/WS1-Domain-Model.jpg)


