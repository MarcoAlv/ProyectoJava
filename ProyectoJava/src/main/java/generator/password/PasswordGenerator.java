
package generator.password;

import functions.Func;

import java.util.Scanner;

public class PasswordGenerator {
    
    
    public static final Scanner input = new Scanner(System.in);
    public static final Func functions = new Func();
    public static final String[] data = new String[4];

    static{

        /* Llenar los caracteres usados para cada tipo
         *  data[0]: String = minusculas
         *  data[1]: String = minusculas
         *  data[2]: String = simbolos
         *  data[3]: String = numeros
         *
         *  lo mismo con options[i] -> (int)
         */

        data[0] ="abcdefghijklmnopqrstuvwxyz";
        data[1] ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        data[2] ="!@#$%^&*()_+-={}[]|\\:;\"'<>,.?/";
        data[3] ="0123456789";
    }


    public static String passwordGenerator() {
                

        StringBuilder all = new StringBuilder();
        int length = 0;
        int[] options;

        options = new int[]{2,2,2,2};

        while (true) {
            functions.cls();

            System.out.println("######################");
            System.out.println("| Password Generator |");
            System.out.println("######################");
            System.out.println();
            


            System.out.println("Selecciona las siguientes opciones: \n1: Si - 0: No");
            
            System.out.println("Desea min\u00fasculas (a-z):");
            if (options[0] == 2) {
                options[0] = input.nextInt();
                if (options[0] != 0 && options[0] != 1) {
                    options[0] = 2; continue;
                } else {
                    all.append(options[0] == 1 ? data[0] : "");
                }
            } else {
                System.out.println(options[0]);
            }

            
            System.out.println("Desea may\u00fasculas (A-Z):");
            
            if (options[1] == 2) {
                options[1] = input.nextInt();

                if (options[1] != 0 && options[1] != 1) {
                    options[1] = 2; continue;
                } else {
                    all.append(options[1] == 1 ? data[1] : "");}

            } else { System.out.println(options[1]);}
            

            
            System.out.println("Desea caracteres especiales:");
            
            if (options[2] == 2) {
                options[2] = input.nextInt();
            } else { System.out.println(options[2]);}
            
            if (options[2] != 0 && options[2] != 1) {
                options[2] = 2; continue;
            } else {
                all.append(options[2] == 1 ? data[2] : "");}
            
            System.out.println("Desea n\u00fameros (0-9):");

            if (options[3] == 2) {
                options[3] = input.nextInt();
            } else {
                System.out.println(options[3]);
            }
            if (options[3] != 0 && options[3] != 1) {
                options[3] = 2; continue;
            } else {if (options[3] == 1) {
                all.append(data[3]);}}

            System.out.println("Introduzca la longitud de la contraseña (8 - 60):");

            if (length < 8 || length > 60) {
                length = input.nextInt();
            } else {
                input.close();
                break;
            }
        }
        
        return Func.passwordGen(options, all.toString(), length);
        
/*======= (Creo que todo esto ya está implementado en el método passwordGen())
        StringBuilder password = new StringBuilder();
        int selected = 0;

        for (int i = 0; i < 4; i++) {

            if (options[i] == 1) {
                password.append(getRandomCharacter(data[i]));
                selected++;
            }

        }

        for (int i = selected; i < lenght; i++) {
            password.append(getRandomCharacter(all));
        }

        // Mezcla los caracteres para que no estén en orden predecible
        for (int i = 0; i < lenght; i++) {
            int randomIndex = random.nextInt(lenght);
            char temp = password.charAt(i);
            password.setCharAt(i, password.charAt(randomIndex));
            password.setCharAt(randomIndex, temp);
        }
        
        return password.toString();
>>>>>>> main*/


    }


}
