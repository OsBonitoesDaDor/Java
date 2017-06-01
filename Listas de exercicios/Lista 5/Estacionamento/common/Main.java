package common;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static ArrayList<Marca> marcasCadastradas = new ArrayList<Marca>();

	private static String[] opcoesDoMenu = { "1", "Cadastrar Marca", "2", "Cadastrar Modelo", "3",
			"Cadastrar entrada de um novo carro", "4", "Mostrar estacionamento", "5", "Retirar carro", "6", "Sair" };
	private static Menu menu;

	private static Estacionamento e;

	private static Scanner scan = new Scanner(System.in);

	public static void main(String args[]) {
		menu = new Menu(opcoesDoMenu);
		e = new Estacionamento();
		do {
			menu.drawMenu();
			switch (menu.getInput()) {
			case 1:
				addMarca();
				break;
			case 2:
				addModelo();
				break;
			case 3:
				addCarro();
				break;
			case 4:
				e.drawEstacionamento();
				break;
			case 5:
				retiraCarro();
				break;
			case 6:
				return;
			}
		} while (true);

	}

	private static void retiraCarro() {
		String entr, horaSaida;
		float custo;
		System.out.println("Me informe a placa ou o ID da vaga");
		entr = scan.nextLine();
		System.out.println("Que horas saiu?");
		horaSaida = scan.nextLine();
		if (isInteger(entr))
			custo = e.tiraCarro(Integer.valueOf(entr), horaSaida);
		else
			custo = e.tiraCarro(entr, horaSaida);

		System.out.printf("%s", (custo <= 0 ? "Erro nos dados, tente novamente!" : "Tudo certo, custou " + custo + "\n"));
	}

	private static void addCarro() {
		String idMarca, idModelos, placa, hEntrada;
		String modeloCarro = "";
		Marca m = null;
		
		if (marcasCadastradas.size() == 0) {
			System.out.println("nenhum modelo cadastrado");
			return;
		}
		
		System.out.println("Qual a marca do carro? Essas sao as disponiveis");
		mostraMarcas();
		idMarca = scan.nextLine();
		if(isInteger(idMarca)){
			m = marcasCadastradas.get(Integer.parseInt(idMarca) - 1);
		}else{
			for (Marca marca : marcasCadastradas) {
				if(marca.getId().toLowerCase().equals(idMarca.toLowerCase())){
					m = marca;
				}
			}
		}
		
		System.out.println("Qual o modelo? Esses sao os cadastrados: ");
		if(m == null){
			System.out.println("Marca nao encontrada!");
			return;
		}
		
		mostraModelos(m);
		idModelos = scan.nextLine();
		if(isInteger(idModelos)){
			modeloCarro = m.getModelos().get(Integer.parseInt(idModelos) - 1);
		}else{
			for (String s : m.getModelos()) {
				if(s.equals(idModelos)){
					modeloCarro = idModelos;
				}
			}
		}
		
		if(modeloCarro.equals("")){
			System.out.println("Modelo nao encontrado!");
			return;
		}
		
		System.out.println("Qual a placa do carro? ");
		placa  = scan.nextLine();
		
		System.out.println("Qual a hora de entrada? ");
		hEntrada = scan.nextLine();
		
		e.addCarro(new Carro(placa, m, hEntrada, modeloCarro) );		
	}

	private static void addModelo() {
		boolean achouMarca = false, entrouId = false;
		String idMarca, idModelo;
		int i =0;
		System.out.println("Entre com a marca, essas sao as disponiveis: ");
		mostraMarcas();
		idMarca = scan.nextLine();
		
		if(isInteger(idMarca))
			entrouId = true;
		
		if(entrouId){		
			System.out.println("Entre com o modelo a ser cadastrado: ");
			idModelo = scan.nextLine();
			marcasCadastradas.get( Integer.parseInt(idMarca ) -1 ).addModelo(idModelo);
			System.out.println("OK!");
			return;
		}
		
		for (Marca marca : marcasCadastradas) {
			if(marca.getId().equals(idMarca)){
				achouMarca = true;
				break;
			}
			i++;
		}
		
		if(!achouMarca){
			System.out.println("Marca nao encontrada!");
			return;
		}
		
		System.out.println("Entre com o modelo a ser cadastrado: ");
		idModelo = scan.nextLine();
		
		marcasCadastradas.get(i).addModelo(idModelo);
		
		System.out.println("OK!");		
	}

	private static void mostraModelos(Marca m){
		int cont  = 1 ;
		for (String s : m.getModelos()) {
			System.out.println("\t" + cont +" -> " + s);
		}
		cont++;
	}
	
	private static void mostraMarcas() {
		int cont = 0;
		for (Marca m : marcasCadastradas) {
			cont++;
			System.out.println(cont + "\t->" + m.getId());
		}
	}

	private static boolean isInteger(String s){
		for (char c : s.toCharArray()) {
			if(c < '0' || c > '9')
				return false;
		}
		return true;
	}
	
	private static void addMarca() {
		System.out.println("Entre com a marca: ");
		marcasCadastradas.add(new Marca(scan.nextLine()));
	}
}
