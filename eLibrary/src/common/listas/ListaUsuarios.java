package common.listas;

import java.io.Serializable;
import java.util.ArrayList;

import common.classes.Admin;
import common.classes.UsuarioGenerico;
import external.Entrada;
import external.Utils;

public class ListaUsuarios implements Serializable {

	//TODO: PEGAR O ULTIMO ID, QUADO O PROGRAMA REINICIA ELE COMECA A CONTAGEM DE NOVO
	
	private static final long serialVersionUID = 1L;

	private static int id = 0;

	private ListaGenerica<UsuarioGenerico> lista = new ListaGenerica<>();
	
	private Entrada scan = new Entrada();

	public ListaUsuarios() {
		id = 0;
	}

	public void addUsuario() {
		String userName, cpf, input = null;
		UsuarioGenerico newUser;
		boolean isAdmin = false;
		ArrayList<UsuarioGenerico> usuarios =(ArrayList<UsuarioGenerico>) 
				lista.getLista(Utils.getUsersFilePath());
		
		System.out.println("Qual o nome do usuario? ");
		userName = scan.nextLine();
		System.out.println("Qual o EMAIL do usuario? ");
		cpf = scan.nextLine();
		System.out.println("O usuario eh admin? (S/N)");
		input  = scan.nextLine();
		if(Utils.isStringEqual(input, "s")){
			isAdmin = true;
		}
		if (usuarios != null) {
			// Checa se o nome do usuario esta disponivel
			for (UsuarioGenerico u : usuarios) {
				if (Utils.isStringEqual(u.getNome(), userName)) {
					System.out.println("Esse usuario ja existe, tente novamente!");
					return;
				}
			}

			// Checa se o EMAIL esta disponivel
			for (UsuarioGenerico u : usuarios) {
				if (Utils.isStringEqual(u.getEmail(), cpf)) {
					System.out.println("Esse EMAIL ja esta cadastrado, tente novamente!");
					return;
				}
			}
		}
		if(isAdmin)
			newUser = new Admin(userName, cpf, id);
		else
			newUser = new UsuarioGenerico(userName, cpf, id);
		usuarios.add(newUser);
		id++;
		lista.saveLista(usuarios, Utils.getUsersFilePath());
	}

	public void mostraUsuarios() {
		for (UsuarioGenerico u : lista.getLista(Utils.getUsersFilePath())) {
			System.out.println(u);
		}
	
	}

	public void delUsuario() {
		String tag;
		ArrayList<UsuarioGenerico> usuarios = lista.getLista(Utils.getUsersFilePath());
		ArrayList<UsuarioGenerico> delUsers = lista.getLista(Utils.getDelUsersFilePath());
		System.out.println("Qual usuario deseja excluir? ");
		tag = scan.nextLine();
		UsuarioGenerico u = null;
		// Encontra quem é o usuario
		if (Utils.isInteger(tag)) {
			u = usuarios.get(Integer.parseInt(tag));
			usuarios.remove(Integer.parseInt(tag));
		} else {
			for (int i = 0; i < usuarios.size(); i++) {
				if (Utils.isStringEqual(tag, usuarios.get(i).getNome())) {
					u = usuarios.get(i);
					usuarios.remove(i);
					break;
				}
			}
		}

		if (u == null) {
			System.out.println("Usuario nao encontrado!");
			return;
		}
		delUsers.add(u);
		lista.saveLista(delUsers, Utils.getDelUsersFilePath());
		lista.saveLista(usuarios, Utils.getUsersFilePath());

	}

	public ArrayList<UsuarioGenerico> getLista(String path){
		return lista.getLista(path);
	}

}
