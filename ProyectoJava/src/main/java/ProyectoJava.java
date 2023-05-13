
import java.util.Scanner;

import generator.password.PasswordGenerator;

import java.io.Console;
import functions.Funcs;

// import java.util.Arrays;

/**
 *
 * @author marcs
 */
public class ProyectoJava {

    
    public static final Scanner input = new Scanner(System.in);
    public static final Funcs functions = new Funcs();

    public static void main(String[] args) {
        
        /**
        * 
        * REGLAS AL PROGRAMAR:
        * 
        * - Escribir comentarios en español al crear funciones
        *
        * - Los nombes de las variables se escriben DeEstaForma;
        *   con mayúsculas en cada palabra
        * 
        * - Comentar solo lo necesario
        * 
        * - Avanzar al menos 3 horas semanales
        * 
        * si no saben algun tema pueden preguntar :3 happy to help
        * 
        */
        
        String user = "", logPassword = "";

        String textoBienvenida = 
        "#########################\n" +
        "| Gestor de contrase\u00f1as |\n" +
        "#########################\n" ;

        String listOptions = "(1) Crer nueva contrase\u00f1a\n" +
        "(2) Mostrar Lista de contrase\u00f1as\n" +
        "(3) Eliminar contrase\u00f1a\n" +
        "(4) Importar contrase\u00f1as\n" +
        "(5) Cerrar sesi\u00f3n\n";


        System.out.println(textoBienvenida);
    
    
        System.out.print("Usuario    :");
        user = input.nextLine();

        Console cons;
        
        if((cons = System.console())!=null) {

            char [] password = cons.readPassword("Contrase\u00f1a :");
            logPassword = new String (password);

        } else
        {
            System.out.println("No Console Found...");
        }


        if (!(functions.userValidation(user, logPassword))) {
            return;
        }


        functions.cls();

        System.out.println(textoBienvenida);
        System.out.println(listOptions);

        int opcionElegida;

        System.out.println("opci\u00f3n: ");
        opcionElegida = input.nextInt();
 
        switch (opcionElegida) {
            case 1:
                System.out.println(PasswordGenerator.passwordGenerator());
                break;
        
            default:
                break;
        }



    }





}
