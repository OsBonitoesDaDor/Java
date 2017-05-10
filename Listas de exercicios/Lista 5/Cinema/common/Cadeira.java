package common;

public class Cadeira {
	private String id;
	private boolean ocupada;
	
	public Cadeira(String id, boolean ocupada) {
		super();
		this.id = id;
		this.ocupada = ocupada;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}
	
	
}
