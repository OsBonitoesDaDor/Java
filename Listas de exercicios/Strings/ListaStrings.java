import java.util.Iterator;
import java.util.Scanner;

public class ListaStrings {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args){
			ex2();
		
		
	}
	
	static void ex1(){
		String in = scan.next();
		int vet[] = new int[5];
		char[] sToC = in.toCharArray();
		char c;
		for(int i = 0; i < in.length(); i++){
			c = sToC[i];
			switch(c){
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
		}System.out.println();
		
		System.out.print("e: ");
		for (int i = 0; i < vet[1]; i++) {
			System.out.print("* ");
		}System.out.println();
		
		System.out.print("i: ");
		for (int i = 0; i < vet[2]; i++) {
			System.out.print("* ");
		}System.out.println();
		
		System.out.print("o: ");
		for (int i = 0; i < vet[3]; i++) {
			System.out.print("* ");
		}System.out.println();
		
		System.out.println("u: ");
		for (int i = 0; i < vet[4]; i++) {
			System.out.print("* ");
		}
		
	}

	static void ex2(){
		int entrada;
		String sCent = new String(), sDez = new String(), sUni= new String(), done;
		String[] vet = new String[3];
		int iCent, iDez, iUni;
		do{
			entrada = scan.nextInt();
			if(entrada < 0 || entrada > 999)
				System.out.println(" valor fornecido fora dos limites operacionais, por favos, tente novamente ");
			
		}while(entrada < 0 || entrada > 999);
		
		iCent = entrada / 100;
		iDez = (entrada / 10) %10 ;
		iUni = entrada % 10;
		
	//	System.out.printf("Centena: " + iCent + " Dezena: " + iDez + " Unidade: " + iUni);
		
		
		if(iCent >= 5){
				sCent = "D";
			if(iCent > 5)
				for(int i = iCent; i >5; i--)
					sCent += "C";
			
		}else{
			if(iCent == 4)
				sCent = "CD";
			else
				for (int i = 0; i < iCent; i++) 
					sCent += "C";	
		}
		
		///////////////////////////////////
		
		if(iDez >= 5){
			sDez = "L";
			if(iDez > 5)
				for(int i = iDez; i >5; i--)
					sDez += "X";
		
		}else{
			if(iDez == 4)
				sDez = "XL";
			else
				for (int i = 0; i < iDez; i++) 
					sDez += "X";	
		}
		
		//////////////////////////////////////////////////////
		if(iUni >= 5){
			sUni = "X";
		if(iUni > 5)
			for(int i = iUni; i >5; i--)
				sUni += "I";
		
		}else{
			if(iUni == 4)
				sUni = "IX";
			else
				for (int i = 0; i < iUni; i++) 
					sUni += "I";	
		}
		
		done = sCent +  " " + sDez + " " + sUni;
		
		System.out.println(" " + done);
		
	}
		
	
}
