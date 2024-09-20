/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Practica1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author berta
 */
public class Practica1 {

    public static void main(String[] args) throws FileNotFoundException {
        
        File archivoExistente = new File("C:\\Users\\berta\\Desktop\\2º DAM\\Practica1\\prueba.txt");
        File archivoNoExistente = new File("C:\\Users\\berta\\Desktop\\2º DAM\\Practica1\\prueba2.txt");
        
        try {
            if (archivoExistente.exists()){
                System.out.println("El archivo existente existe");
            }
            
            if (archivoNoExistente.exists()){
                System.out.println("El archivo NO existente existe");
                
            } else {
                archivoNoExistente.createNewFile();
                System.out.println("Se ha creado el nuevo archivo");
            }   
            
            leerConScanner(archivoExistente);
            leerConScanner(archivoNoExistente);
            
            leerConFileReader(archivoExistente);
            leerConFileReader(archivoNoExistente);
           
            leerConBufferReader(archivoExistente);
            leerConBufferReader(archivoNoExistente);
            
            
            String textoNuevoExistente = "Texto nuevo";
            String textoNuevoNoExistente = "New text";
            
            
            escribirConFileWriter(archivoExistente, textoNuevoExistente);
            escribirConFileWriter(archivoNoExistente, textoNuevoNoExistente);
           
        } catch(IOException e){
            
        }
    }
    
    public static void leerConScanner(File file) throws FileNotFoundException{
        
        Scanner sc = new Scanner(file);
        
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
    
    public static void leerConFileReader(File file) throws IOException {
        
        FileReader reader = new FileReader(file);
        
        int lectura = reader.read();

        while (lectura != -1){
            System.out.println((char)lectura);
            lectura = reader.read();
        }
    }
    
    public static void leerConBufferReader(File file) throws IOException {

        FileReader reader = new FileReader(file);

        BufferedReader BFreader = new BufferedReader(reader);
        
        String linia = BFreader.readLine();
        while (linia != null) {
            System.out.println(linia);
            linia = BFreader.readLine();
        }
    }
    
    public static void escribirConFileWriter(File file, String textoNuevo) throws IOException{
        
        FileWriter writer = new FileWriter(file);
        
        writer.write(textoNuevo);
      
    }
    
                    
            
}
