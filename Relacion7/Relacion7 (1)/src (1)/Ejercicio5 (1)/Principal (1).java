package Ejercicio5;

public class Principal {

	public static void main(String[] args) {
		
		Equipo e1 = new Equipo("equipo1","estadio1", "ciudad1");
		Equipo e2 = new Equipo("equipo2", "estadio2", "ciudad2");
		
		try {
			Partido p1 = new Partido(1,e1,e2);
			Partido p2 = new Partido(2,e1,e2);
			Partido p3 = new Partido(3,e1,e2);
			
			p1.ponerResultado("2-1");
			p2.ponerResultado("0-0");
			p3.ponerResultado("1-2");
			
			System.out.println(p1);
			System.out.println(p2);
			System.out.println(p3);
			
		} catch (PartidoException e) {
			e.printStackTrace();
		}
	}

}
