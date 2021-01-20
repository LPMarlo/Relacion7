package Ejercicio4;

import java.util.Scanner;

public class PrincipalJarra {
	
	private static final int NUM_OPCIONES = 5;
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Jarra[] array = crearJarra(solicitarNumeroJarras());
		mostrarMenu();
		tratarMenu(array);

	}
	
	public static void mostrarMenu() {
		System.out.println("1. Llenar jarra.");
		System.out.println("2. Vaciar jarra.");
		System.out.println("3. Volcar jarra A en B.");
		System.out.println("4. Ver estado de las jarras.");
		System.out.println("5. Salir");
	}
	
	public static void tratarMenu(Jarra[] Jarra) {
		
		boolean salir= false;
		int jarraA;
		int jarraB;
		int opcion;
		
		do {
			
			opcion = solicitarOpcion();
			
			switch (opcion) {
				case 1:
					jarraA = elegirJarra(Jarra.length);
					
					Jarra[(jarraA)].llenar();
					System.out.println("Jarra llena.");
					break;
				case 2:
					jarraA = elegirJarra(Jarra.length);
					
					Jarra[(jarraA)].vaciar();
					System.out.println("Jarra vacia.");
					break;
				case 3:
					jarraA = elegirJarra(Jarra.length);
					
					try {
						jarraB = elegirJarra(Jarra.length);
						Jarra[(jarraA)].volcar(Jarra[(jarraB)]);
						System.out.println("Jarra " + (jarraA+1) + " volcada en jarra " + (jarraB+1) + ".");
					} catch (JarraException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					jarraA = elegirJarra(Jarra.length);
					System.out.println(Jarra[(jarraA)]);
					break;
				default:
					salir = true;
					System.out.println("El total de agua que se ha gastado llenando jarras es " + Jarra[0].getTotalAguaConsumida() + " litros.");
					break;
			}
		} while (salir==false);
	}
	
	public static int solicitarOpcion() {
		int opcion = 0;
		
		try {
			do {
				System.out.println("Elige una opcion: ");
				opcion = Integer.parseInt(teclado.nextLine());
				
				if (opcion<1 || opcion>NUM_OPCIONES) System.out.println("La opcion debe ser de 1 a " + NUM_OPCIONES + ".");
			} while (opcion<1 || opcion>NUM_OPCIONES);
		} catch (NumberFormatException e) {
			System.out.println("Introduce un numero.");
		}
		
		return opcion;
	}
	
	public static int solicitarNumeroJarras() {
		
		int numJarras = 0;
		
		try {
			do {
				System.out.println("Introduce el numero de Jarras: ");
				numJarras = Integer.parseInt(teclado.nextLine());
				
				if (numJarras<0) System.out.println("Debe ser un numero positivo.");
			} while (numJarras<0);
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		
		return numJarras;
	}
	
	public static Jarra[] crearJarra(int numJarras) {
		
		Jarra[] array = new Jarra[numJarras];
		int capacidad = 0;
		
		try {
			for (int i = 0; i < numJarras; i++) {
				System.out.println("Introduce la capacidad de la jarra " + (i+1) + ": ");
				capacidad = Integer.parseInt(teclado.nextLine());
				
				array[i] = new Jarra(capacidad);
			}
		} catch (JarraException e) {
			System.out.println(e.getMessage());
		}
		
		return array;
	}
	
	private static int elegirJarra(int numJarras) {
		int jarra = 0;
		
		try {
			do {
				System.out.println("Elige una jarra (hay " + numJarras + " jarra/s): ");
				jarra = Integer.parseInt(teclado.nextLine());
			} while (jarra<1 || jarra>numJarras);
		} catch (NumberFormatException e) {
			System.out.println("Introduce un numero.");
		}
		
		jarra--;
		return jarra;
	}
	

}
