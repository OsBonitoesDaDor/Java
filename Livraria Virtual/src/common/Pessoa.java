package common;

import java.io.Serializable;

public class Pessoa implements Serializable{

	
	private String nome, cpf;
	
	public Pessoa(String nome, String cpf){
		this.nome = nome;
		this.cpf  = cpf;
	}
	
	
	public String getNome(){
		return this.nome;
	}

	public String getCpf() {
		return cpf;
	}

	@Override
	public String toString(){
		return "Nome: " + this.getNome() + "\tCPF: " + this.getCpf();
	}
}
