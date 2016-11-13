/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.search;

import java.util.ArrayList;
import model.Boat;
import model.Member;

/**
 *
 * @author olgachristensen
 */
public class HasBoatType implements ISimpleSearchStrategy {
    
    private Boat.BoatType boatType;
    
    public HasBoatType(Boat.BoatType type) {
        boatType = type;
    }
    
    @Override
    public ArrayList<Member> search(ArrayList<Member> members) {
        ArrayList<Member> searchResults = new ArrayList();
        
        for (Member m : members) {            
            if (m.getAmountBoats() != 0) {
                ArrayList<Boat> boats = m.getBoats();
                
                for (Boat b : boats) {
                    if (b.getType() == boatType) {
                        searchResults.add(m);
                        break;
                    }
                }
            }
        }
        
        return searchResults;
    }
    
}
