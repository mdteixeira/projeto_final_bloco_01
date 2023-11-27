package performanceGoal.model;

public class Calcas extends Roupa {

	String corte;

	public Calcas(String nomePeca, String cor, char tamanho, int tipo, int estoque, float preco, String corte) {
		super(nomePeca, cor, tamanho, tipo, estoque, preco);
		this.corte = corte;
	}

	public String getCorte() {
		return corte;
	}

	public void setCorte(String corte) {
		this.corte = corte;
	}
}
