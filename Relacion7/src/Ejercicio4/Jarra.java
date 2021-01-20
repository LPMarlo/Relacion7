package Ejercicio4;

public class Jarra {
	
	//Atributos
	private int capacidad;
	private int cantidad = 0;
	private static int aguaConsumida;

	//Constructor
	public Jarra(int capacidad) throws JarraException {
		setCapacidad(capacidad);
	}
	
	//Metodos
	public String toString() {
		return "[Capacidad=" + capacidad + ", cantidad=" + cantidad + "]";
	}
	
	public void setCapacidad(int capacidad) throws JarraException {

		if (capacidad <= 0) throw new JarraException("Capacidad no valida.");
		this.capacidad = capacidad;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public int getCantidad() {
		return cantidad;
	}
	
	public void llenar() {
		int llenado = capacidad - cantidad;
		
		aguaConsumida += llenado;	
		cantidad += llenado;
	}
	
	public void vaciar() {
		this.cantidad = 0;
	}
	
	public int getTotalAguaConsumida() {
		return aguaConsumida;
	}
	
	public void volcar(Jarra otra) throws JarraException{
		
		if (otra.cantidad==otra.capacidad) throw new JarraException("Error. Jarra llena.");
		
		if (cantidad<(otra.capacidad - otra.cantidad)) {
			otra.cantidad += cantidad;
			cantidad = 0;
		} else {
			cantidad -= (otra.capacidad - otra.cantidad);
			otra.cantidad += (otra.capacidad - otra.cantidad);
		}
	}

}
