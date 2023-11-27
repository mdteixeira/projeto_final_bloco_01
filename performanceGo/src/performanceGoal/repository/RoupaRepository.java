package performanceGoal.repository;

import performanceGoal.model.Roupa;

public interface RoupaRepository {
	
	// CRUD

	public void procurarPorNumero(int numero);

	public void listarTodas();

	public void cadastrar(Roupa roupa);

	public void atualizar(Roupa roupa);

	public void deletar(int numero);
	
	// Métodos de compra
	
	public void adicionarCarrinho(int ID, int quantidade);
	public void RemoverCarrinho(int ID, float quantidade);
	public void limparCarrinho();

}
