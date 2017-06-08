package common.listas;

import java.util.ArrayList;

import common.classes.Livro;
import common.classes.Pedido;
import common.classes.UsuarioGenerico;
import external.Utils;

public class ListaPedidos {
	
	private ListaGenerica<Pedido> lista = new ListaGenerica<>();
	
	public void addPedido(UsuarioGenerico user, Livro livro){
		ArrayList<Pedido> l = lista.getLista(Utils.getPedidosFilePath());
		l.add(new Pedido(user, livro));
		lista.saveLista(l, Utils.getPedidosFilePath());
	}
	
	public ArrayList<Pedido> getLista(){
		return lista.getLista(Utils.getPedidosFilePath());
	}

}
