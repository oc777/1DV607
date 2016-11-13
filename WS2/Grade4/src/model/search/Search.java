package model.search;

import model.Boat.BoatType;

/**
 *
 * @author olgachristensen
 */
public class Search {
    
    public enum SimpleSearch {
        LAST_NAME_CONTAINS, 
        HAS_BOAT_TYPE 
    }
    
    public enum ComplexSearch {
        AND, 
        OR
    }
    
    
    public ISimpleSearchStrategy lNameCotains (String criteria) {
        return new LastNameContains(criteria);
    }
    
    public ISimpleSearchStrategy hasBoatType(BoatType type) {
        return new HasBoatType(type);
    }
    
    public IComplexSearchStrategy andSearch() {
        return new AndSearchStrategy();
    }
    
    public IComplexSearchStrategy orSearch() {
        return new OrSearchStrategy();
    }
    
}
