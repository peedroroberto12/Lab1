package _ADLLGenerics;

public class Node<T extends Comparable<T>>{
	private T data;
	private	Node<T> left, right;
	
	public	Node() {
		this(null, null, null);
	}
	
	public Node(T data, Node<T> left, Node<T> right){
			this.data = data;
			this.left = left;
			this.right = right;
	};

	public T getData() { return data;};
	public Node<T> getLeft(){ return left;};
	public Node<T> getRight(){ return right;};
	public void setData(T data) { this.data = data;};
	public void setLeft(Node<T> left){ this.left = left; };
	public void setRight(Node<T> right){ this.right = right; };
}
