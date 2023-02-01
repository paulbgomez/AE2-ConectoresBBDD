package helpers;

import java.util.List;
import java.util.Scanner;

import modelo.entidad.Coche;
import modelo.persistencia.DaoCoche;
import modelo.persistencia.DaoCocheMySql;

public class CarHandler {

    // Add un coche al stock
    public void addCoche() {
        Scanner scanner = new Scanner(System.in);
        Coche coche = new Coche();
        System.out.print("Introduce la matrícula del coche: ");
        coche.setMatricula(scanner.next());
        System.out.print("Introduce la marca del coche: ");
        coche.setMarca(scanner.next());
        System.out.print("Introduce el modelo del coche: ");
        coche.setModelo(scanner.next());
        System.out.print("Introduce el color del coche: ");
        coche.setColor(scanner.next());
        
        DaoCoche dCoche = new DaoCocheMySql();
        boolean alta = dCoche.alta(coche);
        if (alta) {
        	System.out.println("Coche anhadido");
        } else {
        	System.out.println("Coche NO anhadido");
        }
        
        Menu menu = new Menu();
        menu.printMenu();
    }
    
    // Borrar coche stock
    public void borrarCoche() {
        Scanner scanner = new Scanner(System.in);
    	DaoCoche dCoche = new DaoCocheMySql();
        System.out.print("Introduce el id del coche a borrar: ");
		boolean baja = dCoche.baja(scanner.nextInt());
		if(baja){
			System.out.println("Coche borrado");
		}else{
			System.out.println("Coche NO borrado");
		}
		
        Menu menu = new Menu();
        menu.printMenu();
    }
    
    // Obtener coche por id
    public void getCoche() {
        Scanner scanner = new Scanner(System.in);
    	DaoCoche dCoche = new DaoCocheMySql();
        System.out.print("Introduce el id del coche a obtener: ");
        Coche coche = dCoche.obtener(scanner.nextInt());
        System.out.println(coche.toString());
        
        Menu menu = new Menu();
        menu.printMenu();
    }
    
    public void modificarCoche() {
    	Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el id del coche a modificar: ");
    	// Obtenemos el coche primero
        DaoCoche dCoche = new DaoCocheMySql();
        Coche coche = dCoche.obtener(scanner.nextInt());
        
        // luego lo modificamos
        System.out.print("Introduce la matrícula del coche: ");
        coche.setMatricula(scanner.next());
        System.out.print("Introduce la marca del coche: ");
        coche.setMarca(scanner.next());
        System.out.print("Introduce el modelo del coche: ");
        coche.setModelo(scanner.next());
        System.out.print("Introduce el color del coche: ");
        coche.setColor(scanner.next());
        
        boolean modificar = dCoche.modificar(coche);
		if(modificar){
			System.out.println("Coche actualizado");
		}else{
			System.out.println("Coche NO actualizado");
		}
		
        Menu menu = new Menu();
        menu.printMenu();
    }
    
    // listar todos los coches
    public void listarCoches() {
    	DaoCoche dCoche = new DaoCocheMySql();
    	List<Coche> listaCoches = dCoche.listar();
    	for(Coche c : listaCoches) {
    		System.out.println(c.toString());
    	}
    	
        Menu menu = new Menu();
        menu.printMenu();
    }
}
