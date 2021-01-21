package Ejercicio2;

import java.util.Scanner;

public class Principal {
	
	private static final int ULTIMA_OPCION = 3;
	private static final int PRIMERA_OPCION = 1;
	private static final char DERECHA = 'D';
	private static final char IZQUIERDA = 'I';
	private static final char ABAJO = 'B';
	private static final char ARRIBA = 'A';
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		boolean salir;
		
		System.out.println("- Punto 1 -");
		Punto punto1 = solicitarPunto();
		
		System.out.println("\n- Punto 2 -");
		Punto punto2 = solicitarPunto();
		
		Linea linea = crearLinea(punto1, punto2);
		
		do {
			mostrarMenu();
			salir = tratarMenuPrincipal(linea);
		} while (salir==false);
	}
	public static Punto solicitarPunto() {
		
		int x=0, y=0;
		
		try {
			System.out.println("Coordenada x: ");
			x = Integer.parseInt(teclado.nextLine());
		} catch (NumberFormatException e) {
			e.getStackTrace();
		}
		
		try {
			System.out.println("Coordenada y: ");
			y = Integer.parseInt(teclado.nextLine());
		} catch (NumberFormatException e) {
			e.getStackTrace();
		}
		
		return new Punto(x,y);
	}
	
	public static Linea crearLinea(Punto punto1, Punto punto2) {
		
		Linea linea = null;
		
		try {
			linea = new Linea(punto1, punto2);
		} catch (LineaException e) {
			System.out.println(e.getMessage());
		}
		
		return linea;
	}
	
	public static void mostrarMenu() {
		System.out.println("1. Mover linea\n2. Mostrar linea\n3. Salir");
	}
	
	public static int solicitarOpcion() {
		
		int opcion = 3;
		
		try {
			do {
				System.out.println("Introduzca una opcion: ");
				opcion = Integer.parseInt(teclado.nextLine());
				
				if (opcion<PRIMERA_OPCION || opcion>ULTIMA_OPCION) System.out.println("Error. Introduce una opcion valida.");
			} while (opcion<PRIMERA_OPCION || opcion>ULTIMA_OPCION);
		} catch (NumberFormatException e) {
			System.out.println("Error. Tiene que ser un numero valido.");
		}
		
		return opcion;
	}
	public static boolean tratarMenuPrincipal(Linea linea) {
		
		boolean salir = false;
		
		switch (solicitarOpcion()) {
		case 1:
			tratarMenuMovimiento(linea);
			break;
		case 2:
			System.out.println(linea);
			break;
		default:
			System.out.println("Terminado.");
			salir = true;
			break;
		}
		return salir;
	}
	
	public static void tratarMenuMovimiento(Linea linea) {
		
		char opcion;
		int num;
		
		do {
			System.out.println("Elige hacia donde mover (A-Arriba, B-ABajo, I-Izquierda, D-Derecha): ");
			opcion = teclado.nextLine().toUpperCase().charAt(0);
			
			if (opcion != ABAJO && opcion != ARRIBA && opcion!=DERECHA && opcion!=IZQUIERDA) System.out.println("Error. Introduce una respuesta valida.");
		} while (opcion != ABAJO && opcion != ARRIBA && opcion!=DERECHA && opcion!=IZQUIERDA);
		
		do {
			System.out.println("Elige cuanto mover: ");
			num = Integer.parseInt(teclado.nextLine());
		} while (num<0);
		
		if (opcion==ARRIBA) linea.moverArriba(num);
		else if (opcion==ABAJO) linea.moverAbajo(num);
		else if (opcion==IZQUIERDA) linea.moverIzquierda(num);
		else if (opcion==DERECHA) linea.moverDerecha(num);
	}

}
