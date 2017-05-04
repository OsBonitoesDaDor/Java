package ex2;

import java.util.ArrayList;

import ex2.Pessoa.Cliente;
import ex2.Pessoa.Funcionario;

public class Consultorio {
	private static final String[] nomesDePacientes = {"Alberta", "Bertina", "Catarina", "Doroteia"};
	private static final String[] nomesDePlanos = {"Unimed", "Clinihauer", "Dix", "Alianca Saude"};
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	public static void main(String[] args){
		initClientes();
		Funcionario med = new Funcionario("Hipocrates", "Cardiologsta");
		System.out.println(med);
		for (int i = 0; i < clientes.size(); i++) {
			med.consultar(clientes.get(i));
		}
		
	}
	
	private static void initClientes(){
		for (int i = 0; i < nomesDePacientes.length; i++) {
			clientes.add(new Cliente(nomesDePacientes[i], nomesDePlanos[i]));
		}
	}
}
