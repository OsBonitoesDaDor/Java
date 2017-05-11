package common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

	private static Scanner scan = new Scanner(System.in);

	private static ListaContatos listaContatos;

	private static final String[] opcoesDoMenu = { "1", "Incluir Contato", "2", "Procurar contato por nome", "3", "Listar contatos por ordem alfabetica", "4", "Listar contatos por ordem cronologica", "5", "Sair"};
	private static Menu menu;

	public static void main(String[] args) {
		menu = new Menu(opcoesDoMenu);
		listaContatos = new ListaContatos();

		do {
			menu.drawMenu();
			switch (menu.getInput()) {
			case 1:
				incluiContato();
				break;
			case 2:
				listaContato();
				break;
			case 3:
				listaContatos(1);
				break;
			case 4:
				listaContatos(2);
				break;
			case 5:
				return;
			}
		} while (true);
	}
	
	/**
	 * TODO:Implementar a parte que mostra a idade a ser completada
	 * @param id 1 para alfabetica, 2 para cronologica
	 */
	private static void listaContatos(int id){
		ArrayList<Contato> contatos = listaContatos.getContatos();
		if(id == 1){
			Collections.sort(contatos, new Comparator<Contato>(){
				 @Override
			        public int compare(Contato c2, Contato c1)
			        {

			            return  c1.getNome().compareTo(c2.getNome());
			        }
			});
		}else if(id == 2){
			Collections.sort(contatos, new Comparator<Contato>(){
			 @Override
		        public int compare(Contato c2, Contato c1)
		        {

		            return  c1.getDataDeNasc().compareTo(c2.getDataDeNasc());
		        }
		});
		}
		
		for (Contato c : contatos) {
			System.out.println(c);
		}
	}
	
	private static void listaContato() {
		String nome;

		System.out.println("Digite o nome para consultar o contato, ou deixe em branco para consultar todos ");
		nome = scan.nextLine();

		if (nome.equals(null)) {
			for (Contato c : listaContatos.getContatos())
				System.out.println(c);
			return;
		}

		for (Contato c : listaContatos.getContatos())
			if (c.getNome().equals(nome)) {
				System.out.println(c);
			}

	}

	private static void incluiContato() {
		String nome, sobrenome, celular, temp;
		GregorianCalendar calendar;

		System.out.println("Qual o nome?");
		nome = scan.nextLine();
		System.out.println("Qual o sobrenome?");
		sobrenome = scan.nextLine();
		System.out.println("Qual o celular? ");
		celular = scan.nextLine();
		System.out.println("Entre com a data de nascimento");
		temp = scan.nextLine();

		calendar = new GregorianCalendar(Integer.valueOf(temp.split("/")[2]), Integer.valueOf(temp.split("/")[1]),
				Integer.valueOf(temp.split("/")[0]));

		listaContatos.addContato(new Contato(nome, sobrenome, celular, calendar));

	}
}
