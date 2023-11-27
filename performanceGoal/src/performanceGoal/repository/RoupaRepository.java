package performanceGoal.repository;

import performanceGoal.model.Roupa;

public interface RoupaRepository {
	
	// CRUD

	public void procurarPorId(int numero);

	public void listarTodas();

	public void cadastrar(Roupa roupa);

	public void atualizar(Roupa roupa);

	public void deletar(int numero);

}
