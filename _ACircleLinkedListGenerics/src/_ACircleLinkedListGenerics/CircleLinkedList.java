package _ACircleLinkedListGenerics;

import java.util.LinkedList;

//Classe CircleLinkedList<T>: encarregada de manipular a estrutura de dados
//lista ligada circular genérica.
//
//Autor1: Ivan Carlos Alcântara de Oliveira.
//Data da Criação: 10/10/2024. 15h.
public class CircleLinkedList<T> {
	private Node<T> head; // ponteiro do cabeça de lista
	private Node<T> tail;  // ponteiro do final da lista
	private int size; // tamanho da lista
	// CircleLinkedList(): construtor da Lista encadeada circular
	public CircleLinkedList() {
		head = tail = null;
		size = 0;
	}
	// getHead(): retorna o "Node" cabeça de lista	
	public Node<T> getHead() {
		return head;
	}
	// getTail(): retorna o "Node" final da lista	
	public Node<T> getTail() {
		return tail;
	}
	// isEmpty(): verifica se a lista está vazia, retornando "true" se vazia
	// "false" se não vazia.
	public boolean isEmpty() {
		return head == null;
	}
	// isFull(): verifica se a lista está cheia, retornando "true" se cheia
	// "false" se não cheia.
	public boolean isFull() {
		Node<T> aux = new Node<T>();
		return aux == null;
	}
	// getSize(): retorna o tamanho da lista (total de elementos armazenados).
	public int getSize() {
		return size;
	}
	// get(int pos): retorna o "Node" que se encontra na posição "pos" da lista.	
	//   O head está na posição 1. Lista vazia retorna null. Se pos > size retorna null.
	public Node<T> get(int pos) {
		if (isEmpty()) return null;
		if (pos <= 0 || pos > size) return null;
		int cont = 1;
		Node<T> pAnda = head;
		while (cont != pos){
			pAnda = pAnda.getProx();
			cont++;
		}
		return pAnda;
	}
	// insertTail(T data): insere o "data" passado como parâmetro no final da 
	// lista (funcionalidade idêntica ao addLast).	
	public boolean insertTail(T data){
		Node<T> aux;
	    if (!isFull()){ // Não há espaço de memória
	      aux = new Node<T>(data, null);
	      if (isEmpty()){ // Lista está vazia insere no cabeça
	    	aux.setProx(head);
	        head = tail = aux;
	      }else { // Insere no final e atualiza os ponteiros
	    	tail.setProx(aux);
	    	aux.setProx(head);
	    	tail = aux;
	      }
	      size++;
		  return true;
	    }
	    else return false; 
	};
	// addFirst(T data): insere o "data" passado como parâmetro no começo da 
	// lista (funcionalidade idêntica ao insertHead).
	public boolean addFirst(T data){
		Node<T> aux;
	    if (!isFull()){
	      aux = new Node<T>(data, null);
	      if (isEmpty()){ // Lista está vazia
			head = tail = aux;
		    aux.setProx(head);
	      }else { // Insere no começo e atualiza os ponteiros
	      	aux.setProx(head);
	      	head = aux;
	      	tail.setProx(head);
	      }
	      size++;
	      return true;
	    }
	    else return false; 
	};
	// addLast(T data): adiciona o "data" passado como parâmetro no final da 
	// lista (funcionalidade idêntica ao insertTail)
	public boolean addLast(T data){
		Node<T> aux;
	    if (!isFull()){ // Não há espaço de memória
	      aux = new Node<T>(data, null);
	      if (isEmpty()){ // Lista está vazia insere no cabeça
	    	aux.setProx(head);
	        head = tail = aux;
	      }else { // Insere no final e atualiza os ponteiros
	    	tail.setProx(aux);
	    	aux.setProx(head);
	    	tail = aux;
	      }
	      size++;
		  return true;
	    }
	    else return false; 
	};
	// insertHead(T data): insere o "data" passado como parâmetro no começo da 
	// lista (funcionalidade idêntica ao addFirst).	
	public boolean insertHead(T data){
		Node<T> aux;
	    if (!isFull()){
	      aux = new Node<T>(data, null);
	      if (isEmpty()){ // Lista está vazia
			head = tail = aux;
		    aux.setProx(head);
	      }else { // Insere no começo e atualiza os ponteiros
	      	aux.setProx(head);
	      	head = aux;
	      	tail.setProx(head);
	      }
	      size++;
	      return true;
	    }
	    else return false; 
	};
	
    // insert(T id, int pos): insere o elemento "id" na posição "pos" passada como parâmetro
	// caso seja uma posição maior que o tamanho da lista, insere no final
	// se posição de inserção for inválida  (<= 0) retorna false
	public boolean insert(T id, int pos) {
		Node<T> aux; // Ponteiro auxiliar para o novo nó a ser inserido
		Node<T> pAnda; // Ponteiro que anda na lista ligada	
		Node<T> pAnt = null;  // Ponteiro anterior ao que anda
		if (pos <= 0) return false; // Se posição inválida, não insere e retorna
	    if (!isFull()){ // se há memória disponível
	      aux = new Node<T>(id, null);
	      if (isEmpty()){ // Insere no começo da lista
	    	  head = tail = aux;
	    	  // Caso a posição a iserir seja a última ou superior, insere no final
	      } else if (pos >= size+1) {
	    		insertTail(id);
	      } else {// a posição a inserir é no meio da lista
	    	// Procura a posição de inserção
	    	int cont = 1;
	        pAnda = head;  // Ponteiro que anda até a posição de inserção 
            // Procura a posição de inserção  
	        while (cont != pos){
	           pAnt = pAnda;
	           pAnda = pAnda.getProx();
	           cont++;
	        }
        	aux.setProx(pAnda);
	        if (cont == 1) { // insere no cabeça de lista
	        	head = aux;
	        	tail.setProx(head);
	        } else { // insere no meio
	        	pAnt.setProx(aux);
	        }
	      }
		  size++;
		  return true; // inserção realizada com sucesso
	    }
	    else return false; 
	};
	// search(T data): procura o elemento "data" dentro da lista
	// se "data" não existir ou lista vazia retorna null
	// caso contrário, retorna o "Node"	
	public Node<T> search(T data){
		Node<T> pAnda;
		
	    if (isEmpty()) {
			return null; // Lista vazia
	    }else{
	      pAnda = head;
	      // procura a posição do elemento na lista
	      while ((pAnda.getProx() != head) && (pAnda.getData().equals(data) != true))
	        pAnda = pAnda.getProx();
	      if (pAnda.getData().equals(data))
	    	  return pAnda; // Retorna a referência para o No 
	      return null; // elemento não encontrado
	    }
	}
	// print(): percorre a lista e imprime todo o seu conteúdo
	public void print(){
		Node<T> pAnda; 
	    if (!isEmpty()) {
	    	pAnda = head;
	    	System.out.print("[ ");
	    	while (pAnda.getProx() != head) {
	    		System.out.println(pAnda.getData()+" ");
	    		pAnda = pAnda.getProx();
	    	}
	    	System.out.println(pAnda.getData()+" ");
	    }
	    System.out.print("], Qtde.: " + size + ".\n");
	}
	// clear(): limpa a lista ligada original, deixando-a vazia
	public void clear(){
		Node<T> pAnt, pAnda = head;
		
		while(pAnda.getProx() != head){
			pAnt = pAnda;  // Libera o nó
			pAnda = pAnda.getProx();
			pAnt.setProx(null);
			pAnt = null;
		}
		size = 0;
		tail = head = null;	
	}
	
	// remove(T data): remove a primeira ocorrência do "data" na lista
	// retorna "true" se remoção com sucesso
	// ou "false" se não foi possível remover, nos casos: o elemento não existe
	// ou a lista está vazia
	public boolean remove(T data){
		Node<T> pAnda; // Ponteiro que anda na lista ligada		
		Node<T> pAnt = null; // Ponteiro anterior ao que anda na lista
	    if (isEmpty()) return false; // Se lista vazia, não é possível remover
	    else{  // caso haja elementos na lista
	      pAnda = head;
	      // procura a posição do elemento na lista
	      int contador = 1;
	      while ((contador != size) && (pAnda.getData().equals(data) != true)){
	        pAnt = pAnda;
	        pAnda = pAnda.getProx();
	        contador++;
	      }
	      if ((contador == size) && (pAnda.getData().equals(data) != true))
	    	  return false; // Se não encontrou o elemento
	      else { // Se elemento foi encontrado 
	      	// se tem somente um elemento na lista
	    	if (size == 1) {
	    		head = tail = null;
	    	   // Verifica se está como cabeça da lista e remove
	    	   // e tem mais de um elemento
	    	} else if ((head == pAnda)) {
			    head = pAnda.getProx();
		        tail.setProx(head);
		    } else { // remove elemento do meio/fim da lista
		    	// Se o elemento estiver no fim
		    	if (pAnda == tail)
		    		tail = pAnt; // Atualiza o fim
		    	pAnt.setProx(pAnda.getProx());
			}
    		pAnda.setProx(null);
	      	pAnda = pAnt = null;
	    	size--;
	      	return true;    // remoção realizado como sucesso
	      }
	    }
	}
	// pollFirst(): remove e retorna o primeiro elemento da lista
	public T pollFirst(){
	    if (isEmpty()) return null; // Se lista vazia, não é possível remover
	    else{  // Remove primeiro elemento da lista e retorna o dado
		  Node<T> pAux = head;
		  if (size == 1) { // caso haja somente um elemento na lista
			  head = tail = null;
		  } else { // há mais de um elemento na lista
			  head = head.getProx();
			  tail.setProx(head);
		  }
    	  size--;
	      return pAux.getData();
	    }
	}	
	// pollLast(): remove e retorna o último elemento da lista
	public T pollLast(){
	    if (isEmpty()) return null; // Se lista vazia, não é possível remover
	    else{  
		  Node<T> pAnda = head, pAnt = null;
	      // procura o elemento final da lista
		  int contador = 1;
	      while ((contador != size)){
	        pAnt = pAnda;
	        pAnda = pAnda.getProx();
	        contador++;
	      }  // Remove o elemento e retorna o dado
	      if (size == 1) {
	    	  head = tail = null;
	      } else {
	    	  tail = pAnt;
	    	  pAnt.setProx(pAnda.getProx());
	      }
    	  size--;
	      return pAnda.getData();
	    }
	}	


	public void invert() {
		if (isEmpty() || size == 1) return;

	    CircleLinkedList<T> laux = new CircleLinkedList<>();
	    Node<T> pAnda = head;
	    int count = 0;
	    while (count < size) {
	        laux.addFirst(pAnda.getData());
	        pAnda = pAnda.getProx();
	        count++;
	    }
	    clear();
	    pAnda = laux.head;
	    count = 0;
	    while (count < laux.size) {
	        this.addLast(pAnda.getData());
	        pAnda = pAnda.getProx();
	        count++;
	    }
	}	

	//questao 6 lista
	// inverte(): inverte a lista circular, ou seja, o primeiro elemento passa a ser o último
		public void inverte() {
		// Lista Ligada Auxiliar
		CircleLinkedList<T> lAux = new CircleLinkedList<T>();
		
		Node<T> pAnda = getHead();  // Ponteiro que anda na lista original
		// Percorre a lista original, remove um elemento e insere no cabeça da lista
		//  auxiliar. Ao final, o conteúdo da lista auxiliar é o inverso da original.
		while (pAnda != null) { 
			lAux.insertHead(pAnda.getData());
			pAnda = pAnda.getProx();
		}
		clear();  // Limpa os nós da lista original
		head = lAux.getHead(); // Atribui a lista auxiliar como sendo a nova original
	}
	

	//questao 9 lista
	// concatena(CircleLinkedList<T> lista): concatena a lista circular
	//  passada como parâmetro ao final da lista circular original
	public void concatena(CircleLinkedList<T> lista) {
		tail.setProx(lista.getHead());
		lista.getTail().setProx(head);
		tail = lista.getTail();
		size +=lista.getSize();
	}
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		int qtde = 0;

	    sb.append("L: [ ");
	    Node<T> pAnda = head;
	    while (qtde != size) {
	      sb.append(pAnda.getData()+" ");
	      qtde++;
	      pAnda = pAnda.getProx();
	    }
	    sb.append("]\n");
	    
	    sb.append("Qtde.: " + size);
	    if (size != 0) {
	    	sb.append("\nPrimeiro: " + head.getData() + 
	    			", Ultimo: " + tail.getData());
	    }
    
	    return sb.toString();
	}

	//questao 13 lista
	// merge(CircleLinkedList<T> lista): mescla duas listas circulares
	public void merge(CircleLinkedList<T> lista){
		Node<T> panda1 = this.getHead();
		Node<T> panda2 = lista.getHead();

		CircleLinkedList<T> laux = new CircleLinkedList<T>();

		int count1 = 0, count2 = 0;
		int size1 = this.getSize();
		int size2 = lista.getSize();

		// Intercala os elementos das duas listas
		while (count1 < size1 && count2 < size2) {
			laux.insertTail(panda1.getData());
			panda1 = panda1.getProx();
			count1++;

			laux.insertTail(panda2.getData());
			panda2 = panda2.getProx();
			count2++;
		}

		// Se ainda restarem elementos na lista 1
		while (count1 < size1) {
			laux.insertTail(panda1.getData());
			panda1 = panda1.getProx();
			count1++;
		}

		// Se ainda restarem elementos na lista 2
		while (count2 < size2) {
			laux.insertTail(panda2.getData());
			panda2 = panda2.getProx();
			count2++;
		}

		clear(); // Limpa a lista original
		head = laux.getHead(); // Atribui a lista auxiliar como sendo a nova original
		tail = laux.getTail();
		size = laux.getSize(); // Atualiza o tamanho da lista original
	}



		public static void main(String[] args) {
    CircleLinkedList<Integer> lista = new CircleLinkedList<>();

    lista.addLast(1);
    lista.addLast(2);
    lista.addLast(3);
    lista.addLast(4);

    System.out.println("Lista original:");
    System.out.println(lista);

    lista.invert();

    System.out.println("Lista invertida:");
    System.out.println(lista);
}

//exerc 16 
//Fazer um método que remove da lista LinkedList todos os Nodes que estão nas posições pares
//ou ímpares. Um parâmetro “int tipo” indica a forma de remoção, sendo 1 para ímpar e 2 para
//par. Protótipo: public void remove(int tipo)

public void remove(int tipo) {
    if (isEmpty() || tipo < 1 || tipo > 2) return;

    int originalSize = size;
    Node<T> pAnda = head;
    Node<T> pAnt = tail;
    int contador = 1;

    for (int i = 0; i < originalSize; i++) {
        Node<T> proximo = pAnda.getProx();
        boolean remover = (tipo == 1 && contador % 2 != 0) || (tipo == 2 && contador % 2 == 0);

        if (remover) {
            if (size == 1) {
                head = tail = null;
            } else if (pAnda == head) {
                head = pAnda.getProx();
                tail.setProx(head);
            } else if (pAnda == tail) {
                tail = pAnt;
                tail.setProx(head);
            } else {
                pAnt.setProx(pAnda.getProx());
            }
            size--;
        } else {
            pAnt = pAnda;
        }
        pAnda = proximo;
        contador++;
    }
}
//Fazer um método que atualiza o conteúdo (dado) de um Node da lista CircleLinkedList que se
//encontra em uma posição fornecida como parâmetro. Retorna verdadeiro se atualização
//realizada ou falso, caso contrário. Protótipo: public boolean atualiza(int pos, T data).

public boolean atualiza(int pos, T data) {
	if (isEmpty() || pos <= 0 || pos > size) return false;

	Node<T> pAnda = head;
	int contador = 1;

	while (contador < pos) {
		pAnda = pAnda.getProx();
		contador++;
	}

	pAnda.setData(data);
	return true;
}

}