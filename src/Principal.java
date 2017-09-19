import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;


/**
 * @author Jonnathan Juarez
 * @version 1.0 02/08/2017
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
        //System.out.println(arreglodeDeLineas);
        analizadorSintactico.analizador(arreglodeDeLineas);

        // INICA LEXER
        System.out.println("Crando lexer...");
        LexerGenerator lexerGenerator = new LexerGenerator();

        System.out.println("Archivo generado!");
        ArrayList<String> lista = new ArrayList<>();
        lista.add("if");
        lista.add("while");
        lista.add("for");
        String texto = "def keyword(palabra):\n"+
                "\tlista = " +  lista.toString() +"\n"+
                "\tif palabra in lista:\n"+
                "\t\treturn True,lista[lista.index(palabra)]\n"+
                "\telse:\n"+
                "\t\treturn False,\"\"\n";


        try {
            Writer output;
            output = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\Prueba.py"));  //clears file every time
            output.append(texto);
            output.close();
        }catch (IOException e)
        {            //exception handling left as an exercise for the reader
        }


    }
}
