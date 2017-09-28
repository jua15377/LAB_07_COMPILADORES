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
    private static boolean isletter(String entrada) {
        String tokenName = "letter";
        String conjunto = "ABCDFGHIJKLMNOPQRSTUVWXYZabcdfghijklmnopqrstuvwxyz";
        boolean respuesta = conjunto.contains(entrada);
        if (respuesta) {
            //textoDeSalida += String.format("<%s, \"%s\"> ",tokenName, entrada);
            textoDeSalida += String.format("<%s> ", tokenName);
            return true;
        } else {
            return false;
        }
    }
    private static boolean isdigit(String entrada) {
        String tokenName = "digit";
        String conjunto = "0123456789";
        boolean respuesta = conjunto.contains(entrada);
        if (respuesta) {
            //textoDeSalida += String.format("<%s, \"%s\"> ",tokenName, entrada);
            textoDeSalida += String.format("<%s> ", tokenName);
            return true;
        } else {
            return false;
        }
    }
    private static boolean isplus(String entrada) {
        String tokenName = "plus";
        String conjunto = "+";
        boolean respuesta = conjunto.contains(entrada);
        if (respuesta) {
            //textoDeSalida += String.format("<%s, \"%s\"> ",tokenName, entrada);
            textoDeSalida += String.format("<%s> ", tokenName);
            return true;
        } else {
            return false;
        }
    }
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
		Automata isident = laClase.analizador(RegExConverter.infixToPostfix("(A|B|C|D|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z|a|b|c|d|f|g|h|i|j|k|l|m|n|o|p|q|r|s|t|u|v|w|x|y|z)((A|B|C|D|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z|a|b|c|d|f|g|h|i|j|k|l|m|n|o|p|q|r|s|t|u|v|w|x|y|z)|(0|1|2|3|4|5|6|7|8|9))*"));
		Automata isident1 = laClase.analizador(RegExConverter.infixToPostfix("(A|B|C|D|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z|a|b|c|d|f|g|h|i|j|k|l|m|n|o|p|q|r|s|t|u|v|w|x|y|z)(_)**"));
for(String linea: lineas){
            for(String palabra: linea.split("//s+")){
                if(isKeyword(palabra)){
                }
                else if(laClase.simuladorNFA(isident,palabra)){
                    textoDeSalida += " <ident> ";
                }
                else if(laClase.simuladorNFA(isident1,palabra)){
                    textoDeSalida += " <ident1> ";
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
