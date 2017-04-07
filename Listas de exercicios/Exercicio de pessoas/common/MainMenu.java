package common;

import java.io.IOException;
import java.util.Scanner;

public class MainMenu {
	
	private static Scanner scan;
	private static int op;
	private static Contatos listaContatos= new Contatos();
	public static void main(String[] args) throws IOException{
		System.out.println("\nEntre com a operacao\n 1 - addPessoa\n2 - Remove pessoa\n3 - Mostra pessoa\n");
		scan = new Scanner(System.in);
		do{
			op = scan.nextInt();
			
			switch(op){
				case 1:
					addPessoa();
					break;
				
				case 2:
					removePessoa();
					break;
				case 3:
					mostraPessoas();
					break;
				case 4:
					//TODO: mostr1pessoa
					break;
			}
			System.out.println("Dalhee");
		}while(op > 0);
	}
	
	private static void addPessoa(){
		Pessoa p;
		String nome, email, data;		
		System.out.println("Digite o nome");
		nome = scan.nextLine();	
		nome = scan.nextLine();
		System.out.println("Digite o email");
		email = scan.nextLine();
		System.out.println("Qual a data de nascimento?");
		data = scan.nextLine();
		if(email.equals(null) && data.equals(null))
			p = new Pessoa(nome);
		else if(email.equals(null))
			p = new Pessoa(nome, null, new DataDeNasc(data));
		else if(data.equals(null))
			p = new Pessoa(nome, email, null);
		else	
			p = new Pessoa(nome, email, new DataDeNasc(data));
		
		listaContatos.addPessoa(p);
	}
	
	private static void removePessoa(){
		String nome;
		System.out.println("Qual o nome da pessoa a ser removida?");
		nome = scan.next();
		Pessoa p;
		for (int i = 0; i < listaContatos.getArrayLenght(); i++) {
			p = listaContatos.contatoAt(i);
			if(p.getNome().equalsIgnoreCase(nome)){
				System.out.println("OK!");
				listaContatos.delPessoa(p);
			}
		}
		
		System.out.println("Pessoa com esse nome nao encontrada");
	}

	private static void mostraPessoas(){//
		//TODO: Mostrar apenas um contato
		for (int i = 0; i < listaContatos.getArrayLenght(); i++) {
			
			System.out.println(listaContatos.contatoAt(i).toString());
		}
	}

}
