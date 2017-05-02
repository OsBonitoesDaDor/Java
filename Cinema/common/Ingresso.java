package common;

public class Ingresso {
	private Sala sala;
	private boolean meia;
	private float preco ;
	
	/**
	 * 
	 * @param salaSala do filme passando
	 * @param isMeia define se é meia entrada
	 * @param preco preco do ingresso
	 */
	public Ingresso(Sala sala, boolean isMeia, float preco){
				this.sala = sala;
		this.meia = isMeia;
		this.preco = preco;
	}
	
	/**
	 * Valor fixo de 15zao
	 * @param salaSala do filme passando
	 * @param isMeia define se é meia entrada
	 */
	public Ingresso(Sala sala, boolean isMeia){
		this(sala, isMeia, 15);
	}
	
	/**
	 * Entrada inteira		
	 * @param salaSala do filme passando
	 * @param preco preco do ingresso
	 */
	public Ingresso(Sala sala, float preco){
		this(sala, false, preco);
	}
	
	/**
	 * Não é meia, valor fixo de 15zao
	 * @param sala sala do filme passando
	 */
	public Ingresso(Sala sala){
		this(sala, false);
	}
	
	@Override
	public String toString(){
		return sala.getFilme() + "\tSala: " + sala.getId() + "\tPreco: " + ( meia? preco / 2 : preco);
 	}
}
