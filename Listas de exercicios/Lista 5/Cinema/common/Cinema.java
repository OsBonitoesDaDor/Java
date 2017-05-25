package common;

import java.util.ArrayList;
import java.util.Scanner;

public class Cinema {
	private static Scanner scan = new Scanner(System.in);

	private static int idSalas = 1;

	private static ArrayList<Sala> salas = new ArrayList<Sala>();
	private static ArrayList<Ingresso> ingressosVendidos = new ArrayList<Ingresso>();
	
	private static final String[] opcoesDoMenu = { "1", "Adicionar sala", "2", "Listar salas", "3", "Mostrar sessao" , "4", "Comprar ingresso", "5", "Mostrar poltrona ocupada", "6", "Mostrar financeiro para horario", "7", "Mostrar financeiro para sala", "8", "Sair"};
	private static Menu menu = new Menu(opcoesDoMenu);

	public static void main(String[] args) {
		do {
			menu.drawMenu();
			switch (menu.getInput()) {
			case 1:
				addSala();
				break;
			case 2:
				listaSalas();
				break;
			case 3:
				mostraSessao();
				break;
			case 4:
				compraIngresso();
				break;
			case 5:
				mostraPoltronaOcupada();
				break;
			case 6:
				//Pode bugar
				mostraFinanceiro();
				break;
			case 7:
				//Pode bugar
			
				break;
			case 8:
				return;
			}
		} while (true);

	}
	
	private static int montanteSessao(Sala sala, Sessao sessao){
		int iVendidos = 0, numMeias = 0, numInteiras = 0;
		for (Ingresso i : ingressosVendidos) {
			if(i.getSala() == sala.getId() && i.getHorario() == sessao.getHorario()){
				iVendidos++;
				numMeias = i.isMeia() ? numMeias + 1 : numMeias;
			}
		}
		numInteiras = iVendidos - numMeias;
		System.out.printf("Foram vendidas para a sessao das %d, %d meias e %d inteiras",sessao.getHorario(), numInteiras, numMeias);
		return numInteiras * 22 + numMeias *11;
		
	}
	private static void mostraFinanceiro(){
		int idSala, montante = 0;
		String nomeSessao;
		Sala sala = null;
		
		
		System.out.println("Qual a sala que deseja veirificar? ");
		idSala = scan.nextInt();
		for (Sala s : salas) 
			if(s.getId() == idSala)
				sala = s;
			
		if(sala == null){
			System.out.println("Sala inexistente, tente novamente"); 
			return ;
		}
	
		System.out.println("Qual a sessao que deseja veirifcar? Enter para mostrar o montante total da sala");
		nomeSessao= scan.nextLine();
		nomeSessao= scan.nextLine();
		
		if(nomeSessao.equals(null))
			for (Sessao s : sala.getSessoes()) 
				montante += montanteSessao(sala,  s);
		else{
			for (Sessao s : sala.getSessoes()) {
				if(s.getHorario() == Integer.parseInt(nomeSessao)){
					montante =+ montanteSessao(sala, s);
					break;
				}
			}
		}
		System.out.printf("O montante foi %d\n", montante);	
		
	}
	
	/*
	private static void mostraFinanceiro(Sala sala){
		int cont = 0;
		for (Sessao s : sala.getSessoes()) {
			cont += mostraFinanceiro(s.getHorario(), sala);
		}
		System.out.println("Total arrecadado: " + cont);
	}
	
	private static int mostraFinanceiro(int horario, Sala sala){
		int numVendidos = 0, numMeias = 0, numInteiras, arrecadado;
		System.out.println("Sessao das " + horario + "h: ");
		for (Ingresso i : ingressosVendidos) {
			if(i.getSala() == sala.getId() && i.getHorario() == horario){
				numVendidos++;
				if(i.isMeia())
					numMeias++;
			}
		}
		numInteiras = numVendidos -numMeias;
		arrecadado = 22*numInteiras + 11*numMeias;
		System.out.printf("\n\tIngressos vendidos: %d, inteiras: %d, meias: %d, total arrecadado: %d", numVendidos, numInteiras, numMeias, arrecadado);
		return arrecadado;
		
	}
*/
	//Esse metodo mostra uma poltrona especifica em uma sessao e sala 
	private static void mostraPoltronaOcupada(){
		int idSala, sessao;
		String idPoltrona;
		System.out.println("Qual a sala?");
		idSala = scan.nextInt();
		System.out.println("Qual a sessao?");
		sessao = scan.nextInt();
		System.out.println("Qual o ID da poltrona?");
		idPoltrona = scan.nextLine();
		idPoltrona = scan.nextLine();
		
		for (Ingresso i : ingressosVendidos) {
			if(i.getCadeira().equals(idPoltrona) && i.getHorario() == sessao && i.getSala() == idSala){
				System.out.println(i);
				return;
			}
		}
		System.out.println("Nao encontramos sua poltrona!");
		
	}

	//Compra um ingresso quando possivel
	private static void compraIngresso(){
		boolean cadeiraLivre = false;
		String dono, idPolt;
		int sala, horario, idMeia;
		System.out.println("Qual a sala? ");
		sala = scan.nextInt();
		System.out.println("Qual o horario da sessao?");
		horario = scan.nextInt();
		mostraSessao2(sala,horario);
		System.out.println("Qual poltrona gostaria?");
		idPolt = scan.nextLine();
		idPolt = scan.nextLine();
		//Loop nas salas
		for (Sala s : salas) {
			//Encontra a sala que o cliente quer
			if(s.getId() == sala){
				//Loop nas sessoes da sala
				for (Sessao a : s.getSessoes()) {
					//Encontra a sessao que o cliente quer
					if(a.getHorario() == horario){
						//Esses 2 loops procuram  a poltrona que o cliente quer
						for (int i = 0; i < a.getCadeiras().length; i++) {
							for (int j = 0; j < a.getCadeiras()[i].length; j++) {
								String idCadeira = a.getCadeiras()[i][j].getId();
								if(idPolt.equals(idCadeira) ){
									//A cadeira esta ocupada
									if(a.getCadeiras()[i][j].isOcupada())
										System.out.println("A cadeira esta ocupada, tente outra vez");
									else{
										//A cadeira nao esta ocupada, compre ela
										a.getCadeiras()[i][j].setOcupada(true);
										//Encontrou uma cadeira, continue com o cadastro do ingresso
										cadeiraLivre = true;
									}
								}
							}
						}
					}
				}
			}
		}
		//Compra do ingresso, ja que vimos que a cadeira esta livre
		if(cadeiraLivre){
			System.out.println("Qual seu nome?");
			dono = scan.nextLine();
			System.out.println("É doador de sangue? Digite 1. É estudante? Digite 2. Nenhum dos dois, digite 0");
			idMeia = scan.nextInt();
			//Compra o ingresso
			ingressosVendidos.add(new Ingresso(dono, idMeia, sala, horario, idPolt));
		}
		
		
		
	}
	//Mostra a matriz com as poltronas ja compradas
	private static void mostraSessao() {
		int op;
		Sala sala = null;
		System.out.println("Entre com a sala da sessao");
		op = scan.nextInt();
		for (Sala s : salas)
			if (s.getId() == op)
				sala = s;
		if (sala == null) {
			System.out.println("Sala nao encontrada, tente novamente!");
			return;
		}
		System.out.println("Entre com a sessao: ");
		op = scan.nextInt();
		for (Sala s : salas)
			for (int i = 0; i < s.getNumSessoes(); i++)
				if (s.getSessaoAt(i).getHorario() == op){
					s.getSessaoAt(i).printCadeiras();	
					return;
				}
		System.out.println("Horario indisponivel, tente mais tarde!");
	}
	
	private static int mostraSessao2(int salaEscolhida, int sassaoEscolhida) {
		Sala sala = null;
		for (Sala s : salas)
			if (s.getId() == salaEscolhida)
				sala = s;
		if (sala == null) {
			System.out.println("Sala nao encontrada, tente novamente!");
			return 0;
		}
		for (Sala s : salas)
			for (int i = 0; i < s.getNumSessoes(); i++)
				if (s.getSessaoAt(i).getHorario() == sassaoEscolhida){
					s.getSessaoAt(i).printCadeiras();	
					return 1;
				}
		return 0;
	}
	//Mostra as salas com suas sessoes
	private static void listaSalas() {
		for (Sala s : salas) {
			System.out.println(s);
		}
	}
	//Cria uma nova sala
	private static void addSala() {
		ArrayList<Sessao> ses = new ArrayList<Sessao>();
		System.out.println("Entre com a sessao das 14h: ");
		scan.nextLine();
		ses.add(new Sessao(scan.nextLine(), 14));
		System.out.println("Entre com a sessao das 16h: ");
		scan.nextLine();
		ses.add(new Sessao(scan.nextLine(), 16));
		System.out.println("Entre com a sessao das 18h: ");
		scan.nextLine();
		ses.add(new Sessao(scan.nextLine(), 18));
		System.out.println("Entre com a sessao das 20h: ");
		scan.nextLine();
		ses.add(new Sessao(scan.nextLine(), 20));

		salas.add(new Sala(idSalas, ses));
		idSalas++;
	}
}
