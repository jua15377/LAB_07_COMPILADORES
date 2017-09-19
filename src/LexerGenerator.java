import java.util.ArrayList;

public class LexerGenerator {
    public LexerGenerator(){

    }
    public void genarate(ArrayList<String> linesArray){
        String cojunto = "";
        for (String linea: linesArray) {
            // si no es una linea en blanco
            if (!linea.equals("")) {
                //si es una linea de comentario
                if (linea.charAt(0) == '/' && linea.charAt(1) == '/') {
                    System.out.println("Se encontro una linea con comentada\nComentario: ");
                    System.out.print(linea.replace("/", ""));
                    continue;
                }
                String[] lineaseparada = linea.split(" ");
                if(lineaseparada.length == 1){
                    switch (lineaseparada[0]){
                        case "CHARACTERS":
                            cojunto = "CHARACTERS";
                            break;
                        case "KEYWORDS":
                            cojunto = "KEYWORDS";
                            break;
                        case "IGNORE":
                            cojunto = "IGNORE";
                            break;
                        default:
                            continue;
                    }
                }
                //debe
                //System.out.println(lineaseparada.length);
                else if (lineaseparada.length == 3){
                    //System.out.println(lineaseparada[0]);
                    //System.out.println(lineaseparada[1]);
                    //System.out.println(lineaseparada[2]);
                    if (cojunto == "KEYWORDS"){

                    }
                    else if (cojunto == "CHARACTERS"){

                    }
                }
            }
        }
    }
    public String clearEndLine(String s){
        System.out.println(s);
        s.charAt(s.length()-1);
        String nuevaString = s.substring(0, s.length()-1);
        System.out.println(nuevaString);
        return nuevaString;

    }
}
