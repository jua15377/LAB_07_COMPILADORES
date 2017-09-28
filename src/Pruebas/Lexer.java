package Pruebas;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import clasesPrincipales.Automata;
import clasesPrincipales.RegExConverter;
import clasesPrincipales.SuperClaseHiperMegaPro;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Lexer {

    private static String  textoDeSalida = "";
    private static SuperClaseHiperMegaPro laClase = new SuperClaseHiperMegaPro();
    private static boolean isKeyword(String entrada){
        String tokenName = "keyword";
        String[] listaDeKeywords = {"palabra reseadaque no hace mach"};
        ArrayList<String> conjunto = new ArrayList<>(Arrays.asList(listaDeKeywords));
        boolean respuesta = conjunto.contains(entrada);
        if (respuesta){
            int indice = conjunto.indexOf(entrada);
            //textoDeSalida += String.format("<%s, \"%s\"> ",conjunto.get(indice), entrada);
            textoDeSalida += String.format("<%s> ",conjunto.get(indice));
            return true;
        }
        else {
            return false;
        }
    }
 public static void main(String[] args){
        //filechooser para ver el escoger el archivo que se esta buscando
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("./src"));
        chooser.setDialogTitle("Seleccione su archivo");
        chooser.setFileFilter(new FileNameExtensionFilter("Text files (.txt)", "txt"));
        int returnVal = chooser.showOpenDialog(null);
        ArrayList<String> lineas = new ArrayList<>();
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try (BufferedReader br = new BufferedReader(new FileReader(chooser.getSelectedFile().getAbsolutePath()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if(!line.equals(""))
                        lineas.add(line);
                }
            }
            catch (IOException e){
            }
        }
for(String linea: lineas){
            for(String palabra: linea.split(" ")){
                if(isKeyword(palabra)){
                }
else {
                    textoDeSalida += "No reconocida ";
                    System.out.printf("ERROR [ %s ] no fue reconocida\n",palabra);
                }
            }
            textoDeSalida += "\n";
        }
        System.out.println(textoDeSalida);
    }

}
