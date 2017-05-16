package utils;

import java.util.Scanner;

public class Entrada {
	
	/**
	 * @return Proxima palavra digitada pelo usuario
	 */
	public String next(){
		Scanner scan = new Scanner(System.in);
		return scan.next();
	}
	
	/**
	 * @return Proxima linha digitada pelo usuario
	 */
	public String nextLine(){
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
	
	/**
	 * @return Proximo int digitado pelo usuario
	 */	
	public int getInt(){
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
	

	/**
	 * @return Proximo float digitado pelo usuario
	 */	
	public float nextFloat(){
		Scanner scan = new Scanner(System.in);
		return scan.nextFloat();
	}
	

	/**
	 * @return Proximo double digitado pelo usuario
	 */	
	public double nextDouble(){
		Scanner scan = new Scanner(System.in);
		return scan.nextDouble();
	}
	
	/**
	 * 
	 * @return Proximo boolean digitado
	 */
	public boolean nextBoolean(){
		Scanner scan = new Scanner(System.in);
		return scan.nextBoolean();
	}
}
