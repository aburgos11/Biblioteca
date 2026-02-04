package Biblioteca;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	private List<Libro> libros = new ArrayList<>();
	private List<Socio> socios = new ArrayList<>();
	private static List<Prestamo> prestamos = new ArrayList<>();
	private List<Prestamo> prestamos_cerrados = new ArrayList<>();
	
	
	public boolean alta_libro(Libro nuevo_libro) {
		if (buscar_libro(nuevo_libro.getIsbn()) != null) {
			throw new Error("Este libro ya ha sido registrado anteriornmente");
		}
		System.out.println("Libro registrado correctamente");
		return libros.add(nuevo_libro);
	}
	public boolean alta_socio(Socio nuevo_socio) {
		if (buscar_socio(nuevo_socio.getDni_socio()) != null) {
			throw new Error("Este socio ya ha sido registrado anteriornmente");
		}
		System.out.println("Socio registrado correctamente");
		return socios.add(nuevo_socio);
	}
	
	public Libro buscar_libro(int isbn) {
		for (Libro l : libros) {
			if (l.getIsbn() == isbn) {
				return l;
			}
		}
		return null;
	}
	
	public Socio buscar_socio(int dni_socio) {
		for (Socio s : socios) {
			if (s.getDni_socio() == dni_socio) {
				return s;
			}
		}
		return null;
	}
	
	public String nuevo_prestamo(int dni_socio, int isbn, Date fecha_prestamo) {
		Socio s = buscar_socio(dni_socio);
		Libro l = buscar_libro(isbn);
		
		if (s == null) {
			throw new Error("Socio no encontrado");
		}
		if (l == null) {
			throw new Error("Libro no encontrado");
		}
		if (l.getDisponible() == false) {
			throw new Error("Libro no disponible");			
		}
		if (s.getLimite_prestamos() == 0) {
			throw new Error("El usuario ha alcanzado el límite de préstamos");			
		}
		
		s.prestar();
		l.setDisponible(false);
        prestamos.add(new Prestamo(s, l, fecha_prestamo));
        Prestamo.setContador_de_id();
        return "Prestamo registrado correctamente";
	}
	
	public boolean devolver_libro(int isbn, Date fecha_hoy) {
	    Prestamo p = buscar_prestamo(isbn);

	    if (p != null) {
	        
	        prestamos.remove(p);
	        prestamos_cerrados.add(p);
	        p.setFecha_devolucion(fecha_hoy);
	        p.getLibro().setDisponible(true);
	        p.getSocio().devolver();
	        
	        return true; 
	    }
	    return false;
	}
	
	public Prestamo buscar_prestamo(int isbn) {
	    for (Prestamo p : prestamos) {
	        
	        if (p.getLibro().getIsbn() == isbn) {
	            return p;
	        }
	    }
	    return null; 
	}
	
	public List<Libro> listar_disponibles() { // Hacer una 'public List<>' es idea de Gemini. He probado formas muy largas para sacarlo y creo que es más sencillo de lo que pensaba, pero mi cabeza no da para más.
		// para Gemini sencillo: una 'public List<>' y listo, y yo: pues venga
	    List<Libro> disponibles = new ArrayList<>();
	    
	    for (Libro l : this.libros) {
	        if (l.getDisponible() == true) {
	            disponibles.add(l);
	        }
	    }
	    return disponibles;
	}
	
	public void listar_prestamos() { // Solo tengo que recorrer la lista de prestamos de esta misma clase.
		if (prestamos.isEmpty()) {
			throw new Error("No hay préstamos activos acturalmente");
		}
		for (Prestamo p : prestamos) {
			System.out.println(p);
		}
		System.out.println();
	}
	
	public List<Prestamo> obtener_prestamos_socio(int idSocio) {
		
		if (buscar_socio(idSocio) == null) {
			throw new Error("El usuario ha alcanzado el límite de préstamos");
	    }
		List<Prestamo> prestamos_socio = new ArrayList<>();

	    for (Prestamo p : prestamos) {
	        if (p.getSocio().getDni_socio() == idSocio) {
	            prestamos_socio.add(p);
	        }
	    }
	    
	    return prestamos_socio;
	}
	
	
}
