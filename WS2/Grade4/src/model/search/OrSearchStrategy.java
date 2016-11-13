package model.search;

import java.util.ArrayList;
import model.Member;

/**
 *
 * @author olgachristensen
 */
public class OrSearchStrategy implements IComplexSearchStrategy {
    
    public ArrayList<Member> search(ArrayList<Member> members1, ArrayList<Member> members2) {
        
        for (Member m : members2) {
            if (!members1.contains(m)) {
                members1.add(m);
            }
        }
        
        return members1;
    }
}
