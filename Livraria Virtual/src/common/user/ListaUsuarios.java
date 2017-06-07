package common.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import external.Utils;
//TODO: nada nao, eh nois
  //Brinks debuga ai que e nois
public class ListaUsuarios implements Serializable {

	private static final long serialVersionUID = 1L;

	private static int id;

	private Scanner scan = new Scanner(System.in);

	private ObjectOutputStream saida = null;
	private ObjectInputStream entr = null;

	public ListaUsuarios() {
		id = 0;
	}

	public void addUsuario() {
		String userName, cpf;
		UsuarioGenerico newUser;
		System.out.println("Qual o nome do usuario? ");
		userName = scan.nextLine();
		ArrayList<UsuarioGenerico> usuarios = this.getLista(Utils.getUsersFilePath());
		System.out.println("Qual o CPF do usuario? ");
		cpf = scan.nextLine();
		if (usuarios != null) {
			// Checa se o nome do usuario esta disponivel
			for (UsuarioGenerico u : usuarios) {
				if (Utils.isStringEqual(u.getNome(), userName)) {
					System.out.println("Esse usuario ja existe, tente novamente!");
					return;
				}
			}

			// Checa se o CPF esta disponivel
			for (UsuarioGenerico u : usuarios) {
				if (Utils.isStringEqual(u.getCpf(), cpf)) {
					System.out.println("Esse CPF ja esta cadastrado, tente novamente!");
					return;
				}
			}
		}
		newUser = new UsuarioGenerico(userName, cpf, id);
		usuarios.add(newUser);
		id++;
		try {
			System.out.println(newUser);
			saida = new ObjectOutputStream(new FileOutputStream(Utils.getUsersFilePath()));
			saida.writeObject(usuarios);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				saida.close();
				System.out.println("OK!");
			} catch (IOException e) {

			}
		}
	}

	@SuppressWarnings("unchecked")
	public void mostraUsuarios() {
		int id = 0;
		ArrayList<UsuarioGenerico> usuarios = this.getLista(Utils.getUsersFilePath());
		for (UsuarioGenerico u : usuarios) {
			System.out.println(u);
		}
	
	}

	@SuppressWarnings("unchecked")
	public ArrayList<UsuarioGenerico> getLista(String path) {
		ArrayList<UsuarioGenerico> lista = null;
		try {
			entr = new ObjectInputStream(new FileInputStream(path));
			lista = (ArrayList<UsuarioGenerico>) entr.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				entr.close();
			} catch (IOException e) {
				System.out.println(e);
			} catch (NullPointerException e) {
				System.out.println(e);
			}
		}
		if (lista == null)
			return new ArrayList<UsuarioGenerico>();

		return lista;
	}

	public void delUsuario() {
		String tag;
		ArrayList<UsuarioGenerico> usuarios = this.getLista(Utils.getUsersFilePath());
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

		try{
			saida = new ObjectOutputStream(new FileOutputStream(Utils.getUsersFilePath()));
			saida.writeObject(usuarios);
		}catch(IOException e){
			
		}finally{
			try{
				saida.close();
			}catch(IOException e){
				
			}
		}
		
		
		try {
			saida = new ObjectOutputStream(new FileOutputStream(Utils.getDelUsersFilePath()));
			saida.writeObject(u);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				saida.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	/**
	 * public void update() { String path = Utils.getUsersFilePath();
	 * System.out.println(path); File f = new File(path); try { f.delete();
	 * saida = new ObjectOutputStream(new FileOutputStream(path));
	 * saida.writeObject(usuarios); } catch (IOException e) {
	 * e.printStackTrace(); // System.out.println(e); } finally { try {
	 * saida.close(); } catch (IOException e) { System.out.println(e); } } }
	 */

}
