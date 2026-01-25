package Biblioteca;

public class Prestamo {
	
	private static int contador_de_id = 1;
	private int id_prestamo;
	private Socio socio;
	private Libro libro;
	private Date fecha_prestamo;
	private Date fecha_devolucion;
	private boolean prestamo_activo;
	
	public Prestamo (Socio socio, Libro libro, Date fecha_prestamo) {
		this.id_prestamo = contador_de_id;
		this.socio = socio;
		this.libro = libro;
		this.fecha_prestamo = fecha_prestamo;
		this.fecha_devolucion = null;
		this.prestamo_activo = true;
	}
	
	
	public int getId_prestamo() {
		return id_prestamo;
	}
	public Socio getSocio() {
		return socio;
	}
	public Libro getLibro() {
		return libro;
	}
	public Date getFecha_prestamo() {
		return fecha_prestamo;
	}
	public Date getFecha_devolucion() {
		return fecha_devolucion;
	}
	public void setFecha_devolucion(Date fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}
	public boolean getPrestamo_activo() {
		return prestamo_activo;
	}
	public void setPrestamo_activo(boolean prestamo_activo) {
		this.prestamo_activo = prestamo_activo;
	}
	public static void setContador_de_id() {
		contador_de_id ++;
	}
	
	public String toString() {
		return "-----------------------" + "\n" + 
				"ID: " + id_prestamo + "\n" +
				"Socio: " + socio + "\n" +
				"Libro: " + libro + "\n" +
				"Fecha de préstamo: " + fecha_prestamo + "\n" +
				"Fecha de devolución: " + fecha_devolucion +
				(prestamo_activo ? "Activo" : "Cerrado") +"\n" +
				"----------------------";
				
	}
	
}
