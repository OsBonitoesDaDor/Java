package utils;

import java.util.Scanner;

public class Entrada {
	
	/**
	 * @return Proxima palavra digitada pelo usuario
	 */
	public String getNext(){
		Scanner scan = new Scanner(System.in);
		return scan.next();
	}
	
	/**
	 * @return Proxima linha digitada pelo usuario
	 */
	public String getNextLine(){
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
	public float getFloat(){
		Scanner scan = new Scanner(System.in);
		return scan.nextFloat();
	}
	

	/**
	 * @return Proximo double digitado pelo usuario
	 */	
	public double getDouble(){
		Scanner scan = new Scanner(System.in);
		return scan.nextDouble();
	}
	
	/**
	 * 
	 * @return Proximo boolean digitado
	 */
	public boolean getBoolean(){
		Scanner scan = new Scanner(System.in);
		return scan.nextBoolean();
	}
}
