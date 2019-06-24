/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author usuario
 */
public class Gestor {

    public String leerArchivopar(String linea) {
        try {
            linea = new String();
            try (FileReader ruta = new FileReader("archivos/archivo1.txt");
                    BufferedReader in_arch = new BufferedReader(ruta)) {
                while (in_arch.readLine() != null) {
                    linea = in_arch.readLine();
                    System.out.println(linea);
                }
            }
        } catch (IOException e) {
            System.out.println("No se ha podido leer el archivo.");
        }
        return linea;
    }

    public String leerArchivoSinSaltos(String ruta) {
        Path archivo = Paths.get(ruta);
        String texto = "";
        try {
            texto = new String(Files.readAllBytes(archivo));
        } catch (IOException e) {
            System.out.println("El archivo no pudo ser leido");
        }
        return texto.replaceAll("\n", "");
    }

    public String leerArchivo(String ruta) {

        Path archivo = Paths.get(ruta);
        String texto = "";
        try {
            texto = new String(Files.readAllBytes(archivo));

        } catch (IOException e) {
            System.out.println("El archivo no pudo ser leido");
        }
        return texto;
    }
    public String diferenciarArchivo(String direccion) {

        String textoFormat;
        if (direccion.contains("archivo1.txt")) {
            textoFormat = lineasPares(direccion);
        } else {
            textoFormat = separarSaltos(direccion);
        }
        return textoFormat;
    }
    private String lineasPares(String direccion) {
        String texto = leerArchivo(direccion);
        String[] separados = separarCondicion(texto, "\n");
        texto = "";
        for (int i = 0; i < separados.length / 2; i++) {
            texto = texto + separados[1 + 2 * i] + "\n";

        }
        return texto;
    }
    private String[] separarCondicion(String texto, String condicion) {
        String[] separacion = texto.split(condicion);
        return separacion;
    }
    private String separarSaltos(String direccion) {
        String texto = leerArchivo(direccion);
        String[] separados = separarCondicion(texto, "\n");
        texto = "";
        for (int i = 0; i < separados.length; i++) {
            texto = texto + separados[i] + " ";

        }
        return texto;
    }
    
}
