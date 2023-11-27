package performanceGoal.model;

public class Camisas extends Roupa {

	boolean mangaLonga;
	String estampa;

	public Camisas(int Id, String tecido, String cor, char tamanho, int estoque, float preco, boolean mangaLonga, String estampa) {
		super(Id, tecido, cor, tamanho, estoque, preco);
		this.mangaLonga = mangaLonga;
		this.estampa = estampa;
	}

	public boolean isMangaLonga() {
		return mangaLonga;
	}

	public void setMangaLonga(boolean mangaLonga) {
		this.mangaLonga = mangaLonga;
	}
	
    @Override
	public void visualizar() {
		super.visualizar();
		System.out.println("\t* É manga longa: " + this.mangaLonga);
		System.out.println("\t* Estampa: " + this.estampa);
		System.out.println("\n---------------------------------------------\n");

	}

}
