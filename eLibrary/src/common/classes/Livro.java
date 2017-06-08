package common.classes;

public class Livro {
	private String autor;
	private String titulo;
	private float preco;
	
	public Livro(String autor, String titulo, float preco) {
		super();
		this.autor = autor;
		this.titulo = titulo;
		this.preco = preco;
	}

	public String getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public float getPreco() {
		return preco;
	}
	
	public String toString(){
		return "Titulo: " + this.getTitulo() + "\tAutor: " + this.getAutor() + "\tPreco: " + this.getPreco();
	}
	
	
	
}
