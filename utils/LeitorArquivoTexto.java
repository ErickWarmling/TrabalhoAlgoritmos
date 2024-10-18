package utils;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Acadêmico: Erick Augusto Warmling
public class LeitorArquivoTexto {

    public static String[] lerArquivo(String caminho) {
        File arquivo = new File(caminho);
        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
            List<String> embaralhamentos = new ArrayList<>();
            String linha = leitor.readLine();

            while (linha != null) {
                embaralhamentos.add(linha);
                linha = leitor.readLine();
            }

            return embaralhamentos.toArray(new String[embaralhamentos.size()]);

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
