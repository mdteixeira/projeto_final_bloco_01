package performanceGoal.model;

public class Camisas extends Roupa {

	boolean mangaLonga;
	int tipoGola;

	public Camisas(String nomePeca, String cor, char tamanho, int tipo, int estoque, float preco, boolean mangaLonga,
			int tipoGola) {
		super(nomePeca, cor, tamanho, tipo, estoque, preco);
		this.mangaLonga = mangaLonga;
		this.tipoGola = tipoGola;
	}

	public boolean isMangaLonga() {
		return mangaLonga;
	}

	public void setMangaLonga(boolean mangaLonga) {
		this.mangaLonga = mangaLonga;
	}
	
	public int getTipoGola() {
		return tipoGola;
	}

	public void setTipoGola(int tipoGola) {
		this.tipoGola = tipoGola;
	}
	
    @Override
	public void visualizar() {
		super.visualizar();
		System.out.println("\t* É manga longa: " + this.mangaLonga);
		System.out.println("\t* Tipo da gola: " + this.tipoGola);
		System.out.println("\n---------------------------------------------\n");

	}

}
