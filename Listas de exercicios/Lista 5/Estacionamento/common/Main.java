package common;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static ArrayList<String> marcasCadastradas = new ArrayList<String>();
	private static ArrayList<Modelo> modelosCadastrados = new ArrayList<Modelo>();

	private static String[] opcoesDoMenu = { "1", "Cadastrar Marca", "2", "Cadastrar Modelo", "3",
			"Cadastrar entrada de um novo carro", "4", "Mostrar estacionamento", "5", "Retirar carro", "6", "Sair" };
	private static Menu menu;

	private static Estacionamento e;

	private static Scanner scan = new Scanner(System.in);

	public static void main(String args[]) {
		menu = new Menu(opcoesDoMenu);
		e = new Estacionamento();
		initTestes();
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

	private static void initTestes() {
		marcasCadastradas.add("Honda");
		marcasCadastradas.add("Chrevolet");
		marcasCadastradas.add("Fiat");
		marcasCadastradas.add("Ford");
		modelosCadastrados.add(new Modelo("XRE 300", "Honda"));
		modelosCadastrados.add(new Modelo("Celta", "Chrevolet"));
		modelosCadastrados.add(new Modelo("Uno", "Fiat"));
		modelosCadastrados.add(new Modelo("Ka", "Ford"));
	}

	private static void retiraCarro() {
		String entr, horaSaida;
		float custo;
		System.out.println("Me informe a placa ou o ID da vaga");
		entr = scan.nextLine();
		System.out.println("Que horas saiu?");
		horaSaida = scan.nextLine();
		if(isInteger(entr))
			custo = e.tiraCarro(Integer.valueOf(entr), horaSaida);
		else 
			custo = e.tiraCarro(entr, horaSaida);
		
		System.out.printf("%s", (custo <= 0 ? "Erro nos dados, tente novamente!" : "Tudo certo, custou" + custo));
	}

	private static boolean isInteger(String s) {
		for (char c : s.toCharArray())
			if (c < '0' || c > '9')
				return false;

		return true;
	}

	private static void addCarro() {
		String op, placa;
		Modelo m;
		System.out.println("Qual o modelo do carro? Estes sao os cadastrados: ");
		mostraModelos();
		op = scan.nextLine();
		m = modelosCadastrados.get(Integer.valueOf(op) - 1);
		System.out.println("Qual a placa do carro? ");
		placa = scan.nextLine();
		System.out.println("Qual a hora de chegada do carro?");
		op = scan.nextLine();
		e.addCarro(new Carro(placa, m, op));
	}

	private static void addModelo() {
		boolean inseriuId = true, achouMarca = false;
		String marca;
		System.out.println("Qual a marca? Essas sao as disponiveis: ");
		mostraMarcas();
		marca = scan.nextLine();

		// Checa se a entrada foi um numero um o nome da marca, se tem letra
		// fode
		for (char c : marca.toCharArray()) {
			if (c > '9' || c < '0') {
				inseriuId = false;
				break;
			}
		}

		if (inseriuId)
			marca = marcasCadastradas.get(Integer.parseInt(marca) - 1);
		else {
			// O for e o if checam se a marca existe
			for (String s : marcasCadastradas) {
				if (s.equals(marca)) {
					achouMarca = true;
					break;
				}
			}
			if (!achouMarca) {
				System.out.println("Marca invalida! Tente novamente");
				return;
			}

		}
		System.out.println("Qual o modelo do carro?");
		modelosCadastrados.add(new Modelo(scan.nextLine(), marca));
	}

	private static void mostraModelos() {
		int cont = 0;
		for (Modelo m : modelosCadastrados) {
			cont++;
			System.out.println(cont + "->" + m);
		}

	}

	private static void mostraMarcas() {
		int cont = 0;
		for (String string : marcasCadastradas) {
			cont++;
			System.out.println(cont + "\t->" + string);
		}
	}

	private static void addMarca() {
		System.out.println("Entre com a marca: ");
		marcasCadastradas.add(scan.nextLine());
	}
}
