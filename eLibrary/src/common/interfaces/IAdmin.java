package common.interfaces;

import common.listas.ListaLivros;

public interface IAdmin extends ICliente{
	public void addLivro(ListaLivros l);
	public void delLivro(ListaLivros l);
}
