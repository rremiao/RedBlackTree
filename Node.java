public class Node {
	public Integer key; 
	public Node father, left, right;
	public boolean color; 
	
	public Node(int n, boolean color) {
		this.key = n;
		this.color = color;
		this.father = this.left = this.right = Arvore.nil;
	}

	// Busca o nó que será o pai do proximo nó a ser inserido
	public Node encontra(int n) {
		if (n < this.key && this.left != Arvore.nil) return this.left.encontra(n);
		else if (n > this.key && this.right != Arvore.nil) return this.right.encontra(n);
		else return this;
	}

	// Busca o menor valor da árvore
	public Node minimo() {
		if (this.left != Arvore.nil) return left.minimo();
		else return this;
	}
	
	public Node sucessor(){
		if (this.right != Arvore.nil) return this.right.minimo();
		else return this;
	}

}