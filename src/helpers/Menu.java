package helpers;

import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private CarHandler cHandler = new CarHandler();

    public void printMenu() {
        System.out.println("###########################################################################");
        System.out.println("#                                                                         #");
        System.out.println("#  > 1. Añadir nuevo coche                                                #");
        System.out.println("#  > 2. Borrar coche por id                                               #");
        System.out.println("#  > 3. Consulta coche por id                                             #");
        System.out.println("#  > 4. Modificar coche por id                                            #");
        System.out.println("#  > 5. Listado de coches                                                 #");
        System.out.println("#  > 6. Gestion de pasajeros                                              #");
        System.out.println("#  > 7. Terminar el programa                                              #");
        System.out.println("#                                                                         #");
        System.out.println("###########################################################################");
        System.out.print("Selecciona una opción: ");
        int option = sc.nextInt();
        handleOptionsCoche(option);
    }
	
    // imprimimos el submenu
	private void printSubMenu() {
		System.out.println("###########################################################################");
        System.out.println("#                                                                         #");
        System.out.println("#  > 1. Añadir nuevo pasajero                                             #");
        System.out.println("#  > 2. Borrar pasajero por id                                            #");
        System.out.println("#  > 3. Consulta pasajero por id                                          #");
        System.out.println("#  > 4. Añadir pasajero a coche                                           #");
        System.out.println("#  > 4. Elimnar pasajero de coche                                         #");
        System.out.println("#  > 5. Listar pasajero de un coche                                       #");
        System.out.println("#  > 6. Terminar el programa                                              #");
        System.out.println("#                                                                         #");
        System.out.println("###########################################################################");
        int option = sc.nextInt();
        // TODO handlePersonas
    }
	
	private void handleOptionsCoche(int option) {
	    switch (option) {
	        case 1:
	            cHandler.addCoche();
	            break;
	        case 2:
	            cHandler.borrarCoche();
	            break;
	        case 3:
	            cHandler.getCoche();
	            break;
	        case 4:
	            cHandler.modificarCoche();
	            break;
	        case 5:
	            cHandler.listarCoches();
	            break;
	        case 6:
	            printSubMenu();
	            break;
	        case 7:
	            System.out.println("Programa terminado");
	            sc.close();
	            break;
	        default:
	            System.out.println("Opción inválida. Intenta de nuevo.");
	            printMenu();
	            break;
	    }
	}
}
