package common;

import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class Estacionamento {

	private Carro[][] carros;
	
	public Estacionamento(){
		carros = new Carro[10][10];
		initEst();
	}
	
	private void initEst(){
		for (int i = 0; i < carros.length; i++) {
			for (int j = 0; j < carros[i].length; j++) {
				carros[i][j] = new Carro();
			}
		}
	}
	
	/**
	 * Adiciona um carro ao estacionamento se a vaga estiver disponivel
	 * @param c Carro a ser adicionado
	 */
	public void addCarro(Carro c){
		for (int i = 0; i < carros.length; i++) {
			for (int j = 0; j < carros[i].length; j++) {
				if(carros[i][j].getPlaca().equals("-VAZIO-")){
					carros[i][j] = c;
					System.out.println("O seu carro estara na vaga " + (i*10) + j);
					return;
				}
			}
		}
	}
	
	
	public float tiraCarro(int pos, String hSaida){
		int lin = pos / 10, col = pos % 10;
		GregorianCalendar saida = Carro.stringToGreg(hSaida);
		Carro c = carros[lin][col];
		long permanencia = TimeUnit.MILLISECONDS.toMinutes(saida.getTimeInMillis() - c.getGregTime().getTimeInMillis()), custo = 14;
		
		if(saida.before(c.getGregTime())){
			System.out.println("Horario de saida invalido");
			return -1;
		}
		permanencia -= 120;
		
		if(permanencia <= 0 ){
			return custo;
		}

		do{
			custo +=2.5;
		}while((permanencia =- 15) > 1);
		carros[lin][col] = new Carro();

		
		return custo;
	}
	
	public float tiraCarro(String placa, String horaSaida){
		for (int i = 0; i < carros.length; i++) 
			for (int j = 0; j < carros[i].length; j++) 
				if(carros[i][j].getPlaca().equals(placa))
					return tiraCarro((i*10) + j, horaSaida);
		return -1;		
	}
	
	public void drawEstacionamento(){
		for (int i = 0; i < carros.length; i++) {
			for (int j = 0; j < carros[i].length; j++) {
				//System.out.printf("\t%s", (carros[i][j].getPlaca().equals("VAZIO") ? "-VAZIO-" : carros[i][j].getPlaca()) );
				System.out.print(" \t "+ carros[i][j].getPlaca());
			}
			System.out.println();
		}
	}

}
