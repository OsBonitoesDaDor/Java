package common.listas;

import java.util.ArrayList;

import common.classes.Livro;
import external.Utils;

public class ListaLivros {
	private ListaGenerica<Livro> lista = new ListaGenerica<>();
	
	public ArrayList<Livro> getLista() {
		return lista.getLista(Utils.getLivrosFilePath());
	}
	

	public void addLivro(Livro livro) {
		ArrayList<Livro> lista = this.getLista();
		if(lista == null){
			lista = new ArrayList<Livro>();
		}
		lista.add(livro);
		this.lista.saveLista(lista, Utils.getLivrosFilePath());
		
	}
	
	public void mostraLivros(){
		for (Livro l : lista.getLista(Utils.getLivrosFilePath())) {
			System.out.println(l);
		}
	}

}
