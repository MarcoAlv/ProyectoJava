import frames.asciiFrames;
import functions.Func;

public class ProyectoJava {

    public static final asciiFrames frames = new asciiFrames();

    public static void main(String[] args) {

        /*
        *
        * REGLAS AL PROGRAMAR:
        * - Escribir comentarios en español al crear funciones
        * - Los nombes de las variables se escriben DeEstaForma;
        *   con mayúsculas en cada palabra
        * - Comentar solo lo necesario
        * - Avanzar al menos 3 horas semanales
        * si no saben algun tema pueden preguntar :3 happy to help
        *
        */

        Func.createUsersDatabase();
        frames.startFrame();

    }
}
