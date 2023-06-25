package frames;

import functions.Func;
import functions.User;
import functions.UserBuilder;

import java.io.Console;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class asciiFrames {
    public static final Func functions = new Func();
    public static final Scanner input = new Scanner(System.in);

    public static final String textoBienvenida =
            """
                    #########################
                    | Gestor de contrase\u00f1as |
                    #########################
                    """;

    public static final String listOptions =
            """
                    (1) Crer nueva contrase\u00f1a
                    (2) Mostrar Lista de contrase\u00f1as
                    (3) Importar contrase\u00f1a
                    (4) Cerrar sesi\u00f3n
                    """;

    public static final String logOptions =
            """
                    (1) Iniciar sesi\u00f3n
                    (2) Crear cuenta
                    """;

    public void createUserFrame() {
        while (true) {

            functions.cls();
            System.out.println(textoBienvenida);
            System.out.println("----Crear Cuenta----");


            System.out.println("Ingrese su nombre:");
            String nombre = input.nextLine();
            nombre += input.nextLine();
            System.out.println("Ingres sus apellidos:");
            String apellidos = input.nextLine();
            System.out.println("Ingrese su edad:");
            int edad = input.nextInt();
            System.out.println("Ingrese su correo:");
            String correo = input.nextLine();
            System.out.println("Ingrese un nombre de Usuario:");
            String nombreUsuario = input.nextLine();
            System.out.println("Ingrese su numero de celular:");
            int cell = input.nextInt();

            System.out.println("Ingresa una contraseña segura:");
            String contrasena1 = input.nextLine();

            System.out.println("Repita la contrase\u00f1a:");
            String contrasena2 = input.nextLine();

            if (cell > 999999999 || cell < 99999999) {
                System.out.println("El numero de celular es invalido");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                continue;
                
            }
            if (!(contrasena1.equals(contrasena2))) {
                System.out.println("Las contraseñas no coinciden");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                continue;
            }

            while (true) {
                System.out.println("Desea crear la cuenta?");
                System.out.println("(1) Si \n(2) No");
                int regreso = input.nextInt();
                if (!functions.optionValidator(regreso, 2)) {
                    continue;
                }
                switch (regreso) {
                    case 1:
                        User actualUser = new UserBuilder()
                                .name(nombre).lastName(apellidos)
                                .age(edad).cell(cell)
                                .userName(nombreUsuario)
                                .password(contrasena1)
                                .buildUser();
                        System.out.println("Las contraseñas fue creada");
                        try {
                            TimeUnit.SECONDS.sleep(3);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 2:
                        System.out.println("Las contraseñas no fue creada");
                        try {
                            TimeUnit.SECONDS.sleep(3);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                }
                break;
            }
            break;
        }
    }

    public void loggingFrame() {
        functions.cls();
        String user, logPassword = "";


        System.out.println(textoBienvenida);


        System.out.println("Usuario\t:");
        user = input.nextLine();

        Console cons;

        if((cons = System.console())!=null) {

            char [] password = cons.readPassword("Contraseña\t:");
            logPassword = new String (password);

        } else
        {
            System.out.println("No Console Found...");
        }

        if (!(functions.userValidation(user, logPassword))) {

            System.exit(0);
        }


        mainFrame();


    }

    public void mainFrame(){
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

    public static void startFrame() {

        while (true) {
            functions.cls();

            System.out.println(textoBienvenida);
            System.out.println(logOptions);

            int opcionElegida;

            System.out.println("Opción: ");
            opcionElegida = input.nextInt();

            switch (opcionElegida) {
                case 1 -> loggingFrame();
                case 2 -> createUserFrame();
                default -> System.out.println("Opción no admitida");
            }
        }
    }
}
