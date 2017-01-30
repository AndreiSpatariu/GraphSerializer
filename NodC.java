/**
 * Created by Andrei Spatariu on 12/11/2016.
 */
public class NodC extends Node{
    public static int specificVersion;

    public NodC(int id, String name){
        super(id, specificVersion, name);
    }

    public String getNodeType(){
        return Constants.NODE_C;
    }
}
