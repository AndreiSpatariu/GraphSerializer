import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        PrintWriter writer = new PrintWriter("outputfilename.out");

        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Andrei Spatariu\\IdeaProjects\\Tema2\\src\\input.in"));
        String line;

        Graf graf = Graf.getInstance();

        while((line = bufferedReader.readLine()) != null) {
            InputOutput.ReadLine(line, writer);
        }

        graf.print();
    }
}
