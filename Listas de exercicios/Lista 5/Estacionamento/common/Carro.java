package common;

import java.util.GregorianCalendar;

public class Carro {

	public void setHoraEntrada(GregorianCalendar horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	private String placa;
	Modelo modelo;
	GregorianCalendar horaEntrada;

	public Carro(String placa, Modelo modelo, String hEntrada) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		horaEntrada = stringToGreg(hEntrada);
	}

	public Carro() {
		this.placa = "-VAZIO-";
		this.horaEntrada = new GregorianCalendar();
	}

	public String getPlaca() {
		return placa;
	}

	public GregorianCalendar getGregTime() {
		return this.horaEntrada;
	}

	public int getHoraEntrada() {
		return horaEntrada.get(GregorianCalendar.HOUR_OF_DAY);
	}

	public int getMinutoEntrada() {
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

	public static GregorianCalendar stringToGreg(String time) {
		char[] entrada = time.toCharArray();
		int indice = 0, hora, minuto;
		StringBuilder builder = new StringBuilder();
		
		if(time.equals(null))
			return new GregorianCalendar();
		
		for (char c : entrada) {
			if (c == 'h' || c == 'H' || c == ':') 
				break;
			indice++;
		}

		for (int i = 0; i < indice; i++) {
			char c = entrada[i];

			if (c < '0' || c > '9')
				continue;
			builder.append(c);
		}
		hora = Integer.parseInt(builder.toString());
		builder = new StringBuilder();

		for (int i = indice + 1; i < entrada.length; i++) {
			char c = entrada[i];

			if (c < '0' || c > '9')
				continue;
			builder.append(c);
		}
		minuto = Integer.parseInt(builder.toString().equals("") ? "0" :  builder.toString());
		
		return new GregorianCalendar(new GregorianCalendar().get(GregorianCalendar.DAY_OF_MONTH),new GregorianCalendar().get(GregorianCalendar.MONTH),
				new GregorianCalendar().get(GregorianCalendar.YEAR), hora, minuto, 00);
	}
}
