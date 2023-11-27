package performanceGoal;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import performanceGoal.controller.RoupasController;
import performanceGoal.model.Calcas;
import performanceGoal.model.Camisas;
import performanceGoal.model.Roupa;

public class Menu {

	static Scanner sc = new Scanner(System.in);
	static String urlRepo = "https://github.com/mdteixeira/projeto_final_bloco_01";
	static RoupasController roupas = new RoupasController();

	public static void main(String[] args) {

		int operacao = 0;

		String tecido, cor, estampa, corte;
		char tamanho, mangaLonga;
		int quantidade, tipo;
		float preco;
		boolean isMangaLonga, isShorts;

		// Testes
		Roupa camisateste = new Camisas(roupas.gerarId(), "algodão", "Cinza", 'P', 32, 45.90f, true, "Floral");
		Roupa calcateste = new Calcas(roupas.gerarId(), "jeans", "preta", 'P', 32, 119.90f, "Skinny", false);

		roupas.cadastrar(camisateste);
		roupas.cadastrar(calcateste);
		///////

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
			System.out.println("\t6 - Saída de estoque");
			System.out.println("\t7 - Entrada de estoque");
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

				System.out.println("Digite o tecido da peça: ");
				sc.skip("\\R");
				tecido = sc.nextLine();
				System.out.println("Digite a cor da peça: ");
				cor = sc.nextLine();
				System.out.println("Digite o tamanho da peça: ");
				tamanho = sc.next().charAt(0);
				System.out.println("Digite a quantidade em estoque da peça: ");
				quantidade = sc.nextInt();
				System.out.println("Digite o preço unitário da peça: ");
				preco = sc.nextFloat();
				System.out.println("Digite o tipo da peça: (1 - camisa / 2 - calça");
				tipo = sc.nextInt();

				switch (tipo) {
				case 1 -> {
					System.out.println("Manga longa: (S - sim / N - não");
					mangaLonga = sc.next().charAt(0);

					switch (mangaLonga) {
					case 's', 'S' -> isMangaLonga = true;
					case 'n', 'N' -> isMangaLonga = false;
					default -> isMangaLonga = false;
					}

					System.out.println("Digite a estampa da camisa: ");
					sc.skip("\\R");
					estampa = sc.nextLine();

					roupas.cadastrar(new Camisas(roupas.gerarId(), tecido, cor, tamanho, quantidade, preco,
							isMangaLonga, estampa));
					keyPress();
				}
				case 2 -> {
					System.out.println("Shorts: (S - sim / N - não");
					var shorts = sc.next().charAt(0);

					switch (shorts) {
					case 's', 'S' -> isShorts = true;
					case 'n', 'N' -> isShorts = false;
					default -> isShorts = false;
					}

					System.out.println("Digite o corte da calça: ");
					sc.skip("\\R");
					corte = sc.nextLine();

					roupas.cadastrar(
							new Calcas(roupas.gerarId(), tecido, cor, tamanho, quantidade, preco, corte, isShorts));
					keyPress();
				}
				}
			}
			case 2 -> {
				System.out.println("Opção 2 > Listar todos os itens");
				roupas.listarTodas();
			}
			case 3 -> {
				System.out.println("Opção 3 > Buscar item por ID");
				System.out.println("Qual Id deseja procurar? > ");
				int procurarId = sc.nextInt();
				roupas.procurarPorId(procurarId);
			}

			case 4 -> {
				System.out.println("Opção 4 > Atualizar dados do item");

				System.out.println("Digite o Id da peça: ");
				int Id = sc.nextInt();
				Optional<Roupa> roupa = roupas.buscarNaCollection(Id);

				if (roupa.isPresent()) {

					System.out.println("Digite o tecido da peça: ");
					sc.skip("\\R");
					tecido = sc.nextLine();
					System.out.println("Digite a cor da peça: ");
					cor = sc.nextLine();
					System.out.println("Digite o tamanho da peça: ");
					tamanho = sc.next().charAt(0);
					System.out.println("Digite a quantidade em estoque da peça: ");
					quantidade = sc.nextInt();
					System.out.println("Digite o preço unitário da peça: ");
					preco = sc.nextFloat();

					if (roupa.get() instanceof Camisas) {
						System.out.println("Manga longa: (S - sim / N - não");
						mangaLonga = sc.next().charAt(0);

						switch (mangaLonga) {
						case 's', 'S' -> isMangaLonga = true;
						case 'n', 'N' -> isMangaLonga = false;
						default -> isMangaLonga = false;
						}

						System.out.println("Digite a estampa da camisa: ");
						sc.skip("\\R");
						estampa = sc.nextLine();

						roupas.atualizar(new Camisas(roupa.get().getId(), tecido, cor, tamanho, quantidade, preco,
								isMangaLonga, estampa));
						keyPress();
					} else {
						System.out.println("Shorts: (S - sim / N - não");
						var shorts = sc.next().charAt(0);

						switch (shorts) {
						case 's', 'S' -> isShorts = true;
						case 'n', 'N' -> isShorts = false;
						default -> isShorts = false;
						}

						System.out.println("Digite o corte da calça: ");
						sc.skip("\\R");
						corte = sc.nextLine();

						roupas.atualizar(new Calcas(roupa.get().getId(), tecido, cor, tamanho, quantidade, preco, corte,
								isShorts));
						keyPress();
					}
				} else {
					System.err.println("Erro: A peça de ID " + Id + " não foi encontrada.");
					keyPress();
				}

			}
			case 5 -> {
				System.out.println("Opção 1 > Apagar item");
				System.out.println("Insira o Id do item que deseja deletar > ");
				int deletarId = sc.nextInt();
				roupas.deletar(deletarId);
			}
			case 6 -> {
				System.out.println("Opção 6 > Saída de estoque");
				System.out.println("Insira o Id do item > ");
				int idItem = sc.nextInt();
				System.out.println("Insira a quantidade a ser retirada de estoque > ");
				int quant = sc.nextInt();
				
				roupas.retirarEstoque(idItem, quant);

			}
			case 7 -> {
				System.out.println("Opção 7 > Entrada de estoque");
				System.out.println("Insira o Id do item > ");
				int idItem = sc.nextInt();
				System.out.println("Insira a quantidade a ser adicionada ao estoque > ");
				int quant = sc.nextInt();
				
				roupas.adicionarEstoque(idItem, quant);
				
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
