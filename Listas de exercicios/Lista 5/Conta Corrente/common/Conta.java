package common;

import java.util.ArrayList;
import java.util.Scanner;

import external.Menu;

public class Conta {

	private static Scanner scan = new Scanner(System.in);

	private static ArrayList<Operacao> operacoesRealizadas = new ArrayList<Operacao>();

	private static final String[] opcoesDoMenu = { "1", "Incluir deposito", "2", "Incluir saque", "3",
			"Incluir pgto com cartao", "4", "Incluir pgto com cheque", "5", "Mostrar saldo", "6", "Sair" };
	private static Menu menu = new Menu(opcoesDoMenu);

	public static void main(String args[]) {

		operacoesRealizadas.add(new Operacao("deposito", 3000F, "12/12/12"));
		operacoesRealizadas.add(new Operacao("saque", 200F, "9/12/12"));
		operacoesRealizadas.add(new Operacao("cartao", 1000F, "15/12/12"));
		operacoesRealizadas.add(new Operacao("cheque", 1500F, "22/12/12"));
		for (Operacao op : operacoesRealizadas) {
			System.out.println(op);
		}
		do {
			menu.drawMenu();
			switch (menu.getInput()) {
			case 1:
				incluiOp("deposito");
				break;
			case 2:
				incluiOp("saque");
				break;
			case 3:
				incluiOp("cartao");
				break;
			case 4:
				incluiOp("cheque");
				break;
			case 5:
				mostraSaldo();
				break;
			case 6:
				return;
			}
		} while (true);
	}

	private static void incluiOp(String op) {
		float valor;
		String data;
		System.out.printf("Entre com o valor do %s: \n", op);
		valor = scan.nextFloat();
		System.out.printf("Entre com a data do %s: \n", op);
		data = scan.nextLine();
		data = scan.nextLine();

		operacoesRealizadas.add(new Operacao(op, valor, data));
	}

	private static float saldoNoMes(int mes) {
		float entrada = 0, saida = 0;
		if (mes <= 0 || mes >= 13) {
			System.out.println("Mes invalido! Tente novamente");
			return 0F;
		}

		for (Operacao o : operacoesRealizadas) {
			if (o.getMes() != mes)
				continue;
			if (! o.getId().equals("deposito")) {
				saida += o.getQuantidade();
			} else {
				entrada += o.getQuantidade();
			}
			System.out.println(o);
		}

		return entrada - saida;
	}

	private static void mostraSaldo() {
		boolean mesPorNumero = true;
		String entrada;
		int mes1, mes2;
		float res = 0;
		System.out.println(
				"Entre com o mes a ser analizado, ou com 2 meses para analizar um período (separe os meses por espaco)");
		entrada = scan.nextLine();

		// Esse for checa se o usuario entrou o nome do mes (Janeiro) ou o
		// numero(1)
		for (char c : entrada.toCharArray()) {
			if (c < '0' || c > '9') {
				mesPorNumero = false;
			}
		}
	//Esse if inicializa os meses
		if(mesPorNumero){
			if(entrada.contains(" ")){
				mes1 = Integer.parseInt(entrada.split(" " )[0]);
				mes2 = Integer.parseInt(entrada.split(" ")[1]);
			}else{
				mes1 = Integer.parseInt(entrada);
				mes2 = mes1;
			}
		}else{
			if(entrada.contains(" ")){
				mes1 = mesToInt(entrada.split(" ")[0]);
				mes2 = mesToInt(entrada.split(" ")[1]);
			}else{
				mes1 = mesToInt(entrada);
				mes2 = mes1;
			}
		}
		
		if(mes1 == mes2){
			res = saldoNoMes(mes1);
			System.out.println("----------------------------------------------------------------");
			System.out.println("O saldo no mes foi de " + res);
		}else{
			if(mes1 > mes2){
				for (int i = mes1; i < mes2; i++) {
					res += saldoNoMes(i);
					System.out.println("----------------------------------------------------------------");
				}
			}else{
				for (int i = mes2; i < mes1; i++) {
					res += saldoNoMes(i);
					System.out.println("----------------------------------------------------------------");
				}
			}
			System.out.println("O saldo nesses meses foi de " + res);
		}

	}

	private static int mesToInt(String mes) {
		switch (mes.toLowerCase()) {
		case "janeiro":
			return 1;
		case "fevereiro":
			return 2;
		case "marco":
			return 3;
		case "abril":
			return 4;
		case "maio":
			return 5;
		case "junho":
			return 6;
		case "julho":
			return 7;
		case "agosto":
			return 8;
		case "setembro":
			return 9;
		case "outubro":
			return 10;
		case "novembro":
			return 11;
		case "dezembro":
			return 12;
		}
		return 0;
	}
}
