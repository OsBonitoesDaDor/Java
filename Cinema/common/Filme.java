package common;

import java.sql.Time;

public class Filme {

	private String nome;
	@SuppressWarnings("deprecation")
	private Time duracao = new Time(1, 30, 0);
	
	public Filme(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return this.nome;
	}
	public Time getDuracao(){
		return this.duracao;
	}
	
	@Override
	public String toString(){
		return "Filme: " + this.nome;
	}
}
