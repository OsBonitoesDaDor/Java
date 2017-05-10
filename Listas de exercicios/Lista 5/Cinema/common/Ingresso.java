package common;

public class Ingresso {
	private String nomeDoDono, cadeira;
	private boolean doador = false, estudante = false;
	private int sala, horario;
	
	public Ingresso(String nomeDoDono, int idPreco, int sala, int horario, String cadeira) {
		this.nomeDoDono = nomeDoDono;
		this.cadeira = cadeira;
		this.sala = sala;
		this.horario = horario;
		switch(idPreco){
		case 1:
			doador = true;
			break;
		case 2:
			estudante = true;
			break;
		}
	}

	public int getSala() {
		return sala;
	}

	public void setSala(int sala) {
		this.sala = sala;
	}

	public int getHorario() {
		return horario;
	}

	public void setHorario(int horario) {
		this.horario = horario;
	}

	public String getNomeDoDono() {
		return nomeDoDono;
	}

	public void setNomeDoDono(String nomeDoDono) {
		this.nomeDoDono = nomeDoDono;
	}

	public String getCadeira() {
		return cadeira;
	}

	public void setCadeira(String cadeira) {
		this.cadeira = cadeira;
	}

	public boolean isMeia(){
		return doador || estudante;
	}

	@Override
	public String toString(){
		return String.format("Dono: %s, %s na sala %d as %dh", this.nomeDoDono, (estudante || doador ? "pagou meia entrada" : ""), this.sala, this.horario);
	}
}
