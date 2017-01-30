import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Andrei Spatariu on 12/14/2016.
 */
public class Operations {
    public static void addNode(String[] arguments) {
        Graf graf = Graf.getInstance();
        int numberOfNonNeighboursArguments = 3;
        int numberOfNeighbours = arguments.length - numberOfNonNeighboursArguments;
        int nodeId = graf.numberOfNodes;

        String nodeType = arguments[1];
        String nodeName = arguments[2];

        Node node;

        switch(nodeType){
            case Constants.NODE_A:
                node = new NodA(nodeId, nodeName);
                break;

            case Constants.NODE_B:
                node = new NodB(nodeId, nodeName);
                break;

            case Constants.NODE_C:
                node = new NodC(nodeId, nodeName);
                break;

            default:
                node = null;
        }

        Node auxNode;
        String newNodeName = new String();

        String[] linkArguments = new String[3];
        linkArguments[1] = nodeName;

        for(int i = 3; i < numberOfNeighbours + 3; i++) {
            newNodeName = arguments[i];
            auxNode = graf.getNode(newNodeName);

            node.neighbour.add(auxNode);

            //we add link to the neighbour too
        }

        graf.numberOfNodes++;
        graf.nodes.add(node);

        for(int i = 3; i < numberOfNeighbours + 3; i++) {
            newNodeName = arguments[i];
            linkArguments[2] = newNodeName;

            addLink(linkArguments);
        }
    }

    public static void deleteNode(String[] arguments) {
        Graf graf = Graf.getInstance();
        String nodeName;

        //delete node from the stored array in graf
        nodeName = arguments[2];

        Node auxNode = graf.getNode(nodeName);
        graf.nodes.remove(auxNode);

        //delete node from neighbour lists
        for(Node node : graf.nodes) {
            node.removeNeighbour(nodeName);
        }
    }

    public static void addLink(String[] arguments){
        Graf graf = Graf.getInstance();

        String firstNodeName = arguments[1];
        String secondNodeName = arguments[2];

        Node firstNode = graf.getNode(firstNodeName);
        Node secondNode = graf.getNode(secondNodeName);

        //add link to first node

        ArrayList<Node> firstNodeNeighbour = new ArrayList<Node>();
        firstNodeNeighbour.add(secondNode);
        firstNode.addNeighbours(firstNodeNeighbour);

        //add link to second node

        ArrayList<Node> secondNodeNeighbour = new ArrayList<Node>();
        secondNodeNeighbour.add(firstNode);
        secondNode.addNeighbours(secondNodeNeighbour);
    }

    public static void removeLink(String[] arguments) {
        Graf graf = Graf.getInstance();

        String firstNodeName = arguments[1];
        String secondNodeName = arguments[2];

        Node firstNode = graf.getNode(firstNodeName);
        Node secondNode = graf.getNode(secondNodeName);

        firstNode.removeNeighbour(secondNodeName);
        secondNode.removeNeighbour(firstNodeName);
    }

    public static void updateSettings(String[] arguments) {
        NodA.specificVersion = Integer.valueOf(arguments[1]);
        NodB.specificVersion = Integer.valueOf(arguments[2]);
        NodC.specificVersion = Integer.valueOf(arguments[3]);
    }

    public static void serialize(String[] arguments) {
        Graf graf = Graf.getInstance();
        String nodeName = arguments[1];

        Node toBeSerialized = graf.getNode(nodeName);

        if(!toBeSerialized.hasBeenSerialized){

            toBeSerialized.hasBeenSerialized = true;

            System.out.println("<Object class=" + toBeSerialized.getNodeType()
                    + " Version=" + toBeSerialized.version + " id=" + toBeSerialized.id + ">");
            System.out.println("<Nume>" + toBeSerialized.name + "</Nume>");

            if(!toBeSerialized.neighbour.isEmpty()){
                System.out.println("<" + toBeSerialized.getNeighbourType() + ">");

                Iterable<Node> neighbours = toBeSerialized.neighbour.getNeighbours();

                String[] newArguments = new String[2];

                for(Node node : neighbours) {
                    newArguments[1] = node.name;
                    serialize(newArguments);
                }

                System.out.println("</" + toBeSerialized.getNeighbourType() + ">");
            }

            System.out.println("</Object>");
            return;
        }

        System.out.println("<Reference class=" + toBeSerialized.getNodeType()
                + " Version=" + toBeSerialized.version + " id=" + toBeSerialized.id + ">");
    }

    public static void deserialize(String[] arguments) {

    }
}
