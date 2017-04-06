package common;

public class Pessoa {
	private String nome, email;
	
	public Pessoa(String nome, String email){
		this.nome = nome;
		this.email = email;
	}
	public Pessoa(String nome){
		this(nome, "Sem email");
	}
	public Pessoa(){
		this("Sem nome", "Sem Email");
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String toString(){
		return "Nome: " + this.nome +"\tEmail: "+ this.email;
	}
}
