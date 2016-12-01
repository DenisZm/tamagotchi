package ex1;

import java.util.Set;

/**
 * Created by denis on 01.12.16.
 */
public interface Operations {

    boolean equals(Set a, Set b);

    Set union(Set a, Set b);

    Set subtract(Set a, Set b);

    Set intersect(Set a, Set b);

    Set symmetricSubtract(Set a, Set b);
}
