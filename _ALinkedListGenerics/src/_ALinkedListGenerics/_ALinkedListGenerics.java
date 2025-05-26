package _ALinkedListGenerics;

public class _ALinkedListGenerics {
	public static final int SIZE = 7;
	public static void main(String[] args) {	
		LinkedList<Integer> lista1 = new LinkedList<Integer>();

		int ids1[] = { 5, 2, 15, 7, 35, 77, 81 };
	           // Insere no final da lista 
		for (int i = 0; i < ids1.length; ++i)
			lista1.insertTail(ids1[i]);
		
		System.out.println(lista1);
		
		lista1.inverte();
		
		System.out.println("Lista Invertida: ");
		
		System.out.println(lista1);	
	
		LinkedList<Integer> lista2 = new LinkedList<Integer>();

		int ids2[] = { 15, 12, 115, 17, 135, 177, 181 };
		
	    // Insere no final da lista 
		for (int j = 0; j < ids2.length; ++j)
			lista2.insertTail(ids2[j]);
		
		System.out.println(lista2);	
	
		lista1.concatena(lista2);
		
		System.out.println("Lista concatenada: ");
			
		System.out.println(lista1);	
			          
	    System.out.println("Res.: " + lista1.search(12).getDado());
	    
	    lista1.remove(12);
        
		System.out.println("Remoção do 12: ");
	    System.out.println(lista1);	

	}
}
