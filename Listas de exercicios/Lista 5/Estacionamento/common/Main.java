package common;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	private static ArrayList<String> marcasCadastradas = new ArrayList<String>();
	private static ArrayList<Modelo> modelosCadastrados = new ArrayList<Modelo>();
	
	private static String[] opcoesDoMenu = {"1", "Cadastrar Marca", "2", "Cadastrar Modelo", "3", "Cadastrar entrada de um novo carro", "4", "Mostrar estacionamento", "5", "Retirar carro", "6", "Sair"};
	private static Menu menu;
	
	private static Estacionamento e;
	
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String args[]){
		menu = new Menu(opcoesDoMenu);
		e = new Estacionamento();
		do{
			menu.drawMenu();
			switch(menu.getInput()){
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
		}while(true);
				
	}
	
	private static void retiraCarro(){
		String entr, horaSaida;
		float custo;
		System.out.println("Me informe a placa ou o ID da vaga");
		entr = scan.nextLine();
		System.out.println("Que horas saiu?");
		horaSaida = scan.nextLine();
		if(entr.length() == 2)
			custo = e.tiraCarro(Integer.valueOf(entr), horaSaida);
		else{
			custo = e.tiraCarro(entr, horaSaida);
		}
		System.out.printf( "%s", (custo <= 0 ? "Erro nos dados, tente novamente!" : "Tudo certo, custou" + custo)  );
	}
	
	private static void addCarro(){
		String op, placa;
		Modelo m;
		System.out.println("Qual o modelo do carro? Estes sao os cadastrados: ");
		mostraModelos();
		op = scan.nextLine();
		m = modelosCadastrados.get(1 - Integer.valueOf(op));
		System.out.println("Qual a placa do carro? ");
		placa = scan.nextLine();
		System.out.println("Qual a hora de chegada do carro?");
		op = scan.nextLine();
		e.addCarro(new Carro(placa, m, op));
	}
	
	private static void addModelo(){
		String marca;
		System.out.println("Qual a marca? Essas sao as disponiveis: ");
		mostraMarcas();
		marca = scan.nextLine();
		System.out.println("Qual o modelo do carro?");
		modelosCadastrados.add(new Modelo(scan.nextLine(), marca));	
	}
	
	private static void mostraModelos(){
		int cont = 0;
		for (Modelo m : modelosCadastrados) {
			cont++;
			System.out.println(cont + "->" + m);
		}
		
	}
	
	private static void mostraMarcas(){
		int cont = 0;
		for (String string : marcasCadastradas) {
			cont++;
			System.out.println(cont + "\t->" + string);
		}
	}
	
	private static void addMarca(){
		System.out.println("Entre com a marca: " );
		marcasCadastradas.add(scan.nextLine());
	}
}
