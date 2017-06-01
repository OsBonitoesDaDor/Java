package common;

import java.util.ArrayList;

public class Marca {
	private String id;
	private ArrayList<String> modelos = new ArrayList<String>();
	
	public Marca(String id){
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void addModelo(String modelo){
		this.modelos.add(modelo);
	}
	
	public ArrayList<String> getModelos(){
		return this.modelos;
	}
}
