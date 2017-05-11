package common;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Contato {
	private String nome, sobrenome, celular;
	private GregorianCalendar dataDeNasc;
	
	public Contato(String nome, String sobrenome, String celular, GregorianCalendar dataDeNasc) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.celular = celular;
		this.dataDeNasc = dataDeNasc;
	}

	public String getNome() {
		return nome;
	}
	
	public GregorianCalendar getDataDeNasc() {
		return dataDeNasc;
	}

	@Override
	public String toString(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		return String.format("Nome completo: %s %s, Telefone: %s Nascimento: %s", nome, sobrenome, celular, sdf.format(dataDeNasc));
	}
}
