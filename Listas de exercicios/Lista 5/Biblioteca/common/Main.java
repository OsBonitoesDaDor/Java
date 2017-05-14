package common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import menu.Menu;

public class Main {

	private static ArrayList<Livro> livrosCadastrados = new ArrayList<Livro>();
	private static ArrayList<Brother> brosCadastrados = new ArrayList<Brother>();
	
	private static final String[] opcoesDoMenu = {"1", "Cadastrar Livros", "2", "Cadastrar um colega", "3", "Emprestar o livro", "4", "Devolver Livro", "5", "Listar livros"};
	private static Menu menu = new Menu(opcoesDoMenu);
	
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String args[]){
		do{
			menu.drawMenu();
			switch(menu.getInput()){
			case 1:
				cadastraLivro();
				break;
			case 2:
				cadastraBrother();
				break;
			case 3:
				emprestaLivro();
				break;
			case 4:
				devolveLivro();
				break;
			case 5:
				listarLivros();
				break;
			}
		}while(true);
	}
	
	private static void listarLivros(){
		ArrayList<Livro> livros = livrosCadastrados;
		
		Collections.sort(livros, new Comparator<Livro>(){
			@Override
	        public int compare(Livro l2, Livro l1)
	        {

	            return  l1.getTitulo().compareTo(l2.getTitulo());
	        }
		});
		
		for (Livro l : livros) {
			System.out.printf("->Titulo: %s\n\tAutor:%s\n\tValor:%f\n\tEsta emprestado? %s\n",l.getTitulo(), l.getAutor(), l.getValor(), (l.isEmprestado() ?"Sim, para o " + l.getBro().getNome() + "que tem numero " + l.getBro().getNumero() :"nao")  );
		}
	}
	
	private static void devolveLivro() {
		String titulo;
		System.out.println("Qual o livro a ser devolvido? ");
		titulo = scan.nextLine();
		
		for (Livro livro : livrosCadastrados) {
			if(livro.getTitulo().equals(titulo)){
				if(!livro.isEmprestado()){
					System.out.println("Esse livro ainda nao foi emprestado! Tente novamente");
					return;
				}
				livro.setEmprestado(false, null);
				System.out.println("OK");
				return;
			}
		}
		
		System.out.println("Nao encontrei o livro!");
	}

	private static void emprestaLivro(){
		String bro, titulo;
		Brother brother = null;
		Livro livro = null;
		boolean achouBro = false, achouLivro = false;
		
		//Encontra o cara que vai emprestar o livro
		System.out.println("Pra quem é o livro? ");
		bro = scan.nextLine();
		for (Brother b : brosCadastrados) 
			if(b.getNome().equals(bro)){
				achouBro = true;
				brother = b;
				break;
			}
		if(!achouBro){
			System.out.println("Nao achei esse bro! Cadastre-o e tente novamente");
			return;
		}
		
		//Encontra o livro a ser emprestado
		System.out.println("Qual o titulo do autor? ");
		titulo = scan.nextLine();
		for (Livro l : livrosCadastrados) {
			if(l.getTitulo().equals(titulo)){
				if(l.isEmprestado()){
					System.out.println("O livro ja foi emprestado ao " + l.getBro().getNome());
					return;
				}
				achouLivro = true;
				livro = l;
				break;
			}
		}
		if(!achouLivro){
			System.out.println("Nao achei o livro! Tente novamente");
			return;
		}
		
		livro.setEmprestado(true, brother);	
	}
	
	private static void cadastraLivro(){
		String titulo, autor;
		float valor;
		System.out.println("Qual o titulo da obra? ");
		titulo = scan.nextLine();
		System.out.println("Qual o nome do autor?");
		autor = scan.nextLine();
		System.out.println("Qual o valor? ");
		valor = scan.nextFloat();
		livrosCadastrados.add(new Livro(titulo, autor, valor) );
	}
	
	private static void cadastraBrother(){
		String brother, numero;
		System.out.println("Qual o nome do brother? ");
		brother = scan.nextLine();
		brother = scan.nextLine();
		System.out.println("Qual o numero do brother?");
		numero = scan.nextLine();
		numero = scan.nextLine();
		brosCadastrados.add(new Brother(brother, numero) );
	}
}
