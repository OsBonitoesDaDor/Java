package common;

public class Sessao {

	public static final int MAX_FIL = 20, MAX_COL = 10;
	
	private String nome;
	private int horario;
	private Cadeira[][] cadeiras = new Cadeira[MAX_FIL][MAX_COL];

	public Sessao(String nome, int horario) {
		initCadeiras();
		this.nome = nome;
		this.horario = horario;
	}
	
	public Cadeira[][] getCadeiras() {
		return cadeiras;
	}

	public void printCadeiras(){
		Cadeira c;
		System.out.println("  \t1\t2\t3\t4\t5\t6\t7\t8\t9\t10");
		for (int i = 0; i < cadeiras.length; i++) {
			System.out.printf( "%s\t", Character.valueOf( (char) ((i)  + 'A') ) );
			for (int j = 0; j < cadeiras[i].length; j++) {
				c = cadeiras[i][j];
				System.out.printf(" " + (c.isOcupada() ? "XX" : c.getId()) + "\t");
			}
			System.out.println();
		}
	}
	
	private void initCadeiras(){
		char fil = 'A';
		for (int i = 0; i < cadeiras.length; i++) {
			
			for (int j = 0; j < cadeiras[i].length; j++) {
				
				cadeiras[i][j] = new Cadeira(fil + "" + (j + 1), false);
			}
			fil++;
		}
	}
	


	public int getHorario() {
		return horario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setHorario(int horario) {
		this.horario = horario;
	}

	
}
