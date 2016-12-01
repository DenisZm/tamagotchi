package ex1;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by denis on 01.12.16.
 */
public class SetsOperations implements Operations {
    @Override
    public boolean equals(Set a, Set b) {
        if (a.containsAll(b) && b.containsAll(a)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Set union(Set a, Set b) {
        Set tmp = new TreeSet(a);
        tmp.addAll(b);
        return tmp;
    }

    @Override
    public Set subtract(Set a, Set b) {
        Set tmp = new TreeSet(a);
        tmp.removeAll(b);
        return tmp;
    }

    @Override
    public Set intersect(Set a, Set b) {
        Set tmp = new TreeSet(a);
        tmp.retainAll(b);
        return tmp;
    }

    @Override
    public Set symmetricSubtract(Set a, Set b) {
        Set tmp1 = subtract(a, b);
        Set tmp2 = subtract(b, a);
        return union(tmp1, tmp2);
    }
}
