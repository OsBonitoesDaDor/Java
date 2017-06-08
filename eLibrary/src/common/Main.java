package common;

import common.classes.Loja;
import common.classes.UsuarioGenerico;
import common.listas.ListaUsuarios;
import external.Entrada;
import external.Menu;
import external.Utils;

public class Main {
	private static ListaUsuarios usuarios = new ListaUsuarios();
	private static Loja loja;

	private static final String[] opcoesDoMenu = { "1", "Gerenciar usuarios", "2", "Ir para a loja", "3", "Sair" };
	private static Menu menu = new Menu(opcoesDoMenu);

	private static  Entrada scan = new Entrada();
	
	public static void main(String[] args) {
		do {
			menu.drawMenu();
			switch (menu.getInput()) {
			case 1:
				gerenciadorDeUsuarios(usuarios);
				break;
			case 2:
				loja();
				break;
				
			}
		} while (true);
	}

	private static void gerenciadorDeUsuarios(ListaUsuarios u) {
		final String[] opcoes = { "1", "Cadastrar usuario", "2", "Mostrar usuarios", "3", "Excluir usuario", "4",
				"Sair" };
		Menu m = new Menu(opcoes);

		do {
			m.drawMenu();
			switch (m.getInput()) {
			case 1:
				u.addUsuario();
				break;
			case 2:
				u.mostraUsuarios();
				break;
			case 3:
				u.delUsuario();
				break;
			case 4:
				return;
			}
		} while (true);
	}

	private static void loja(){	
		String nome;
		UsuarioGenerico user = null;
		System.out.println("Qual o nome do usuario? ");
		nome  = scan.nextLine();
		
		for (UsuarioGenerico u  : usuarios.getLista(Utils.getUsersFilePath())){
			if(Utils.isStringEqual(u.getNome(), nome)){
				user = u;
				break;
			}
		}
		
		if(user == null){
			System.out.println("Usuario nao encontrado, tente novamente!");
			return;
		}
		
		loja = new Loja(user);
		loja.drawMenu();
		
	}
}
