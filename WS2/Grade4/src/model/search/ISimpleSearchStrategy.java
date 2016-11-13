package model.search;

import java.util.ArrayList;
import model.Member;

/**
 *
 * @author olgachristensen
 */
public interface ISimpleSearchStrategy {
    public ArrayList<Member> search(ArrayList<Member> members);
}
