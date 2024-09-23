package Practica1;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author BERTA GARCIA VELASCO
 */

public class Banc {

    public static void main(String[] args) {
        
        File archivo = new File("C:\\Users\\berta\\Desktop\\2º DAM\\Practica1\\banco.txt");
        
        try {
            if (!archivo.exists()){
                archivo.createNewFile();
                System.out.println("Se ha creado el archivo");
                int capitalCuentaNueva = 100;
                
                escribirConFileWriter(archivo, capitalCuentaNueva);
                  
            } else {
                System.out.println("El archivo existe\n"); 
                
            }
            
            // El archivo debe contener el capital de esa cuenta
            int i_capital = leerConScanner(archivo);

            boolean salir = false;

            Scanner sc = new Scanner(System.in);

            while (!salir){

                String s_opcions = "1-Afegir diners\n"
                        + "2-Treure diners\n"
                        + "3-Sortir del programa\n";

                System.out.println(s_opcions);

                int i_opcio_escollida = sc.nextInt();
                int i_quantitat = 0;
                switch (i_opcio_escollida) {
                    case 1:
                        System.out.println("Introdueix la quantitat a ingressar");
                        i_quantitat = sc.nextInt();
                        i_capital += i_quantitat;
                        System.out.println("Saldo disponible: " + i_capital + "€");
                        escribirConFileWriter(archivo, i_capital);
                        break;

                    case 2:
                        System.out.println("Introdueix la quantitat a extreure");
                        i_quantitat = sc.nextInt();
                        if (i_quantitat > i_capital) {
                            System.out.println("No té suficient capital");
                        } else {
                            i_capital -= i_quantitat;
                            System.out.println("Saldo disponible: " + i_capital + "€");
                            escribirConFileWriter(archivo, i_capital);
                        }
                        break;

                    case 3:
                        System.out.println("Sortint del programa. Fins aviat!");
                        salir = true;
                        break;

                    default:
                        System.out.println("Opció incorrecta. Sortint del programa.");
                        break;
                }
            }

        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void escribirConFileWriter(File archivo, int i_capital) throws IOException{

            FileWriter writer = new FileWriter(archivo);
            writer.write(String.valueOf(i_capital));
            writer.close();

    }
    
    public static int leerConScanner(File file) throws FileNotFoundException{
        String capital = "";
        String caracter = "";
        
        Scanner scanner = new Scanner(file);
        
        while (scanner.hasNextLine()) {
            capital = caracter.concat(scanner.nextLine());
        }

        scanner.close();

        return Integer.parseInt(capital);
    }
}