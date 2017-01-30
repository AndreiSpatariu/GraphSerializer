import java.io.PrintWriter;

/**
 * Created by Andrei Spatariu on 12/14/2016.
 */
public class InputOutput {
    public static void ReadLine (String string, PrintWriter writer) {
        String[] arguments = string.split(" ");

        String operationType = arguments[0];

        switch(operationType){
            case Constants.ADD_NODE:
                Operations.addNode(arguments);
                break;

            case Constants.REMOVE_NODE:
                Operations.deleteNode(arguments);
                break;

            case Constants.ADD_LINK:
                Operations.addLink(arguments);
                break;

            case Constants.REMOVE_LINK:
                Operations.removeLink(arguments);
                break;

            case Constants.UPDATE_SETTINGS:
                Operations.updateSettings(arguments);
                break;

            case Constants.SERIALIZE:
                Operations.serialize(arguments);
                break;

            case Constants.DESERIALIZE:
                Operations.deserialize(arguments);
                break;
        }
    }
}
