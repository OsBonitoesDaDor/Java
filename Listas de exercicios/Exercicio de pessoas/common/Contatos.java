package common;

import java.util.ArrayList;

public class Contatos {

	ArrayList<Pessoa> contatos = new ArrayList<Pessoa>();
	
	public void addPessoa(Pessoa p){
		contatos.add(p);
	}
	
	public void delPessoa(Pessoa p){
		contatos.remove(p);
	}
	
	public int getArrayLenght(){
		return contatos.size();
	}
	
	public Pessoa contatoAt(int index){
		return contatos.get(index);
	}
	
	public ArrayList<Pessoa> getContatos(){
		return this.contatos;
	}
}
