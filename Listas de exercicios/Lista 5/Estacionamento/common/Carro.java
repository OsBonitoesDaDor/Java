package common;

import java.util.GregorianCalendar;

public class Carro {
	
	private String placa;
	Modelo modelo;
	GregorianCalendar horaEntrada;
	
	public Carro(String placa, Modelo modelo, String hEntrada) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		horaEntrada = stringToGreg(hEntrada);
	}
	public String getPlaca() {
		return placa;
	}

	public GregorianCalendar getGregTime(){
		return this.horaEntrada;
	}
	
	public int getHoraEntrada(){
		return horaEntrada.get(GregorianCalendar.HOUR_OF_DAY);
	}	
	public int getMinutoEntrada(){
		return horaEntrada.get(GregorianCalendar.MINUTE);
	}
	
	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

		public void setPlaca(String placa) {
		this.placa = placa;
	}
		
		public static GregorianCalendar stringToGreg(String time){
				return (time.contains(":") ? (new GregorianCalendar(Integer.valueOf(time.split(":" )[0]), Integer.valueOf(time.split(":" )[1]), 0) ) : (new GregorianCalendar(Integer.valueOf(time.split("h")[0]), Integer.valueOf(time.split("h")[1]), 0)));
		}
}
