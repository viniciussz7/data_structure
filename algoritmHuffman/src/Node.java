import java.util.Map;

public class Node implements Comparable<Node> {
    private char simbolo;
    private int countFrequency;
    private Node left;
    private Node right;

    
    public Node(Node left, Node right) {
        this.simbolo = '+';
        this.left = left;
        this.right = right;
    }


    public Node(char simbolo) {
        this.simbolo = simbolo;
    }

    public boolean isFolha() {
        return left == null && right == null;
    }
    
    public char getSimbolo() {
        return simbolo;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
    
    public int getCountFrequency() {
        if (isFolha()) {
            return countFrequency;
        }
        return this.left.getCountFrequency() + this.right.getCountFrequency();
    }

    public void incrementFrequency() {
        countFrequency++;
    }

    public void buildCodeMap(Map<Character, String> codemap, String code) {
        if (isFolha()) {
            codemap.put(getSimbolo(), code);
            return;
        }
        left.buildCodeMap(codemap, code+"0");
        right.buildCodeMap(codemap, code+"1");
    }

    @Override
    public int compareTo(Node no) {
        return getCountFrequency() - no.getCountFrequency();
    }

    @Override
    public String toString() {
        String ch = simbolo == '\n' ? "\\n" : "" + simbolo;
        return String.format("'%s': '%d'", ch, this.countFrequency);
    }

}