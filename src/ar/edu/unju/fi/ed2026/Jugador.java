package ar.edu.unju.fi.ed2026;

public class Jugador {
    private String nombre;
    private String apellido;
    private int edad;
    private int puntaje;
    private Object cartaEnMano;
    private MiStack cartasAcumuladas;

    // Constructor vacío
    public Jugador() {
        this.puntaje = 0;
    }

    public Jugador(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.puntaje = 0;
    }

    // --- GETTERS Y SETTERS (para manipular la info desde el Main u otras clases) ---

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void sumarPuntaje(int puntos) {
        this.puntaje += puntos;
    }

    public Object getCartaEnMano() {
        return cartaEnMano;
    }

    public void setCartaEnMano(Object cartaEnMano) {
        this.cartaEnMano = cartaEnMano;
    }
    
    public MiStack getCartasAcumuladas() {
    	return cartasAcumuladas;
    }
    
    public void setCartasAcumuladas(MiStack cartasAcumuladas) {
    	this.cartasAcumuladas = cartasAcumuladas;
    }

    @Override
    public String toString() {
        return "Jugador: " + nombre + " " + apellido + " (Edad: " + edad + " años) - Puntaje actual: " + puntaje;
    }
}
