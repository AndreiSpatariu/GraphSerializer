/**
 * Created by Andrei Spatariu on 12/13/2016.
 */
public class NeighbourFactory {
    private static NeighbourFactory neighbourFactory;

    public static NeighbourFactory getInstance() {
        if(neighbourFactory != null)
            return neighbourFactory;

        neighbourFactory = new NeighbourFactory();
        return neighbourFactory;
    }

    Neighbour getAdiacenta(int index){
        if(index == Constants.LIST)
            return new List();

        if(index == Constants.VECTOR)
            return new Vector();

        if(index == Constants.SET)
            return new Set();

        return null;
    }
}
