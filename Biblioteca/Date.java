package Biblioteca;

public class Date {
	private int dia;
	private int mes;
	private int year;
	
	public Date (int dia, int mes, int year) {
		this.setDia(dia);
		this.setMes(mes);
		this.setYear(year);
		
	}
	
	public int getDia() {
		return this.dia;
	}
	public void setDia(int dia) {
		if (dia > 31 || dia < 1) {
			return;
		}
		this.dia = dia;
	}
	public int getMes() {
		return this.mes;
	}
	public void setMes(int mes) {
		if (mes > 12 || mes < 1) {
			return;
		}
		this.mes = mes;
	}
	public int getYear() {
		return this.year;
	}
	public void setYear(int year) {
		if (year != 2026) {
			return;
		}
		this.year = year;
	}
	
	
	public String toString() {
		return dia + "/ " + mes + "/ " + year;
	}
	
}
