import java.util.LinkedList;

/**
 * Created by Andrei Spatariu on 12/13/2016.
 */
public class List implements Neighbour {
    public LinkedList<Node> list = new LinkedList<Node>();

    public void add(Node node){
        if(!list.contains(node))
            list.add(node);
    }

    public void cloneInto(Neighbour neighbour){
        for(Node node : list)
            neighbour.add(node);
    }

    private Node getNode(String nodeName) {
        for(Node node : list) {
            if(node.name.equals(nodeName))
                return node;
        }
        return null;
    }

    public void removeNode(String nodeName) {
        Node node = getNode(nodeName);
        list.remove(node);
    }

    public void print(){
        for(Node node : list){
            System.out.println(node.name);
        }
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public LinkedList<Node> getNeighbours() {
        return list;
    }
}
