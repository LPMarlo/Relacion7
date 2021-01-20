package Ejercicio2;

public class Linea {
	
	private Punto punto1;
	private Punto punto2;
	
	public Linea(Punto punto1, Punto punto2) throws LineaException{
		
		if(punto1.equals(punto2)) throw new LineaException("Error. No pueden ser 2 puntos iguales.");
		
		this.punto1 = punto1;
		this.punto2 = punto2;
	}
	
	public void moverDerecha(int num) {
		punto1.setX(punto1.getX()+num);
		punto2.setX(punto2.getX()+num);
	}
	public void moverIzquierda(int num) {
		punto1.setX(punto1.getX()-num);
		punto2.setX(punto2.getX()-num);
	}
	public void moverArriba(int num) {
		punto1.setY(punto1.getY()+num);
		punto2.setY(punto2.getY()+num);
	}
	public void moverAbajo(int num) {
		punto1.setY(punto1.getY()-num);
		punto2.setY(punto2.getY()-num);
	}

	public Punto getPunto1() {
		return punto1;
	}

	public void setPunto1(Punto punto1) {
		this.punto1 = punto1;
	}

	public Punto getPunto2() {
		return punto2;
	}

	public void setPunto2(Punto punto2) {
		this.punto2 = punto2;
	}

	public String toString() {
		return "[" + punto1 + "," + punto2 + "]";
	}
	
	
}
