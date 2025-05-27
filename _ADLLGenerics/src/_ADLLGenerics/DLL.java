package _ADLLGenerics;

//Classe DLL<T>: encarregada de manipular a estrutura de dados
//lista duplamente ligada ordenada e circular genérica.
//
//Autor1: Ivan Carlos Alcântara de Oliveira.
//Data da Criação: 10/10/2024. 15h.
public class DLL<T extends Comparable<T>> {
	private	Node<T> head;
	private int size;
	
	// DLL(): Construtor vazio
	// inicia o cabeça da lista como null e tamanho = 0
	public DLL(){
		this.head = null;
		this.size = 0;
	}
	// isEmpty(): verifica se a lista está vazia, retornando "true" se vazia
	// "false" se não vazia.
	public boolean isEmpty() { // Verifica se DLL está vazia
		return head == null;
	}
	// isFull(): verifica se a lista está cheia, retornando "true" se cheia
	// "false" se não cheia.
	public boolean isFull() {
		Node<T> aux = new Node<T>();
		return aux == null;
	}
	// getSize(): retorna o tamanho da lista (total de elementos armazenados).
	public int getSize() { return size; }
	// getHead(): retorna o Node cabeça de lista.
	public Node<T> getHead() { return head; }
	// Percorre a DLL em ordem crescente 
	// e mostra os seus valores
	public void showAscending(){
		// Percorre a lista e imprime os valores
		// em ordem Crescente
		if (isEmpty()) System.out.print( "Lista vazia!\n");
		else{
			System.out.print( "Lista: [ ");
			Node<T> pAnda = this.head;
			while (pAnda.getRight() != this.head){
				System.out.print( pAnda.getData() + " ");
				pAnda= pAnda.getRight();
			}
			System.out.print( pAnda.getData() +"]");
		}
	}
	// Percorre a DLL em ordem decrescente e mostra os seus valores
	public void showDescending(){
		// Percorre a lista e imprime os valores
		// em ordem decrescente
		if (isEmpty()) System.out.print( "Lista vazia!\n" );
		else{
			System.out.print( "Lista: [ " );
			Node<T> pAnda = this.head;
			while (pAnda.getLeft() != this.head){
				pAnda= pAnda.getLeft();
				System.out.print( pAnda.getData() + " " );
			}
			System.out.print( pAnda.getLeft().getData() + "]");
		}
	}    
	// Insere um novo elemento na DLL na ordem
	// crescente
	public boolean insertAscending(T data){
		if (isFull()) return false;
		
		// Cria um novo no
		Node<T> novoNo = new Node<T>(data, null, null);

		// se lista vazia, insere o nó no ponteiro cabeça
		// e faz o nó apontar para ele mesmo
		if (isEmpty()) {
			this.head = novoNo;
			novoNo.setRight(novoNo);
			novoNo.setLeft(novoNo);
		} else { 
		    // Caso contrário, procura posição de inserção
		    // na ordem crescente de valores
			Node<T> pAnda = this.head, pAnt = null;
			while (pAnda.getRight() != head && pAnda.getData().compareTo(data) < 0){
					pAnt = pAnda;
					pAnda = pAnda.getRight();
			}	
			// Se não andou na lista e a Key que pAnda aponta
		    // é maior que a Key a ser inserida, significa que a Key
			// a ser inserida é antes do cabeça
			// e cabeça precisa ser redefinido
			if (pAnt == null && pAnda.getData().compareTo(data) > 0){
				novoNo.setLeft(this.head.getLeft());
				this.head.getLeft().setRight(novoNo);
				this.head.setLeft(novoNo);
				novoNo.setRight(this.head);
				this.head = novoNo;
			} else {
				// Caso pAnda tenha caminhado na lista e
				// a Key que o pAnda aponta é maior do que a Key a ser inserido
				// insere o nó depois do ponteiro anterior pAnt
			 	if (pAnda.getData().compareTo(data) > 0 && pAnt != null) {	 
					pAnt.getRight().setLeft(novoNo);
					novoNo.setRight(pAnda);
					pAnt.setRight(novoNo);
					novoNo.setLeft(pAnt);
				} else {// Senão, insere a Key depois do pAnda
			    	pAnda.getRight().setLeft(novoNo);
					novoNo.setRight(pAnda.getRight());
					pAnda.setRight(novoNo);
					novoNo.setLeft(pAnda);
				}
			}
		}
		this.size++;
		return true;
	}	
	// get(int pos): retorna o "Node" que se encontra na posição "pos" da lista.	
	//   O head está na posição 1. Lista vazia retorna null. Se pos > size retorna null.
	public Node<T> get(int pos){
		if (isEmpty()) return null;
		if (pos <= 0 || pos > size) return null;
		int cont = 1;
		Node<T> pAnda = head;
		while (cont != pos){
			pAnda = pAnda.getRight();
			cont++;
		}
		return pAnda;		
	}
	// clear(): limpa a lista ligada original, deixando-a vazia
	public void clear(){
	    if (isEmpty()) {
	        size = 0;
	        head = null;
	        return;
	    }
	    Node<T> pAnt, pAnda = head;
	    int total = size;
	    int cont = 0;
	    while(cont != total){
	        pAnt = pAnda;
	        pAnda = pAnda.getRight();
	        pAnt.setRight(null);
	        pAnt.setLeft(null);
	        pAnt = null;
	        cont++;
	    }
	    size = 0;
	    head = null;
	}
	// search(T Data): procura pelo data em ordem crescente no nó e retorna 
	// a posição onde foi enconradoo ou -1 se não encontrou
	public int searchAscending(T data){
		// Lista vazia
		if (isEmpty()) return -1;
		
		// Procura o elemento 
		Node<T> pAnda = this.head;
		int pos = 1;
		while (pAnda.getRight() != this.head && pAnda.getData().compareTo(data) != 0){
			pAnda = pAnda.getRight();
			pos++;
		}
		
		if (pAnda.getRight() == this.head && pAnda.getData().compareTo(data) != 0){// elemento não encontrado
			return -1;
		} else { // elemento encontrado
			return pos;
		}
	}
	// remove(T data): Remove um elemento da DLL
	// retornando verdadeiro ou falso
	public boolean remove(T data) {
		// Lista vazia
		if (isEmpty()) return false;
		
		// Procura o elemento a ser removido
		Node<T> pAnda = this.head, pAnt = null;
		while (pAnda.getRight() != this.head && pAnda.getData().compareTo(data) != 0){
			pAnt = pAnda;
			pAnda = pAnda.getRight();
		}
		
		if (pAnda.getRight() == this.head && pAnda.getData().compareTo(data) != 0){// elemento não encontrado
			return false;
		} else {
			// elemento encontrado no cabeça
			if (pAnt == null && pAnda.getData().compareTo(data) == 0){
				pAnda.getLeft().setRight(pAnda.getRight());
				this.head = this.head.getRight();
				this.head.setLeft(pAnda.getLeft());
				pAnda.setLeft(null);
				pAnda.setRight(null);
			} else { // elemento encontra-se no meio da lista
			    pAnt.setRight(pAnda.getRight());
			    pAnda.getRight().setLeft(pAnt);
			    pAnda.setLeft(null);
			    pAnda.setRight(null);
			}
			pAnda = null;
			this.size--;
			return true;
		}
	}
	
	// removePos(int pos): Remove e retorna um elemento da DLL na posição pos
	public Node<T> remove(int pos) {
		// Lista vazia
		if (isEmpty()) return null;
		if (pos <= 0 || pos > size) return null;
		
		// Procura o elemento a ser removido
		Node<T> pAnda = this.head, pAnt = null;
		int cont = 1;
		while (pAnda.getRight() != this.head && cont != pos){
			pAnt = pAnda;
			pAnda = pAnda.getRight();
			cont++;
		}
		
		if (pAnda.getRight() == this.head && cont != pos){// elemento não encontrado
			return null;
		} else {
			// elemento encontrado no cabeça
			if (cont == 1){
				pAnda.getLeft().setRight(pAnda.getRight());
				this.head = this.head.getRight();
				this.head.setLeft(pAnda.getLeft());
				pAnda.setLeft(null);
				pAnda.setRight(null);
			} else { // elemento encontra-se no meio da lista
			    pAnt.setRight(pAnda.getRight());
			    pAnda.getRight().setLeft(pAnt);
			    pAnda.setLeft(null);
			    pAnda.setRight(null);
			}
			this.size--;
			return pAnda;
		}
	}

	// questao 7 Fazer um método da classe DLL (versão 1 e 2) que inverte o conteúdo da lista duplamente
    //encadeada ordenada e circular. Protótipo: public void inverte()

	public void inverte() {
		if (isEmpty()) return; // Lista vazia não tem o que inverter
		
		Node<T> pAnda = head;
		Node<T> temp = null;
		
		// Inverte os ponteiros de cada nó
		do {
			temp = pAnda.getLeft();
			pAnda.setLeft(pAnda.getRight());
			pAnda.setRight(temp);
			pAnda = pAnda.getLeft(); // Avança para o próximo nó
		} while (pAnda != head);
		
		// Ajusta o ponteiro cabeça
		head = head.getLeft();
	}

	//questao 10 Fazer um método da classe DLL que concatena uma outra DLL (versão 1 e 2) no final da lista
	//ligada da classe DLL original. Protótipo: public void concatena(DLL<T> lista).
	//Fazer um programa main para testes

	public void concat(DLL<T> lista){
	    if (lista == null || lista.isEmpty()) return; // Nada para concatenar
	    if (this.isEmpty()) {
	        // Se a lista original está vazia, apenas copia a referência
	        this.head = lista.head;
	        this.size = lista.size;
	        return;
	    }
	    // Liga o último nó da lista original ao primeiro nó da lista a ser concatenada
	    Node<T> tail1 = this.head.getLeft(); // Último nó da lista original
	    Node<T> head2 = lista.head;          // Primeiro nó da lista a ser concatenada
	    Node<T> tail2 = lista.head.getLeft();// Último nó da lista a ser concatenada

	    // Ajusta os ponteiros para unir as listas
	    tail1.setRight(head2);
	    head2.setLeft(tail1);

	    tail2.setRight(this.head);
	    this.head.setLeft(tail2);

	    this.size += lista.size;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		int qtde = 0;
		sb.append("\n[Lista]\n");
	
	    sb.append("L: [ ");
	    Node<T> pAnda = head;
	    while (qtde != size) {
	      sb.append(pAnda.getData());
	      qtde++;
	      pAnda = pAnda.getRight();
	    }
	    sb.append("]\n");
	    sb.append("Qtde.: " + size);    
	    return sb.toString();
	}

	//questao 14:
	//merge
	//Fazer um método da classe DLL que recebe uma outra DLL (versão 1 e 2) e
	//realiza o merge das duas listas, mantendo a ordem crescente dos elementos.

	public void merge(DLL<T> lista) {
		if (lista == null || lista.isEmpty()) return; // Nada para mesclar
		
		if (this.isEmpty()) {
			this.head = lista.head;
			this.size = lista.size;
			return;
		}
		
		Node<T> pAnda1 = this.head;
		Node<T> pAnda2 = lista.head;
		DLL<T> mergedList = new DLL<>();
		
		while (pAnda1.getRight() != this.head && pAnda2.getRight() != lista.head) {
			if (pAnda1.getData().compareTo(pAnda2.getData()) <= 0) {
				mergedList.insertAscending(pAnda1.getData());
				pAnda1 = pAnda1.getRight();
			} else {
				mergedList.insertAscending(pAnda2.getData());
				pAnda2 = pAnda2.getRight();
			}
		}
		
		while (pAnda1.getRight() != this.head) {
			mergedList.insertAscending(pAnda1.getData());
			pAnda1 = pAnda1.getRight();
		}
		
		while (pAnda2.getRight() != lista.head) {
			mergedList.insertAscending(pAnda2.getData());
			pAnda2 = pAnda2.getRight();
		}
		
		this.head = mergedList.head;
		this.size = mergedList.size;
	}
	
	//questao 17
	 //Fazer um método que remove da lista DLL (versão 1 e 2) todos os Nodes que estão nas
	//posições pares ou ímpares. Um parâmetro “int tipo” indica a forma de remoção, sendo 1 para
	//ímpar e 2 para par. Protótipo: public void remove(int tipo)
	public void remove2(int tipo) {
		if (isEmpty() || (tipo != 1 && tipo != 2)) return; // Lista vazia ou tipo inválido
		
		Node<T> pAnda = this.head;
		int pos = 1;
		
		while (pAnda.getRight() != this.head) {
			if ((tipo == 1 && pos % 2 != 0) || (tipo == 2 && pos % 2 == 0)) {
				Node<T> toRemove = pAnda;
				pAnda = pAnda.getRight();
				remove(toRemove.getData());
			} else {
				pAnda = pAnda.getRight();
			}
			pos++;
		}
		
		// Verifica o último elemento
		if ((tipo == 1 && pos % 2 != 0) || (tipo == 2 && pos % 2 == 0)) {
			remove(pAnda.getData());
		}
	}

	//Fazer um método que atualiza o conteúdo (dado) de um Node da lista DLL (versão 1 e 2) que
	//se encontra em uma posição fornecida como parâmetro. Retorna verdadeiro se atualização
	//realizada ou falso, caso contrário. Protótipo: public boolean atualiza(int pos, T data).
	public boolean atualiza(int pos, T data) {
		if (isEmpty() || pos <= 0 || pos > size) return false; // Lista vazia ou posição inválida
		
		Node<T> pAnda = this.head;
		int cont = 1;
		
		while (cont < pos) {
			pAnda = pAnda.getRight();
			cont++;
		}
		
		pAnda.setData(data); // Atualiza o dado do Node
		return true; // Atualização realizada com sucesso
	}


	
	// main(): Método de teste da classe DLL
	public static void main(String[] args) {
	
	}

}
