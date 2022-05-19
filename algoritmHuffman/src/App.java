//Aluno: Vinicius de Oliveira Souza
//Ciencia da Computacao - III Semestre
//AED

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {
    public static void main(String[] args) throws Exception {
        Huff applyHuff = new Huff();

        String textoOriginal = "";
        String textoCodificado = "";
        
        String textoHuffman = "";

        BufferedReader leitor = new BufferedReader(new FileReader("data_structure/algoritmHuffman/src/texto.txt"));
        String temp;
        while ((temp = leitor.readLine()) != null) {
            textoOriginal = textoOriginal + temp;
        }
        leitor.close();

        System.out.println("\nTexto original: \n" + textoOriginal);

        textoCodificado = applyHuff.codificar(textoOriginal);

        ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream("data_structure/algoritmHuffman/src/textoHuffman.bin"));
        escritor.writeObject(textoCodificado);
        escritor.close();

        ObjectInputStream leitorBin = new ObjectInputStream(new FileInputStream("data_structure/algoritmHuffman/src/textoHuffman.bin"));
        textoHuffman = leitorBin.readObject().toString();
        leitorBin.close();


        System.out.println("\nTextoCodificado: \n" + textoCodificado);
        System.out.println("\nTexto Decodificado: \n" + applyHuff.decodificar(textoHuffman));

        System.out.println("\n*************Details compression*************");
        System.out.println("Tamanho do texto original em bits: " + textoOriginal.length() * 8);
        System.out.println("Tamanho do texto codificado em bits: " + textoCodificado.length());
        System.out.println("Taxa de compressao: " + (textoCodificado.length()/(double)(textoOriginal.length() * 8))*100 + "%");
        System.out.println("*********************************************");
    }
}
