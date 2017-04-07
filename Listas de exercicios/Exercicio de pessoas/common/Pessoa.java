package common;

public class Pessoa {
	
	private String nome, email;
	private int id;
	private DataDeNasc data;
	
	public Pessoa(String nome, String email, DataDeNasc data){
		this.nome = nome;
		this.email = email;
		this.data = data;
	}
	
	public Pessoa(String nome, String email){
		this(nome, email, null);
	}
	
	public Pessoa(String nome){
		this(nome, "Sem email");
	}
	
	public Pessoa(){
		this("Sem nome");
	}

	public DataDeNasc getData() {
		return data;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setData(DataDeNasc data) {
		this.data = data;
	}
	
	public String toString(){
		return "Id: " + id + "\tNome: " + this.nome +"\tEmail: "+ this.email + "\tNascimento:" + data;
	}
	
}
