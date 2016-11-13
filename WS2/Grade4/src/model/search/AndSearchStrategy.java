package model.search;

import java.util.ArrayList;
import model.Member;

/**
 *
 * @author olgachristensen
 */
public class AndSearchStrategy implements IComplexSearchStrategy {
    
    public ArrayList<Member> search(ArrayList<Member> members1, ArrayList<Member> members2) {
        ArrayList<Member> searchResults = new ArrayList();
        for (Member m : members2) {
            if (members1.contains(m)) {
                searchResults.add(m);
            }
        }
        
        return searchResults;
    }
}
