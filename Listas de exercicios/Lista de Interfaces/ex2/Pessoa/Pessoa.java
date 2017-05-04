package ex2.Pessoa;

public abstract class Pessoa {
	
	private String nome;
	
	public Pessoa(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setString(String nome){
		this.nome = nome;
	}
}
