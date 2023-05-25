package Arquivos;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {

    public void escrever(String texto, String nomeArquivo) throws IOException {
        File arquivo = new File(System.getProperty("C:\\Users\\SAMSUNG\\Documents\\Reprografia\\SoftwareDeRelatoriosReprografia\\src\\Arquivos") + "/" + nomeArquivo);
        
        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }
        FileWriter writer = new FileWriter(arquivo);
        writer.write(texto);
        writer.close();
    }
    
        public String ler(String nomeArquivo) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("C:\\Users\\SAMSUNG\\Documents\\Reprografia\\SoftwareDeRelatoriosReprografia\\src\\Arquivos") + "\\" + nomeArquivo));
        StringBuilder sb = new StringBuilder();
        String line = reader.readLine();
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = reader.readLine();
        }
        reader.close();
        return sb.toString();
    }
}
