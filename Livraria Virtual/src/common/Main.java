package common;

import common.store.ListaLivros;
import common.user.ListaUsuarios;
import external.Menu;
import external.Utils;
//TODO: Implentar a loja, em relacao ao usuario ta tudo OK!
public class Main {
	private static ListaUsuarios usuarios = new ListaUsuarios();
	private static ListaLivros livros = new ListaLivros();

	private static final String[] opcoesDoMenu = { "1", "Gerenciar usuarios", "2", "Ir para a loja", "3", "Sair" };
	private static Menu menu = new Menu(opcoesDoMenu);

	public static void main(String[] args) {
		do {
			menu.drawMenu();
			switch (menu.getInput()) {
			case 1:
				gerenciadorDeUsuarios(usuarios);
				break;
			case 2:
				System.out.println(Utils.getAbsPath());
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
			}
		} while (true);
	}

}
