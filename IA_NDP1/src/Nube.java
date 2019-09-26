/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego_SF
 */
import java.util.*;
import java.io.*;

public class Nube {

    public static void main(String args[]) {
        /*   String frase;
         Scanner palabara = new Scanner (System.in);
         System.out.println("Intruce texto: ");
         frase = palabara.nextLine();
         StringTokenizer num_p = new StringTokenizer(frase);
         System.out.println("la candidad de palablas son: "+num_p.countTokens());
       
         */
      //  FileReader archivo = new FileReader("pruebas.txt");
        //  BufferedReader leer = new BufferedReader(archivo); 
        //    if(){
        //     StringTokenizer num_p = new StringTokenizer(archivoPlano.get()); 
        //     System.out.println("numero de palabras: " + num_p.countTokens());
        // }
        //---------------------------------------------------------------------------------
   //     String cadena1 = "En un lugar de La Mancha";

// Cadena en la que almacenaremos el resultado
     //   String cadena2 = null, cadena3 = null;
       // cadena2 = cadena1.replace("[lugar|La]", "");
       // cadena3 = cadena2.replace("La", "");
      //  System.out.println(cadena2);
// En un bar de La Mancha
     //   System.out.println(cadena1);
       // System.out.println(cadena3);
// En un lugar de La Mancha
/* Como vemos, el ejecutar el método 
         replace no afecta a la cadena original */
        /*
         contar cuantas vaves se repite una palaba, 
         si la palabra mas repetida es mayor que la 
         */
        
//-------------------------------------------------------------------------------    
        // Cadena sobre la que realizaremos la sustitución
        String cadena1 = "En un lugar de La Mancha la casa lo metio si asi es consiso";

// Cadena en la que almacenaremos el resultado
        String cadena2= null;

      //  cadena2 = cadena1.replaceAll("a", "e");

       // System.out.println(cadena2);
// En un luger de Le Menche

        cadena2  = cadena1.replaceAll(" lo | si ", " ");
        System.out.println(cadena2);
// En en leger de Le Menche

        System.out.println(cadena1);
// En un lugar de La Mancha
/* Como vemos, el ejecutar el método
         replaceAll no afecta a la cadena original */
        //new Texto("Perro gato perro gato data baño gato atun atun gato").contarTodas();

    }
}


