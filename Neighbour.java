import java.util.ArrayList;

/**
 * Created by Andrei Spatariu on 12/13/2016.
 */
public interface Neighbour {
    void add(Node node);
    void cloneInto(Neighbour neighbour);
    void removeNode(String neighbourName);
    void print();
    boolean isEmpty();
    Iterable<Node> getNeighbours();
}
