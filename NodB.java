/**
 * Created by Andrei Spatariu on 12/11/2016.
 */
public class NodB extends Node {
    public static int specificVersion;

    public NodB(int id, String name){
        super(id, specificVersion, name);
    }

    public String getNodeType(){
        return Constants.NODE_B;
    }
}
