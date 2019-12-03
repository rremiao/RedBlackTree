public class App {

	public static void main(String[] args) {
		Arvore arv = new Arvore();

		arv.add(10);
		arv.add(20);
		arv.add(12);
		arv.add(25);
		arv.add(26);
		arv.add(9);
		arv.add(27);
		
		System.out.println("Árvore impressa: ");
		arv.print();
		
		System.out.println("Altura: "+arv.height());
		System.out.println("Tamanho:"+arv.size());


		System.out.println("\n");
		System.out.println("Posicionamentos: ");
		System.out.println("\n");
		
		System.out.println("Posicionamento Pré-Fixado: "+arv.positionsPre());
		System.out.println("Posicionamento Pós-Fixado: "+arv.positionsPos());
		System.out.println("Posicionamento Central: "+arv.positionsCentral());
		System.out.println("Posicionamento em Largura: "+arv.positionsWidth());
		
		System.out.println("\n");
		System.out.println("Clone na ordem errada: ");
		Arvore a = new Arvore();
		a = arv.clone(); // Imprime Errado
		a.print();
		System.out.println("\n");
	}
}