import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ListaStrings {

	static Scanner scan = new Scanner(System.in);
	static Random rand = new Random();
	public static void main(String[] args) {
		ex9();

	}

	static void ex1() {
		String in = scan.next();
		int vet[] = new int[5];
		char[] sToC = in.toCharArray();
		char c;
		for (int i = 0; i < in.length(); i++) {
			c = sToC[i];
			switch (c) {
			case 'a':
				vet[0]++;
				sToC[i] = '@';
				break;
			case 'e':
				vet[1]++;
				sToC[i] = '@';
				break;
			case 'i':
				vet[2]++;
				sToC[i] = '@';
				break;
			case 'o':
				vet[3]++;
				sToC[i] = '@';
				break;
			case 'u':
				vet[4]++;
				sToC[i] = '@';
				break;
			default:

				break;
			}
		}
		String resp = new String(sToC);
		System.out.println("Frase original: " + in);
		System.out.println("Frase modificada: " + resp);

		System.out.print("a: ");
		for (int i = 0; i < vet[0]; i++) {
			System.out.print("* ");
		}
		System.out.println();

		System.out.print("e: ");
		for (int i = 0; i < vet[1]; i++) {
			System.out.print("* ");
		}
		System.out.println();

		System.out.print("i: ");
		for (int i = 0; i < vet[2]; i++) {
			System.out.print("* ");
		}
		System.out.println();

		System.out.print("o: ");
		for (int i = 0; i < vet[3]; i++) {
			System.out.print("* ");
		}
		System.out.println();

		System.out.println("u: ");
		for (int i = 0; i < vet[4]; i++) {
			System.out.print("* ");
		}

	}

	static void ex2() {
		int entrada;
		String sCent = new String(), sDez = new String(), sUni = new String(), done;
		//String[] vet = new String[3];
		int iCent, iDez, iUni;
		do {
			entrada = scan.nextInt();
			if (entrada < 0 || entrada > 999)
				System.out.println(" valor fornecido fora dos limites operacionais, por favos, tente novamente ");

		} while (entrada < 0 || entrada > 999);

		iCent = entrada / 100;
		iDez = (entrada / 10) % 10;
		iUni = entrada % 10;

		// System.out.printf("Centena: " + iCent + " Dezena: " + iDez + "
		// Unidade: " + iUni);

		if (iCent >= 5) {
			sCent = "D";
			if (iCent > 5)
				for (int i = iCent; i > 5; i--)
					sCent += "C";

		} else {
			if (iCent == 4)
				sCent = "CD";
			else
				for (int i = 0; i < iCent; i++)
					sCent += "C";
		}

		///////////////////////////////////

		if (iDez >= 5) {
			sDez = "L";
			if (iDez > 5)
				for (int i = iDez; i > 5; i--)
					sDez += "X";

		} else {
			if (iDez == 4)
				sDez = "XL";
			else
				for (int i = 0; i < iDez; i++)
					sDez += "X";
		}

		//////////////////////////////////////////////////////
		if (iUni >= 5) {
			sUni = "X";
			if (iUni > 5)
				for (int i = iUni; i > 5; i--)
					sUni += "I";

		} else {
			if (iUni == 4)
				sUni = "IX";
			else
				for (int i = 0; i < iUni; i++)
					sUni += "I";
		}

		done = sCent + " " + sDez + " " + sUni;

		System.out.println(" " + done);

	}

	static void ex3() {
		StringBuilder builder = new StringBuilder();
		int entrada, iCent, iDez, iUni;
		
		do {
			entrada = scan.nextInt();
			if (entrada < 0 || entrada > 999)
				System.out.println(" valor fornecido fora dos limites operacionais, por favos, tente novamente ");

		} while (entrada < 0 || entrada > 999);

		// Ans: String concatenada. entrs:centena[0], dezena[1] e unidade[2] do
		// valor inserido em string
		String  entrs[] = new String[3];
		iCent = entrada / 100;
		iDez = (entrada / 10) % 10;
		iUni = entrada % 10;

		//
		switch (iCent) {
		case 0:
			entrs[0] = "";
			break;
		case 1:
			if (iDez == 0 && iUni == 0)
				entrs[0] = "Cem";
			else
				entrs[0] = "Cento";

			break;
		case 2:
			entrs[0] = "Duzentos";
			break;
		case 3:
			entrs[0] = "Trezentos";
			break;
		case 4:
			entrs[0] = "Quatrocentos";
			break;
		case 5:
			entrs[0] = "Quinhentos";
			break;
		case 6:
			entrs[0] = "Seiscentos";
			break;
		case 7:
			entrs[0] = "Setecentos";
			break;
		case 8:
			entrs[0] = "Oitocentos";
			break;
		case 9:
			entrs[0] = "Novecentos";
			break;
		}

		if (iDez != 0  && iCent != 0) {
			entrs[0] = entrs[0] + " e ";
		}

		switch (iDez) {
		case 0:
			entrs[1] = "";
			break;
		case 1:
			switch (iUni) {
			case 1:
				entrs[2] = "onze.";
				break;
			case 2:
				entrs[2] = "doze.";
				break;
			case 3:
				entrs[2] = "treze.";
				break;
			case 4:
				entrs[2] = "quatorze.";
				break;
			case 5:
				entrs[2] = "quinze.";
				break;
			case 6:
				entrs[2] = "dezesseis.";
				break;
			case 7:
				entrs[2] = "dezessete.";
				break;
			case 8:
				entrs[2] = "dezoito.";
				break;
			case 9:
				entrs[2] = "dezenove.";
				break;
			}
			break;
		case 2:
			entrs[1] = "vinte";
			break;
		case 3:
			entrs[1] = "trinta";
			break;
		case 4:
			entrs[1] = "quarenta";
			break;
		case 5:
			entrs[1] = "cinquenta";
			break;
		case 6:
			entrs[1] = "sessenta";
			break;
		case 7:
			entrs[1] = "setenta";
			break;
		case 8:
			entrs[1] = "oitenta";
			break;
		case 9:
			entrs[1] = "noventa";
			break;
		}
		
		if (iUni != 0 &&  iDez != 0) {
			entrs[1] = entrs[1] + " e ";
		}

		switch (iUni) {
		case 0:
			entrs[2] = "";
			break;		
		case 1:
			entrs[2] = "um";
			break;
		case 2:
			entrs[2] = "dois.";
			break;
		case 3:
			entrs[2] = "tres.";
			break;
		case 4:
			entrs[2] = "quatro.";
			break;
		case 5:
			entrs[2] = "cinco.";
			break;
		case 6:
			entrs[2] = "seis.";
			break;
		case 7:
			entrs[2] = "sete.";
			break;
		case 8:
			entrs[2] = "oito.";
			break;
		case 9:
			entrs[2] = "nove.";
			break;

		}
		
		for (int i = 0; i < entrs.length; i++) {
			builder.append(entrs[i]);
		}
		
		System.out.println(builder.toString());

	}

	
	//	TERMINAAAAAAR
	static void ex4(){
		String[] conjPres = new String[6];
		String[] conjPret = new String[6];
		String verbo = scan.next();
		StringBuilder builder = new StringBuilder();
		char vogalTematica = verbo.charAt(verbo.length() - 1);
		String rad;
		for(int i = 0; i < verbo.length() - 1; i ++){
			builder.append(verbo.charAt(i));
		}
		rad = builder.toString();
		
		if(vogalTematica == 'a'){
			conjPres[0] =rad + "o" ;
			conjPres[1] =rad + "as" ;
			conjPres[2] =rad + "a" ;
			conjPres[3] =rad + "amos" ;
			conjPres[4] =rad + "ais" ;
			conjPres[5] =rad + "am" ;

			conjPret[0] =rad + "ei" ;
			conjPret[1] =rad + "aste" ;
			conjPret[2] =rad + "ou" ;
			conjPret[3] =rad + "amos" ;
			conjPret[4] =rad + "astes" ;
			conjPret[5] =rad + "aram" ;
			
		}else if(vogalTematica == 'e'){
			conjPres[0] =rad + "o" ;
			conjPres[1] =rad + "es" ;
			conjPres[2] =rad + "e" ;
			conjPres[3] =rad + "emos" ;
			conjPres[4] =rad + "eis" ;
			conjPres[5] =rad + "em" ;

			conjPret[0] =rad + "i" ;
			conjPret[1] =rad + "este" ;
			conjPret[2] =rad + "eu" ;
			conjPret[3] =rad + "emos" ;
			conjPret[4] =rad + "estes" ;
			conjPret[5] =rad + "eram" ;
		}else if(vogalTematica == 'i'){
			conjPres[0] =rad + "o" ;
			conjPres[1] =rad + "es" ;
			conjPres[2] =rad + "e" ;
			conjPres[3] =rad + "imos" ;
			conjPres[4] =rad + "is" ;
			conjPres[5] =rad + "em" ;

			conjPret[0] =rad + "i" ;
			conjPret[1] =rad + "iste" ;
			conjPret[2] =rad + "iu" ;
			conjPret[3] =rad + "imos" ;
			conjPret[4] =rad + "istes" ;
			conjPret[5] =rad + "iram" ;
		}
		System.out.println("Verbo: " + verbo);
		System.out.println("Conjugacao do presente: ");
		for (int i = 0; i < conjPres.length; i++) {
			System.out.println(conjPres[i]);
		}
		System.out.println("Conjugacao do preterito: ");
		for (int i = 0; i < conjPret.length; i++) {
			System.out.println(conjPres[i]);
		}
	}
	
	static void ex5(){
		boolean gameOver = false, achouLetra = false;
		int vidas = 6, rounds = 0;
		char entr;
		String comidas[] = {"batata", "churrasco", "macarrao", "empadao", "sorvete", "torta", "chocolate"};
		char[] resp = comidas[rand.nextInt(comidas.length - 1)].toCharArray(), tabuleiro = new char[(resp.length )],
			   jaForam = new char[resp.length + 6];
		for (int i = 0; i < tabuleiro.length; i+=1) {
			tabuleiro[i] = '_';
		}
		
		//O jogo roda enquanto nao acaba
		do{
			
			System.out.println("Entre com uma letra: " + "VIdas:" +vidas );
			System.out.println();
			System.out.println(new String(tabuleiro));
			entr = scan.next().toCharArray()[0];
			for (int i = 0; i < resp.length; i++) {
				if(resp[i] == entr){
					tabuleiro[i] = entr;
					achouLetra = true;
				}
			}
			jaForam[rounds] = entr;
			if(!achouLetra)
				vidas --;
		
			if(vidas == 0 ){
				gameOver = true;
				System.out.println("Voce perdeu! A palava era " + new String(resp) );
			}
			
			achouLetra = false;
			if(Arrays.equals(resp, tabuleiro)){
				gameOver = true;
				System.out.println("Voce Ganhou!! A palavra era " + new String(resp));
			}
			
		}while(!gameOver);
	}
	
	static void ex6(){
		StringBuilder builder = new StringBuilder();
		int numAtomico = scan.nextInt();
		char defPeso = ' ';
		String[] tabela = {"1 s2", "2 s2", "2 p6", "3 s2"," 3 p6","4 s2", "3 d10","4 p6", 
						   "5 s2", "4 d10","5 p6", "6 s2", "4 f14", "5 d10", "6 p6", 
						   " 7 s2", "5 f14", "6 d10","7 p6" };
		
		for(int peso = 0, i = 0; peso < numAtomico && i < tabela.length; i++){
			builder.append(tabela[i]);
			
			for (int j = 0; j < tabela[i].length(); j++) {
				if(tabela[i].charAt(j) > '9' ){
					defPeso = tabela[i].toCharArray()[j];
					//System.out.println(tabela[i].toCharArray()[j]);
				}
			}
			
			switch(defPeso){
			case 's':
				peso += 2;
				break;
			case 'p':
				peso += 6;
				break;
			case 'd':
				peso += 10;
				break;
			case 'f':
				peso += 14;
				break;
			}
			
			builder.append(" -- ");
		}
		
		System.out.println(builder.toString());
		
		
		
	}
	
	static void ex7(){
		String entr = scan.nextLine();
		StringBuilder builder = new StringBuilder();
		char c;
		for (int i = 0; i < entr.length(); i++) {
			c = entr.charAt(i);
			switch(c){
			case ' ':
				builder.append(' ');
				break;
			case 'a':
				builder.append("4");
				break;
			case 'b':
				builder.append("ß");
				break;
			case 'c':
				builder.append("¢");
				break;
			case 'd':
				builder.append("[)");
				break;
			case 'e':
				builder.append("€");
				break;
			case 'f':
				builder.append("|=");
				break;
			case 'g':
				builder.append("6");
				break;
			case 'h':
				builder.append("#");
				break;
			case 'i':
				builder.append("|");
				break;
			case 'j':
				builder.append(";");
				break;
			case 'K':
				builder.append("|{");
				break;
			case 'l':
				builder.append("|_");
				break;
			case 'm':
				builder.append("/\\/\\");
				break;
			case 'n':
				builder.append("/\\/");
				break;
			case 'o':
				builder.append('0');
				break;
			case 'p':
				builder.append("|^");
				break;
			case 'q':
				builder.append("9");
				break;
			case 'r':
				builder.append("Я");
				break;
			case 's':
				builder.append("$");
				break;
			case 't':
				builder.append("+");
				break;
			case 'u':
				builder.append("|_|");
				break;
			case 'v':
				builder.append("\\/");
				break;
			case 'w':
				builder.append("\\/\\/");
				break;
			case 'x':
				builder.append("Ж");
				break;
			case 'y':
				builder.append(" ¥");
				break;
			case 'z':
				builder.append("2");
				break;
			}
		}
	
		System.out.println("Frase inserida: " + entr);
		System.out.println("Frase em |33t: " + builder.toString());
	
	}
	static void ex8(){
		String[] numeros = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}, naipes = {"E", "C", "O", "P"} ;
		String[] baralho = new String[numeros.length * naipes.length];
		String temp;
		int randInd;
		for (int i = 0; i < naipes.length; i++) {
			for (int j = 0; j < numeros.length; j++) {
				String string = numeros[j];
				//System.out.print(string + naipes[i] +  ", ");
				baralho[ ( (i*numeros.length) + j)] = numeros[j] + naipes[i];
				
			}
			System.out.println();
		}
	
		for (int i = 0; i < baralho.length; i++) {
			System.out.print(baralho[i] + ", ");
			if(i % 13 == 0 && i != 0)
				System.out.println();
		}
		System.out.println();
		System.out.println("-----------------------------");
		for (int i = 0; i < baralho.length; i++) {
			randInd = rand.nextInt(baralho.length);
			temp = baralho[randInd];
			baralho[randInd] = baralho[i];
			baralho[i] = temp;
		}
		
		for (int i = 0; i < baralho.length; i++) {
			System.out.print(baralho[i] + ", ");
			if(i % 13 == 0 && i != 0)
				System.out.println();
		}
	
	}

	static void ex9(){
		System.out.println("Quantas pessoas tem na sua familia? ");
		int num = scan.nextInt();
		String familia[] = new String[num], menorVal, das;
		int posMenorVal;
		System.out.println("Serio? Quem sao elas?");
		for (int i = 0; i < familia.length; i++) {
			familia[i] = scan.next();
		}
		
		for (int i = 0; i < familia.length; i++) {
			menorVal = familia[i];
			posMenorVal = i;
			for (int j = i; j < familia.length; j++) {
				if ( menorVal.compareToIgnoreCase(familia[j]) > 0) {
					menorVal = familia[j];
					posMenorVal = j;
				}
			}
			
			das = familia[i];
			familia[i] = menorVal;
			familia[posMenorVal] = das;
			
		}

		for (int i = 0; i < familia.length; i++) {
			System.out.println(familia[i]);
		}
	}



	static void ex10(){
		String cpfCru =  scan.next();
		StringBuilder cpfDigts = new StringBuilder();
		int temp = 0, tempo;
		int cpf;
		int digitoDigitado = (int) (cpfCru.toCharArray()[cpfCru.length() - 1]) - 48;
		int[] valoresCpf;
		char c;
		for (int i = 0; i < cpfCru.length(); i++) {
			c = cpfCru.charAt(i);
			if(c >= 48 && c <= '9')
				cpfDigts.append(c);
			
		}
		valoresCpf = new int[cpfDigts.length() - 1];
		for (int i = 0; i < valoresCpf.length - 1; i++) {
			tempo = cpfDigts.toString().toCharArray()[i] - 48;
		//	System.out.print(tempo + " ");
			valoresCpf[i] = tempo;
		}
		for (int i = 0,  j = 7; i < valoresCpf.length; i++, j--) {
			temp += valoresCpf[i] * j;
		}
		cpf = 11 - (temp % 11);
		//System.out.println();
	//	System.out.println(digitoDigitado + "   " + cpfDigts.toString() +  "     " + cpf);

		if(digitoDigitado == cpf)
			System.out.println("Válido!!");
		else
			System.out.println("CPF Invalido");
	}

}
	
	
