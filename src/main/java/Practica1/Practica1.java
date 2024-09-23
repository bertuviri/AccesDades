/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Practica1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
public class Practica1 {

    public static void main(String[] args) throws FileNotFoundException {
        
        File archivoExistente = new File("C:\\Users\\berta\\Desktop\\2º DAM\\Practica1\\prueba2.txt");
        File archivoNoExistente = new File("C:\\Users\\berta\\Desktop\\2º DAM\\Practica1\\prueba.txt");
        
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
            
            escribirConFileWriter(archivoExistente);
            escribirConFileWriter(archivoNoExistente);
            
            escribirConBufferedWriter(archivoExistente);
            escribirConBufferedWriter(archivoNoExistente);
            
            añadirTextoConFileWriter(archivoExistente);
            añadirTextoConFileWriter(archivoNoExistente);
            
            añadirTextoConBufferedWriter(archivoExistente);
            añadirTextoConBufferedWriter(archivoNoExistente);
            
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void leerConScanner(File file) throws FileNotFoundException{
        
        Scanner sc = new Scanner(file);
        
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
        
        sc.close();
    }
    
    public static void leerConFileReader(File file) throws IOException {
        
        FileReader reader = new FileReader(file);
        
        int lectura = reader.read();

        while (lectura != -1){
            System.out.println((char)lectura);
            lectura = reader.read();
        }
        reader.close();
    }
    
    public static void leerConBufferReader(File file) throws IOException {

        FileReader reader = new FileReader(file);

        BufferedReader BFreader = new BufferedReader(reader);
        
        String linia = BFreader.readLine();
        while (linia != null) {
            System.out.println(linia);
            linia = BFreader.readLine();
        }
        
        reader.close();
        BFreader.close();
    }
    
    public static void escribirConFileWriter(File file) throws IOException{
        
        FileWriter writer = new FileWriter(file);
        
        writer.write("Escrito con File Writer.\n");
        writer.close();

    }
    
    public static void escribirConBufferedWriter(File file) throws IOException{
          FileWriter writer = new FileWriter(file);
          BufferedWriter BFwriter = new BufferedWriter(writer);
          BFwriter.write("Escrito con Buffered Writer.\n");
          BFwriter.close();
    }
    
    public static void añadirTextoConFileWriter(File file) throws IOException{
        FileWriter writer = new FileWriter(file, true);
        
        writer.write("Texto añadido con File Writer.\n");
        writer.close();
    }
    
    public static void añadirTextoConBufferedWriter(File file) throws IOException{
        FileWriter writer = new FileWriter(file, true);
        
        BufferedWriter BFwriter = new BufferedWriter(writer);
        BFwriter.write("Texto añadido con Buffered Writer.\n");
        BFwriter.close();
    }
            
}
