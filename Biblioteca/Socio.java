package Biblioteca;

public class Socio {
	private int dni_socio; //Sin letra, a modo de ID como identificador único
	private String nombre_completo;
	private String email;
	private int limite_prestamos;
	
	public Socio (int dni_socio, String nombre_completo, String email) {
		this.setDni_socio(dni_socio);
		this.setNombre_completo(nombre_completo);
		this.setEmail(email);
		this.limite_prestamos = 3;
	}
	
	public int getDni_socio() {
		return dni_socio;
	}
	public void setDni_socio(int id_socio) {
		if (id_socio == 0) {
			System.out.println("El ID de socio no es válido");
			return;
		}
		this.dni_socio = id_socio;
	}

	public String getNombre_completo() {
		return nombre_completo;
	}
	public void setNombre_completo(String nombre_completo) {
		if (nombre_completo == null) {
			System.out.println("El nombre no puede estar vacío");
			return;
		}
		this.nombre_completo = nombre_completo;
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if (!email.contains("@")) {
			System.out.println("Dirección de email no válida");
			return;
		}
		this.email = email;
		
	}
	public int getLimite_prestamos() {
		return limite_prestamos;
	}
	public void prestar() {
		limite_prestamos--;
	}
	public void devolver() {
		limite_prestamos++;
	}
	
	public String toString() {
		return "ID: " + dni_socio + "\n" + 
				"Nombre: " + nombre_completo + "\n" +
				"Email: " + email + "\n";
				
	}
}
