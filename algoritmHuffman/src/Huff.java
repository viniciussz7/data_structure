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

    private PriorityQueue<Node> frequencies(char[] caracteres) {
        Map<Character, Node> count = new HashMap<>();
        for (char c : caracteres) {
            if (!count.containsKey(c)) {
                count.put(c, new Node(c));
            }
            count.get(c).incrementFrequency();
        }
        return new PriorityQueue<>(count.values());
    }

    private Node createTree(PriorityQueue<Node> nodes) {
        while (true) {
            Node no1 = nodes.poll();
            Node no2 = nodes.poll();

            Node pai = new Node(no1, no2);

            if (nodes.isEmpty()) {
                return pai;
            }

            nodes.add(pai);
        }
    }

    private Map<Character, String> createCodeMap() {
        Map<Character, String> resultado = new TreeMap<>();
        root.buildCodeMap(resultado, "");
        return resultado;
    }

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
