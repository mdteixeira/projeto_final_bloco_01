package performanceGoal;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	static Scanner sc = new Scanner(System.in);
	static String urlRepo = "https://github.com/mdteixeira/projeto_final_bloco_01";

	public static void main(String[] args) {

		int operacao = 0;

		while (true) {

			System.out.println("*********************************************");
			System.out.println("\t\tLoja de Roupas");
			System.out.println("*********************************************");
			System.out.println("");
			System.out.println("\t1 - Criar Item");
			System.out.println("\t2 - Listar todos os Itens");
			System.out.println("\t3 - Buscar item por ID");
			System.out.println("\t4 - Atualizar Dados de item");
			System.out.println("\t5 - Apagar Item");
			System.out.println("\t6 - Adionar item ao carrinho");
			System.out.println("\t7 - Remover do carrinho");
			System.out.println("\t0 - Sair");
			System.out.println("");
			System.out.println("*********************************************");
			System.out.println("\n*** Entre com a opção desejada:");
			System.out.print("\n >>> ");

			try {
				operacao = sc.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("\tDigite valores inteiros.");
				sc.nextLine();
				operacao = 0;
			}

			switch (operacao) {
			case 1 -> {
				System.out.println("Opção 1 > Criar item");
			}
			case 2 -> {
				System.out.println("Opção 2 > Listar todos os itens");
			}
			case 3 -> {
				System.out.println("Opção 3 > Buscar item por ID");
			}
			case 4 -> {
				System.out.println("Opção 4 > Atualizar dados do item");
			}
			case 5 -> {
				System.out.println("Opção 1 > Apagar item");
			}
			case 6 -> {
				System.out.println("Opção 1 > Adicionar item ao carrinho");
			}
			case 7 -> {
				System.out.println("Opção 1 > Remover do carrinho");
			}
			case 0 -> Finalizar();

			default -> {
				System.err.println("Erro: Operação inválida!");
				keyPress();
			}
			}

		}
	}

	private static void Finalizar() {
		System.out.println("\nOpção 9 - Sair\n");

		System.out.println("*********************************************");
		System.out.println("");
		System.out.println("\t\tLoja de Roupas");
		System.out.println("");
		System.out.println("*********************************************");
		Sobre();
		sc.close();
		System.exit(0);

	}

	private static void Sobre() {
		System.out.println("\n" + "*********************************************");
		System.out.println("\nProjeto desenvolvido por Matheus Teixeira");
		System.out.println("\nCódigo disponível em: \n" + urlRepo);
		System.out.println("*********************************************");

	}

	public static void keyPress() {

		try {

			System.out.println("\n\nPressione a tecla Enter para continuar");
			System.in.read();

		} catch (IOException e) {
			System.err.println("Erro: Você pressionou uma tecla inválida!");
		}
	}

}
