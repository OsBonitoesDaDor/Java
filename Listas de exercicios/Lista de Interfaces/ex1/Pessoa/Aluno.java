package ex1.Pessoa;

public class Aluno extends Pessoa{

	private String curso;
	
	public Aluno(String nome, String curso) {
		super(nome);
		this.curso = curso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	

}
