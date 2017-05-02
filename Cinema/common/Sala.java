package common;

import java.sql.Time;
import java.util.Calendar;

//Classe de uma sala de cinema
	@SuppressWarnings("deprecation")
public class Sala {
	private Filme filme;
	private Calendar horario = Calendar.getInstance();
	private String id;
	//private ArrayList<String> horarios = new ArrayList<String>();
	private String[] horarios;
	public Sala(Filme filme, Calendar horario, String id){
		this.filme = filme;
		horario.add(Calendar.HOUR_OF_DAY, horario.get(Calendar.HOUR_OF_DAY));
		horario.add(Calendar.MINUTE, horario.get(Calendar.MINUTE));
		this.id = id;
	}

	public Sala(Filme filme, Time foo, String id) {
		this.filme = filme;
		this.id = id;
		horario.add(Calendar.HOUR_OF_DAY, foo.getHours());
		horario.add(Calendar.MINUTE, foo.getMinutes());
		initHorarios();
	}
	
	private void initHorarios(){
		Calendar base = Calendar.getInstance();
		StringBuilder builder = new StringBuilder("");
		base.add(Calendar.HOUR_OF_DAY, horario.get(Calendar.HOUR_OF_DAY));base.add(Calendar.MINUTE, horario.get(Calendar.MINUTE));base.add(Calendar.DAY_OF_MONTH, 1);	
		do{
			builder.append( (base.get(Calendar.HOUR_OF_DAY) < 10 ? "0"+ base.get(Calendar.HOUR_OF_DAY) : base.get(Calendar.HOUR_OF_DAY)) + ":" + (base.get(Calendar.MINUTE) < 10 ? "0" + base.get(Calendar.MINUTE) : base.get(Calendar.MINUTE)) + " - ");
			base.add(Calendar.HOUR_OF_DAY, filme.getDuracao().getHours());base.add(Calendar.MINUTE, filme.getDuracao().getMinutes());
		
		}while(!(base.get(Calendar.HOUR_OF_DAY) >= 1 && base.get(Calendar.HOUR_OF_DAY) <= 6));
		
		horarios = builder.toString().split(" - ");
	}
	
	private String getHorarios(){
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < horarios.length; i++) {
			builder.append(horarios[i] + " - ");
		}
		builder.delete(builder.length() - 2, builder.length());
		
		return builder.toString();
	}

	public Filme getFilme(){
		return this.filme;
	}
	
	public String getId(){
		return this.id;
	}
	@Override
	public String toString(){
		return "Sala " +  id + ":\t " + this.filme.getNome() +"\n\t Sessoes: " + getHorarios();
	}
}
