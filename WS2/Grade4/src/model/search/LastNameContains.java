package model.search;

import java.util.ArrayList;
import model.Member;

/**
 *
 * @author olgachristensen
 */
public class LastNameContains implements ISimpleSearchStrategy {
    private String searchFor;
    
    public LastNameContains(String criteria) {
        searchFor = criteria;
    }
    
    public ArrayList<Member> search(ArrayList<Member> members) {
        ArrayList<Member> searchResults = new ArrayList();
        
        for (Member m : members) {
            if (m.getLName().toLowerCase().contains(searchFor)) {
                searchResults.add(m);
            }
        }
        
        return searchResults;
    }
}
