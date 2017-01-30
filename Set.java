import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Andrei Spatariu on 12/13/2016.
 */
public class Set implements Neighbour {
    public HashSet<Node> set = new HashSet<Node>();

    public void add(Node node) {
        if(!set.contains(node))
            set.add(node);
    }

    public void cloneInto(Neighbour neighbour){
        for(Node node : set)
            neighbour.add(node);
    }

    private Node getNode(String nodeName) {
        for(Node node : set) {
            if(node.name.equals(nodeName))
                return node;
        }
        return null;
    }

    public void removeNode(String nodeName) {
        Node node = getNode(nodeName);
        set.remove(node);
    }

    public void print(){
        for(Node node : set){
            System.out.println(node.name);
        }
    }

    public boolean isEmpty(){
        return set.isEmpty();
    }

    public HashSet<Node> getNeighbours(){
        return set;
    }
}
