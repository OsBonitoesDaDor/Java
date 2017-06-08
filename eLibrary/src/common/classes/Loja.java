package common.classes;

import java.util.ArrayList;
import java.util.Scanner;

import common.interfaces.IAdmin;
import common.listas.ListaLivros;
import common.listas.ListaPedidos;
import external.Menu;
import external.Utils;

public class Loja {
	private ListaLivros livros = new ListaLivros();
	private ListaPedidos pedidos = new ListaPedidos();
	private UsuarioGenerico user;

	private transient Scanner scan = new Scanner(System.in);

	public Loja(UsuarioGenerico u) {
		this.user = u;
		System.out.println("Bem vindo, " + u.getNome());
	}

	public void drawMenu() {
		ArrayList<String> opcoesArray = new ArrayList<String>();
		opcoesArray.add("1");
		opcoesArray.add("Procurar livros");
		opcoesArray.add("2");
		opcoesArray.add("Comprar livros");

		if (user instanceof IAdmin) {
			opcoesArray.add("3");
			opcoesArray.add("Adicionar livro ao estoque");
			opcoesArray.add("4");
			opcoesArray.add("Remover livro do estoque");
		}

		opcoesArray.add("0");
		opcoesArray.add("Sair");
		String[] opcoesDoMenu = new String[opcoesArray.size()];
		opcoesDoMenu = opcoesArray.toArray(opcoesDoMenu);

		Menu m = new Menu(opcoesDoMenu);
		do {
			m.drawMenu();
			switch (m.getInput()) {
			case 0:
				return;
			case 1:
				procuraLivros();
				break;
			case 2:
				compraLivro();
				break;
			case 3:
				if((user instanceof IAdmin))
					((IAdmin) user).addLivro(livros);
				break;
			}
		} while (true);
	}

	private void procuraLivros() {
	//	user.procuraLivro(livros.getLista());
		livros.mostraLivros();
	}

	private void compraLivro() {
		String tag;
		ArrayList<Livro> matches = new ArrayList<Livro>();
		Livro match = null;
		System.out.println("Qual livro deseja comprar? ");
		tag = scan.nextLine();
		for (Livro livro : livros.getLista()) {
			if(livro.getAutor().contains(tag) || livro.getTitulo().contains(tag)){
				matches.add(livro);
			}
		}
		
		if(matches.isEmpty()){
			System.out.println("Obra nao encontrada, tente novamente");
			return;
		}
		
		if(matches.size() != 1){
			System.out.println("Multiplas obras foram encontradas. Entre qual voce quer comprar, ou digite 'enter' para comprar todas");
			for (int i = 0; i < matches.size(); i++) 
				System.out.println(i +" => " +  matches.get(i));
			tag = scan.nextLine();
			if(Utils.isStringEqual(tag, "")){
				for (Livro livro : matches) {
					user.compraLivro(livro);
					this.pedidos.addPedido(user, livro);
				}
				return;
			}
			match = matches.get(Integer.parseInt(scan.nextLine()));		
		}else
			match = matches.get(0);
		if(match == null){
			System.out.println("Algo de errado aconteceu, tente novamente!");
			return;
		}
		
		pedidos.addPedido(user, match);
		
	}



}
