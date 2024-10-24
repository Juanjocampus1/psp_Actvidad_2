import java.util.Random;

public class Examinador implements Runnable {
    private Thread hilo;
    private BufferExamenes buffer;

    public Examinador(String alumno, BufferExamenes generador) {
        this.buffer = generador;
        this.hilo = new Thread(this, alumno);
        this.hilo.start();
    }

    @Override
    public void run() {
        String codigoExamen = this.buffer.consumirExamen();
        if (codigoExamen != null) {
            Random random = new Random();
            String[] respuestas = {"A", "B", "C", "D", "-"};

            for (int i = 1; i <= 10; i++) {
                String respuesta = respuestas[random.nextInt(respuestas.length)];
                System.out.println(codigoExamen + ";" + this.hilo.getName() + "; Pregunta " + i + ";" + respuesta);
            }
        } else {
            System.out.println("Agotado tiempo de espera y no hay más exámenes");
        }
    }
}