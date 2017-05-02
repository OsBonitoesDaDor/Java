package common;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Cinema {
	private static final float[] precosFilmes = {15, 16, 13, 23, 21, 11, 18};
	private static final String[] nomesFilmes = { "Duro de matar 13", "Fragmentado", "Piratas do Caribe 12",
			"Star Wars 8", "As Branquelas 2", "Click 4", "Harry Potter 11", "Aneis do Senhor 6" };
	private static final String[] opcoesDoMenu = { String.valueOf(1), "Listar filmes em Cartaz", String.valueOf(2),
			"Comprar ingressos", String.valueOf(3), "Ver ingressos", String.valueOf(4), "Sair" };
	
	private static Menu menu = new Menu(opcoesDoMenu);
	private static ArrayList<Sala> salas = new ArrayList<Sala>();
	private static ArrayList<Ingresso> ingressosComprados = new ArrayList<Ingresso>();
	
	private static Scanner scan = new Scanner(System.in);
	private static Random rand = new Random();
	
	public static void main(String[] args) {
		initSalas();
		do {
			menu.drawMenu();
			switch (menu.getInput()) {
			case 1:
				mostraFilmes();
				break;
			case 2:
				compraIngressos();
				break;
			case 3:
				mostraIngressos();
				break;
			case 4:
				return;
			}
		} while (true);
	}
	
	static void mostraIngressos(){
		for (int i = 0; i < ingressosComprados.size(); i++) {
			System.out.println(ingressosComprados.get(i));
		}
	}

	static boolean compraIngressos() {
		System.out.println("Qual o filme que gostaria de assistir?");
		String filme = scan.nextLine();
		Sala salaDoFilme = null;
		int nIngressos, nMeias;
		float precoFilme = 0;
		//Procura a sala que o filme ta passando
		for (int i = 0; i < salas.size(); i++) {
			if ( salas.get(i).getFilme().getNome().toLowerCase().equals(filme.toLowerCase()) || filme.equals(salas.get(i).getId()) ) {
				salaDoFilme = salas.get(i);
				break;
			}
		}
		
		for (int i = 0; i < precosFilmes.length; i++) {
			if(salas.get(i).getFilme().getNome().toLowerCase().equals(nomesFilmes[i].toLowerCase())){
				precoFilme = precosFilmes[i];
				break;
			}
		}

		if (salaDoFilme == null) {
			System.out.println("Filme nao encontrado! Tentar outra vez? (S/N)");
			return  (scan.nextLine().toLowerCase().toCharArray()[0] == 's' ? compraIngressos() : false);
		}

		System.out.println("Quantos ingressos gostaria?");
		do{
			nIngressos = scan.nextInt();
			if(nIngressos <= 0){
				System.out.println("Ingressos negativos? Tente novamente!");
			}else
				break;
		}while(true);
		
		System.out.println("Quantas meia entradas?");
		do{
			nMeias = scan.nextInt();
			if(nMeias >= nIngressos){
				System.out.println("Tem mais meias que ingressos! Tente novamente");
			}else
				break;
		}while(true);
		
		for (int i = 0; i < nIngressos; i++) {
			if(nMeias <= 0)
				ingressosComprados.add(new Ingresso(salaDoFilme, precoFilme));
			else{
				ingressosComprados.add(new Ingresso(salaDoFilme, true, precoFilme));
				nMeias--;
			}
		}
		
		System.out.println("Posso lhe ajudar em mais alguma coisa? (S/N)");
		
		return (scan.next().toLowerCase().toCharArray()[0] == 's' ? compraIngressos() : true);
	}

	static void mostraFilmes() {
		for (int i = 0; i < salas.size(); i++) {
			Sala temp = salas.get(i);
			System.out.println(temp);

		}
	}

	@SuppressWarnings("deprecation")
	private static void initSalas() {
		Time foo = new Time(0L);
		for (int i = 0; i < nomesFilmes.length; i++) {
			Filme temp = new Filme(nomesFilmes[i]);
			foo.setHours(rand.nextInt(3) + 3);
			foo.setMinutes(rand.nextInt(59));
			salas.add(new Sala(temp, foo, String.valueOf(i + 1)));
		}
	}
}
