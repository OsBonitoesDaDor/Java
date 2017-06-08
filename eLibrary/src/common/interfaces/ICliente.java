package common.interfaces;

import java.util.ArrayList;

import common.classes.Livro;

public interface ICliente {
	public void compraLivro(Livro l);
	public void procuraLivro(ArrayList<Livro> l);
	
}
