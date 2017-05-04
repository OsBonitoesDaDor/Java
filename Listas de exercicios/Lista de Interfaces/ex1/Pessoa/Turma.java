package ex1;

import java.util.ArrayList;

import ex1.Pessoa.Aluno;
import ex1.Pessoa.Professor;

public class Turma {
	private static final String[] nomeDosAlunos = {" Marie Curie", " Niels Bohr", "Alan Turing", " Charles Darwin", "Georg Hegel"};
	private static final String[] discDosAlunos = { " Fisica", "Quimica", "Matematica", "Biologia", "Historia"};
	private static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	
	public static void main(String[] args){
		initAlunos();
		Professor p = new Professor("Socrates", "Filosofia");
		System.out.println(p);
		for (int i = 0; i < alunos.size(); i++) 
			p.tirarDuvida(alunos.get(i));
	}
	
	
	private static void initAlunos(){
		for (int i = 0; i < nomeDosAlunos.length; i++) {
			alunos.add(new Aluno(nomeDosAlunos[i], discDosAlunos[i]));
		}
	}

}
