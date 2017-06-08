package common.classes;

import java.util.ArrayList;
import java.util.Scanner;

import common.interfaces.IAdmin;
import common.listas.ListaLivros;
import external.Utils;

public class Admin extends UsuarioGenerico implements IAdmin{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3996402761962960106L;
	private transient Scanner e = new Scanner(System.in);
	
	public Admin(String nome, String cpf, int id) {
		super(nome, cpf, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addLivro(ListaLivros l) {
		String autor, titulo;
		float preco;
		ArrayList<Livro> lista;
		System.out.println("Qual o titulo da obra?");
		//TODO: BUGADAASSSO, ta dando NUllPointerException?!?!?!!?!??!?
		titulo  = e.nextLine();
		System.out.println("Qual o autor da obra? ");
		autor = e.nextLine();
		System.out.println("Qual o preco da obra? ");
		preco = e.nextFloat();
		lista = (l.getLista() == null ? new ArrayList<Livro>() : l.getLista());
		if(lista == null){
			lista = new ArrayList<Livro>();
			l.addLivro(new Livro(autor, titulo, preco));
			return;
		}
		for (Livro livro : lista) {
			if(Utils.isStringEqual(livro.getTitulo(), titulo) && Utils.isStringEqual(livro.getAutor(), autor)){
				System.out.println("Obra ja cadastrada");
				return;
			}
		}
		l.addLivro(new Livro(autor, titulo, preco));
		
	}

	@Override
	public void delLivro(ListaLivros l) {
		// TODO Auto-generated method stub
		
	}



}
