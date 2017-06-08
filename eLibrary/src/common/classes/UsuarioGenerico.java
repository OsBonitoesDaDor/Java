package common.classes;

import java.io.Serializable;
import java.util.ArrayList;

import common.interfaces.IAdmin;
import common.interfaces.ICliente;
import external.Entrada;

public class UsuarioGenerico  implements ICliente, Serializable{

	private  String nome, email;
	private static final long serialVersionUID = -6546865030694575521L;
	private int id;
	
	
	//private ArrayList<Livro> livrosComprados;
	
	public UsuarioGenerico(String nome, String email, int id) {
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	
	@Override
	public String toString(){
		return "ID: " + id + " => " + "Nome: " + this.nome + "\tEmail: " + this.email + "\tStatus: " + (this instanceof IAdmin ? " Administrador" : " Cliente") ;
	}

	public String getNome() {
		// TODO Auto-generated method stub
		return this.nome;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@Override
	public void compraLivro(Livro l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procuraLivro(ArrayList<Livro> l) {
		String tag;
		ArrayList<Livro> lista = l;
		Entrada scan  =new Entrada();
		System.out.println("Entre com o que deseja procurar: ");
		tag = scan.nextLine();
		if(l == null){
			System.out.println("Nenhum livro cadastrado");
			return;
		}
		for (Livro livro : lista) {
			if(!(livro.getAutor().contains(tag) || livro.getTitulo().contains(tag))){
				lista.remove(lista);
			}
		}
		System.out.println("Ocorrencias desse livro: ");
		for (Livro livro : lista) {
			System.out.println(livro);
		}
		
	}
}
