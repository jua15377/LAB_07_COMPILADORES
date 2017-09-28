package Pruebas;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import clasesPrincipales.Automata;
import clasesPrincipales.RegExConverter;
import clasesPrincipales.SuperClaseHiperMegaPro;
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
    private static boolean ishexdigit(String entrada) {
        String tokenName = "hexdigit";
        String conjunto = "0123456789ABCDEF";
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
        String[] listaDeKeywords = {"palabra reseadaque no hace mach","if","while"};
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
    }    public static void main(String[] args){

        String regex = "(0|1|2|3|4|5|6|7|8|9)(0|1|2|3|4|5|6|7|8|9)*";
        Automata nombreDEtyoken = laClase.analizador(RegExConverter.infixToPostfix(regex));


        ArrayList<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("test2.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(!line.equals(""))
                    lineas.add(line);
            }
        }
        catch (IOException e){
        }
        for(String linea: lineas){
            for(String palabra: linea.split(" ")){
                if(!isKeyword(palabra)){
                    for(char caracter: palabra.toCharArray()){
						if(isletter(String.valueOf(caracter))){continue;}
						if(isdigit(String.valueOf(caracter))){continue;}
						if(ishexdigit(String.valueOf(caracter))){continue;}
                        else {System.out.printf("ERROR [ %c ] no son caracteres reconocidos\n",caracter);}
                    }
                }
                else {
                    //es una keyword
                }
            }
            textoDeSalida += "\n";
        }
        System.out.println(textoDeSalida);
    }

}