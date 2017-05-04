package ex1.Pessoa;

import ex1.Interfaces.IDocente;

public class Professor extends Pessoa implements IDocente {

	private String disciplina;

	public Professor(String nome, String disciplina) {
		super(nome);
		this.disciplina = disciplina;
	}

	public void tirarDuvida(Aluno a) {
		//System.out.println(this.getNome() + " tirando duvida de " + a.getNome() + " do assunto " + a.getCurso());
		System.out.printf("%s, tirando duvida de %s, do assunto %s\n", this.getNome(), a.getNome(), a.getCurso());
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getDisciplina() {
		return disciplina;
	}
	
	@Override
	public String toString(){
		return String.format("Ola, sou o %s, professor de %s\n", this.getNome(), this.getDisciplina());
	}
}
