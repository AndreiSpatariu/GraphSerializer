import java.util.ArrayList;

/**
 * Created by Andrei Spatariu on 12/13/2016.
 */
public class Vector implements Neighbour {
    public ArrayList<Node> array = new ArrayList<Node>();

    public void add (Node node){
        if(!array.contains(node))
            array.add(node);
    }

    public void cloneInto(Neighbour neighbour){
        for(Node node : array)
            neighbour.add(node);
    }

    private Node getNode(String nodeName) {
        for(Node node : array) {
            if(node.name.equals(nodeName))
                return node;
        }
        return null;
    }

    public void removeNode(String nodeName) {
        Node node = getNode(nodeName);
        array.remove(node);
    }

    public void print(){
        for(Node node : array){
            System.out.println(node.name);
        }
    }

    public boolean isEmpty(){
        return array.isEmpty();
    }

    public ArrayList<Node> getNeighbours(){
        return array;
    }
}
