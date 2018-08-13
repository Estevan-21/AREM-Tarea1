package edu.escuelaing.arem.tarea;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.List;


/**
 * Tarea 1 AREM
 *
 * @author Vargas Brayam
 * 
 */
public class Tarea {
    static ListaDinamica lista=new ListaDinamica();
    
    
    
    /**
     * Método Principal del programa
     * @param args args
     * @throws  java.io.IOException excepcion
     */
    public static void main(String[] args) throws IOException {
        leer("C:/Users/Estevan/Desktop/archivo2.txt");        
        System.out.println("La media de los datos encontrados en el archivo es: "+calculoMedia(lista));
        System.out.println("La desviacion estandar de los datos encontrados en el archivo es: "+calculoDesviacion(lista));
    }
    
   
    /**
     * Lee los números de un archivo .txt y los almacena en una lista enlazada
     * @throws java.io.IOException IoException
     * @throws java.io.FileNotFoundException IoException
     * @param archivo archivo
     */
    public static void leer(String archivo) throws FileNotFoundException, IOException {
        String cadena; 
       
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena =b.readLine())!=null) {
            float a=Float.parseFloat(cadena);
            lista.addLast(a);
        }
        b.close();
    }   
    
    
    /**
     * Calcula la media de los números que se encuentran en una lista enlazada
     *
     * @param lista lista
     * @return media de los números
     */
    public static float calculoMedia(ListaDinamica lista){
        float media=0;
        float valor=0;        
        for(int i=0;i<lista.size();i++){
            valor=Float.parseFloat(lista.get(i).toString());
            media=media+valor;
        }        
       media= media/lista.size();
        return media;
    }
    
    /**
     * Calcula la desviacion estandar de los números que se encuentran en una lista enlazada
     *
     * @param lista lista
     * @return desviacion estandar de los números
     */
    public static float calculoDesviacion(ListaDinamica lista){ 
        float sumatoria=0;
        float valor=0;
        float media2=calculoMedia(lista);
        float desviacion=0;
        for(int i=0;i<lista.size();i++){
            valor=Float.parseFloat(lista.get(i).toString())-media2;
            valor=valor*valor;
            sumatoria=sumatoria+valor;
        }        
        desviacion=sumatoria/(lista.size()-1); 
        desviacion=(float) sqrt(desviacion);
        return desviacion;
    }
 
}
