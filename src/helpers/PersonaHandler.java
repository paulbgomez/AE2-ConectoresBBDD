package helpers;

import java.util.List;
import java.util.Scanner;
import modelo.entidad.Persona;
import modelo.persistencia.DaoPersona;
import modelo.persistencia.DaoPersonaMySql;

public class PersonaHandler {
	// Add un Persona al stock
    public void addPersona() {
        Scanner scanner = new Scanner(System.in);
        Persona persona = new Persona();
        System.out.print("Introduce el nombre de la persona: ");
        persona.setNombre(scanner.nextLine());
        System.out.print("Introduce la edad de la persona: ");
        persona.setEdad(scanner.nextInt());
        System.out.print("Introduce el peso de la persona: ");
        persona.setPeso(scanner.nextDouble());
        
        DaoPersona dPersona = new DaoPersonaMySql();
        boolean alta = dPersona.alta(persona);
        if (alta) {
        	System.out.println("Persona anhadida");
        } else {
        	System.out.println("Persona NO anhadida");
        }
        
        Menu menu = new Menu();
        menu.printMenu();
    }
    
    // Borrar Persona stock
    public void borrarPersona() {
        Scanner scanner = new Scanner(System.in);
    	DaoPersona dPersona = new DaoPersonaMySql();
        System.out.print("Introduce el id de la persona a borrar: ");
		boolean baja = dPersona.baja(scanner.nextInt());
		if(baja){
			System.out.println("Persona borrada");
		}else{
			System.out.println("Persona NO borrada");
		}
		
        Menu menu = new Menu();
        menu.printMenu();
    }
    
    // Obtener Persona por id
    public void getPersona() {
        Scanner scanner = new Scanner(System.in);
    	DaoPersona dPersona = new DaoPersonaMySql();
        System.out.print("Introduce el id de la persona a obtener: ");
        Persona persona = dPersona.obtener(scanner.nextInt());
        System.out.println(persona.toString());
        
        Menu menu = new Menu();
        menu.printMenu();
    }
    
    // anhadir una persona a un coche
    public void addCoche() {
        Scanner scanner = new Scanner(System.in);
    	DaoPersona dPersona = new DaoPersonaMySql();
        System.out.print("Introduce el id de la persona a anhadir: ");
        int idPersona = scanner.nextInt();
        System.out.println("Introduce el id del coche:");
        int idCoche = scanner.nextInt();
        boolean alta = dPersona.addToCar(idPersona, idCoche);
		if(alta){
			System.out.println("Persona anhadida al coche");
		}else{
			System.out.println("Persona NO anhadida");
		}
		
        Menu menu = new Menu();
        menu.printMenu();
    }
    
    // borrar una persona de un coche
    public void borrarCoche() {
        Scanner scanner = new Scanner(System.in);
    	DaoPersona dPersona = new DaoPersonaMySql();
        System.out.print("Introduce el id de la persona a borrar: ");
        int idPersona = scanner.nextInt();
        System.out.println("Introduce el id del coche:");
        int idCoche = scanner.nextInt();
        boolean baja = dPersona.deleteFromCar(idPersona, idCoche);
		if(baja){
			System.out.println("Persona borrada al coche");
		}else{
			System.out.println("Persona NO borrada");
		}
		
        Menu menu = new Menu();
        menu.printMenu();
    }
    
    // listar todas las personas de un coche
    public void listarPersonasCoche() {
        Scanner scanner = new Scanner(System.in);
    	DaoPersona dPersona = new DaoPersonaMySql();
        System.out.print("Introduce el id del coche para mostrar sus pasajeros: ");
    	List<Persona> listaPersonas = dPersona.listarPersonasCoche(scanner.nextInt());
    	for(Persona p : listaPersonas) {
    		System.out.println(p.toString());
    	}
    	
        Menu menu = new Menu();
        menu.printMenu();
    }
}
