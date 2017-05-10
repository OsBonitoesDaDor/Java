package common;

public class Modelo {
	private String modelo, marca;

	/**
	 * 
	 * @param modelo
	 * @param marca
	 */
	public Modelo(String modelo, String marca) {
		super();
		this.modelo = modelo;
		this.marca = marca;
	}
	
	public Modelo(){
		this.modelo = "VAZIO";
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	@Override
	public String toString(){
		return "Marca: " + this.marca + " - Modelo: " + this.modelo;
	}
	
}
