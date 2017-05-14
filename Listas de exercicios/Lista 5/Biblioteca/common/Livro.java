package common;

public class Livro {
	private String titulo, autor;
	private float valor;
	private boolean emprestado;
	private Brother bro;
	public Livro(String titulo, String autor, float valor) {
		super();
		this.setTitulo(titulo);
		this.autor = autor;
		this.valor = valor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public boolean isEmprestado() {
		return emprestado;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public void setEmprestado(boolean emprestado, Brother b) {
		this.emprestado = emprestado;
		this.setBro(b);
	}

	public Brother getBro() {
		return bro;
	}

	public void setBro(Brother bro) {
		this.bro = bro;
	}

	


}
