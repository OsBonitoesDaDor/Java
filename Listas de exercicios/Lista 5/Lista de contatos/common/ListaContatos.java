package common;

import java.util.ArrayList;

public class ListaContatos {
	private ArrayList<Contato> contatos;
	
	public ListaContatos(){
		contatos = new ArrayList<Contato>();
	}

	public ArrayList<Contato> getContatos() {
		return contatos;
	}

	public void addContato(Contato contato) {
		contatos.add(contato);		
	}
}
