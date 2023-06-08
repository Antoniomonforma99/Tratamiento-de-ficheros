package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        BufferedInputStream entrada = null;
        BufferedInputStream entrada1 = null;
        BufferedOutputStream salida = null;

        final int TAM = 1024*16;

        try {
            entrada = new BufferedInputStream(new FileInputStream("src/main/java/org/example/jason.jpg"));
            entrada1 = new BufferedInputStream(new FileInputStream("src/main/java/org/example/tela.PNG"));
            salida = new BufferedOutputStream(new FileOutputStream("jsonCopia"));

            int cantidadBytes = 0;
            int cantidadBytesAux = 0;

            byte[] buffer = new byte[TAM];

            while((cantidadBytesAux = entrada1.read(buffer, 0, TAM)) != -1){
                salida.write(buffer, 0, cantidadBytesAux);
            }

            while((cantidadBytes = entrada.read(buffer, 0, TAM)) != -1){
                salida.write(buffer, 0, cantidadBytes);
            }






        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (entrada != null)
                try {
                    entrada.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            if (salida != null)
                try {
                    salida.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            if(entrada1 != null)
                try {
                    entrada1.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
        }


    }
}