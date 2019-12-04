public class Arvore {

	private static class Node {
		private Integer key; 
		private Node father, left, right;
		private boolean color; //false = preto	
							  //true = vermelho
		
		public Node(int n, boolean color) {
			this.key = n;
			this.color = color;
			this.father = this.left = this.right = Arvore.nil;
		}

		// Busca o nó que será o pai do proximo nó a ser inserido
		private Node encontra(int n) {
			if (n < this.key && this.left != Arvore.nil) return this.left.encontra(n);
			else if (n > this.key && this.right != Arvore.nil) return this.right.encontra(n);
			else return this;
		}
	}	

	public Node root;
	public static Node nil = new Node(0, false);
	public int count;

	public Arvore() {
		root = Arvore.nil;
	}

	public Arvore(int key) {
		root = new Node(key, false);
	}

	private void rotacao_esq(Node n) {
		Node aux = n.right;
		n.right = aux.left;
		if (aux.left != Arvore.nil) {
			aux.left.father = n;
		}
		aux.father = n.father;
		if (n.father == Arvore.nil){
			root = aux;
		}	
		else if (n == n.father.left){
			n.father.left = aux;
		}
		else{
			n.father.right = aux;
		}
		aux.left = n;
		n.father = aux;
	}

	private void rotacao_dir(Node n) {
		Node aux = n.left;
		n.left = aux.right;
		if (aux.right != Arvore.nil){
			aux.right.father = n;
		}
		aux.father = n.father;
		if (n.father == Arvore.nil){
			root = aux;
		}
		else if (n == n.father.left){
			n.father.left = aux;
		}
		else{
			n.father.right = aux;
		}
		aux.right = n;
		n.father = aux;
	}

	public void add(Integer n) { //Notação O(log n)
		if (root == Arvore.nil) {
			root = new Node(n, false);
		} else {
			Node aux = encontra(n);
			if (n < aux.key) {
				aux.left = new Node(n, true);
				aux.left.father = aux;
				fix(aux.left);
			} else if (n > aux.key) {
				aux.right = new Node(n, true);
				aux.right.father = aux;
				fix(aux.right);
			}
		}	
		count++;
	}

	private void fix(Node n) {
		Node aux;
		while (n.father.color) {
			if (n.father == n.father.father.left) {
				aux = n.father.father.right;
				if (aux.color) {
					n.father.color = false;
					aux.color = false;
					n.father.father.color = true;
					n = n.father.father;
				} else {
					if (n == n.father.right) {
						n = n.father;
						rotacao_esq(n);
					}
					n.father.color = false;
					n.father.father.color = true;
					rotacao_dir(n.father.father);
				}
			} else {
				aux = n.father.father.left;
				if (aux.color) {
					aux.color = n.father.color = false;
					n.father.father.color = true;
					n = n.father.father;
				} else {
					if (n == n.father.left) {
						n = n.father;
						rotacao_dir(n);
					}
					n.father.color = false;
					n.father.father.color = true;
					rotacao_esq(n.father.father);
				}
			}
		}
		root.color = false;
	}

	public Node encontra(int n) {
		return root.encontra(n);
	}

	public void print() {
		print(root);
		System.out.print("\n");
	}

	private void print(Node n) {
		if (n != null) {
			String key = (n.key == 0) ? "nil" : n.key + "";
			System.out.print(key + "[" + color(n.color) + "] --> ");
			print(n.left);
			print(n.right);
		}
	}

	String color(boolean flag) {
		return (flag) ? "RED" : "BLACK";
	}

	public boolean isEmpty() { //Notação O(1)
            if(root == null) return true;
            else return false;
        }

        public int size() { //Notação O(1)
            return count;
        }

        public boolean contains(int e) { //Notação O (n)
            Node aux = encontra(e);
            if(aux.key == e) return true;
			else return false;
        }

        public Integer get(int e) { //Notação O (n)
            if(contains(e)) return e; 
            else return null;
        }

        public Integer getParent(Integer e) { //Notação O (log n)
            Node n = encontra(e);
			if(!contains(e)) return null;
			if(e == root.key) return null;
            if(n == null) return null;
			else if (n.father != null) return n.father.key; 
			return null;
        }

        public int height() { //Notação O(log n)
			 int h;
             if(root == null) h = -1;
			 else h=heightAux(root) -1;
        	 return h;
        }

        private int heightAux(Node aux) { //Notação O(log n)
			int hAux = 1;
            int hAuxL = 0;
            int hAuxR = 0;
            
            if(aux.left != null) hAuxL = heightAux(aux.left);
            if(aux.right != null) hAuxR = heightAux(aux.right);
            if(hAuxL > hAuxR) hAux += hAuxL;
            else hAux += hAuxR;

			return hAux;
        }

        public LinkedListOfInteger positionsPre() { //Notação O(n)
            LinkedListOfInteger r = new LinkedListOfInteger();
            positionsPreAux(root, r);
            return r;
        }

        private void positionsPreAux(Node n, LinkedListOfInteger r) { //Notação O(n)
            if(n != null) {
                r.add(n.key);
                positionsPreAux(n.left, r);
                positionsPreAux(n.right, r);
            }
        }
        
        public LinkedListOfInteger positionsPos() { //Notação O(n)
            LinkedListOfInteger r = new LinkedListOfInteger();
            positionsPosAux(root, r);
            return r;
        }

        private void positionsPosAux(Node n, LinkedListOfInteger r) { //Notação O(n)
            if(n != null) {
                positionsPosAux(n.left, r);
                positionsPosAux(n.right, r);
                r.add(n.key);
            }
        }

        public LinkedListOfInteger positionsCentral() { //Notação O(n)
            LinkedListOfInteger r = new LinkedListOfInteger();
            positionsCentralAux(root, r);
            return r;
        }

        private void positionsCentralAux(Node n, LinkedListOfInteger r) { //Notação O(n)
            if(n != null) {
                positionsCentralAux(n.left, r);
                r.add(n.key);
                positionsCentralAux(n.right, r);
            }
        }

        public LinkedListOfInteger positionsWidth() { //Notação O(n)
			LinkedListOfInteger res = new LinkedListOfInteger();
			Queue<Node> q = new Queue<>();
			if(root!=null) {
				q.enqueue(root);
				while(q.size() > 0) {
					Node n = q.dequeue();
					res.add(n.key);
					if(n.left != null) q.enqueue(n.left);
					if(n.right != null) q.enqueue(n.right);
				}
			}
			return res;
        }

        public Arvore clone() {
			Arvore a = new Arvore();
			clone(root, a);
			return a;
		}

		private void clone(Node n, Arvore a) {		
			if(n == null) return;

			else if(n.left == null && n.right == null){
				a.add(n.key);
			} 

			else{
				a.add(n.key);
				if(n.left != null){
					clone(n.left,a);
				}
				if(n.right != null){
					clone(n.right,a);
				}
			}
		}
}