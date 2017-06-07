package common.user;

import java.io.Serializable;

import common.Pessoa;
import common.Interfaces.ICliente;
//TODO: NADAAAAA
//O proposito dessa classe e diferenciar o usuario do autor de um livro
public class UsuarioGenerico extends Pessoa implements ICliente{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6546865030694575521L;
	private int id;
	
	public UsuarioGenerico(String nome, String cpf, int id) {
		super(nome, cpf);
		this.id = id;
	}
	
	@Override
	public String toString(){
		return "ID: " + id + "=>" + super.toString() ;
	}
}
