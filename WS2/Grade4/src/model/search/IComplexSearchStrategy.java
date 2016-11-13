package model.search;

import java.util.ArrayList;
import model.Member;

/**
 *
 * @author olgachristensen
 */
public interface IComplexSearchStrategy {
    public ArrayList<Member> search(ArrayList<Member> searResults1, ArrayList<Member> searchResults2);
}
