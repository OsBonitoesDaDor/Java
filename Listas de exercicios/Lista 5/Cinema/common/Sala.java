package common;

import java.util.ArrayList;

public class Sala {
	
	private ArrayList<Sessao> sessoes;
	private int id;
	
	public Sala(int idSalas, ArrayList<Sessao> sessoes) {
		this.sessoes = sessoes;
		this.id = idSalas;
	}

	public int getNumSessoes(){
		return sessoes.size();
	}
	
	public ArrayList<Sessao> getSessoes() {
		return sessoes;
	}

	public Sessao getSessaoAt(int index) {
		return sessoes.get(index);
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void setSessoes(ArrayList<Sessao> sessoes) {
		this.sessoes = sessoes;
	}



	@Override
	public String toString(){
		StringBuilder builder =  new StringBuilder();
		
		builder.append("Sala " + this.id + ": " );
		
		for(Sessao s : sessoes){
			builder.append(String.format("Sessao das %dh: %s\t", s.getHorario(), s.getNome()));
		}
		
		return builder.toString() ;
	}
	
}
