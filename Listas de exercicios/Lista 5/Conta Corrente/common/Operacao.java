package common;

import java.util.GregorianCalendar;

public class Operacao {
	private String id;
	private GregorianCalendar data;
	private float quantidade;
	public static final String[] operacoesPossiveis = {"Deposito", "Saque"};
	
	public Operacao(String id, float quantidade, String data) {
		super();
		this.id = id;
		this.data = stringToGreg(data);
		this.quantidade = quantidade;
	}

		
	public static GregorianCalendar stringToGreg(String data){
		return new GregorianCalendar(Integer.parseInt(data.split("/")[2]), Integer.parseInt(data.split("/")[1]) - 1,Integer.parseInt(data.split("/")[0]) );
	}
	
	
	public String getData(){
		return String.format("%d/%d/%d", this.data.get(GregorianCalendar.DAY_OF_MONTH), this.data.get(GregorianCalendar.MONTH) + 1, this.data.get(GregorianCalendar.YEAR));
	}
	
	public int getMes(){
		return data.get(GregorianCalendar.MONTH) + 1;	
	}
	
	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	@Override
	public String toString(){
		return String.format("%s -> \tNatureza: %s \t Valor:%f", getData(), this.id, this.quantidade);
	}
	
}
