package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        File directorio = new File("./collehita");

        BufferedWriter salida = null;

        try {
            salida = new BufferedWriter(new FileWriter("tracklist.txt"));

            List<String> lista = Arrays.asList(directorio.list());

            for (String s : lista) {
                StringBuilder builder = new StringBuilder(s.length());

                builder.append(s);
                salida.write(builder.toString());
                salida.newLine();

                builder = null;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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