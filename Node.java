import java.util.ArrayList;

/**
 * Created by Andrei Spatariu on 11/25/2016.
 */
public abstract class Node {
    public int id;
    public String name;
    public int version;
    public Neighbour neighbour;
    public boolean hasBeenSerialized;

    public abstract String getNodeType();

    public Node(int id, int version, String name){
        this.id = id;
        this.version = version;
        this.name = name;
        hasBeenSerialized = false;

        instantiateNeighbour();
    }

    public void instantiateNeighbour() {
        NeighbourFactory neighbourFactory = NeighbourFactory.getInstance();
        neighbour = neighbourFactory.getAdiacenta(version);
    }

    public void addNeighbours(ArrayList<Node> nodes){
        for(Node node : nodes) {
                neighbour.add(node);
        }
    }

    public void removeNeighbour(String neighbourName) {
        neighbour.removeNode(neighbourName);
    }

    private boolean canChangeToVersion(int newVersion){
        if(newVersion < version)
            return false;

        return true;
    }

    public void changeVersion(int newVersion) {
        NeighbourFactory neighbourFactory = NeighbourFactory.getInstance();
        Neighbour nodeBuffer = neighbourFactory.getAdiacenta(version);

        neighbour.cloneInto(nodeBuffer);
        neighbour = neighbourFactory.getAdiacenta(newVersion);

        nodeBuffer.cloneInto(neighbour);
    }

    public void printNeighbours(){
        System.out.println("Vecini:");
        neighbour.print();
    }

    public String getNeighbourType(){
        if(version == Constants.LIST)
            return "LIST";

        if(version == Constants.VECTOR)
            return "VECTOR";

        if(version == Constants.SET)
            return "SET";

        return null;
    }
}
