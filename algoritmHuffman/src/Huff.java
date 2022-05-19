import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Huff {
    private Node root;

    private char[] getChars(String texto) {
        char [] caracteres = new char[texto.length()];
        texto.getChars(0, texto.length(), caracteres, 0);
        return caracteres;
    }

    //PASSO 1
    //metooo para montar a tabela de frequencias ds simbolos
    private PriorityQueue<Node> frequencies(char[] caracteres) {
        Map<Character, Node> count = new HashMap<>();
        for (char c : caracteres) {
            if (!count.containsKey(c)) { //se nao contem o simbolo, add
                count.put(c, new Node(c));
            }
            count.get(c).incrementFrequency(); //se o simbolo apareceu novamente eu incremento 1 em sua frequencia
        }
        return new PriorityQueue<>(count.values()); //retorna a fila priorizada em ordem crescente de frequencia
    }

    //PASSO 2
    //metodo para criar a arvore binaria de acordo com as frequencias
    private Node createTree(PriorityQueue<Node> nodes) {
        while (true) {
            //retira os dois nos de menor frequencia
            Node no1 = nodes.poll();
            Node no2 = nodes.poll();

            //agrupa os dois em um no pai
            Node pai = new Node(no1, no2);

            if (nodes.isEmpty()) {
                return pai;
            }

            //add no pai na lista (de forma ordenada)
            nodes.add(pai);
        }
    }

    //PASSO 3 PARA O NO RAIZ
    private Map<Character, String> createCodeMap() {
        Map<Character, String> resultado = new TreeMap<>();
        root.buildCodeMap(resultado, "");
        return resultado;
    }

    //PASSO 4
    //metodo para codificar o texto, chama todos os outros metodos e vai concatenando as sequencias geradas
    public String codificar(String texto) {
        char [] caracteres = getChars(texto);
        root = createTree(frequencies(caracteres));
        Map<Character, String> codemap = createCodeMap();

        StringBuilder dados = new StringBuilder();
        for (char c : caracteres) {
            dados.append(codemap.get(c));
        }
        return dados.toString();
    }

    //metodo para decodificar percorrendo a sequencia ate o no folha e concatenando os simboblos
    public String decodificar(String dados) {
        Node current = root;

        StringBuilder texto = new StringBuilder();
        for (char ch : getChars(dados)) {
            if (ch == '0') {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }

            if (current.isFolha()) {
                texto.append(current.getSimbolo());
                current = root;
            }
        }
        return texto.toString();
    }

}
