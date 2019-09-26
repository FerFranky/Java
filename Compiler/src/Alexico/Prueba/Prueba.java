/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alexico.Prueba;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Fernando Olmos
 */
public class Prueba {
    public static void main (String[]args){
        String tablaTokens="(void)|(main)|([a-zA-Z]+)";
        String texto="void main hol";
        Pattern p = Pattern.compile(tablaTokens);
    Matcher mat = p.matcher(texto);
    System.out.println("prueba1");
    while(mat.find()){
    String tokenVoid = mat.group(1);
        String tokenPrin = mat.group(2);
        String tokenAlf = mat.group(3);
        if(tokenVoid != null){
            System.out.println("1: "+tokenVoid);
        }
        if(tokenPrin != null){
            System.out.println("2: "+tokenPrin);
        }
        if(tokenAlf!=null){
            System.out.println("3: "+tokenAlf);
        }
        if(tokenVoid!=null&&tokenPrin!=null){
            System.out.println("Sintaxis correcta: "+tokenVoid+" "+tokenPrin);
        }else if(tokenVoid!=null&&tokenPrin==tokenAlf){
            System.out.println("Sintaxis incorrecta se recomienda main despues de: "+tokenVoid);
        }
    }            
    }
}
