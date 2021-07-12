package digital.innovation.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

public class Inferencia {

    /* Uso da palavra-chave "var"

       - só pode usar para variáveis locais, dá erro de compilação;
       - não deve ser usado como parâmetro;
       - deve usar o var inicializando a variável, se não, dá erro de compilação;
       - pode ser usado no try-with-resources, for iterativo, foreach, while, do-while, etc. escopo de classe, não é possível, como o primeiro item diz.

    */

    public static void main(String[] args) throws IOException {
        conectar();
    }

    private static void conectar() throws IOException {
        var url = new URL("https://docs.oracle.com/javase/10/language/");
        var urlConnection = url.openConnection();
        var bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
    }

}
