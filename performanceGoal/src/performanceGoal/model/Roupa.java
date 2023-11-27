package performanceGoal.model;

public abstract class Roupa {

	private String nomePeca, cor;
	private char tamanho;
	private int tipo, estoque;
	private float preco;

	public Roupa(String nomePeca, String cor, char tamanho, int tipo, int estoque, float preco) {
		super();
		this.nomePeca = nomePeca;
		this.cor = cor;
		this.tamanho = tamanho;
		this.tipo = tipo;
		this.estoque = estoque;
		this.preco = preco;
	}

	public String getNomePeca() {
		return nomePeca;
	}

	public void setNomePeca(String nomePeca) {
		this.nomePeca = nomePeca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public char getTamanho() {
		return tamanho;
	}

	public void setTamanho(char tamanho) {
		this.tamanho = tamanho;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public void visualizar() {

		System.out.println("\n---------------------------------------------");
		System.out.println("\t\tDados da peça\n");
		System.out.println("\t* Nome da peça: " + this.nomePeca);
		System.out.println("\t* Cor: " + this.cor);
		System.out.println("\t* Tamanho: " + this.tamanho);
		System.out.println("\t* Tipo: " + this.tipo);
		System.out.println("\t* Estoque: " + this.estoque);
		System.out.println("\t* Preço: " + this.preco);
	}

	// operações de estoque

	// Adicionar peças ao estoque
	public boolean pegarPeca(int quantidade) {
		if (this.estoque < quantidade) {
			System.out.println("Não há estoque suficiente.");
			return false;
		}
		this.setEstoque(this.getEstoque() - quantidade);
		return true;
	}

	// Adicionar peças ao estoque
	public void adicionarPeca(int valor) {
		this.setEstoque(this.getEstoque() + valor);
	}

}
