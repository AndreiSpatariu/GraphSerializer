/**
 * Created by Andrei Spatariu on 12/11/2016.
 */
public class NodA extends Node{
    public static int specificVersion;

    public NodA(int id, String name){
        super(id, specificVersion, name);
    }

    public String getNodeType(){
        return Constants.NODE_A;
    }
}
