package Biblioteca;

public class Libro {
	private int isbn;
	private String titulo;
	private String autor;
	private int year;
	private boolean disponible;
	
	
	public Libro (int isbn, String titulo, String autor, int year) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.year = year;
		this.disponible = true;
	}
	
	public int getIsbn() {
		return isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getAutor() {
		return autor;
	}
	public int getYear() {
		return year;
	}
	public boolean getDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	
	public String toString() {
		return "ISBN: " + isbn + "\n" +
				"Título: " + titulo + "\n" +
				"Autor: " + autor + "\n" +
				"Año: " + year + "\n" +
				(disponible ? "Disponible" : "Prestado") +"\n";
	}
}
