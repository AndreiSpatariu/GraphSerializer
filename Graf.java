import java.util.ArrayList;

/**
 * Created by Andrei Spatariu on 12/13/2016.
 */
public class Graf {
    private static Graf graf;
    public static int numberOfNodes;

    public ArrayList<Node> nodes;

    public static Graf getInstance () {
        if (graf != null)
            return graf;

        graf = new Graf();
        graf.nodes = new ArrayList<Node>();
        graf.numberOfNodes = 0;

        return graf;
    }

    public Node getNode(String nodeName) {
        for(Node node : nodes)
            if(node.name.equals(nodeName))
                return node;

        System.out.println("Could not find specified node");
        return null;
    }

    public void print() {
        for(Node node : nodes) {
            System.out.println("Nod principal: " + node.name);

            node.printNeighbours();
        }
    }
}
