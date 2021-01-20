package Ejercicio5;

public class Partido {

	private static final int MAX_JORNADAS = 38;
	private static final int MIN_JORNADAS = 1;
	private int jornada;
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private int golesLocal;
	private int golesVisitante;
	private char resultadoQuiniela;
	private boolean jugado;

	public Partido(int jornada, Equipo equipoLocal, Equipo equipoVisitante) throws PartidoException {
		
		setJornada(jornada);
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		jugado = false;
	}

	public void ponerResultado(String resultado) throws PartidoException {

		golesLocal = Integer.parseInt(resultado.substring(0,1));
		golesVisitante = Integer.parseInt(resultado.substring(2));
		
		if (golesLocal <0) throw new PartidoException("Goles del local tiene que ser positivo.");
		if (golesVisitante <0) throw new PartidoException("Goles del visitante tiene que ser positivo.");
		
		jugado = true;
		if (golesLocal > golesVisitante) {
			resultadoQuiniela = '1';
		} else {
			if (golesVisitante > golesLocal) {
				resultadoQuiniela = '2';
			} else {
				resultadoQuiniela = 'X';
			}
		}
	}
	
	//Setters
	private void setJornada(int jornada) throws PartidoException{
		if (jornada<MIN_JORNADAS || jornada>MAX_JORNADAS) throw new PartidoException("Jornada invalida.");
		this.jornada = jornada;
	}
	
	//Equals
	public void equals(Equipo otro) throws PartidoException{
		if (equipoLocal.equals(equipoVisitante)) throw new PartidoException("Son iguales");
	}
	
	//toString
	public String toString() {
		if (jugado) {
			return "Partido entre equipo local " + equipoLocal + " y el equipo visitante " + equipoVisitante
					+ " jugado en el estadio " + equipoLocal.getNombreEstadio() + " de la ciudad "
					+ equipoLocal.getCiudad() + " ha finalizado con " + golesLocal + " goles del equipo local y "
					+ golesVisitante + " goles del equipo visitante. Resultado quiniela = " + resultadoQuiniela;
		} else {
			return "Partido entre equipo local " + equipoLocal + " y el equipo visitante " + equipoVisitante +" todavia no se ha jugado";
		}
	}
	
	//Getters
	public int getJornada() {
		return jornada;
	}

	public Equipo getEquipoLocal() {
		return equipoLocal;
	}

	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}

	public int getGolesLocal() {
		return golesLocal;
	}

	public int getGolesVisitante() {
		return golesVisitante;
	}

	public char getResultadoQuiniela() {
		return resultadoQuiniela;
	}
}
