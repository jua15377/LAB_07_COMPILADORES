package clasesPrincipales;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import clasesPrincipales.SuperClaseHiperMegaPro;


/**
 * @author Jonnathan Juarez
 * @version 1.0 25/09/2017
 */
public class Principal {
    public static void main(String args[]) {

        AnalizadorSintactico analizadorSintactico = new AnalizadorSintactico();
// lee el archivo
        Scanner s = null;
        ArrayList<String> arreglo = new ArrayList<>();
        try {
            s = new Scanner(new BufferedReader(new FileReader("test.txt")));
            while (s.hasNext())
            {
                String str = s.next();
                arreglo.add(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (s != null) {
                s.close();
            }
        }
        //analiza la estructura de cocol
        analizadorSintactico.cocolAnalizer(arreglo);

        ArrayList<String> arreglodeDeLineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(!line.equals(""))
                arreglodeDeLineas.add(line);
            }
        }
        catch (IOException e){

        }

        analizadorSintactico.analizador(arreglodeDeLineas);
        System.out.println("Si no hay errores el lexer fue creado correctamente" +
                "de lo contrario, el LEXER FUE GENERARO CON ERRORES");
        // INICA LEXER
        System.out.println("Creando lexer...");
        LexerGenerator lexerGenerator = new LexerGenerator();
        //System.out.println(lexerGenerator.automataRegexGenerator("(abcd)?(abdd)*"));
        lexerGenerator.genarate(arreglodeDeLineas);
        String texto = lexerGenerator.textoFinal;
        System.out.println("Archivo generado!");


        try {
            Writer output;
            output = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\Pruebas\\Lexer.java"));  //clears file every time
            output.append(texto);
            output.close();
        }catch (IOException e)
        {            //exception handling left as an exercise for the reader
        }


    }
}
