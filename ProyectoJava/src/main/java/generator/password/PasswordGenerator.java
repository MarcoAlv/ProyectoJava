
package generator.password;

import java.security.SecureRandom;
import java.util.Random;

import functions.Funcs;
import java.util.Scanner;

public class PasswordGenerator {
    
    
    public static final Scanner input = new Scanner(System.in);
    public static final Random random = new SecureRandom();
    public static final Funcs funtions = new Funcs();

    public static String passwordGenerator () {
                

        String  all = "";
        String[] data = new String[4];
        Boolean saved;
        int[] options = new int[4];
        int lenght = 2; 
        saved = false;
        
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



        while (true) {
            funtions.cls();

            System.out.println("######################");
            System.out.println("| Password Generator |");
            System.out.println("######################");
            System.out.println();
            

            
            if (!saved) {
                options = new int[]{2,2,2,2};
                saved = true;
            }

            System.out.println("Selecciona las siguientes opciones: \n1: Si - 0: No");
            
            System.out.println("Desea min\u00fasculas (a-z):");
            if (options[0] == 2) { 
                options[0] = input.nextInt();
            } else {
                System.out.println(options[0]);
            }
            if (options[0] != 0 && options[0] != 1)
            {options[0] = 2; continue;} else {
                    all += options[0] == 1 ? data[0] : "";
                }
            
            System.out.println("Desea may\u00fasculas (A-Z):");
            
            if (options[1] == 2) { 
                options[1] = input.nextInt();
            } else { System.out.println(options[1]);}
            
            if (options[1] != 0 && options[1] != 1) {
                options[1] = 2; continue;
            } else {all += options[1] == 1 ? data[1] : "";}
            
            System.out.println("Desea caracteres especiales:");
            
            if (options[2] == 2) { 
                options[2] = input.nextInt();
            } else { System.out.println(options[2]);}
            
            if (options[2] != 0 && options[2] != 1) {
                options[2] = 2; continue;
            } else {all += options[2] == 1 ? data[2] : "";}
            
            System.out.println("Desea n\u00fameros (0-9):");

            if (options[3] == 2) { 
                options[3] = input.nextInt();
            } else {
                System.out.println(options[3]);
            }
            if (options[3] != 0 && options[3] != 1) {
                options[3] = 2; continue;
            } else {if (options[3] == 1) {all += data[3];}}

            System.out.println("Introdusca la longitud de la contraseña (8 - 60):");
            if (lenght == 2) { 
                lenght = input.nextInt();
            } else {
                System.out.println(lenght);
            }
            if (!(lenght >= 8 && lenght <= 60)) {lenght = 2; continue;}
            else {
                input.close();
                break;
            }
        }
        
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


    }

    private static Object getRandomCharacter(String characterSet) {
        int randomIndex = random.nextInt(characterSet.length());
        return characterSet.charAt(randomIndex);
    }
}
