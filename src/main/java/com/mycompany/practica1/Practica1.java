/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practica1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author berta
 */
public class Practica1 {

    public static void main(String[] args) {
        
        File archivoExistente = new File("C:\\Users\\berta\\Desktop\\2º DAM\\Practica1\\prueba.txt");
        File archivoNoExistente = new File("C:\\Users\\berta\\Desktop\\2º DAM\\Practica1\\prueba2.txt");
        
        try {
            
            FileReader readerIndependiente1 = new FileReader(archivoExistente);
            FileReader readerIndependiente2 = new FileReader(archivoNoExistente);
            
            FileReader readerExistente = new FileReader(archivoExistente);
            FileReader readerNoExistente = new FileReader(archivoNoExistente);
            
            BufferedReader BFreaderExistente = new BufferedReader(readerIndependiente1);
            BufferedReader BFreaderNoExistente = new BufferedReader(readerIndependiente2);

            Scanner scExistente = new Scanner(archivoExistente);
            Scanner scNoExistente = new Scanner(archivoNoExistente);
            
            if (archivoExistente.exists()){
                System.out.println("El archivo existente existe");
            }
            
            if (archivoNoExistente.exists()){
                System.out.println("El archivo NO existente existe");
                
            } else {
                archivoNoExistente.createNewFile();
                System.out.println("Se ha creado el nuevo archivo");
            }   
      
            leerConScanner(archivoExistente, scExistente);
            leerConScanner(archivoNoExistente, scNoExistente);
            
            leerConFileReader(readerExistente);
            leerConFileReader(readerNoExistente);
           
            leerConBufferReader(BFreaderExistente);
            leerConBufferReader(BFreaderNoExistente);
            
        } catch(IOException e){
            
        }
    }
    
    public static void leerConScanner(File archivo, Scanner sc) throws FileNotFoundException{
        
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
    
    public static void leerConFileReader(FileReader reader) throws IOException {
        
        int lectura = reader.read();

        while (lectura != -1){
            System.out.println((char)lectura);
            lectura = reader.read();
        }
    }
    
    public static void leerConBufferReader(BufferedReader BFreader) throws IOException {

        String linia = BFreader.readLine();
        while (linia != null) {
            System.out.println(linia);
            linia = BFreader.readLine();
        }
    }
    
    
                    
            
}
