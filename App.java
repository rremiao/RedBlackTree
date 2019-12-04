import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		CEP a = new CEP();
		
		//Se passar um número de CEP inválido, o addCEP corrige;
		System.out.println("Digite a quantidade de CEPS que deseja armazenar: ");
		int qtdCep = s.nextInt();
		int novoCep = 0;
		for(int i = 0; i < qtdCep; i++){
			System.out.println("Digite o CEP que deseja armazenar:");
			novoCep = s.nextInt();
			a.addCEP(novoCep);
		}

		System.out.println("-----------------********-----------------");
		System.out.println("Verificando se sua agenda de CEPS esta vazia...");
		System.out.println(a.cepIsEmpty());

		System.out.println("-----------------********-----------------");
		System.out.println("Imprimindo seus CEPS...");
		a.printaCEP();

		System.out.println("-----------------********-----------------");
		System.out.println("Posicionamentos...");
		System.out.println("Posicionamento Pre-Fixado: "+ a.positionsPreCep());
		System.out.println("Posicionamento Pos-Fixado: "+ a.positionsPosCep());
		System.out.println("Posicionamento Central: "+ a.positionsCentralCep());
		System.out.println("Posicionamento em Largura: "+  a.positionsWidthCep());

		System.out.println("-----------------********-----------------");
		System.out.println("Tamanho e Quantidade de ceps...");
		System.out.println("Tamanho da arvore de CEPS: "+ a.cepHeight());
		System.out.println("Quantidade de CEPS: "+ a.cepSize());

		System.out.println("-----------------********-----------------");
		System.out.println("Digite de qual pai deseja descobrir o pai do elemento: ");
		int pai = s.nextInt();
		System.out.println("Pai do elemento desejado: "+ a.getParentCep(pai));
		System.out.println("Digite qual elemento deseja descobrir onde esta: ");
		int elemento = s.nextInt();
		System.out.println("O elemento desejado eh: "+a.getCep(elemento));

		



		System.out.println("-----------------Obrigado-----------------");
	}
}