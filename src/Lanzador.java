import java.io.IOException;

public class Lanzador {
    public static void main(String[] args) {

        try {
            ProcessBuilder pb1 = new ProcessBuilder("java", "Main", "Pepe", "Juan", "Luis");
            pb1.redirectOutput(new java.io.File("examen1.txt"));
            Process p1 = pb1.start();

            ProcessBuilder pb2 = new ProcessBuilder("java", "Main", "Rosa", "Miguel", "Pedro");
            pb2.redirectOutput(new java.io.File("examen2.txt"));
            Process p2 = pb2.start();

            p1.waitFor();
            p2.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}