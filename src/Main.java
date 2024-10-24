public class Main {
    public static void main(String[] args) throws InterruptedException {
        if (args.length < 3) {
            System.out.println("Por favor, proporciona los nombres de los alumnos como argumentos.");
            return;
        }

        BufferExamenes generador = new BufferExamenes();
        for (int i = 0; i < args.length; i++) {
            new ProductorExamenes(generador);
            new Examinador(args[i], generador);
        }
    }
}