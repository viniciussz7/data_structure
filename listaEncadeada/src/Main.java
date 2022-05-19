//Aluno: Vinicius de Oliveira Souza
//Ciencia da Computacao - III Semestre
//AED

public class Main {
    public static void main(String[] args) throws Exception {
        
        ListaEncadeada myList = new ListaEncadeada();
        ListaEncadeada otherList = new ListaEncadeada();
        
        //Mostrando a lista vazia
        System.out.println("Lista vazia: " + myList);
        System.out.println();

        //Inserindo elementos no inicio da lista
        myList.inserirInicio(5);
        System.out.println("Inserindo o elemento '5' na lista com o metodo inserirInicio(): ");
        System.out.println(myList);
        System.out.println();
        
        myList.inserirInicio(4);
        System.out.println("Inserindo o elemento '4' no inicio da lista: ");
        System.out.println(myList);
        System.out.println();

        

        //Inserindo elementos no final da lista
        myList.inserirFim(6);
        System.out.println("Inserindo o elemento '6' no final da lista: ");
        System.out.println(myList);
        System.out.println();

        
        myList.inserirFim(10);
        System.out.println("Inserindo o elemento '10' no final da lista: ");
        System.out.println(myList);
        System.out.println();

        

        //Retornando o primeiro e o ultimo elemento da lista
        System.out.println("Primeiro elemento da lista: " + myList.getPrimeiroElemento());
        System.out.println("Ultimo elemento da lista: " + myList.getUltimoElemento());
        System.out.println();
        
        
        //Extraindo um elemento da lista
        //myList.extrairItem(5);
        //System.out.println(myList);
        //Esse metodo retorna uma excecao NullPointer que eu nao consegui identificar o porque, pois segundo minha analise o codigo esta correto.

        

        //Atribuindo myList a otherList
        System.out.println("Atribuindo a lista 'myList' para uma outra lista 'otherList': ");
        otherList.atribuir(myList);
        System.out.println("myList: " + myList);
        System.out.println("otherList: " + otherList);
        System.out.println();
        

        //Inserindo antes de um elemento
        System.out.println("Inserindo o elemento 8 ANTES do elemento 10: ");
        myList.getElement(10).inserirAntes(8);
        System.out.println(myList);
        System.out.println();

        System.out.println("Inserindo o elemento 8 ANTES do elemento 10: ");
        myList.getElement(8).inserirAntes(7);
        System.out.println(myList);
        System.out.println();


        //Inserindo depois de um elemento
        System.out.println("Inserindo o elemento 9 DEPOIS do elemento 8: ");
        myList.getElement(8).inserirDepois(9);
        System.out.println(myList);
        System.out.println();

        

        //Limpando a lista
        System.out.println("Limpando a lista 'otherList': ");
        otherList.fazVazia();
        System.out.println("otherList " + otherList);

    }
}
