package cript_object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JOptionPane;

public class CriptObject {
	
	public static String[] alfabeto = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", 
			"l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "x", "y", "z"};
	public static String alfabeto2 = "abcdefghijklmnopqrstuvwxyz";
	
	
	
	
	//..........Algoritmo de cifrado César, generalizado (algoritmo de sustitución)..........
	
	public static String encriptarCesar(int clave, String texto) {
		char caracter;
		String textoCodificado = "";
		 
		texto = texto.toLowerCase();
		
		    for (int i = 0; i<texto.length(); i++) {
		      for (int j = 0; j < alfabeto.length; j++) {
		   
		    	   	caracter = texto.charAt(i);
		        	
		    	   	if(String.valueOf(caracter).equals(alfabeto[j])) {
		    	   		int pos = (j + clave) %  alfabeto.length;
		    	   		textoCodificado = textoCodificado + alfabeto[pos];
					}
		        }
		    }  
		    return textoCodificado;
	}
	 
	public static String desencriptarCesar(int clave, String texto) {
		char caracter;
		String textoCodificado = "";
		texto = texto.toLowerCase();
		
		    for (int i = 0; i<texto.length(); i++) {
		      for (int j = 0; j < alfabeto.length; j++) {
		   
		    	   	caracter = texto.charAt(i);
		        	
		    	   	if(String.valueOf(caracter).equals(alfabeto[j])) {
		    	   		int pos = (j - clave) %  alfabeto.length;
		    	   		textoCodificado = textoCodificado + alfabeto[pos];
					}
		        }
		    }  
		    return textoCodificado.toLowerCase();
	}
	
	
	//..........Algoritmo de cifrado monoalfabético (algoritmo de sustitución)..........
	
	public static String encriptarMonoalfabetico(String clave, String texto) {
		
		clave = clave.toLowerCase();
		StringBuilder sb = new StringBuilder();
        for(int i = 0; i < clave.length(); i++){
            if(clave.indexOf(clave.charAt(i)) == i){
                sb.append(clave.charAt(i));
            }
        }
       
        String clau = sb.toString();
        String nuevoAlfabeto = clau.concat(alfabeto2);
         
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < nuevoAlfabeto.length(); i++){
            if(nuevoAlfabeto.indexOf(nuevoAlfabeto.charAt(i)) == i){
                sb2.append(nuevoAlfabeto.charAt(i));
            }
        }
        
        nuevoAlfabeto = sb2.toString();
        
        
        int separador = 0;
        double numero = (nuevoAlfabeto.length()/clau.length()) + ((nuevoAlfabeto.length()%clau.length()) * 0.1);
        int columna = clau.length();
        int fila = (int) Math.ceil(numero);
        
        
        char matriz[][] = new char[fila][columna];
        char matrizFinal[][] = new char[columna][fila];

        StringBuilder str = new StringBuilder();
        
      
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
            	if(separador < nuevoAlfabeto.length()) {
            		matriz[i][j] = nuevoAlfabeto.charAt(separador);
            		matrizFinal[j][i] = nuevoAlfabeto.charAt(separador);
                	separador++;
                
            	} else {
            		matriz[i][j] = '.';
            	}
               
            }
        }
       
      
        for (int i = 0; i < matrizFinal.length; i++){
            for (int j = 0; j < matrizFinal[i].length; j++){
            	str.append(matrizFinal[i][j]);	
            }
        }

        String alfabetoFinal = str.toString();
        
        char caracter;
        char caracterAlfabeto;
		String textoCodificado = " ";
        texto = texto.toLowerCase();
        
        for (int i = 0; i < texto.length(); i++) {
		      for (int j = 0; j < alfabeto2.length(); j++) {
		   
		    	   	caracter = texto.charAt(i);
		    	   	caracterAlfabeto = alfabeto2.charAt(j);
		        	
		    	   	if(caracter == caracterAlfabeto) {
		    	   		textoCodificado = textoCodificado + alfabetoFinal.charAt(j);
					}
		        }
		    }  
        
    return textoCodificado.replace(" ", "");
       
    }
	
	public static String desencriptarMonoalfabetico(String clave, String texto) {
		
		clave = clave.toLowerCase();
		StringBuilder sb = new StringBuilder();
        for(int i = 0; i < clave.length(); i++){
            if(clave.indexOf(clave.charAt(i)) == i){
                sb.append(clave.charAt(i));
            }
        }
       
        String clau = sb.toString();
        String nuevoAlfabeto = clau.concat(alfabeto2);
         
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < nuevoAlfabeto.length(); i++){
            if(nuevoAlfabeto.indexOf(nuevoAlfabeto.charAt(i)) == i){
                sb2.append(nuevoAlfabeto.charAt(i));
            }
        }
        
        nuevoAlfabeto = sb2.toString();
        
        
        int separador = 0;
        double numero = (nuevoAlfabeto.length()/clau.length()) + ((nuevoAlfabeto.length()%clau.length()) * 0.1);
        int columna = clau.length();
        int fila = (int) Math.ceil(numero);
        
        
        char matriz[][] = new char[fila][columna];
        char matrizFinal[][] = new char[columna][fila];

        StringBuilder str = new StringBuilder();
        
      
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
            	if(separador < nuevoAlfabeto.length()) {
            		matriz[i][j] = nuevoAlfabeto.charAt(separador);
            		matrizFinal[j][i] = nuevoAlfabeto.charAt(separador);
                	separador++;
            	} else {
            		matriz[i][j] = '.';
            	}
            }
        }
       
      
        for (int i = 0; i < matrizFinal.length; i++){
            for (int j = 0; j < matrizFinal[i].length; j++){
            	str.append(matrizFinal[i][j]);	
            }
        }

        String alfabetoFinal = str.toString();
        
        char caracter;
        char caracterAlfabeto;
		String textoCodificado = " ";
        texto = texto.toLowerCase();
        
        for (int i = 0; i < texto.length(); i++) {
		      for (int j = 0; j < alfabetoFinal.length(); j++) {
		   
		    	   	caracter = texto.charAt(i);
		    	   	caracterAlfabeto = alfabetoFinal.charAt(j);
		        	
		    	   	if(caracter == caracterAlfabeto) {
		    	   		textoCodificado = textoCodificado + alfabeto2.charAt(j);
					}
		        }
		    }  
        
    return textoCodificado.replace(" ", "");
       
    }
	
	
	//..........Algoritmo de cifrado por numeración (algoritmo de transposición)..........
	
	
	public static String encriptarPorNumeracion(String clave, String texto) {
		
		clave = clave.toLowerCase();
		StringBuilder sb = new StringBuilder();
        for(int i = 0; i < clave.length(); i++){
            if(clave.indexOf(clave.charAt(i)) == i){
                sb.append(clave.charAt(i));
            }
        }
       
        String clau = sb.toString();
        texto = texto.toLowerCase();
        String nuevaCadena = clau.concat(texto);
         
        
        int separador = 0;
        double numero = (nuevaCadena.length()/clau.length()) + ((nuevaCadena.length()%clau.length()) * 0.1);
        int columna = clau.length();
        int fila = (int) Math.ceil(numero);
        
        
        char matriz[][] = new char[fila][columna];
       
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
            	if(separador < nuevaCadena.length()) {
            		matriz[i][j] = nuevaCadena.charAt(separador);
                	separador++;
                
            	} else {
            		matriz[i][j] = '*';
            	}
            }
        }
      
        char matrizNueva[][] = new char[fila+1][columna];
        char nuevaFila[] = new char[columna];
        
        for (int x = 0; x < nuevaFila.length; x++){
        	nuevaFila[x] = '/';
        }
        
        int posNuevaFila = fila;
        
        int valor = 0; 

        for (int i = 0; i < matrizNueva.length; i++) {        
            for (int j = 0; j < matrizNueva[0].length; j++) {
                    if (i == posNuevaFila) {
                       matrizNueva[i][j] = nuevaFila[j];
                       valor = 1;
                    }              
                    else
                        matrizNueva[i][j] = matriz[i-valor][j];

               }
         }
        
     
        char matrizProva[][] = new char[columna][fila+1];
       
        for (int i = 0; i < matrizNueva.length; i++){
            for (int j = 0; j < matrizNueva[i].length; j++){
            	matrizProva[j][i] = matrizNueva[i][j];
            }
        }
         
        
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < matrizProva.length; i++){
            for (int j = 0; j < matrizProva[i].length; j++){
              str.append(matrizProva[i][j]);
            }
        }
        
        String frase = str.toString();
        String[] textoSeparado = frase.split("/");
        ArrayList<String> lista = new ArrayList<>(Arrays.asList(textoSeparado));
        
        Collections.sort(lista);
        
        StringBuilder sbuild = new StringBuilder();
        
        for (String s : lista){
        	sbuild.append(s);
        }

        String fraseCodificada = sbuild.toString();
        
    return fraseCodificada.replace("*", "");
       
    }
	
	
	
	public static String desencriptarPorNumeracion(String clave, String texto) {
		
		clave = clave.toLowerCase();
		StringBuilder sb = new StringBuilder();
        for(int i = 0; i < clave.length(); i++){
            if(clave.indexOf(clave.charAt(i)) == i){
                sb.append(clave.charAt(i));
            }
        }
       
        String clau = sb.toString();
        texto = texto.toLowerCase();
        String nuevaCadena = texto;
         
        
        int separador = 0;
        double numero = (nuevaCadena.length()/clau.length()) + ((nuevaCadena.length()%clau.length()) * 0.1);
        int columna = clau.length();
        int fila = (int) Math.ceil(numero);
        
        
        char matriz[][] = new char[fila][columna];
       
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
            	if(separador < nuevaCadena.length()) {
            		matriz[i][j] = nuevaCadena.charAt(separador);
                	separador++;
                
            	} else {
            		matriz[i][j] = '*';
            	}
            }
        }
      
        char matrizNueva[][] = new char[fila+1][columna];
        char nuevaFila[] = new char[columna];
        
        for (int x = 0; x < nuevaFila.length; x++){
        	nuevaFila[x] = '/';
        }
        
        int posNuevaFila = fila;
        
        int valor = 0; 

        for (int i = 0; i < matrizNueva.length; i++) {        
            for (int j = 0; j < matrizNueva[0].length; j++) {
                    if (i == posNuevaFila) {
                       matrizNueva[i][j] = nuevaFila[j];
                       valor = 1;
                    }              
                    else
                        matrizNueva[i][j] = matriz[i-valor][j];

               }
         }
        
     
        char matrizProva[][] = new char[columna][fila+1];
       
        for (int i = 0; i < matrizNueva.length; i++){
            for (int j = 0; j < matrizNueva[i].length; j++){
            	matrizProva[j][i] = matrizNueva[i][j];
            }
        }
         
        
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < matrizProva.length; i++){
            for (int j = 0; j < matrizProva[i].length; j++){
              str.append(matrizProva[i][j]);
            }
        }
        
        String frase = str.toString();
        String[] textoSeparado = frase.split("/");
        ArrayList<String> lista = new ArrayList<>(Arrays.asList(textoSeparado));
        Collections.sort(lista);
        
        StringBuilder sbuild = new StringBuilder();
        
        for (String s : lista){
        	sbuild.append(s);
        }

        String fraseCodificada = sbuild.toString();
        
    return fraseCodificada.replace("*", "");
       
    }
	
}	
	




