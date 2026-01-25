package Biblioteca;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static Biblioteca biblioteca = new Biblioteca();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[]args) throws InterruptedException {
		
		precargar_datos();
		
		int opcion;
		
		System.out.println("----- BIENVENIDO AL MENÚ DE GESTIÓN DE LA BIBLIOTECA ------");
		do {
			System.out.println();
			System.out.println("¿Qué acción quieres realizar?");
			System.out.println("1. Dar de alta un libro");
	        System.out.println("2. Dar de alta un nuevo socio");
	        System.out.println("3. Prestar un libro");
	        System.out.println("4. Devolver un libro");
	        System.out.println("5. Consultar libros disponibles");
	        System.out.println("6. Consultar préstamos activos;");
	        System.out.println("7. Consultar préstamos de un socio");
	        System.out.println("0. Salir");
	        System.out.println("Selecciona una opción: ");
	        opcion = sc.nextInt();
			while (opcion < 0 || opcion > 7) {
				System.out.println("La opción no es válida. Selecciona una opción válida: ");
				opcion = sc.nextInt();
			}
			
			switch (opcion) {
				case 1 -> alta_libro();
				case 2 -> alta_socio();
				case 3 -> nuevo_prestamo();
				case 4 -> devolver_libro();
				case 5 -> listar_disponibles();
				case 6 -> listar_prestamos_activos();
				case 7 -> listar_prestamos_socio();
				case 0 -> {
					System.out.print("Saliendo del programa");
					Thread.sleep(350);
					System.out.print(".");
					Thread.sleep(350);
					System.out.print(".");
					Thread.sleep(350);
					System.out.print(".");
					Thread.sleep(400);
					System.out.print(" ¡HASTA LA PRÓXIMA!");
				}
			}
		} while (opcion != 0);
		
		
	}
	
	// -----------------------------------------------------------------
	// --------- MÉTODOS ---------
	
	public static void alta_libro() {
		System.out.println("Introduce los siguientes datos: ");
		System.out.print("ISBN: ");
		int isbn = sc.nextInt();
		System.out.print("Título: ");
		String titulo = sc.next();
		System.out.print("Autor: ");
		String autor = sc.next();
		System.out.print("Año: ");
		int year = sc.nextInt();
		
		Libro nuevo_libro = new Libro(isbn, titulo, autor, year);
		biblioteca.alta_libro(nuevo_libro);
		System.out.println();
	}
	
	public static void alta_socio() {
		System.out.println("Introduce los siguientes datos: ");
		System.out.print("DNI: ");
		int dni_socio = sc.nextInt();
		System.out.print("Nombre: ");
		String nombre_completo = sc.next();
		System.out.print("Email: ");
		String email = sc.next();
		Socio nuevo_socio = new Socio(dni_socio, nombre_completo, email);
		biblioteca.alta_socio(nuevo_socio);
		System.out.println();
	}
	
	public static void nuevo_prestamo() {
		System.out.println("Introduce los siguientes datos: ");
		System.out.print("DNI del socio: ");
		int dni_socio = sc.nextInt();
		System.out.print("ISBN del libro: ");
		int isbn = sc.nextInt();
		System.out.print("Dia: ");
		int dia = sc.nextInt();
		System.out.print("Mes: ");
		int mes = sc.nextInt();
		System.out.print("Año: ");
		int year = sc.nextInt();
		Date fecha_prestamo = new Date(dia, mes, year);
		biblioteca.nuevo_prestamo(dni_socio, isbn, fecha_prestamo);
		System.out.println();
	}
	
	public static void devolver_libro() {
		System.out.print("ISBN del libro a devolver: ");
        int isbn = sc.nextInt();
        System.out.println("Dia de la devolución: ");
        int dia = sc.nextInt();
        System.out.println("Mes de la devolución: ");
        int mes = sc.nextInt();
        System.out.println("Año de la devolución: ");
        int year = sc.nextInt();
        Date fecha_hoy = new Date(dia, mes, year);
        
        if (biblioteca.devolver_libro(isbn, fecha_hoy) == true) {
            System.out.println("Libro devuelto correctamente.");
        } else {
            System.out.println("Error: No hay un préstamo activo para ese ISBN.");
        }
        System.out.println();
	}
	
	public static void listar_disponibles() {
		List<Libro> disponibles = biblioteca.listar_disponibles();
        if (disponibles.isEmpty()) {
            System.out.println("No hay libros disponibles.");
        } else {
            for (Libro l : disponibles) System.out.println(l + "\n---");
        }
        System.out.println();
	}
	
	public static void listar_prestamos_activos() {
		biblioteca.listar_prestamos();
		
	}
	
	public static void listar_prestamos_socio() {
		System.out.println("Introduce el DNI del socio: ");
		int dni_socio = sc.nextInt();
		
		List<Prestamo> lista = biblioteca.obtener_prestamos_socio(dni_socio);
        
        if (lista == null) {
            System.out.println("Socio no encontrado.");
        } else if (lista.isEmpty()) {
            System.out.println("El socio no tiene préstamos.");
        } else {
            for (Prestamo p : lista) System.out.println(p + "\n---");
        }
	}
	
	private static void precargar_datos() {
        
        biblioteca.alta_libro(new Libro(111, "Los Renglones Torcidos de Dios", "Torcuato Luca de Tena", 1979));
        biblioteca.alta_libro(new Libro(222, "Quijote", "Cervantes", 1605));
        biblioteca.alta_libro(new Libro(333, "Clean Code", "Robert Martin", 2008));
        biblioteca.alta_libro(new Libro(444, "El Principito", "Saint-Exupéry", 1943));
        biblioteca.alta_libro(new Libro(555, "1984", "George Orwell", 1949));
        biblioteca.alta_libro(new Libro(666, "Dune", "Frank Herbert", 1965));

        biblioteca.alta_socio(new Socio(1111, "Ana Garcia", "ana@mail.com"));
        biblioteca.alta_socio(new Socio(2222, "Juan Perez", "juan@mail.com"));
        biblioteca.alta_socio(new Socio(3333, "Luz Mora", "luz@mail.com"));

        Date fecha_prestamo1 = new Date(11, 01, 2000);
        Date fecha_prestamo2 = new Date(25, 05, 2026);
        biblioteca.nuevo_prestamo(1111, 111, fecha_prestamo1);
        biblioteca.nuevo_prestamo(2222, 222, fecha_prestamo2);
    }
	
	
}
