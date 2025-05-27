package _ALinkedListGenerics;

public class _ALinkedListGenerics {
	public static final int SIZE = 7;
	public static void main(String[] args) {	
		LinkedList<Integer> lista1 = new LinkedList<Integer>();
		LinkedList<Integer> lista2 = new LinkedList<Integer>();

		// Preenchendo lista1
		lista1.insertTail(1);
		lista1.insertTail(3);
		lista1.insertTail(5);

		// Preenchendo lista2
		lista2.insertTail(2);
		lista2.insertTail(4);
		lista2.insertTail(6);
		lista2.insertTail(8);

		System.out.println("Lista 1 antes do merge:");
		System.out.println(lista1);

		System.out.println("Lista 2:");
		System.out.println(lista2);

		// Testando o merge
		lista1.merge(lista2);

		System.out.println("Lista 1 após o merge:");
		System.out.println(lista1);
	}
}
