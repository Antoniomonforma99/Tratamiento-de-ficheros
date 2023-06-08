package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {


        final int OFFSET = 4;

        BufferedReader entrada = null;
        BufferedWriter salida = null;

        try {
            entrada = new BufferedReader(new FileReader("src/main/java/org/example/hola.txt"));
            salida = new BufferedWriter(new FileWriter("hola_encrypt"));

            String linea =null;

            while((linea = entrada.readLine()) != null){
                //Transformamos la línea
                StringBuilder builder = new StringBuilder(linea.length());

                for (char c: linea.toUpperCase().toCharArray()){
                    char result;

                    if (Character.isLetter(c)){
                        int intValue = (int) c - 'A'; //REcogemos el valor númerico dee la letra
                        int intResult = (intValue + OFFSET)%26;   //Calculamos el valor entero de la letr a ya codificada

                        result = (char) ('A' + intResult);  //CAsteamos el valor entero a caracter
                    } else{
                        result = c;
                    }
                    builder.append(result); //Le añadimos al Stringbuilder el caracter resultado

                }
                salida.write(builder.toString());  //Añadimos el builder cmo sTring al buffer de salida
                salida.newLine(); //Creamos una nueva línea
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            if (entrada != null){
                try {
                    entrada.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}