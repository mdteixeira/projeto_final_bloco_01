package performanceGoal.model;

public class Calcas extends Roupa {

	String corte;
	boolean shorts;

	public Calcas(int Id, String tecido, String cor, char tamanho, int estoque, float preco, String corte, boolean shorts) {
		super(Id, tecido, cor, tamanho, estoque, preco);
		this.shorts = shorts;
		this.corte = corte;
	}

	public boolean isShorts() {
		return shorts;
	}

	public void setShorts(boolean shorts) {
		this.shorts = shorts;
	}

	public String getCorte() {
		return corte;
	}

	public void setCorte(String corte) {
		this.corte = corte;
	}
	
    @Override
	public void visualizar() {
		super.visualizar();
		System.out.println("\t* Corte: " + this.corte);
		System.out.println("\t* É shorts: " + this.shorts);
		System.out.println("\n---------------------------------------------\n");

	}
}
