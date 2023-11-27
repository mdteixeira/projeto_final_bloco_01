package performanceGoal.controller;

import java.util.ArrayList;
import java.util.Optional;

import performanceGoal.model.Roupa;
import performanceGoal.repository.RoupaRepository;

public class RoupasController implements RoupaRepository {

	// Criar a collection
	private ArrayList<Roupa> listaRoupas = new ArrayList<Roupa>();

	// variavel para receber o ID da peça
	int Id = 0;

	@Override
	public void procurarPorId(int Id) {
		Optional<Roupa> roupa = buscarNaCollection(Id);

		if (roupa.isPresent())
			roupa.get().visualizar();
		else
			System.out.println("Erro: A peça com ID " + Id + " não foi encontrada.");

	}

	@Override
	public void listarTodas() {

		for (Roupa roupa : listaRoupas) {
			roupa.visualizar();
		}

		if (listaRoupas.isEmpty()) {
			System.out.println("Erro: Não há roupas cadastradas.");
		}

	}

	@Override
	public void cadastrar(Roupa roupa) {

		listaRoupas.add(roupa);
		System.out.println("A roupa de ID " + roupa.getId() + " foi cadastrada com sucesso.");

	}

	@Override
	public void atualizar(Roupa roupa) {
		Optional<Roupa> buscaRoupa = buscarNaCollection(Id);

		if (buscaRoupa.isPresent()) {
			listaRoupas.set(listaRoupas.indexOf(buscaRoupa.get()), roupa);
			System.out.println("A roupa de ID " + roupa.getId() + " foi atualizada com êxito.");
		} else
			System.out.println("Erro: A roupa de ID " + roupa.getId() + " não foi encontrada.");

	}

	@Override
	public void deletar(int Id) {

		Optional<Roupa> roupa = buscarNaCollection(Id);

		if (roupa.isPresent()) {
			if (listaRoupas.remove(roupa.get()) == true) {
				System.out.println("A roupa de ID " + Id + " foi deletada com êxito");
			}
		} else
			System.out.println("Erro: A roupa de ID " + Id + " não foi encontrada.");

	}

	public void retirarEstoque(int Id, int quantidade) {

		Optional<Roupa> roupa = buscarNaCollection(Id);

		if (roupa.isPresent()) {
			if (roupa.get().pegarPeca(quantidade) == true) {
				System.out.println("A retirada de " + quantidade + " peças foi efetuada com sucesso.");
			}
		} else
			System.out.println("Erro: O item de ID " + Id + " não foi encontrada.");
	}

	public void adicionarEstoque(int Id, int quantidade) {

		Optional<Roupa> roupa = buscarNaCollection(Id);

		if (roupa.isPresent()) {
			roupa.get().adicionarPeca(quantidade);
			System.out
					.println("A adição de " + quantidade + " peças de ID " + Id + " foi efetuada com sucesso.");
		} else {
			System.out.println("Erro: A peça de " + Id + " não foi encontrada.");
		}
	}

	// métodos auxiliares

	public int gerarId() {
		return ++Id;
	}

	public Optional<Roupa> buscarNaCollection(int numero) {
		for (var roupa : listaRoupas) {
			if (roupa.getId() == numero)
				return Optional.of(roupa);
		}

		return Optional.empty();
	}

}
